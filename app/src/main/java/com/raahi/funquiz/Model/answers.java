package com.raahi.funquiz.Model;

import java.io.Serializable;

public class answers implements Serializable
{
    String id,answer;

    public answers(String id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswerString() {
        return answer;
    }

    public void setAnswerString(String answer) {
        this.answer = answer;
    }

}
