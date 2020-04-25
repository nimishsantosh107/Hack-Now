package com.example.hack_now.ui.social;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hack_now.R;

public class SocialFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_social, container, false);

        String[] hashtags = new String[] {
                "#doggos","#quarantinecooking","#tiktok","#painting","#workout","#yoga"
        };
            AutoCompleteTextView editText = root.findViewById(R.id.actv);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,hashtags);
            editText.setAdapter(adapter);


        return root;
    }
}