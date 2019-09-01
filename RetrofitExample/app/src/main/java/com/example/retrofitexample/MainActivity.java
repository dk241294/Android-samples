package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listview);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeroes();
        //calling Api
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroes = response.body();
                String[] heroname = new String[heroes.size()];
                for (int i = 0; i < heroes.size(); i++) {
                    heroname[i] = heroes.get(i).getName()
                            + "\n" + heroes.get(i).getRealName()
                            + "\n" + heroes.get(i).getCreatedBy()
                            + "\n" + heroes.get(i).getFirstAppearance()
                            + "\n" + heroes.get(i).getBio()
                            + "\n" + heroes.get(i).getImageurl()
                            + "\n" + heroes.get(i).getPublisher()
                            + "\n" + heroes.get(i).getTeam();


                }
                list.setAdapter(new ArrayAdapter<String>(getApplicationContext()
                        , android.R.layout.simple_list_item_1, heroname));

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
