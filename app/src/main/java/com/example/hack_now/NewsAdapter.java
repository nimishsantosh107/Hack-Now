package com.example.hack_now;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hack_now.ui.dashboard.DashboardFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter {

    List<String> data=new ArrayList<>();
    Context mContext;

    public NewsAdapter(Context context, int resource, List<String> data) {
        super(context, resource, data);
        mContext=context;

        this.data=data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {

            view = new View(mContext);
            view = inflater.inflate(R.layout.news_card, null);

            //convertView = ((Activity) this).getLayoutInflater().inflate(R.layout.blogs, parent, false);


            TextView title = (TextView) view.findViewById(R.id.title);

            //set description


            title.setText(data.get(position));


        }
        else
        {
            view = (View) convertView;
        }
        return view;
    }
}