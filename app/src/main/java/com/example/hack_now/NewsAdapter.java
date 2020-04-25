package com.example.hack_now;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter {

    List<NewsItem> newsItemList=new ArrayList<>();
    Context mContext;

    public NewsAdapter(Context context, int resource, List<NewsItem> newsItemList) {
        super(context, resource, newsItemList);
        mContext=context;
        this.newsItemList = newsItemList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = inflater.inflate(R.layout.news_card, null);

            TextView title =view.findViewById(R.id.title);
            TextView desc=view.findViewById(R.id.desc);

            title.setText(newsItemList.get(position).getTitle());
            desc.setText(newsItemList.get(position).getDesc());
            //SET BG COLOR  depending on postedBy

        }
        else
        {
            view = (View) convertView;
        }
        return view;
    }
}