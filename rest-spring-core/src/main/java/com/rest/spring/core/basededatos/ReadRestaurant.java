package com.rest.spring.core.basededatos;
//Importaciones de sql

import com.rest.spring.core.DBSettings;
import com.rest.spring.core.dao.Restaurant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class ReadRestaurant {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadRestaurant.class);
    /**
     * ArrayList para leer restaurantes
     * @param buscar
     * @return
     */
    public static ArrayList getRestaurants(String buscar) {
        ArrayList al = new ArrayList();
        try {
            //Ponemos que usamos base de datos Oracle
            Class.forName(DBSettings.DB_DRIVER);
            Connection con = DriverManager.getConnection(DBSettings.DB_CONNECTION, DBSettings.DB_USER,DBSettings.DB_USER);

            Statement stmt = con.createStatement();
            //Ponemos el SELECT de lo que queremos ver
            ResultSet rs;
            String stmtTxt;

            if (StringUtils.isEmpty(buscar)){
                stmtTxt = "SELECT * FROM (SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_URL_IMG, R.RES_TELEFON, R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI ORDER BY R.RES_MITJANA desc) WHERE ROWNUM <= 5";
                System.out.println(stmtTxt);
                rs = stmt.executeQuery(stmtTxt);
            }
            else {

                System.out.println("SELECT * FROM (SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_URL_IMG, R.RES_TELEFON, R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI AND LOWER (R.RES_NOM) LIKE '%'+buscar.toLowerCase()+'%' ORDER BY R.RES_MITJANA desc) WHERE ROWNUM <=5");
                rs = stmt.executeQuery("SELECT * FROM (SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_URL_IMG, R.RES_TELEFON, R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE R.RES_TRS_CODI = TR.TRS_CODI AND LOWER (R.RES_NOM) LIKE '%'+buscar.toLowerCase()+'%' ORDER BY R.RES_MITJANA desc) WHERE ROWNUM <=5");
            }

            while (rs.next()) {
                //Las columnas que queremos ver
                String name = rs.getString("RES_NOM");
                String address = rs.getString("RES_ADRECA");
                String website = rs.getString("RES_WEB");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String id = rs.getString("RES_CODI");
                String url_imagen = rs.getString("RES_URL_IMG");


                Restaurant std = new Restaurant();
                std.setName(name);
                std.setAddress(address);
                std.setWebsite(website);
                std.setTelephone(telephone);
                std.setType(type);
                std.setId(id);
                std.setUrl_imagen(url_imagen);


                al.add(std);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            LOGGER.error("Getting data", e);
        }
        return al;
    }

    //segundo metodo, lee un restaurante en especifico

    /**
     *
     * @param id
     * @return
     */
    public Restaurant getRestaurantInfo(String id) {
        Restaurant rstt = null;

        try {
            //Ponemos que usamos base de datos Oracle
            Class.forName(DBSettings.DB_DRIVER);
            Connection con = DriverManager.getConnection(DBSettings.DB_CONNECTION, DBSettings.DB_USER,DBSettings.DB_USER);

            //sacar el restaurante de la base de datos
            Statement stmt = con.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, " +
                    "R.RES_CODI, TR.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS TR WHERE " + id+ "= R.RES_CODI " +
                    "AND R.RES_TRS_CODI = TR.TRS_CODI");

            if (rs.next()){
                rstt = new Restaurant();

                rstt.setName(rs.getString("RES_NOM"));
                rstt.setAddress(rs.getString("RES_ADRECA"));
                rstt.setTelephone(rs.getString("RES_TELEFON"));
                rstt.setType(rs.getString("TRS_DESCRIPCIO"));
                rstt.setWebsite(rs.getString("RES_WEB"));
                rstt.setId(rs.getString("RES_CODI"));
                rstt.setUrl_imagen(rs.getString("RES_URL_IMG"));


                // Sacar los comentarios de la base de datos
                Statement stamt = con.createStatement();
                ResultSet rst;

                rst = stamt.executeQuery("SELECT O.OPI_OBSERVACIO, U.USU_NOM FROM RESTAURANTS R, OPINIONS O, USUARIS U WHERE R.RES_CODI = O.OPI_RES_CODI AND " + id + "=R.RES_CODI AND O.OPI_USU_CODI = U.USU_CODI");

                while (rst.next()){

                    rstt.getOpinions().add(rst.getString("USU_NOM"));
                    rstt.getOpinions().add(rst.getString("OPI_OBSERVACIO"));
                }
                stamt.close();
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            LOGGER.error("Getting data", e);
        }
        return rstt;
    }

    // EN TEORIA este metodo ejecuta las consultas con functional programming
    private Object executeQuery(String query, Function<ResultSet, Object> f) {
        Connection con;
        Statement stmt;
        try {
            //Ponemos que usamos base de datos Oracle
            Class.forName(DBSettings.DB_DRIVER);
             con = DriverManager.getConnection(DBSettings.DB_CONNECTION, DBSettings.DB_USER,DBSettings.DB_USER);
            stmt = con.createStatement();
            // aqui se ejecuta la query mediante un statement
            ResultSet rs = stmt.executeQuery(query);
            // se crea un objeto generico y se le aplica la funcion f al resultset
            Object o = f.apply(rs);
            // se cierra el statement y la conexion
            stmt.close();
            con.close();
            // devuelve el objeto generico
            return o;
        } catch (Exception e) {
            return null;
        }
    }

    public List readRestaurantAPI() {
        //se crea un ArrayList para introducir los datos,
        List<Restaurant> arrayRestaurants = new ArrayList<>();
        // se crea un objeto que mapea la informacion de la base de datos, esto se encuentra en una clase generica para cualquier objeto
        ResultSetMapper<Restaurant> mapper = new ResultSetMapper<>();
        try {
            //consulta la base de datos, que se introduce en un String
            final String query = "SELECT R.RES_CODI,R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO FROM " +
                    "RESTAURANTS R,TRESTAURANTS TR WHERE  R.RES_TRS_CODI = TR.TRS_CODI";
            //se crea un objeto apartir de la funcion para poder ejectuarla
            Function<ResultSet, Object> func = new Function<ResultSet, Object>() {
                // se ejecuta un objeto con el metodo apply que nos ejecuta la funcion, y nos devuelve el mapeo mediante el resultset y la clase que queremos
                public Object apply(ResultSet rs) {
                    return mapper.mapResultSetToObject(rs, Restaurant.class);
                }
            };
            //indicamos al array creado anteriorme que ejecut el metodo functional, junto con la query
            arrayRestaurants = (ArrayList) executeQuery(query, func);

        } catch (Exception e) {
            LOGGER.error("Getting data", e);
        }
        //devuelve la informacion introducida en el ArrayList
        return arrayRestaurants;
    }
}