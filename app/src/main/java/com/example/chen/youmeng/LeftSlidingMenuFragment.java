package com.example.chen.youmeng;

/**
 * Created by Administrator on 2014/9/11.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class LeftSlidingMenuFragment extends Fragment implements OnClickListener{

    private View thelayout_for_one ;
    private View thelayout_for_two ;
    private View thelayout_for_three ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_left_layout, container,
                false);

        thelayout_for_one = view.findViewById(R.id.layout_for_one);
        thelayout_for_one.setOnClickListener(this);
        thelayout_for_two = view.findViewById(R.id.layout_for_two);
        thelayout_for_two.setOnClickListener(this);
        thelayout_for_three = view.findViewById(R.id.layout_for_three);
        thelayout_for_three.setOnClickListener(this);



        System.out.println();
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment newContent = null;
        switch (v.getId()) {
//            case R.id.button_register:             //点击注册按钮，出现的东西
//                //
//                break;
//            case R.id.button_join:                //点击登录按钮，出现的东西
//                //
//                break;
            case R.id.layout_for_one:          //第二个即首页的东西
                newContent = new Fragment_view();
                thelayout_for_one.setSelected(true);
                thelayout_for_two.setSelected(false);
                thelayout_for_three.setSelected(false);

                break;
            case R.id.layout_for_two:           //第三个，即我的消息里面的
                newContent = new Fragment_news();
                thelayout_for_one.setSelected(false);
                thelayout_for_two.setSelected(true);
                thelayout_for_three.setSelected(false);
                break;
            case R.id.layout_for_three:         //第三个，即我的设置里面的
                newContent = new Fragment_setting();
                thelayout_for_one.setSelected(false);
                thelayout_for_two.setSelected(false);
                thelayout_for_three.setSelected(true);
                break;
            default:
                break;
        }

        if (newContent != null)
            switchFragment(newContent);

    }


    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;
        MainActivity ra = (MainActivity) getActivity();
        ra.switchContent(fragment);

    }
}
