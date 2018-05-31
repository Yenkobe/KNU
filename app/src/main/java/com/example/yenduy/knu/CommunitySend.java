package com.example.yenduy.knu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CommunitySend extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_send);

        Button btnSend = (Button) findViewById(R.id.Send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //close activity
                Intent intent = new Intent(CommunitySend.this, CommunityRoom.class );
                CommunitySend.this.finish();
                startActivity(intent);

            }
        });


    }



    // back for activity
    //for(Activity activity:activities) activity.finish();
}