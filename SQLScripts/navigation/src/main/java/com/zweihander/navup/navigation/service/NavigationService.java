package com.zweihander.navup.navigation.service;

/**
 * Created by siphokazi on 2017/04/22.
 */
import com.zweihander.navup.navigation.domain.POI;
import com.zweihander.navup.navigation.repository.POIRepository;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
//public class NavigationService implements INavigationService{
public class NavigationService{

    @Autowired
    POIRepository poiRepository;


    public POI addPOI(POI location){
        return poiRepository.save(location);
    }

    //@Override
    public POI modifyPOI(POI location){

        POI tempLat = poiRepository.findByUsernameAndLongitude(location.getUsername(), location.getLongitude());
        POI tempLong = poiRepository.findByUsernameAndLatitude(location.getUsername(), location.getLatitude());

        if (  tempLat != null)
        {
            tempLat.setLatitude(location.getLatitude());
            return poiRepository.save(tempLat);
        }
        else  if ( tempLong != null)
        {
            tempLong.setLongitude(location.getLongitude());
            return poiRepository.save(tempLong);
        }
        else
        {
            return poiRepository.save(location);
        }
    }


    public void deleteByID(Long id) {
        poiRepository.delete(id);
    }


    public boolean deletePOI(POI poi){
        POI tmp = poiRepository.findByUsernameAndLongitudeAndLatitude(poi.getUsername(), poi.getLongitude(), poi.getLatitude());

        if ( tmp != null){
            poiRepository.delete(poi);
            return true;
        }
        return false;
    }


    public POI getPOI(String username,double long_, double lat_){

        POI result = poiRepository.findByUsernameAndLongitudeAndLatitude(username,long_,lat_);

        System.out.println("result: ======= "+result);
        return result;
    }


    public ArrayList<POI> getAllPOIForUser(String username){
        return poiRepository.findAllByUsername(username);
    }

}