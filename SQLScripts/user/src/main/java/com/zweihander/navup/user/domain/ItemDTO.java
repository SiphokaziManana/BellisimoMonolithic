package com.zweihander.navup.user.domain;

/**
 * Created by siphokazi on 2017/09/17.
 */
public class ItemDTO {

    /*@Inject
    ItemMapper itemMapper;*/

    private Long id;
    private String name;
    private String code;
    private Double price;
    private Double specialPrice;
    private String category;
    private Image image;
    private Long special;
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

    public void setSpecial(Long special) {
        this.special = special;
    }

    public Long getSpecial() {
        return special;
    }

    public void setHasSpecial(Boolean hasSpecial) {
        this.hasSpecial = hasSpecial;
    }

    public Boolean getHasSpecial() {
        return hasSpecial;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    /*public Item toEntity(){
        return itemMapper.itemDTOToItem(this);
    }*/

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", special='" + special + '\'' +
                ", hasSpecial='" + hasSpecial + '\'' +
                "}";
    }

}
