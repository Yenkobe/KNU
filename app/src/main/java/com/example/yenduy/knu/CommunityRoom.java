package com.example.yenduy.knu;

import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommunityRoom extends AppCompatActivity {

    private ListView lvArticleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_room);

        lvArticleList = (ListView) findViewById(R.id.lvArticleList);

        List articleList = new ArrayList();
        for (int i = 0; i < 300; i++) {
            articleList.add(new ArticleVO("Item" + i, ".", new Random().nextInt(9999)));
        }

        lvArticleList.setAdapter(new ArticleListViewAdapter(articleList, this));
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

