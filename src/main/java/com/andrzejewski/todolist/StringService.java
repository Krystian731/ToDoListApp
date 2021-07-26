package com.andrzejewski.todolist;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class StringService {

    @Autowired
    private StringRepository stringRepository;

    public StringService(StringRepository stringRepository) {
        this.stringRepository = stringRepository;
    }

    public List<StringEntity> getAllStrings() { return Lists.newArrayList(stringRepository.findAll()); }

    public StringEntity getById(Long id) {
        StringEntity stringEntity = stringRepository.findById(id).orElseThrow(() -> new StringDoesNotExistException(id));
        return stringEntity;
    }

    public String getString() {
        Random random = new Random();

        List<StringEntity> stringEntities = Lists.newArrayList(stringRepository.findAll());

        int n = random.nextInt(stringEntities.size());
        Long randomNumber = Long.valueOf(n);
        return stringEntities.get(n).getStringText();
    }

    public void addNewString(StringEntity stringEntity){
        stringRepository.save(stringEntity);
    }

    public void deleteString(Long id) {
        if (!stringRepository.existsById(id)) { throw new StringDoesNotExistException(id); }
        stringRepository.deleteById(id);
    }

    @Transactional
    public void updateString(Long id, String text) {
        StringEntity stringEntity = stringRepository.findById(id).orElseThrow(() -> new StringDoesNotExistException(id));
        stringEntity.setStringText(text);
    }
}
