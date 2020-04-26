package com.example.hack_now.ui.social;

import android.Manifest;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.hack_now.R;
import com.example.hack_now.SocialAdapter;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.NearbyPermissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.bluetooth.BluetoothDevice.ACTION_FOUND;
import static android.content.ContentValues.TAG;


public class SocialFragment extends Fragment {

    MessageListener mMessageListener;
    Message mMessage;
    MessagesClient mMessagesClient;

    ListView socialList;

    List<String> nameList1 = new ArrayList<String>();
    List<String> nameList2 = new ArrayList<String>();

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_social, container, false);
        nameList1.add("Name1");
        nameList1.add("Name2");

        nameList2.add("Name3");
        nameList2.add("Name4");
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMessagesClient = Nearby.getMessagesClient(getContext(), new MessagesOptions.Builder()
                    .setPermissions(NearbyPermissions.BLE)
                    .build());
        }

        SocialAdapter socialAdapter = new SocialAdapter(getContext(), 0,nameList1);
        socialList = root.findViewById(R.id.socialList);
        socialList.setAdapter(socialAdapter);


        mMessageListener = new MessageListener() {
            @Override
            public void onFound(Message message) {
                Log.e("MESSAGE", "Found message: " + new String(message.getContent()));
                String m = new String(message.getContent());
                Log.e("M",m);
                nameList1.add(m);
                Log.e("NL10",nameList1.get(0));
                Log.e("NL11",nameList1.get(1));
                SocialAdapter socialAdapter = new SocialAdapter(getContext(), 0,nameList1);
                socialList.setAdapter(socialAdapter);
            }

            @Override
            public void onLost(Message message) {
                Log.d("MESSAGE", "Lost sight of message: " + new String(message.getContent()));
            }
        };

        mMessage = new Message("Sanjay".getBytes());

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        Nearby.getMessagesClient(getContext()).publish(mMessage);
        Nearby.getMessagesClient(getContext()).subscribe(mMessageListener);
    }

    @Override
    public void onStop() {
        Nearby.getMessagesClient(getContext()).unpublish(mMessage);
        Nearby.getMessagesClient(getContext()).unsubscribe(mMessageListener);
        super.onStop();
    }


}