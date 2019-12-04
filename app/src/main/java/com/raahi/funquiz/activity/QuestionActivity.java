package com.raahi.funquiz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.raahi.funquiz.Model.QuestionModel;
import com.raahi.funquiz.Model.Questions;
import com.raahi.funquiz.R;
import com.raahi.funquiz.adapter.QuestionsAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private List<Questions> questionsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private QuestionsAdapter mAdapter;
    private HashMap<String,String > userAnswerList;
    private TextView btSubmit;
    private int count =0;
    private QuestionModel questionModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
        recyclerView = findViewById(R.id.recycler_view);

        /*String json = inputStreamToString(getResources().openRawResource(R.raw.questions));

        parentsModel = new Gson().fromJson(json, ParentsModel.class);*/


        String jsonData = getJsonStringFromFile(getResources().openRawResource(R.raw.questions));

        questionModel = new Gson().fromJson(jsonData, QuestionModel.class);

        mAdapter = new QuestionsAdapter(questionModel,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        //prepareQuestionData(jsonData);
    }


    public String getJsonStringFromFile(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            return new String(bytes);
        } catch (IOException e) {
            return null;
        }
    }

    public void submit(View v) {
        if(userAnswerList.size()==questionsList.size()) {
            for (int i = 0; i < questionsList.size(); i++) {
                if (questionsList.get(i).getAnswer().equalsIgnoreCase(userAnswerList.get(String.valueOf(i)))) {
                    count++;
                }
            }
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("question_list", (Serializable) questionsList);
            intent.putExtra("answer_list", (Serializable) userAnswerList);
            intent.putExtra("answer_count", String.valueOf(count));
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Please attempt all questions",Toast.LENGTH_LONG).show();
        }
    }

}
