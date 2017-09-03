package com.bellisimo.monolithic.service;

import com.bellisimo.monolithic.domain.Item;
//import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.domain.Special;
import com.bellisimo.monolithic.exception.CustomException;
import com.bellisimo.monolithic.mapper.ItemMapper;
import com.bellisimo.monolithic.repository.ItemRepository;


import javax.inject.Inject;
//import java.util.List;
import com.bellisimo.monolithic.repository.SpecialRepository;
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
    SpecialRepository specialRepository;

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
            System.out.println("adding ");

            Item obj = itemRepository.save(itemMapper.itemDTOToItem(dto));
            System.out.println("addded ");
            ItemDTO result = itemMapper.itemToItemDTO(obj);
            return result;
        }catch (Exception e){
            throw new CustomException("Could not ADD ITEM into the database. Error: " + e.toString());
        }
    }

    public ItemDTO updateItem(Long id , ItemDTO dto){
        Item item;

        if ( id != null){
             item = itemRepository.findOne(id);
        }
        else{
            return addItem(dto);
        }

        try{
            if ( item != null){
                item.setHasSpecial(dto.getHasSpecial());
                if ( dto.getHasSpecial())
                    item.setSpecial(dto.getSpecial());
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
        Item item = itemRepository.findOne(id);

        if ( item.getHasSpecial()){
            Special special = specialRepository.findOne(item.getSpecial());
            Double specialPrice = item.getPrice() * special.getPercentage();
            item.setPrice(specialPrice);
        }
        return itemMapper.itemToItemDTO(item);
    }

    public void deleteItem(Long id){
        itemRepository.delete(id);
    }

    public Boolean addSpecialToItem(ItemDTO dto){
        Item item = itemRepository.findOne(dto.getId());
        if (item != null){
            if (dto.getSpecial() != null){
                item.setHasSpecial(true);
                item.setSpecial(dto.getSpecial());
                itemRepository.save(item);
                return true;
            }
            else{
                throw new CustomException("There is no special found to be applied to the item");
            }
        }
        else
        {
            throw new CustomException("A special cannot be applied to the item as the item does not exist");
        }
    }

    public void removeSpecialFromItem(Long id){
        Item item = itemRepository.findOne(id);
        if (item != null){
            item.setHasSpecial(false);
            item.setSpecial(null);
        }
    }


}
