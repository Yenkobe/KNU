package com.example.yenduy.knu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CommunitySend extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_send);

        Button btnSend = (Button) findViewById(R.id.Send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(); //Get Reference database
                Map<String, String> sendData = new HashMap<>();


                DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
                String date = df.format(Calendar.getInstance().getTime());


                EditText editText = (EditText) findViewById(R.id.editText);

                String msg = editText.getText().toString();
                sendData.put("date", date );
                sendData.put("text", msg );
/*
                FirebaseUser user = firebaseAuth.getCurrentUser();
                sendData.put("email", user.getEmail() );
*/
                databaseReference.child("community").child(date).setValue(sendData);

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