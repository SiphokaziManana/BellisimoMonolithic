package com.bellisimo.monolithic.mapper;

import com.bellisimo.monolithic.domain.Special;
import com.bellisimo.monolithic.domain.SpecialDTO;

import java.util.List;

/**
 * Created by siphokazi on 2017/07/23.
 */
public interface SpecialMapper {

    Special specialDTOToSpecial(SpecialDTO specialDTO);
    List<Special> specialDTOsToSpecials(List<SpecialDTO> specialDTOS);
    SpecialDTO specialToSpecialDTO(Special special);
    List<SpecialDTO> specialsToSpecialDTOs(List<Special> specials);
}
