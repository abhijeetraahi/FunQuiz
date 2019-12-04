package com.raahi.funquiz.adapter;

/**
 * Created by admin on 27-Aug-19.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.raahi.funquiz.Model.Questions;
import com.raahi.funquiz.R;

import java.util.HashMap;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder> {

    private List<Questions> questionsList;
    private HashMap<String, String> userAnswerList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvQuestionName;
        public TextView tvAnswerUser;
        public TextView tvAnswerJson;
        public ImageView imageViewAnswer;


        public MyViewHolder(View view) {
            super(view);
            /*tvQuestionName = (TextView) view.findViewById(R.id.tv_question);
            tvAnswerUser = (TextView) view.findViewById(R.id.tv_answer_user);
            tvAnswerJson = (TextView) view.findViewById(R.id.tv_answer_json);
            imageViewAnswer = (ImageView) view.findViewById(R.id.iv_status);*/


        }
    }


    public ResultAdapter(List<Questions> questionsList, Context context, HashMap<String, String> userAnswerList) {
        this.questionsList = questionsList;
        this.context = context;
        this.userAnswerList = userAnswerList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Questions questions = questionsList.get(position);
        holder.tvQuestionName.setText(questions.getQuestion());


        /*if(questions.getAnswer().equalsIgnoreCase(userAnswerList.get(String.valueOf(position)))){
            holder.tvAnswerJson.setVisibility(View.GONE);
            holder.imageViewAnswer.setImageResource(R.drawable.ic_correct);
            holder.tvAnswerUser.setText("Answer : "+userAnswerList.get(String.valueOf(position)));
            holder.tvAnswerJson.setText(questions.getAnswer());
        }
        else{
            holder.tvAnswerJson.setVisibility(View.VISIBLE);
            holder.imageViewAnswer.setImageResource(R.drawable.ic_error);
            holder.tvAnswerUser.setText("Your Response : "+userAnswerList.get(String.valueOf(position)));
            holder.tvAnswerJson.setText("Correct Answer : "+questions.getAnswer());
        }*/


    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }
}