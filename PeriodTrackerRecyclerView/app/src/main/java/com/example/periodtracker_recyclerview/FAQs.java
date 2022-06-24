package com.example.periodtracker_recyclerview;

public class FAQs {

    private String title;
    private String question;
    //Links to answers to questions

    FAQs(String title, String question) {
        this.title = title;
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
