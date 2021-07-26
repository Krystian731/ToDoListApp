package com.andrzejewski.todolist;

import javax.persistence.*;

@Entity
@Table(name = "string")
public class StringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long stringId;

    private String stringText;

    public StringEntity() {
    }

    public StringEntity(Long stringId, String stringText) {
        this.stringId = stringId;
        this.stringText = stringText;
    }

    public StringEntity(String stringText) {
        this.stringText = stringText;
    }

    public Long getStringId() {
        return stringId;
    }

    public void setStringId(Long stringId) {
        this.stringId = stringId;
    }

    public String getStringText() {
        return stringText;
    }

    public void setStringText(String stringText) {
        this.stringText = stringText;
    }

    @Override
    public String toString() {
        return "StringEntity{" +
                "id=" + stringId + '\'' +
                ", text='" + stringText + '\'' +
                '}';
    }
}
