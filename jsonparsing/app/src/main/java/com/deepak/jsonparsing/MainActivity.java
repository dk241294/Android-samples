package com.deepak.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.deepak.jsonparsing.children.Children;
import com.deepak.jsonparsing.model.Feed;
import com.deepak.jsonparsing.model.RedditApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "https://www.reddit.com/";
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RedditApi redditApi = retrofit.create(RedditApi.class);
        Call<Feed> call = redditApi.getData();

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                Log.d(TAG, "onResponse:  Server Response" + response.toString());
                Log.d(TAG, "onResponse: received information" + response.body().toString());

                ArrayList<Children> childrenlist = response.body().getData().getChildren();
                for (int i = 0; i < childrenlist.size(); i++) {
                    Log.d(TAG, "onResponse: \n" +
                            "kind" + childrenlist.get(i).getKind() + "\n" +
                            "contest_mode" + childrenlist.get(i).getData().getContest_mode() + "\n" +
                            "subreddit" + childrenlist.get(i).getData().getSubreddit() + "\n" +
                            "author" + childrenlist.get(i).getData().getAuthor() + "\n" +
                            "image"+childrenlist.get(i).getData().getUrl()+"\n"+
                            "----------------------------------------------------------------------"+"\n"
                    +
                            "----------------------------------------------------------------------");
                }

            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "onFailure: something went wrong " + t.getMessage());
                Toast.makeText(getApplicationContext(), "Something went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
