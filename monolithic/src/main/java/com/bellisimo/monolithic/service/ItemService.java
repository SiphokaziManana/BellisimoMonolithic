package com.bellisimo.monolithic.service;

import com.bellisimo.monolithic.domain.Item;
//import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.exception.CustomException;
import com.bellisimo.monolithic.mapper.ItemMapper;
import com.bellisimo.monolithic.repository.ItemRepository;


import javax.inject.Inject;
//import java.util.List;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if ( dto.getHasSpecial() == null){
            dto.setHasSpecial(false);
        }
        if (dto.getCategory() == null){
            dto.setCategory(Item.Category.UNKNOWN);
        }
        try {
            Item obj = itemRepository.save(itemMapper.itemDTOToItem(dto));
            ItemDTO result = itemMapper.itemToItemDTO(obj);
            return result;
        }catch (Exception e){
            throw new CustomException("Could not ADD ITEM into the database. Error: " + e.toString());
        }
    }

    public ItemDTO updateItem(ItemDTO dto){
        Item item;
        if (dto.getCode() != null){
             item = itemRepository.findByCode(dto.getCode());
        }
        else if ( dto.getId() != null){
             item = itemRepository.findOne(dto.getId());
        }
        else{
            return addItem(dto);
        }

        try{
            if ( item != null){
                item.setHasSpecial(dto.getHasSpecial());
                if ( dto.getHasSpecial())
                    item.setSpecial(dto.getSpecial().toEntity());
                if ( dto.getImage() != null)
                    item.setImage(dto.getImage());
                if ( dto.getPrice() != null)
                    item.setPrice(dto.getPrice());
                if ( dto.getName() != null)
                    item.setName(dto.getName());
                return itemMapper.itemToItemDTO(itemRepository.save(item));
            }
            else{
                throw new CustomException("Item Could not be found");
            }
        }catch (Exception e){
            throw new CustomException("Could not UPDATE ITEM in the database. Error: " + e.toString());
        }
    }

    public List<ItemDTO> getAllItems(){
        return itemMapper.itemsToItemDTOs(itemRepository.findAll());
    }

    public ItemDTO getItem(Long id){
        return itemMapper.itemToItemDTO(itemRepository.findOne(id));
    }

    public void deleteItem(Long id){
        itemRepository.delete(id);
    }

}
