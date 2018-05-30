package com.example.yenduy.knu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Comunity extends AppCompatActivity {

    private ImageButton tipsB;
    private ImageButton communityB;
    private ListView lvArticleList;



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
        lvArticleList = (ListView) findViewById(R.id.lvArticleList);

        List articleList = new ArrayList();
        for (int i = 0; i < 300; i++) {
            articleList.add(new ArticleVO("제목입니다..." + i, "글쓴이입니다.", new Random().nextInt(9999)));
        }

        lvArticleList.setAdapter(new ArticleListViewAdapter(articleList, this));
    }

        // Ctrl + i

        private class ArticleListViewAdapter extends BaseAdapter {
            /**
             * ListView에 세팅할 Item 정보들
             */

            private List articleList;

            /**
             * ListView에 Item을 세팅할 요청자의 정보가 들어감
             */

            private Context context;

            /**
             * 생성자
             *
             * @param articleList * @param context
             */

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
            public View getView(int position, View converView, ViewGroup parent) {

                if (converView == null) {

                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

                    converView = inflater.inflate(R.layout.item_list, parent, false);
                }

                View  convertView = null;
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





