package com.bellisimo.monolithic.service;

import com.bellisimo.monolithic.domain.Special;
import com.bellisimo.monolithic.domain.SpecialDTO;
import com.bellisimo.monolithic.exception.CustomException;
import com.bellisimo.monolithic.mapper.SpecialMapper;
import com.bellisimo.monolithic.repository.SpecialRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

/**
 * Created by siphokazi on 2017/07/27.
 */
@Service
public class SpecialService {

    @Inject
    SpecialRepository specialRepository;

    @Inject
    SpecialMapper specialMapper;

    //1 Vo = { obj, customException } = 2
    public SpecialDTO add(SpecialDTO dto){
        try { //a //b
            dto.setStartDate(LocalDateTime.now());//a
            dto.setEndDate(LocalDateTime.now().plus(20, ChronoUnit.DAYS));//a
            Special special = specialMapper.specialDTOToSpecial(dto);//a
            Special obj = specialRepository.save(special);//a
            SpecialDTO result = specialMapper.specialToSpecialDTO(obj);
            return result;//a
        }catch (Exception e){
            throw new CustomException("Could not ADD SPECIAL into the database. Error: " + e.toString()); //b
        }
    }

    //2 Vo = { obj, customException } = 2
    public SpecialDTO update(SpecialDTO dto){
        Special obj = specialRepository.findOne(dto.getId()); //a
        try{ //a //b
            if ( obj != null){ //a //b
                return specialMapper.specialToSpecialDTO(specialRepository.save(obj));//a
            }
            else{
                throw new CustomException("Special Could not be found"); //b
            }
        }catch (Exception e){
            throw new CustomException("Could not UPDATE SPECIAL in the database. Error: " + e.toString()); //b
        }
    }

    //3
    public List<SpecialDTO> getAll(){
        return specialMapper.specialsToSpecialDTOs(specialRepository.findAll()); //a
    }

    //4
    public SpecialDTO get(Long id){
        return specialMapper.specialToSpecialDTO(specialRepository.findOne(id));//a
    }

    //5
    public void delete(Long id){
        specialRepository.delete(id);//a
    }
}
