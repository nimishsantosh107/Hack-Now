package com.example.hack_now;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.wallet.PaymentsClient;

import java.util.List;

public class SocialAdapter extends ArrayAdapter {
    List<String> nameList;
    Context mContext;
    private PaymentsClient paymentsClient;

    public SocialAdapter(Context context, int resource, List<String> nameList) {
        super(context, resource, nameList);
        mContext=context;
        this.nameList=nameList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = inflater.inflate(R.layout.social_card, null);

            TextView name = (TextView) view.findViewById(R.id.name);

            //SET BG COLOR & HIDE BUTTON if AD
            name.setText(nameList.get(position));
        }
        else
        {
            view = (View) convertView;
        }
        return view;
    }
}
