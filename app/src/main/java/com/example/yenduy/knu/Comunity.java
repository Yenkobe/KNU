package com.example.yenduy.knu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Comunity extends AppCompatActivity {

    private ImageButton tipsB;
    private ImageButton communityB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunity);

//-----------------------Community room button---------------//
        communityB = (ImageButton) findViewById(R.id.Community_share);
        communityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(Comunity.this, CommunityRoom.class);
                startActivity(open);

            }
        });
        //------------------- tips button ------------//
        tipsB = (ImageButton) findViewById(R.id.TipsButton);
        tipsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(Comunity.this, TipsRoom.class);
                startActivity(open);
            }
        });

        //-----------------------------------------//

                }
            }











