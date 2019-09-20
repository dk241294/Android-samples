package com.deepak.simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView list;
    String []animalName={"chimpanze","goat","kangaroo","lion","mouse","otter","ox","panda","squirrel"};
    int []animalIamge={R.drawable.chimpanze,
            R.drawable.goat,
                    R.drawable.kangaroo,
                    R.drawable.lion,
                    R.drawable.mouse,
                    R.drawable.otter,
                    R.drawable.ox,
                    R.drawable.panda,
                    R.drawable.sqirrel};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= findViewById(R.id.list);
        ArrayList<HashMap<String,String>> arrayList= new ArrayList<>();;
        for(int i=0;i<animalName.length;i++)
        {
         //create a hash map to store data in key value pair
            HashMap<String,String> hashMap= new HashMap<>();
            hashMap.put("animalname" ,animalName[i]);
            hashMap.put("animalpicture", String.valueOf(animalIamge[i]));
            arrayList.add(hashMap);//adding hashmap in arraylist
        }
        String[]from={"animalname","animalpicture"};
        int[]to={R.id.animal_name,R.id.animal_image};
        SimpleAdapter adapter= new SimpleAdapter(getApplicationContext(),arrayList,R.layout.list_item_view,from,to);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);


    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),animalName[position],Toast.LENGTH_SHORT).show();


    }
}
