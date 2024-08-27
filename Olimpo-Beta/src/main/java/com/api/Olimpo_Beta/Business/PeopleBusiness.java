package com.api.Olimpo_Beta.Business;

import com.api.Olimpo_Beta.Dto.PeopleDto;
import com.api.Olimpo_Beta.Entity.PeopleEntity;
import com.api.Olimpo_Beta.Service.PeopleService;
import com.api.Olimpo_Beta.Utilities.CustomException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleBusiness {

    @Autowired
    PeopleService peopleService;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<PeopleDto> findAll() {
        try {
            List<PeopleEntity> peopleList = peopleService.findAll();
            if (peopleList.isEmpty()) {
                return new ArrayList<>();
            }
            List<PeopleDto> peopleDtoList = new ArrayList<>();
            peopleList.forEach(person ->
                    peopleDtoList.add(modelMapper.map(person, PeopleDto.class))
            );
            return peopleDtoList;
        } catch (Exception e) {
            throw new CustomException("Error retrieving people");
        }
    }

    public PeopleDto getById(Long id) {
        try {
            PeopleEntity person = peopleService.getById(id);
            if (person == null) {
                throw new CustomException("Person with id " + id + " not found");
            }
            return modelMapper.map(person, PeopleDto.class);
        } catch (Exception e) {
            throw new CustomException("Error retrieving person");
        }
    }

    public void update(PeopleDto peopleDto) {
        try {
            PeopleEntity person = modelMapper.map(peopleDto, PeopleEntity.class);
            peopleService.update(person);
        } catch (Exception e) {
            throw new CustomException("Error updating person");
        }
    }

    public void create(PeopleDto peopleDto) {
        try {
            PeopleEntity person = modelMapper.map(peopleDto, PeopleEntity.class);
            peopleService.create(person);
        } catch (Exception e) {
            throw new CustomException("Error creating person");
        }
    }

    public void delete(Long id) {
        try {
            PeopleEntity person = peopleService.getById(id);
            if (person == null) {
                throw new CustomException("Person with id " + id + " not found");
            }
            peopleService.delete(person);
        } catch (Exception e) {
            throw new CustomException("Error deleting person");
        }
    }
}
