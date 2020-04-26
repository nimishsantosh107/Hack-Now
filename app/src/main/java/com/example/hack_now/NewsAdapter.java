package com.example.hack_now;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.io.File;
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
            TextView creator=view.findViewById(R.id.creator);

            title.setText(newsItemList.get(position).getTitle());
            desc.setText(newsItemList.get(position).getDesc());
            creator.setText("Posted By: "+newsItemList.get(position).getPostedBy());

//            test.setBackground();
            //Log.e("type",newsItemList.get(position).getPostedBy())

            //SET BG COLOR  depending on postedBy
            if(newsItemList.get(position).getPostedBy().equals("ADMIN")) {
                Log.e("test","admin");
                view.setBackgroundResource(R.drawable.admin_card);
            }
            else if(newsItemList.get(position).getPostedBy().equals("GOVT")) {
                Log.e("test","govt");
                view.setBackgroundColor(Color.WHITE);
                view.setBackgroundResource(R.drawable.govt_card);
            }
            else if(newsItemList.get(position).getPostedBy().equals("WHO")){
                Log.e("test","who");
                view.setBackgroundResource(R.drawable.who_card);
            }
            Log.e("test","looping");
        }
        else
        {
            view = (View) convertView;
        }
        return view;
    }
}