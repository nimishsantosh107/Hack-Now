package com.example.hack_now.ui.social;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hack_now.R;
import com.example.hack_now.liveVideoBroadcaster.LiveVideoBroadcasterActivity;
import com.example.hack_now.liveVideoPlayer.LiveVideoPlayerActivity;

public class SocialFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_social, container, false);

        String[] hashtags = new String[] {
                "#doggos","#quarantinecooking","#fucktiktokifuckinghateit","#painting","#workout","#yoga",
        };
        AutoCompleteTextView editText = root.findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, hashtags);
        editText.setAdapter(adapter);

        /***  BE CAREFUL HERE PLZ ***/

        //BROADCAST
        Button broadcastButton = root.findViewById(R.id.broadcastButton);
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), LiveVideoBroadcasterActivity.class);
                startActivity(i);
            }
        });

        //STREAM
        Button streamButton = root.findViewById(R.id.streamButton);
        streamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), LiveVideoPlayerActivity.class);
                startActivity(i);
            }
        });

        /***  TILL HERE PLZ ***/

        return root;
    }

}