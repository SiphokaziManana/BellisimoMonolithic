package com.bellisimo.monolithic.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by siphokazi on 2017/07/17.
 */
public class SpecialDTO implements AbstractDTO<Special, SpecialDTO> {

    private Long id;
    private String description;
    private Double percentage;
    private Date startDate;
    private Date endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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


    @Override
    public Special toEntity(SpecialDTO dto) {
        Special result = new Special();
        result.setId(dto.getId());
        result.setDescription(dto.getDescription());
        result.setPercentage(dto.getPercentage());
        result.setStartDate(dto.getStartDate());
        result.setEndDate(dto.getEndDate());
        result.setName(dto.getName());
        result.setImage(dto.getImage());
        return result;
    }

    @Override
    public SpecialDTO toDTO(Special entity) {
        SpecialDTO result = new SpecialDTO();
        result.setId(entity.getId());
        result.setDescription(entity.getDescription());
        result.setEndDate(entity.getEndDate());
        result.setStartDate(entity.getStartDate());
        result.setImage(entity.getImage());
        result.setName(entity.getName());
        result.setPercentage(entity.getPercentage());
        return result;
    }

    @Override
    public List<Special> toEntities(List<SpecialDTO> dto) {
        return null;
    }

    @Override
    public List<SpecialDTO> toDTOs(List<Special> entities) {
        List<SpecialDTO> results = new ArrayList<>();
        for (Special entity : entities) {
            SpecialDTO result = toDTO(entity);
            results.add(result);
        }
        return results;
    }
}
