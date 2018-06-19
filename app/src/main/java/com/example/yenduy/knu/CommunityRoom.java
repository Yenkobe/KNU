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
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CommunityRoom extends AppCompatActivity {

    private ListView lvArticleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_room);

        lvArticleList = (ListView) findViewById(R.id.lvArticleList);

        List articleList = new ArrayList();


        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = database.child("community");
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                //Post post = dataSnapshot.getValue(Post.class);
                // ...

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post


                    for (DataSnapshot child : dataSnapshot.getChildren()){
                        //child is each element in the finished list
                        Map<String, String> message = (Map<String, String>)child.getValue();
                        //message.get("date");
                        Log.w("FIREBAS---", "EVENT" + message.get("date") );
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("FIREBAS---", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

         ref.addValueEventListener(postListener);


        for (int i = 0; i < 300; i++) {
            articleList.add(new ArticleVO("Item" + i, ".", new Random().nextInt(999)));
        }

        lvArticleList.setAdapter(new ArticleListViewAdapter(articleList, this));




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommunityRoom.this, CommunitySend.class));
            }
        });
    }

    // Ctrl + i

    private class ArticleListViewAdapter extends BaseAdapter {

        private List articleList;
        private Context context;

        public ArticleListViewAdapter(List articleList, Context context) {
            this.articleList = articleList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return articleList.size();
        }

        @Override
        public Object getItem(int position) {
            return articleList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

                convertView = inflater.inflate(R.layout.item_list, parent, false);
            }

            TextView tvSubject = (TextView) convertView.findViewById(R.id.tvSubject);
            TextView tvAuthor = (TextView) convertView.findViewById(R.id.tvAuthor);
            TextView tvHitCount = (TextView) convertView.findViewById(R.id.tvHitCount);

            ArticleVO article = (ArticleVO) getItem(position);
            tvSubject.setText(article.getSubject());
            tvAuthor.setText(article.getAuthor());
            tvHitCount.setText(article.getHitCoutn() + "");
            return convertView;
        }
    }

}