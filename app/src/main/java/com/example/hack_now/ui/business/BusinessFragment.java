package com.example.hack_now.ui.business;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hack_now.BusinessAdapter;
import com.example.hack_now.R;

import java.util.Arrays;
import java.util.List;

public class BusinessFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_business, container, false);
        //TextView textView=root.findViewById(R.id.test);

        //Do get request





        //After get request and we get json ready

        List<String> test=Arrays.asList("Nimish","Kavya","Sanjay");
        BusinessAdapter businessAdapter =new BusinessAdapter(getContext(), 0, test);
        ListView businessList=root.findViewById(R.id.businessList);

        businessList.setAdapter(businessAdapter);
        return root;
    }
}