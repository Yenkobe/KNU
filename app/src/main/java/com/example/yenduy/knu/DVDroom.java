package com.example.yenduy.knu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DVDroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvdroom);
        TextView mTitleWindow = (TextView)findViewById(R.id.titleWindow3);
        TextView mMessageWindow = (TextView)findViewById(R.id.messageWindow3);

        mTitleWindow.setText("도서관 내의 DVD");


        mMessageWindow.setText("\"도서관 내의 허용된 PC로 DVD를 시청 할 수 있음.\\n\" +\n" +
                "                \"드라마, 액션, 코미디 등 다양한 장르의 영화를 구비하고 있으며, 도서관 1층의 휴bary에서는 \\n\" +\n" +
                "                \"커다란 TV에서 DVD를 시청 할 수 있다");
    }
}
