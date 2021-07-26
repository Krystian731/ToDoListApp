package com.andrzejewski.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "strings")
public class StringController {

    @Autowired
    private final StringService mStringService;

    public StringController(StringService stringService) {
        this.mStringService = stringService;
    }

    @GetMapping
    public List<StringEntity> getAllStrings() {
        return mStringService.getAllStrings();

    }

    @GetMapping(path = "/get/{stringId}")
    public StringEntity getById(@PathVariable("stringId") Long id) {
        return mStringService.getById(id);
    }

    @GetMapping(path = "/getString/{string}")
    public String getString(@PathVariable("string") String string) {
        return mStringService.getString() + string;
    }

    @PostMapping
    public void addNewString(@RequestBody StringEntity stringEntity) {
        mStringService.addNewString(stringEntity);
    }

    @DeleteMapping(path = "/delete/{stringId}")
    public void deleteString(@PathVariable("stringId") Long stringId) {
        mStringService.deleteString(stringId);
    }

    @PutMapping(path = "/{stringId}")
    public void updateString(@PathVariable("stringId") Long id,
                             @RequestParam(required = false) String text) {
        mStringService.updateString(id, text);
    }
}
