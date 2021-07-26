package com.andrzejewski.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;


@Service
public class StringService {

    @Autowired
    private StringRepository stringRepository;

    public StringService(StringRepository stringRepository) {
        this.stringRepository = stringRepository;
    }

    public List<StringEntity> getAllStrings() {
        return stringRepository.findAll();
    }

    public StringEntity getById(Long id) {
        StringEntity stringEntity = stringRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("String with that id doesn't exists"));
        return stringEntity;
    }

    public String getString() {
        Random random = new Random();
        int n = random.nextInt(50);
        Long randomNumber = Long.valueOf(n);
        while (true) {

            if (stringRepository.existsById(randomNumber)) {
                return stringRepository.findById(randomNumber).get().getString_text();
            }
            n = random.nextInt(50);
            randomNumber = Long.valueOf(n);
        }
    }

    public void addNewString(StringEntity stringEntity){
        stringRepository.save(stringEntity);
    }

    public void deleteString(Long id) {
        if (!stringRepository.existsById(id)) {
            throw new IllegalStateException("String with that id doesn't exists");
        }
        stringRepository.deleteById(id);
    }

    @Transactional
    public void updateString(Long id, String text) {
        StringEntity stringEntity = stringRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("String with that id doesn't exists"));
        stringEntity.setString_text(text);
    }
}
