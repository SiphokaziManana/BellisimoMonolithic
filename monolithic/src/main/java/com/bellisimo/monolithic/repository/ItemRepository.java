package com.bellisimo.monolithic.repository;

import com.bellisimo.monolithic.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siphokazi on 2017/07/17.
 */
//@org.springframework.stereotype.Repository
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{


}
