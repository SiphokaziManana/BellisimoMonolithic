package com.bellisimo.monolithic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siphokazi on 2017/07/17.
 */
public class ItemDTO implements AbstractDTO<Item, ItemDTO> {

    private Long id;
    private String name;
    private String code;
    private Double price;
    private String category;
    private Image image;
    private Special specialDTO;
    private Boolean hasSpecial;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setSpecialDTO(Special specialDTO) {
        this.specialDTO = specialDTO;
    }

    public Special getSpecialDTO() {
        return specialDTO;
    }

    public void setHasSpecial(Boolean hasSpecial) {
        this.hasSpecial = hasSpecial;
    }

    public Boolean getHasSpecial() {
        return hasSpecial;
    }

    @Override
    public Item toEntity(ItemDTO dto) {
        Item result = new Item();

        result.setId(dto.getId());
        result.setName(dto.getName());
        result.setCode(dto.getCode());
        if (dto.getCategory().equals("FOOD")){
            result.setCategory(Item.Category.FOOD);
        }
        else if ( dto.getCategory().equals("CLOTHING")){
            result.setCategory(Item.Category.CLOTHING);
        }
        else{
            result.setCategory(Item.Category.UNKNOWN);
        }
        result.setPrice(dto.getPrice());
        result.setImage(dto.getImage());
        result.setHasSpecial(dto.getHasSpecial());
        result.setSpecial(dto.getSpecialDTO());
        return result;
    }

    @Override
    public ItemDTO toDTO(Item entity) {
        ItemDTO result = new ItemDTO();
        result.setId(entity.getId());
        result.setCategory(entity.getCategory().toString());
        result.setCode(entity.getCode());
        result.setHasSpecial(entity.getHasSpecial());
        result.setName(entity.getName());
        result.setImage(entity.getImage());
        result.setSpecialDTO(entity.getSpecial());
        result.setPrice(entity.getPrice());
        return result;
    }

    @Override
    public List<Item> toEntities(List<ItemDTO> dto) {
        return null;
    }

    @Override
    public List<ItemDTO> toDTOs(List<Item> entities) {
        List<ItemDTO> results = new ArrayList<>();
        for (Item entity : entities) {
            ItemDTO result = toDTO(entity);
            results.add(result);
        }
        return results;
    }
}
