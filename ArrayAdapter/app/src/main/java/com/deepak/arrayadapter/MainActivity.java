package com.deepak.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.deepak.arrayadapter.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  //  String []arrayList={"cat","dog","cat","dog","cat","dog","cat","dog","cat","dog"};
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("deepak");
        arrayList.add("kumar");
        arrayList.add("deepak");
        arrayList.add("kumar"); arrayList.add("deepak");
        arrayList.add("kumar");



        listView=findViewById(R.id.list);
//here R.layout.list_item_view give the view by which text will be shown

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.list_item_view,  R.id.list_tv,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
