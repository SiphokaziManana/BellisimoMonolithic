package com.zweihander.navup.navigation.service;

import com.zweihander.navup.navigation.domain.POI;

import java.util.ArrayList;

/**
 * Created by siphokazi on 2017/05/06.
 */
public interface INavigationService {

     POI addPOI(POI location);

     POI modifyPOI(POI location);

     void deleteByID(Long id) ;

     void deletePOI(POI poi);

     POI getPOI(String username,double long_, double lat_);

     ArrayList<POI> getAllPOIForUser(String username);

}
