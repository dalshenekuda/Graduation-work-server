package com.example.diplom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;
    private String qr;

    public Message() {
    }

    public Message(String text, String tag, String qr) {
        this.text = text;
        this.tag = tag;
        this.qr = qr;
    }


    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQr() {
        return qr;
    }
    public void setQr(String qr) {
        this.qr = qr;
    }
}
