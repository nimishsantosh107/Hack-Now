package com.example.hack_now.ui.notifications;

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

import com.example.hack_now.CommunityAdapter;
import com.example.hack_now.R;

import java.util.Arrays;
import java.util.List;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        //TextView textView=root.findViewById(R.id.test);

        //Do get request





        //After get request and we get json ready

        List<String> test=Arrays.asList("Nimish","Kavya","Sanjay");
        CommunityAdapter communityAdapter=new CommunityAdapter(getContext(), 0, test);
        ListView communityList=root.findViewById(R.id.communityList);

        communityList.setAdapter(communityAdapter);
        return root;
    }
}