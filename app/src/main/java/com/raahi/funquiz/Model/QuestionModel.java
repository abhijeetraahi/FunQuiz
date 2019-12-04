package com.raahi.funquiz.Model;

import java.util.ArrayList;
import java.util.List;

public class QuestionModel {

    private List<Questions> questionsList;

    public QuestionModel(){
        questionsList = new ArrayList<>();
    }
    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }
}
