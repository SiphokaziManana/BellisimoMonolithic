package com.zweihander.navup.navigation.domain;

/**
 * Created by siphokazi on 2017/04/22.
 */
public class Location {

    String name;
    String locationId;

    public String getName(){
        return name;
    }
    public void setName( String name_){
        name = name_;
    }

    public String getLocationId(){
        return locationId;
    }
    public void setLocationId(String locationId_){
        locationId = locationId_;
    }
}
