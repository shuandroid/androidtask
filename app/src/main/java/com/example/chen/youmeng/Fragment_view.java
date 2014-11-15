package com.example.chen.youmeng;


import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.umeng.fb.util.Log;

public class Fragment_view extends Fragment {

    TextView tv ;
    int[] buttons ;                    //数字按钮数组
    float result ;
    float result0 ;
    float result1 ;
    int count = 0 ;
    int flag ;
    Button buttonC ;                    //按钮对象声明
    Button button_Jia ;
    Button button_Jian ;
    Button button_Cheng ;
    Button button_Chu ;
    Button button_equal ;
    Button temp;
    String str ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.activity_main_two, container, false);
        init(view2);
        return view2;
    }

    //按C清零
    public void init(View view2) {

        tv = (TextView) view2.findViewById(R.id.tv);            //获取文本框控件对象
        button_Jia = (Button) view2.findViewById(R.id.ButtonJia);
        button_Jian = (Button) view2.findViewById(R.id.Button_Jian);
        button_Cheng = (Button) view2.findViewById(R.id.Button_Cheng);
        button_Chu = (Button) view2.findViewById(R.id.Button_Chu);
        button_equal = (Button) view2.findViewById(R.id.Button_equal);
        buttons = new int[]
                {                            //记录数值按钮的id
                        R.id.Button00, R.id.Button01, R.id.Button02, R.id.Button03, R.id.Button04,
                        R.id.Button05, R.id.Button06, R.id.Button07, R.id.Button08, R.id.Button09
                };
        buttonC = (Button) view2.findViewById(R.id.ButtonC) ;
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
            }
        });

        for (int i = 0;i<buttons.length;i++){
            temp = (Button) view2.findViewById(buttons[i]) ;
            temp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str = tv.getText().toString().trim() ;
                    str = str + String.valueOf(((Button) v).getText()) ;
                    tv.setText(str) ;
                    count = 1 ;
                }

            });

        }
        //四则运算符
        button_Jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 1) {
                    //String str2 = tv.getText().toString().trim();
                    //result0 = Float.parseFloat(str2);
                    //str += str2 ;
                    //tv.setText(result0 + "");
                    tv.setText(str+"+");
                    flag = 1;
                }
            }
        });
        button_Jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 1) {
                    //String str2 = tv.getText().toString().trim();
                    //result0 = Float.parseFloat(str2);
                    //Log.e("e", str2);
                    //str += str2 ;
                    //tv.setText(result0 + "");
                    tv.setText(str + "-");
                    flag = 2;
                }
            }
        });
        button_Cheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 1) {
//                    String str2 = tv.getText().toString().trim();
//                    result0 = Float.parseFloat(str2);
//                    Log.e("e", str2);
//                    str += str2 ;
                    //tv.setText(result0 + "");
                    tv.setText(str + "×");
                    flag = 3;
                }
            }
        });

        button_Chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 1) {
//                    String str2 = tv.getText().toString().trim();
//                    result0 = Float.parseFloat(str2);
//                    str += str2 ;
                    //tv.setText(result0 + "");
                    tv.setText(str + "÷");
                    flag = 4;
                }
            }
        });


      }


}
