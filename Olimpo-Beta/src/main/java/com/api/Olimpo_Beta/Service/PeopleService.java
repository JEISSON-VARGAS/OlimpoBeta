package com.api.Olimpo_Beta.Service;

import com.api.Olimpo_Beta.Entity.PeopleEntity;
import com.api.Olimpo_Beta.Repository.PeopleRepository;
import com.api.Olimpo_Beta.Service.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService implements Idao<PeopleEntity , Long> {

    @Autowired
    PeopleRepository peopleRepository;

    @Override
    public List<PeopleEntity> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public PeopleEntity getById(Long id) {
        Optional<PeopleEntity> optionalPerson = peopleRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    @Override
    public void update(PeopleEntity entity) {
        this.peopleRepository.save(entity);
    }

    @Override
    public PeopleEntity save(PeopleEntity entity) {
        return this.peopleRepository.save(entity);
    }

    @Override
    public void delete(PeopleEntity entity) {
        this.peopleRepository.delete(entity);
    }

    @Override
    public void create(PeopleEntity entity) {
        this.peopleRepository.save(entity);
    }
}
