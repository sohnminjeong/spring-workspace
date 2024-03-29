package com.kh.api.service;

import com.kh.api.domain.Animal;
import com.kh.api.repo.AnimalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalDAO dao;

    public void insert(Animal vo){
        dao.save(vo);
    }

    public List<Animal> select(){
        return dao.findAll();
    }

    public Animal select(int no){
        return dao.findById(no).orElse(null);
    }

    public void update(Animal vo){
        if(dao.existsById(vo.getNo())) {
            dao.save(vo);
        }
    }

    public void delete(int no){
        if(dao.existsById(no)){
            dao.deleteById(no);
        }

    }
}
