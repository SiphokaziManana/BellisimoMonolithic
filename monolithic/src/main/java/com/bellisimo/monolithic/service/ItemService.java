package com.bellisimo.monolithic.service;

import com.bellisimo.monolithic.domain.Item;
//import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.mapper.ItemMapper;
import com.bellisimo.monolithic.repository.ItemRepository;


import javax.inject.Inject;
//import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by siphokazi on 2017/07/17.
 */
@Service
public class ItemService {

    @Inject
    ItemRepository itemRepository;

    @Inject
    ItemMapper itemMapper;


    public ItemDTO addItem(ItemDTO dto){
        Item obj = itemRepository.save(itemMapper.itemDTOToItem(dto));
        ItemDTO result = itemMapper.itemToItemDTO(obj);
        return result;
    }

}
