package com.andrzejewski.todolist;

import javax.persistence.*;

@Entity
@Table(name = "string")
public class StringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long string_id;

    private String string_text;

    public StringEntity() {
    }

    public StringEntity(Long string_id, String string_text) {
        this.string_id = string_id;
        this.string_text = string_text;
    }

    public StringEntity(String string_text) {
        this.string_text = string_text;
    }

    public Long getString_id() {
        return string_id;
    }

    public void setString_id(Long string_id) {
        this.string_id = string_id;
    }

    public String getString_text() {
        return string_text;
    }

    public void setString_text(String string_text) {
        this.string_text = string_text;
    }

    @Override
    public String toString() {
        return "StringEntity{" +
                "id=" + string_id + '\'' +
                ", text='" + string_text + '\'' +
                '}';
    }
}
