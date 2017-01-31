package com.example.rndroid.listview_assignment6;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {

//    ArrayList<String> al;
    ArrayAdapter<String> adapter;
    HashMap<String,String> myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myMap = new HashMap<String, String>();
        myMap.put("www.Google.Com","http://www.google.com");
        myMap.put("www.Youtube.com","http://www.youtube.com");
//        al = new ArrayList<String>();
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, new String[] {"www.Google.Com", "www.Youtube.com"}));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Object o = getListAdapter().getItem(position);
        if(myMap.containsKey(o.toString())){
            Intent i = new Intent(MainActivity.this,SecondActivity.class);
            i.putExtra("web site",myMap.get(o.toString()));
            startActivity(i);
        }
        Toast.makeText(this, ""+myMap.get(o.toString()), Toast.LENGTH_SHORT).show();

    }
}
