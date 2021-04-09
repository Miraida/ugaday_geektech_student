package com.geek.ugadai.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.geek.ugadai.R;
import com.geek.ugadai.ToastClass;
import com.geek.ugadai.adapter.LevelAdapter;
import com.geek.ugadai.model.QuestionModel;

import java.util.ArrayList;

public class LevelFragment extends GeneralFragment implements LevelAdapter.ChooseClick {
    ArrayList<String> list = new ArrayList<>();

    public LevelFragment() {
        super(R.layout.fragment_level);
    }

    @Override
    protected void initClickers() {
    }

    @Override
    protected void initViews(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.level_recycler);
        LevelAdapter adapter = new LevelAdapter(getLevelList(), this);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<String> getLevelList() {
        if (getArguments() != null) {
            list.addAll(getArguments().getStringArrayList(Keys.LIST_LEVEL_KEY.toString()));
        }
        return list;
    }

    @Override
    public void onItemClick(int position) {
        sendQuestion(position);
    }

    private void sendQuestion(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("QUESTION_MODEL", getQuestion(position));
        GameFragment gameFragment = new GameFragment();
        gameFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.frame_layout, gameFragment).commit();
    }

    public QuestionModel getQuestion(int position) {
        QuestionModel model;
        switch (position) {
            case 0:
                model = new QuestionModel(list.get(position), "https://blog.wella.com/sites/default/files/big-image/12-short-blonde-hairstyle-ideas-summer-80e5c8a1.jpg"
                        , "https://guruopta.ru/wp-content/uploads/2015/08/%D0%B0%D0%B4%D0%BC%D0%B8%D0%BD%D0%B8%D1%81%D1%82%D1%80%D0%B0%D1%82%D0%BE%D1%80-%D0%BE%D1%82%D0%B4%D0%B5%D0%BB%D0%B0-%D0%BF%D1%80%D0%BE%D0%B4%D0%B0%D0%B6.jpg",
                        "https://fsa.zobj.net/crop.php?r=Qz_TdofGMZh22LwFg6pnw5KC97VIz1EmWp3bP-rbmZ9CUQW3p6x4lfZtZnf5h2JriTreuEoUtsqwf8_rFlOA6eH3YwSq7WGtCf0OulEoKNvNwYC98VJpEA-Occ93johnANp-bTAXfvxVVaN7",
                        "https://static.onecms.io/wp-content/uploads/sites/20/2019/09/gettyimages-984979480-2000.jpg");
                break;
            case 1:
                model = new QuestionModel(list.get(position), "https://pediaa.com/wp-content/uploads/2020/10/Difference-Between-Coach-and-Mentor_1.png",
                        "https://avatars.mds.yandex.net/get-zen_doc/1645803/pub_5e4faabd9f3ad148f415a09b_5e4facab6617c37cfdda148e/scale_1200",
                        "https://games.mail.ru/hotbox/content_files/game/5040/picture/2caa0.jpeg",
                        "https://images.ua.prom.st/1101097815_w640_h640_1101097815.jpg");
                break;
            case 2:
                model = new QuestionModel(list.get(position), "https://st2.depositphotos.com/1071184/7550/v/600/depositphotos_75505465-stock-illustration-business-customer-care-service.jpg",
                        "https://i.pinimg.com/originals/41/e9/a2/41e9a2d6a6a301557c7961d412465f9d.jpg",
                        "https://www.meme-arsenal.com/memes/58d8bb81f36abe2a08971ee84ecd1faa.jpg",
                        "https://st3.depositphotos.com/3356953/12574/v/950/depositphotos_125749932-stock-illustration-smiley-with-headphones-icon.jpg");
                break;
            default:
                model = new QuestionModel();
                new ToastClass(requireContext()).showToast("Can't find such level");
        }
        return model;
    }
}
