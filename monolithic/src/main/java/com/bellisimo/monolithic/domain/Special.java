package com.bellisimo.monolithic.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by siphokazi on 2017/07/17.
 */
@Entity
public class Special {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column (nullable = false)
    private Double percentage;

    @Column (nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column
    private Image image;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public Double getPercentage(){
        return percentage;
    }
    public void setPercentage( Double percentage){
        this.percentage = percentage;
    }

    public Date getStartDate(){
        return startDate;
    }
    public void  setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return endDate;
    }
    public void  setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Image getImage(){
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
}
