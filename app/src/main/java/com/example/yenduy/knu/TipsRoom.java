package com.example.yenduy.knu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class TipsRoom extends AppCompatActivity {

    GridLayout mainGrid;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_room);


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

                        if (finalI == 0)  // open activity BOOK1
                        {
                            Intent intent = new Intent(TipsRoom.this, BOOK1.class);
                            startActivity(intent);
                        }

                        else if (finalI ==1) // open activity dvd
                        {
                            Intent intent = new Intent(TipsRoom.this,DVDroom.class);
                            startActivity(intent);
                        }
                        else if (finalI ==2) // open activity Comunity
                        {
                            Intent intent = new Intent(TipsRoom.this, UNIVphotocopy.class);
                            startActivity(intent);
                        }
                        else if (finalI ==3) //  knu page
                        {
                            Intent intent = new Intent(TipsRoom.this, UNIVlibrary.class);
                            startActivity(intent);
                        }

                    }
                });

            }
        }

}
