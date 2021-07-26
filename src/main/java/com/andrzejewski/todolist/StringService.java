package com.andrzejewski.todolist;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;


@Service
public class StringService {

    @Autowired
    private StringRepository mStringRepository;

    public StringService(StringRepository stringRepository) {
        this.mStringRepository = stringRepository;
    }

    public List<StringEntity> getAllStrings() { return Lists.newArrayList(mStringRepository.findAll()); }

    public StringEntity getById(Long id) {
        StringEntity stringEntity = mStringRepository.findById(id)
                .orElseThrow(() -> new StringDoesNotExistException(id));
        return stringEntity;
    }

    public String getString() {
        Random random = new Random();

        List<StringEntity> stringEntities = Lists.newArrayList(mStringRepository.findAll());

        int n = random.nextInt(stringEntities.size());
        Long randomNumber = Long.valueOf(n);
        return stringEntities.get(n).getStringText();
    }

    public void addNewString(StringEntity stringEntity){
        mStringRepository.save(stringEntity);
    }

    public void deleteString(Long id) {
        if (!mStringRepository.existsById(id)) throw new StringDoesNotExistException(id);
        mStringRepository.deleteById(id);
    }

    @Transactional
    public void updateString(Long id, String text) {
        StringEntity stringEntity = mStringRepository.findById(id).orElseThrow(() -> new StringDoesNotExistException(id));
        stringEntity.setStringText(text);
    }
}
