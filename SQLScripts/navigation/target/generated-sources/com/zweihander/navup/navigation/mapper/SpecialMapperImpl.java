package com.zweihander.navup.navigation.mapper;

import com.zweihander.navup.navigation.domain.Special;

import com.zweihander.navup.navigation.domain.SpecialDTO;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-18T22:54:01+0200",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"

)

@Component

public class SpecialMapperImpl implements SpecialMapper {

    @Override

    public Special specialDTOToSpecial(SpecialDTO specialDTO) {

        if ( specialDTO == null ) {

            return null;
        }

        Special special = new Special();

        special.setId( specialDTO.getId() );

        special.setName( specialDTO.getName() );

        special.setDescription( specialDTO.getDescription() );

        special.setPercentage( specialDTO.getPercentage() );

        special.setStartDate( specialDTO.getStartDate() );

        special.setEndDate( specialDTO.getEndDate() );

        special.setImage( specialDTO.getImage() );

        return special;
    }

    @Override

    public List<Special> specialDTOsToSpecials(List<SpecialDTO> specialDTOS) {

        if ( specialDTOS == null ) {

            return null;
        }

        List<Special> list = new ArrayList<Special>();

        for ( SpecialDTO specialDTO : specialDTOS ) {

            list.add( specialDTOToSpecial( specialDTO ) );
        }

        return list;
    }

    @Override

    public SpecialDTO specialToSpecialDTO(Special special) {

        if ( special == null ) {

            return null;
        }

        SpecialDTO specialDTO = new SpecialDTO();

        specialDTO.setId( special.getId() );

        specialDTO.setDescription( special.getDescription() );

        specialDTO.setPercentage( special.getPercentage() );

        specialDTO.setStartDate( special.getStartDate() );

        specialDTO.setEndDate( special.getEndDate() );

        specialDTO.setName( special.getName() );

        specialDTO.setImage( special.getImage() );

        return specialDTO;
    }

    @Override

    public List<SpecialDTO> specialsToSpecialDTOs(List<Special> specials) {

        if ( specials == null ) {

            return null;
        }

        List<SpecialDTO> list = new ArrayList<SpecialDTO>();

        for ( Special special : specials ) {

            list.add( specialToSpecialDTO( special ) );
        }

        return list;
    }
}

