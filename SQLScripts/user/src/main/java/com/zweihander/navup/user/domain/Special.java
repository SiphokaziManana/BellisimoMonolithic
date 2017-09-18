package com.zweihander.navup.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

/**
 * Created by siphokazi on 2017/09/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Special {

    private Long id;
    private String description;
    private Double percentage;
    /*private LocalDateTime startDate;
    private LocalDateTime endDate;*/
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

    /*public LocalDateTime getStartDate() {
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
    }*/

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

    @Override
    public String toString(){
        return "{ name=" + this.name + "; " +
                "percentage=" + this.percentage + ";" +
                /*"startDate=" + this.startDate + ";" +
                "endDate=" + this.endDate + ";" +*/
                "description=" + this.description + ";" +
                "}";
    }
}
