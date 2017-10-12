package com.bellisimo.monolithic.service;

import com.bellisimo.monolithic.domain.Item;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.domain.Special;
import com.bellisimo.monolithic.exception.CustomException;
import com.bellisimo.monolithic.mapper.ItemMapper;
import com.bellisimo.monolithic.repository.ItemRepository;
import com.bellisimo.monolithic.repository.SpecialRepository;

import javax.inject.Inject;
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


    //1 Vo = { obj, customException } = 2
    public ItemDTO addItem(ItemDTO dto){
        if ( dto.getHasSpecial() == null){ //a
            dto.setHasSpecial(false); //a
        }
        if (dto.getCategory() == null){ //a
            dto.setCategory("UNKNOWN"); //a
        }
        try { //a //b
            Item obj = itemRepository.save(itemMapper.itemDTOToItem(dto)); //a
            ItemDTO result = itemMapper.itemToItemDTO(obj);
            return result; //a
        }catch (Exception e){
            throw new CustomException("Could not ADD ITEM into the database. Error: " + e.toString()); //b
        }
    }

    //2 Vo = { item, customException } = 2
    public ItemDTO updateItem(Long id , ItemDTO dto){
        Item item;
        if ( id != null){//a
             item = itemRepository.findOne(id); //a
        }
        else{
            return addItem(dto);//a
        }
        try{//a //b
            if ( item != null){//a //b
                if (dto.getHasSpecial()){ //a
                    Special special = specialRepository.getOne(dto.getSpecial());//a
                    item.setHasSpecial(true);//a
                    item.setSpecial(dto.getSpecial());//a
                    item.setSpecialPrice(item.getPrice() * (special.getPercentage()/100));//a
                }
                else{
                    item.setHasSpecial(false);//a
                }
                if ( dto.getImage() != null)//a
                    item.setImage(dto.getImage());//a
                if ( dto.getPrice() != null)//a
                    item.setPrice(dto.getPrice());//a
                if ( dto.getName() != null)//a
                    item.setName(dto.getName());//a
                ItemDTO result = itemMapper.itemToItemDTO(itemRepository.save(item));
                return result;//a
            }
            else{
                throw new CustomException("Item Could not be found"); //b
            }
        }catch (Exception e){
            throw new CustomException("Could not UPDATE ITEM in the database. Error: " + e.toString()); //b
        }
    }

    //3
    public List<ItemDTO> getAllFoodItems(){
        return itemMapper.itemsToItemDTOs(itemRepository.findByCategory("FOOD"));
    }

    //4
    public List<ItemDTO> getAllClothingItems(){
        return itemMapper.itemsToItemDTOs(itemRepository.findByCategory("CLOTHING"));
    }

    //5 Vo = { item } = 1
    public ItemDTO getItem(Long id){
        Item item = itemRepository.findOne(id); //a
        if ( item.getHasSpecial()){ //a
            Special special = specialRepository.findOne(item.getSpecial());//a
            Double specialPrice = item.getPrice() * special.getPercentage();//a
            item.setPrice(specialPrice);//a
        }
        ItemDTO result = itemMapper.itemToItemDTO(item);
        return result;//a
    }

    //6
    public void deleteItem(Long id){
        itemRepository.delete(id);
    }

    //7 Vo = { item, customException } = 2
    public ItemDTO addSpecialToItem(ItemDTO dto){
        Item item = itemRepository.findOne(dto.getId()); //a
        if (item != null){ //a //b
            if (dto.getSpecial() != null){ //a //b
                Special special = specialRepository.getOne(dto.getSpecial()); //a
                item.setHasSpecial(true); //a
                item.setSpecial(dto.getSpecial());//a
                item.setSpecialPrice( item.getPrice() * (special.getPercentage()/100));//a
                ItemDTO result = itemMapper.itemToItemDTO(itemRepository.save(item));
                return result;//a

            }
            else{
                throw new CustomException("There is no special found to be applied to the item"); //b
            }
        }
        else
        {
            throw new CustomException("A special cannot be applied to the item as the item does not exist"); //b
        }
    }
}
