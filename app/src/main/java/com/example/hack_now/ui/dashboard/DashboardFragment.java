package com.example.hack_now.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hack_now.NewsAdapter;
import com.example.hack_now.R;

import java.util.Arrays;
import java.util.List;

public class DashboardFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //TextView textView=root.findViewById(R.id.test);

        //Do get request





        //After get request and we get json ready

        List<String> test=Arrays.asList("Nimish","Kavya","Sanjay");
        NewsAdapter newsAdapter=new NewsAdapter(getContext(), 0, test);
        ListView newsList=root.findViewById(R.id.newsList);

        newsList.setAdapter(newsAdapter);
        return root;
    }
}