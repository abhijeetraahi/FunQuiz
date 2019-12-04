package com.raahi.funquiz.DataManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.raahi.funquiz.Model.answers;

public class QuizDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "quizDatabase";
    private static final String TABLE_NAME = "answers";
    private static final String ID = "id";
    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";


    public QuizDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
                + ANSWER + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public void addAnswer(answers answerModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QUESTION, answerModel.getId());
        values.put(ANSWER, answerModel.getAnswerString());
        db.insert(TABLE_NAME,null, values);
        db.close();

    }
}
