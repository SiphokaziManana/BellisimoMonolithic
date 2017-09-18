package com.zweihander.navup.navigation.domain;

/**
 * Created by siphokazi on 2017/04/22.
 */
import com.zweihander.navup.navigation.domain.Location;

import java.util.ArrayList;

public class Route {

    String name;
    ArrayList<Location> path;

    public Route(String name_, Location start, Location end){
        name = name_;
        path = new ArrayList<>();
        path.add(start);
        path.add(end);
    }
    public String getName(){
        return name;
    }
    public void setName(String name_){
        name = name_;
    }
    public ArrayList<Location> getPath(){
        return path;
    }
    public void setPath(ArrayList<Location> newPath){
        path = newPath;
    }
    public void addLocationToPath(Location location){
        path.add(location);
    }

}
