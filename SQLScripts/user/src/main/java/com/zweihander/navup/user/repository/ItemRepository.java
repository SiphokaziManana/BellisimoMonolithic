package com.zweihander.navup.user.repository;

import com.zweihander.navup.user.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siphokazi on 2017/09/17.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Override
    Item findOne(Long aLong);

    Item findByCode(String code);

    List<Item> findByCategory(String category);
}
