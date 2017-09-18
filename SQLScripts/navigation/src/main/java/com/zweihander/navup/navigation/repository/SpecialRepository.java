package com.zweihander.navup.navigation.repository;

import com.zweihander.navup.navigation.domain.Special;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siphokazi on 2017/09/17.
 */
@Repository
public interface SpecialRepository extends JpaRepository<Special, Long> {

}
