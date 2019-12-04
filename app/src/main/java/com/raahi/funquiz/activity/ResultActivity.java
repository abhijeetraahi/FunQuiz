package com.raahi.funquiz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.raahi.funquiz.R;

import java.io.IOException;
import java.io.InputStream;

public class ResultActivity extends AppCompatActivity {

    private TextView txtQuestion1,txtQuestion2,txtQuestion3,txtQuestion4,txtQuestion5,
                     txtYourAnswer1,txtYourAnswer2,txtYourAnswer3,txtYourAnswer4,txtYourAnswer5;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_activity_result);

        init();

        getSupportActionBar().setTitle("Your ResultActivity");
        String json = inputStreamToString(ResultActivity.this.getResources().openRawResource(R.raw.questions));
    }

    private void init()
    {
        txtQuestion1 = findViewById(R.id.TextViewQuestion1);
        txtQuestion2 = findViewById(R.id.TextViewQuestion2);
        txtQuestion3 = findViewById(R.id.TextViewQuestion3);
        txtQuestion4 = findViewById(R.id.TextViewQuestion4);
        txtQuestion5 = findViewById(R.id.TextViewQuestion5);
        txtYourAnswer1 = findViewById(R.id.TextViewYourAnswer1);
        txtYourAnswer2= findViewById(R.id.TextViewYourAnswer2);
        txtYourAnswer3= findViewById(R.id.TextViewYourAnswer3);
        txtYourAnswer4= findViewById(R.id.TextViewYourAnswer4);
        txtYourAnswer5= findViewById(R.id.TextViewYourAnswer5);
    }

    public String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            return new String(bytes);
        } catch (IOException e) {
            return null;
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
