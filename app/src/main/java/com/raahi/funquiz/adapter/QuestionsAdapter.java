package com.raahi.funquiz.adapter;

/**
 * Created by admin on 27-Aug-19.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.raahi.funquiz.Model.QuestionModel;
import com.raahi.funquiz.R;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.MyViewHolder> {

    private QuestionModel questionModel;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvQuestionName;
        public RadioGroup questionRadioGroup;
        public RadioButton radioOption1;
        public RadioButton radioOption2;
        public RadioButton radioOption3;
        public RadioButton radioOption4;

        public MyViewHolder(View view) {
            super(view);
            tvQuestionName = view.findViewById(R.id.tv_question);
            questionRadioGroup = view.findViewById(R.id.radio_group);
            radioOption1 = view.findViewById(R.id.radio_option_1);
            radioOption2 = view.findViewById(R.id.radio_option_2);
            radioOption3 = view.findViewById(R.id.radio_option_3);
            radioOption4 = view.findViewById(R.id.radio_option_4);

        }
    }


    public QuestionsAdapter(QuestionModel questionModel, Context context) {
        this.questionModel = questionModel;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.questions_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        /*holder.questionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                 //   Toast.makeText(context, rb.getText(), Toast.LENGTH_SHORT).show();
                    if (context instanceof MainActivity) {
                        ((MainActivity)context).noteAnswer(position, String.valueOf(rb.getText()));
                    }
                }

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return questionModel.getQuestionsList().size();
    }
}