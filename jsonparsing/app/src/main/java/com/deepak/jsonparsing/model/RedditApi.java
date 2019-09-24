package com.deepak.jsonparsing.model;

import com.deepak.jsonparsing.model.Feed;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface RedditApi {
    String BASE_URL = "https://www.reddit.com/";

    @GET(".json")
    Call<Feed> getData() ;
}


