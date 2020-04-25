package com.example.hack_now;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class BusinessAdapter extends ArrayAdapter {
    List<BusinessItem> businessItemList=new ArrayList<>();
    Context mContext;

    public BusinessAdapter(Context context, int resource, List<BusinessItem> businessItemList) {
        super(context, resource, businessItemList);
        mContext=context;
        this.businessItemList=businessItemList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = inflater.inflate(R.layout.business_card, null);

            TextView name = (TextView) view.findViewById(R.id.name);
            TextView desc = (TextView) view.findViewById(R.id.desc);

            name.setText(businessItemList.get(position).getName());
            desc.setText(businessItemList.get(position).getDesc());
            //SET BG COLOR & HIDE BUTTON if AD
            if(businessItemList.get(position).getService().equals("ADS")) {
                Button donate=view.findViewById(R.id.donateButton);
                donate.setVisibility(View.GONE);
            }

        }
        else
        {
            view = (View) convertView;
        }
        return view;
    }
}
