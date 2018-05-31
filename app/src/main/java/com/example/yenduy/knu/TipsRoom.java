package com.example.yenduy.knu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TipsRoom extends AppCompatActivity {


    private ImageButton book1;
    private ImageButton UNIVLabrary;
    private ImageButton photocopy;
    private ImageButton dvd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_room);

        //-----------------------Community room button---------------//
        book1 = (ImageButton) findViewById(R.id.image1);
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(TipsRoom.this, BOOK1.class);
                startActivity(open);

            }
        });
        //------------------- tips button ------------//
        UNIVLabrary = (ImageButton) findViewById(R.id.image2);
        UNIVLabrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(TipsRoom.this, UNIVlibrary.class);
                startActivity(open);
            }
        });

        //-----------------------------------------//

        photocopy = (ImageButton) findViewById(R.id.image3);
        photocopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(TipsRoom.this, UNIVphotocopy.class);
                startActivity(open);
            }
        });

        //-----------------------------------------//

        dvd = (ImageButton) findViewById(R.id.image4);
        dvd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(TipsRoom.this, DVDroom.class);
                startActivity(open);
            }
        });

        //-----------------------------------------//
    }
}
