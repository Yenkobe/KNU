package com.example.yenduy.knu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.security.AccessController;

public class DetailActivity extends AppCompatActivity {

    private TextView tvSubject;
    private TextView tvAuthor;
    private TextView tvHitCount;
    private ListView lvArticleList;
    private ThreadLocal articleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvSubject = (TextView) findViewById(R.id.tvSubject);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
        tvHitCount = (TextView) findViewById(R.id.tvHitCount);

        final Intent intent = getIntent();

        ArticleVO article = (ArticleVO) intent.getSerializableExtra("article");

        tvSubject.setText(article.getSubject());
        tvAuthor.setText(article.getAuthor());

        tvHitCount.setText(article.getHitCoutn() + "");

        lvArticleList.setOnClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View view, int position, long id){

                ArticleVO article = articleList.get(position);

                Intent intent = new Intent(view.getContext(),DetailActivity.class);
                intent.putExtra("article", article);
                startActivity(intent);

            }
        });


    }

}
