package com.example.chen.youmeng;


import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_view extends Fragment {

    TextView tv;
    int[] buttons;                    //数字按钮数组
    float result;
    float result0;
    float result1;
    int count = 0;
    Button buttonC;                    //按钮对象声明
    Button button_Jia;
    Button button_Jian;
    Button button_Cheng;
    Button button_Chu;
    Button button_equal;
    Button temp;
    String str ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_two, container, false);
        init(view);
        return view;
    }

    //按C清零
    public void init(View view) {

        buttonC = (Button) view.findViewById(R.id.ButtonC) ;
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
            }
        });

        for (int i = 0;i<buttons.length;i++){
            temp = (Button) view.findViewById(buttons[i]) ;
            temp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str = tv.getText().toString().trim() ;
                    str = str + String.valueOf(((Button) v).getText()) ;
                    tv.setText(str) ;
                }
    });
}



}
}
