package com.example.yenduy.knu;

import android.content.Context;

import android.content.Intent;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CommunityRoom extends AppCompatActivity {


    private ListView ArticleList;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_room);


        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = database.child("community");
        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                //Post post = dataSnapshot.getValue(Post.class);

                ArrayList<String> listItems = new ArrayList<String>();
                ArrayList<String> listKeys = new ArrayList<String>();
                ArrayAdapter<String> adapter;
                ArticleList = (ListView) findViewById(R.id.ArticleList);
                tvTitle = (TextView) findViewById(R.id.tvTitle);

                tvTitle.setText("");


                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    listItems.clear();
                    ArticleList.setAdapter(null);
                    for (DataSnapshot child : dataSnapshot.getChildren()){
                        //child is each element in the finished list
                        Map<String, String> message = (Map<String, String>)child.getValue();
                       // message.get("date");
                        Log.w("CYCLE" ,"FIREBAS---" + message.get("date") );

                        listItems.add( message.get("Title")  + "\n" +message.get("text")+ "\n" +message.get("date")  );
                    }
                }


                ArticleList.setAdapter(new ArrayAdapter<String>(CommunityRoom.this, android.R.layout.simple_list_item_1, listItems));
                //ArticleList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //  Log.w("FIREBAS---", "loadPost:onCancelled", databaseError.toException());
            }
        };
        ref.addValueEventListener(postListener);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommunityRoom.this, CommunitySend.class));
                CommunityRoom.this.finish();
            }
        });
    }



}