package com.bellisimo.monolithic.repository;

import com.bellisimo.monolithic.domain.Special;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siphokazi on 2017/07/27.
 */
@Repository
public interface SpecialRepository extends JpaRepository<Special, Long>{

}
