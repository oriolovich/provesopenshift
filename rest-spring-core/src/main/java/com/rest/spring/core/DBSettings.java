package com.rest.spring.core;

public class DBSettings {
    public static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String DB_CONNECTION ="jdbc:oracle:thin:@35.180.32.114:1521:xe";
    public static final String DB_USER = "usuari";

    public  String getTxt(){return  DB_DRIVER;}
}
