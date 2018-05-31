package com.example.yenduy.knu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BOOK1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);
        TextView mTitleWindow = (TextView)findViewById(R.id.titleWindow);
        TextView mMessageWindow = (TextView)findViewById(R.id.messageWindow);

        mTitleWindow.setText("나는 고작 한번 해봤을 뿐이다");


        mMessageWindow.setText( " '천리 길도 한 걸음부터'란 말처럼 그 무슨 일도 작은 시작에서 비롯된다. 이 책에서 EBS 프로듀서인 저자는 작은 용기와 대수롭지\n" +
                "\n" +
                "않은 노력으로도 할 수 있는 사소한 실천을 통해 어떤 일들이 일어났는지 여러 사례를 들려준다. 저자는 실제로 한 정거장 일찍\n" +
                "\n" +
                "내려 걱디 시작한 '15분 걷기'를 통해 여러 사건을 만나게 된다. 토크쇼의 전설인 래리 킹 앵커 역시 방송인의 꿈을 이루기 위해\n" +
                "\n" +
                "방송국 주변을 어슬렁거니는 것에서부터 시작했다. 3주간 매일 같이 기웃거리다가 방송국 잡역부로 일하게 되었고 2년이 됐을때\n" +
                "\n" +
                "부재중인 앵커를 대신해 방송을 진행할 수 있었다.   '좋은 계획이 행동을 이끄는게 아니라, 작은 행동이 좋은 계획을 이끈다' 는\n" +
                "\n" +
                "저자의 신념을 좇아 당장 할 수 있는 작은 일 부터 시작해보는것은 어떨까\n");
    }
}
