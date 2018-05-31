package com.rest.spring.core.dao;

import com.rest.spring.core.basededatos.ReadRestaurant;

/**
 * dummies
 * com.iesemilidarder.fordummies.web
 * Created by alber in 15/12/2017.
 * Description:
 */
public class User extends ReadRestaurant {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    /**
     * sets the id, owasp
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * sets the name, owaaaaaasp
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    protected void beforeSave() {
        doLog(String.format("Saving %s", this.getClass().getCanonicalName()));
        System.out.println("Saving users");
    }

    private void doLog(String format) {
    }

    public void save() {
    }
}
