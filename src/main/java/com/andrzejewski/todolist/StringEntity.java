package com.andrzejewski.todolist;

import javax.persistence.*;

@Entity
@Table(name = "string")
public class StringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "string_id")
    private Long mStringId;

    @Column(name = "string_text")
    private String mStringText;

    public Long getStringId() {
        return mStringId;
    }

    public void setStringId(Long stringId) {
        this.mStringId = stringId;
    }

    public String getStringText() {
        return mStringText;
    }

    public void setStringText(String stringText) {
        this.mStringText = stringText;
    }

    @Override
    public String toString() {
        return "StringEntity{" +
                "id=" + mStringId + '\'' +
                ", text='" + mStringText + '\'' +
                '}';
    }
}
