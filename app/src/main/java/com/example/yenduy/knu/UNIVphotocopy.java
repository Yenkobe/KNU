package com.example.yenduy.knu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UNIVphotocopy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univphotocopy);
        TextView mTitleWindow = (TextView)findViewById(R.id.titleWindow2);
        TextView mMessageWindow = (TextView)findViewById(R.id.messageWindow2);

        mTitleWindow.setText("복사기의 위치");


        mMessageWindow.setText( "학교생활을 하다보면 복사나 프린트를 할 일 이 많이 생기게 됩니다.\n" +
                "그럴 때를 대비해서 학교 곳곳에는 복사카드를 이용해서 복사를 할 수있도록 하는 공간이 만들어져 있습니다.\n" +
                "각 각 도서관의 1,2,3층 ,인문사회학관의 1층 로비, \n");
    }
}
