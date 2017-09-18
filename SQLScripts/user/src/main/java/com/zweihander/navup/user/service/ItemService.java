package com.zweihander.navup.user.service;

import com.zweihander.navup.user.exception.CustomException;
import com.zweihander.navup.user.mapper.ItemMapper;
import com.zweihander.navup.user.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zweihander.navup.user.domain.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by siphokazi on 2017/09/17.
 */
@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemMapper itemMapper;

    //@Autowired
    RestTemplate restTemplate = new RestTemplate();

    public ItemDTO addItem(ItemDTO dto){
        if ( dto.getHasSpecial() == null){
            dto.setHasSpecial(false);
        }
        if (dto.getCategory() == null){
            dto.setCategory("UNKNOWN");
        }
        try {
            Item obj = itemRepository.save(itemMapper.itemDTOToItem(dto));
            ItemDTO result = itemMapper.itemToItemDTO(obj);
            return result;
        }catch (Exception e){
            throw new CustomException("Could not ADD ITEM into the database. Error: " + e.toString());
        }
    }

    public ItemDTO updateItem(Long id , ItemDTO dto)  {
        Item item;

        if ( id != null){
            item = itemRepository.findOne(id);
        }
        else{
            return addItem(dto);
        }
        try{
            if ( item != null){

                if (dto.getHasSpecial()){
                    //Special special = specialRepository.getOne(dto.getSpecial());
                    Special special = restTemplate.getForObject(
                            "http://localhost:8761/api/navigation/find/{id}",
                            Special.class,
                            dto.getSpecial()
                    );
                    item.setHasSpecial(true);
                    item.setSpecial(dto.getSpecial());
                    item.setSpecialPrice(item.getPrice() * (special.getPercentage()/100));
                }
                else{
                    item.setHasSpecial(false);
                }
                if ( dto.getImage() != null)
                    item.setImage(dto.getImage());
                if ( dto.getPrice() != null)
                    item.setPrice(dto.getPrice());
                if ( dto.getName() != null)
                    item.setName(dto.getName());
                ItemDTO result = itemMapper.itemToItemDTO(itemRepository.save(item));
                return result;
            }
            else{
                throw new CustomException("Item Could not be found");
            }
        }catch (Exception e){
            throw new CustomException("Could not UPDATE ITEM in the database. Error: " + e.toString());
        }
    }

    public List<ItemDTO> getAllFoodItems(){
        return itemMapper.itemsToItemDTOs(itemRepository.findByCategory("FOOD"));
    }


    public List<ItemDTO> getAllClothingItems(){
        return itemMapper.itemsToItemDTOs(itemRepository.findByCategory("CLOTHING"));
    }
    public ItemDTO getItem(Long id){
        Item item = itemRepository.findOne(id);

        if ( item.getHasSpecial()){
//            Special special = specialRepository.findOne(item.getSpecial());
            Special special = restTemplate.getForObject(
                    "http://localhost:8761/api/navigation/find/{id}",
                    Special.class,
                    item.getSpecial()
            );
            Double specialPrice = item.getPrice() * special.getPercentage();
            item.setPrice(specialPrice);
        }
        ItemDTO result = itemMapper.itemToItemDTO(item);
        return result;
    }

    public void deleteItem(Long id){
        itemRepository.delete(id);
    }

    public ItemDTO addSpecialToItem(ItemDTO dto){
        Item item = itemRepository.findOne(dto.getId());
        if (item != null){
            if (dto.getSpecial() != null){
                //Special special = specialRepository.getOne(dto.getSpecial());
                Special special = restTemplate.getForObject(
                        "http://localhost:8761/api/navigation/find/{id}",
                        Special.class,
                        dto.getSpecial()
                );

                System.out.println("\n \n retrieved the special \n " + special.toString());
                item.setHasSpecial(true);
                item.setSpecial(dto.getSpecial());
                item.setSpecialPrice( item.getPrice() * (special.getPercentage()/100));
                ItemDTO result = itemMapper.itemToItemDTO(itemRepository.save(item));
                return result;
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
}
