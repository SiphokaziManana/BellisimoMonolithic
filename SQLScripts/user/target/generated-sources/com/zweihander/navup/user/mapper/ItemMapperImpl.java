package com.zweihander.navup.user.mapper;

import com.zweihander.navup.user.domain.Item;

import com.zweihander.navup.user.domain.ItemDTO;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-18T23:25:30+0200",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"

)

@Component

public class ItemMapperImpl implements ItemMapper {

    @Override

    public Item itemDTOToItem(ItemDTO itemDTO) {

        if ( itemDTO == null ) {

            return null;
        }

        Item item = new Item();

        item.setId( itemDTO.getId() );

        item.setName( itemDTO.getName() );

        item.setCode( itemDTO.getCode() );

        item.setPrice( itemDTO.getPrice() );

        item.setCategory( itemDTO.getCategory() );

        item.setImage( itemDTO.getImage() );

        item.setHasSpecial( itemDTO.getHasSpecial() );

        item.setSpecial( itemDTO.getSpecial() );

        item.setSpecialPrice( itemDTO.getSpecialPrice() );

        return item;
    }

    @Override

    public List<Item> itemDTOsToItems(List<ItemDTO> itemDTOS) {

        if ( itemDTOS == null ) {

            return null;
        }

        List<Item> list = new ArrayList<Item>();

        for ( ItemDTO itemDTO : itemDTOS ) {

            list.add( itemDTOToItem( itemDTO ) );
        }

        return list;
    }

    @Override

    public ItemDTO itemToItemDTO(Item item) {

        if ( item == null ) {

            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId( item.getId() );

        itemDTO.setName( item.getName() );

        itemDTO.setCode( item.getCode() );

        itemDTO.setPrice( item.getPrice() );

        itemDTO.setCategory( item.getCategory() );

        itemDTO.setImage( item.getImage() );

        itemDTO.setSpecial( item.getSpecial() );

        itemDTO.setHasSpecial( item.getHasSpecial() );

        itemDTO.setSpecialPrice( item.getSpecialPrice() );

        return itemDTO;
    }

    @Override

    public List<ItemDTO> itemsToItemDTOs(List<Item> items) {

        if ( items == null ) {

            return null;
        }

        List<ItemDTO> list = new ArrayList<ItemDTO>();

        for ( Item item : items ) {

            list.add( itemToItemDTO( item ) );
        }

        return list;
    }
}

