package com.example.code06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String NEWS_TITLE = "news_title";
    private static final String NEWS_AUTHOR = "news_author";
    private List<Map<String, String>> dataList = new ArrayList<>();
    private String[] titles = null;
    private String[] authors = null;

    public static final String NEWS_ID = "news_id";
    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this,
                R.layout.list_item, newsList);

        ListView lvNewsList = findViewById(R.id.lv_news_list);

        lvNewsList.setAdapter(newsAdapter);
    }

    private void initData() {
        int length;

        titles = getResources().getStringArray(R.array.titles);
        authors = getResources().getStringArray(R.array.authors);
        TypedArray images = getResources().obtainTypedArray(R.array.images);

        if (titles.length > authors.length) {
            length = authors.length;
        } else {
            length = titles.length;
        }

        for (int i = 0; i < length; i++) {
            News news = new News();
            news.setTitle(titles[i]);
            news.setAuthor(authors[i]);
            news.setImageId(images.getResourceId(i, 0));

            newsList.add(news);
        }

    }
}