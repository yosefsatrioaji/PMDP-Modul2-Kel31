package com.example.modul2_kel31;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.nama_nim);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);



    }
}