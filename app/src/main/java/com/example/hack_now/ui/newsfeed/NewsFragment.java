package com.example.hack_now.ui.newsfeed;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.hack_now.HomeActivity;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NewsFragment extends Fragment {

    ListView newsList;
    List <NewsItem> newsItemList = new ArrayList<>();


    //GET REQ
    void run() throws IOException{
        String geturl="https://hacknow-abcdef.herokuapp.com/newsfeed";
        OkHttpClient client=new OkHttpClient();

        Request request = new Request.Builder()
                .url(geturl)
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
                    JSONArray news=json.getJSONArray("news");
                   // Log.e("JSON",news.getJSONObject(1).getString("postedBy"));

                    for (int i = 0; i < news.length(); i++){
                        NewsItem temp = new NewsItem(news.getJSONObject(i).getString("title"),news.getJSONObject(i).getString("description"),news.getJSONObject(i).getString("postedBy"));
                        newsItemList.add(temp);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        NewsAdapter newsAdapter=new NewsAdapter(getContext(), 0, newsItemList);
                        newsList.setAdapter(newsAdapter);
                    }
                });
            }
        });

    }

    //POST REQ
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    void postRequest(String postUrl,String postBody) throws IOException {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, postBody);

        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("TAG",response.body().string());
            }
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        newsList=root.findViewById(R.id.newsList);
        Button postButton = root.findViewById(R.id.postButton);
        final EditText postText = root.findViewById(R.id.postText);
        final EditText postTitle = root.findViewById(R.id.postTitle);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String postedBy = "ADMIN";
                final String title = postTitle.getText().toString();
                final String desc = postText.getText().toString();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        NewsItem temp = new NewsItem(title, desc, postedBy);
                        newsItemList.add(0,temp);
                        NewsAdapter newsAdapter=new NewsAdapter(getContext(), 0, newsItemList);
                        newsList.setAdapter(newsAdapter);
                    }
                });

                String postUrl= "https://hacknow-abcdef.herokuapp.com/newsfeed";
                String postBody="{\n" +
                        "    \"title\": \""+title+"\",\n" +
                        "    \"description\": \""+desc+"\",\n" +
                        "    \"postedBy\": \""+postedBy+"\"\n" +
                        "}";

                Log.e("POSTING", postBody);
                try {
                    postRequest(postUrl,postBody);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            run();
        }
        catch (IOException e) {
            Log.e("ASYNC", e.getMessage() );
        }

        return root;
    }
}