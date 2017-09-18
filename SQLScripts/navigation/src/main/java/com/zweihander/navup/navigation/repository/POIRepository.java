package com.zweihander.navup.navigation.repository;

/**
 * Created by siphokazi on 2017/05/06.
 */

import com.zweihander.navup.navigation.domain.POI;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface POIRepository extends JpaRepository<POI, Long>{


    POI findByUsername(String username);

    POI findByUsernameAndLongitudeAndLatitude(String username, double longitude, double latitude);

    ArrayList<POI> findAllByUsername(String username);

    POI findByUsernameAndLongitude(String username, double longitude);

    POI findByUsernameAndLatitude(String username, double latitude);
}
