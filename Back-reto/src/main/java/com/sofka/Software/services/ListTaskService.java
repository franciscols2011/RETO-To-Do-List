package com.sofka.Software.services;

import com.sofka.Software.models.ListTaskModel;
import com.sofka.Software.repositories.ListTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ListTaskService {
    @Autowired
    private ListTaskRepository listTaskRepository;
    public Iterable<ListTaskModel> list(){
        return listTaskRepository.findAll();
    }


    public ListTaskModel createListTask(ListTaskModel listTask){
        listTask.setCompleted(false);
        return listTaskRepository.save(listTask);
    }


    public void deleteListTask(Long id){
        listTaskRepository.delete(get(id));
    }

    public ListTaskModel get(Long id){
        return listTaskRepository.findById(id).orElseThrow();
    }


    @Transactional
    public ListTaskModel updateListTask(Long id, ListTaskModel listTask) {
        listTask.setId(get(id).getId());
        return listTaskRepository.save(listTask);
    }
}
