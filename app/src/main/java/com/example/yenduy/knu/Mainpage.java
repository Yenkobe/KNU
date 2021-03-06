package com.example.yenduy.knu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class Mainpage extends AppCompatActivity {

    GridLayout mainGrid;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.toolbar));

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);


        firebaseAuth = FirebaseAuth.getInstance();

    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i  < mainGrid.getChildCount();i++){

            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (finalI == 0)  // open activity Bus stop
                    {
                        Intent intent = new Intent(Mainpage.this, Busstop.class);
                        startActivity(intent);
                    }

                    else if (finalI ==1) // open activity Bus tracking
                    {
                        Intent intent = new Intent(Mainpage.this,Bustracking.class);
                        startActivity(intent);
                    }
                    else if (finalI ==2) // open activity Comunity
                    {
                        Intent intent = new Intent(Mainpage.this, Comunity.class);
                        startActivity(intent);
                    }
                    else if (finalI ==3) //  knu page
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kangwon.ac.kr/"));
                        startActivity(intent);
                    }

                }
            });

        }
    }


    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Mainpage.this, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logoutMenu: {
                Logout();

            }

        }
            return super.onOptionsItemSelected(item);
        }
    }






