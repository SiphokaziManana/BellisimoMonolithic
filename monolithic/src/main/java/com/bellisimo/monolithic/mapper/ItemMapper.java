package com.bellisimo.monolithic.mapper;

import com.bellisimo.monolithic.domain.Item;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.domain.Special;
import com.bellisimo.monolithic.domain.SpecialDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by siphokazi on 2017/07/23.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ItemMapper {

    Item itemDTOToItem(ItemDTO itemDTO);
    List<Item> itemDTOsToItems(List<ItemDTO> itemDTOS);

    ItemDTO itemToItemDTO(Item item);
    List<ItemDTO> itemsToItemDTOs(List<Item> items);

    Special specialDTOToSpecial(SpecialDTO specialDTO);
    List<Special> specialDTOsToSpecials(List<SpecialDTO> specialDTOS);
    SpecialDTO specialToSpecialDTO(Special special);
    List<SpecialDTO> specialsToSpecialDTOs(List<Special> specials);

}
