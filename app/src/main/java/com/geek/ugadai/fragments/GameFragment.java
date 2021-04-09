package com.geek.ugadai.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.geek.ugadai.DownloadImageTask;
import com.geek.ugadai.R;
import com.geek.ugadai.ToastClass;
import com.geek.ugadai.model.QuestionModel;

public class GameFragment extends GeneralFragment {
    TextView text_tv;
    EditText text_edt;
    Button check_btn;
    ImageView first_iv, second_iv, third_iv, fourth_iv;
    QuestionModel model;

    GameFragment() {
        super(R.layout.fragment_game);
    }

    @Override
    protected void initViews(View view) {
        text_tv = view.findViewById(R.id.textView);
        check_btn = view.findViewById(R.id.check_button);
        first_iv = view.findViewById(R.id.first_imageView);
        second_iv = view.findViewById(R.id.second_imageView2);
        third_iv = view.findViewById(R.id.third_imageView);
        fourth_iv = view.findViewById(R.id.fourth_imageView);
        text_edt = view.findViewById(R.id.text_editText);
        setViewsData();
    }

    private void setViewsData() {
        if (checkData() != null) {
            model = checkData();
            text_tv.setText(model.getCurrentLevel());
            new DownloadImageTask(first_iv).execute(model.getFirstImage());
            new DownloadImageTask(second_iv).execute(model.getSecondImage());
            new DownloadImageTask(third_iv).execute(model.getThirdImage());
            new DownloadImageTask(fourth_iv).execute(model.getFourthImage());
        } else new ToastClass(requireContext()).showToast("Something gone wrong on setViews");
    }


    private QuestionModel checkData() {
        if (getArguments() != null) {
            return (QuestionModel) getArguments().getSerializable("QUESTION_MODEL");
        }
        return null;
    }

    @Override
    protected void initClickers() {
        check_btn.setOnClickListener(v -> {
            if (model != null) checkForAnswer(text_edt.getText().toString());
            else {
                new ToastClass(requireContext()).showToast("Something gone wrong when button click");
            }
        });

    }

    private void checkForAnswer(String text) {
        switch (model.getCurrentLevel()) {
            case "1":
                checkAnswer(text.equals("Aya") || text.equals("Аья"));
                break;
            case "2":
                checkAnswer(text.equals("Nursultan") || text.equals("Нурсултан"));
                break;
            case "3":
                checkAnswer(text.equals("Karlygach") || text.equals("Karligach") || text.equals("Карлыгач"));
                break;
            default:
                checkAnswer(null);
                break;
        }
    }

    private void checkAnswer(Boolean isTrue) {
        String text;
        if (null != isTrue) {
            if (isTrue) {
                text = "Correct";
            } else {
                text = "Incorrect! Try to write differently";
            }

        } else text = "Something gone wrong!";
        new ToastClass(requireContext()).showToast(text);
    }
}