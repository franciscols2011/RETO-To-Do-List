package com.sofka.Software.services;

import com.sofka.Software.models.ListModel;
import com.sofka.Software.repositories.ListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ListService {
    @Autowired
    private ListRepository listRepository;

    public Iterable<ListModel> list(){

        return listRepository.findAll();
    }


    public ListModel createList(ListModel lista){
        return listRepository.save(lista);
    }


    public void deleteTask(Long id){
        listRepository.delete(get(id));
    }


    public ListModel get(Long id){

        return listRepository.findById(id).orElseThrow();
    }
}
