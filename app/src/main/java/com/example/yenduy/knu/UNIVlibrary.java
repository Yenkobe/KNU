package com.example.yenduy.knu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UNIVlibrary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univlibrary);
        TextView mTitleWindow = (TextView)findViewById(R.id.titleWindow1);
        TextView mMessageWindow = (TextView)findViewById(R.id.messageWindow1);

        mTitleWindow.setText("학교 도서관");


        mMessageWindow.setText( "학교도서관 1층에는 자유롭게 공부할 수 있는 열람실과 휴식을 취 할 수있는 휴게실이 있으며, 2층에는 인문사회와 관련된 3층에는 정보통신과 관련된 책들을 읽고 빌릴 수있다.\n" +
                "4층에는 멀티미디어실과 그룹세미나실이 있다.\n" +
                "멀티미디어실은 누구나 이용가능하고, 그룹세미나실도 회의가 필요한 강원대학생 누구나 인터넷을 통해서 예약을 한 다음 사용 할 수 있다.\n");
    }
}
