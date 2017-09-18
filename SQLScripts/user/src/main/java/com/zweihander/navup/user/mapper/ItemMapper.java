package com.zweihander.navup.user.mapper;

import com.zweihander.navup.user.domain.Item;
import com.zweihander.navup.user.domain.ItemDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by siphokazi on 2017/09/17.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ItemMapper {

    Item itemDTOToItem(ItemDTO itemDTO);
    List<Item> itemDTOsToItems(List<ItemDTO> itemDTOS);

    ItemDTO itemToItemDTO(Item item);
    List<ItemDTO> itemsToItemDTOs(List<Item> items);
}
