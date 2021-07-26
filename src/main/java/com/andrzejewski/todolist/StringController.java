package com.andrzejewski.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "strings")
public class StringController {

    @Autowired
    private final StringService stringService;

    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping
    public List<StringEntity> getAllStrings() {
        return stringService.getAllStrings();

    }

    @GetMapping(path = "/get/{stringId}")
    public StringEntity getById(@PathVariable("stringId") Long id) {
        return stringService.getById(id);
    }

    @GetMapping(path = "/getString/{string}")
    public String getString(@PathVariable("string") String string) {
        return stringService.getString() + string;
    }

    @PostMapping
    public void addNewString(@RequestBody StringEntity stringEntity) {
        stringService.addNewString(stringEntity);
    }

    @DeleteMapping(path = "/delete/{stringId}")
    public void deleteString(@PathVariable("stringId") Long stringId) {
        stringService.deleteString(stringId);
    }

    @PutMapping(path = "/{stringId}")
    public void updateString(@PathVariable("stringId") Long id,
                             @RequestParam(required = false) String text) {
        stringService.updateString(id, text);
    }
}
