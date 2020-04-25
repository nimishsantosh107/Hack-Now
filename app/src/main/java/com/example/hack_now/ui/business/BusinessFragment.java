package com.example.hack_now.ui.business;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.hack_now.BusinessAdapter;
import com.example.hack_now.BusinessItem;
import com.example.hack_now.NewsAdapter;
import com.example.hack_now.NewsItem;
import com.example.hack_now.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BusinessFragment extends Fragment {

    ListView businessList;
    List <BusinessItem> businessItemList = new ArrayList<>();
    public String url="https://hacknow-abcdef.herokuapp.com/helper";

    void run() throws IOException {
        OkHttpClient client=new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();
                try {
                    JSONObject json = new JSONObject(myResponse);
                    JSONArray news=json.getJSONArray("help");
                    // Log.e("JSON",news.getJSONObject(1).getString("postedBy"));

                    for (int i = 0; i < news.length(); i++){
                        BusinessItem temp = new BusinessItem(news.getJSONObject(i).getString("name"),news.getJSONObject(i).getString("description"),news.getJSONObject(i).getString("service"));
                        businessItemList.add(temp);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        BusinessAdapter businessAdapter =new BusinessAdapter(getContext(), 0, businessItemList);
                        businessList.setAdapter(businessAdapter);
                    }
                });
            }
        });

    }

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_business, container, false);
        businessList=root.findViewById(R.id.businessList);

        try {
            run();
        }
        catch (IOException e) {
            Log.e("ASYNC", e.getMessage() );
        }

        return root;
    }
}