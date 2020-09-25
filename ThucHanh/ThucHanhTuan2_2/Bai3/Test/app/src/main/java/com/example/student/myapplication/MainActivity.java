package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView edtNhap;
    ListView listviewKQ;
    Button btnNhap;

    ArrayList<String> danhsach;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNhap = findViewById(R.id.edtNhap);
        listviewKQ = findViewById(R.id.listviewKQ);
        btnNhap = findViewById(R.id.btnNhap);

        danhsach = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,danhsach);
        listviewKQ.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                danhsach.add(edtNhap.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

    }
}
