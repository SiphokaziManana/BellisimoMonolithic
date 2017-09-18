package com.zweihander.navup.navigation.mapper;

import com.zweihander.navup.navigation.domain.Special;
import com.zweihander.navup.navigation.domain.SpecialDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by siphokazi on 2017/09/17.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SpecialMapper {

    Special specialDTOToSpecial(SpecialDTO specialDTO);
    List<Special> specialDTOsToSpecials(List<SpecialDTO> specialDTOS);
    SpecialDTO specialToSpecialDTO(Special special);
    List<SpecialDTO> specialsToSpecialDTOs(List<Special> specials);
}
