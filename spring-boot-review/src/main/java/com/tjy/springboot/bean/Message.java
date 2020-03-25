package com.tjy.springboot.bean;

/**
 * @author tjy
 * @ClassName Message
 * @Description TODO
 * @Date 2020/3/24 11:37
 * @Version 1.0
 **/
public class Message {
    private String text;
    private Integer num;

    public Message(String text, Integer num) {
        this.text = text;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", num=" + num +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
