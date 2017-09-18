package com.zweihander.navup.navigation.domain;

import com.zweihander.navup.navigation.mapper.SpecialMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Created by siphokazi on 2017/09/17.
 */
public class SpecialDTO {

    @Autowired
    SpecialMapper specialMapper;

    private Long id;
    private String description;
    private Double percentage;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String name;
    private Image image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Special toEntity(){
        return specialMapper.specialDTOToSpecial(this);
    }

}