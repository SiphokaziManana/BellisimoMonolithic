package com.bellisimo.monolithic.repository;

import com.bellisimo.monolithic.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siphokazi on 2017/07/17.
 */
//@org.springframework.stereotype.Repository
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    @Override
    Item findOne(Long aLong);

    Item findByCode(String code);

    List<Item> findByCategory(String category);
}
