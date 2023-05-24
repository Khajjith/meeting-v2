package com.example.onkules.data.repository.impl;

import com.example.onkules.data.model.Meeting;
import com.example.onkules.data.repository.MRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MettingRepo implements MRepository<Meeting,Long> {
    private static final Map<Long, Meeting> STORIGE = new HashMap<>();


    @Override
    public Meeting save(Meeting ules){
        Long id = STORIGE.size()+1L;
        ules.setId(id);
        STORIGE.put(id,ules);
        return STORIGE.get(id);
    }
    @Override
    public Optional<Meeting> getById(Long id){
        return Optional.ofNullable(STORIGE.get(id));
    }


    @Override
    public List<Meeting> getAll() {
        return STORIGE.values().stream().toList();
    }

    @Override
    public Meeting update(Meeting ules){
        Long id = ules.getId();
        STORIGE.put(id,ules);
        return STORIGE.get(id);
    }
    @Override
    public void deleteById(Long id){
        STORIGE.remove(id);
    }
}
