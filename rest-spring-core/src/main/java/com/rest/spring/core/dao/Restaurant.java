package com.rest.spring.core.dao;

import java.util.ArrayList;

public class Restaurant {
    //Objetos privados
    private String name;
    private String address;
    private String website;
    private String telephone;
    private String type;
    private String id;
    private String url_imagen;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    //Get y Set del objeto Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Get y Set del objeto Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //Get y Set del objeto Website
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    //Get y Set del objeto Telephone
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    //Get y Set del objeto Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //get y set de imagen
    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }


    //get y set de opiniones
    private ArrayList<String> opinions;

    public ArrayList<String> getOpinions() {
        return opinions;
    }

    public void setOpinions(ArrayList<String> opinions) {
        this.opinions = opinions;
    }

    public Restaurant() {
        this.opinions = new ArrayList<String>();
    }
}

