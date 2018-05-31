package com.rest.spring.front.controlador;

import com.rest.spring.core.basededatos.ReadRestaurant;
import com.rest.spring.core.dao.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 */
@RestController
@RequestMapping(path = "/rest/api")
public class ApiRestController {

    //anotacion que indica la ruta  donde se va a pasar la informacion, se le puede definir los verbos, en este caso GET
    @RequestMapping(path = "/restaurants",method = RequestMethod.GET)
    //metodo que nos permite sacar una lista de restaurantes
    public List<Restaurant> list() {
        //se crea una clase no estatica para la incorporacion de sus metodos
        ReadRestaurant dbQuery = new ReadRestaurant();
        //creamos la lista de los objetos a devolver usando un metodo del objeto que hemos creado antes
        List<Restaurant> restaurants = (List<Restaurant>) dbQuery.getRestaurants(""); //dbQuery.readRestaurantAPI();
        // se devuelven los restaurantes
        return restaurants;
    }
}
