package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    TextView txtKetQua;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        txtKetQua = findViewById(R.id.txtKetQua);
//
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//        String name = prefs.getString("ten", "No name defined");
//        String diachi = prefs.getString("diachi", null);
//        txtKetQua.setText("tên:"+name+"\t"+"địa chỉ:"+diachi);
        lvItems = findViewById(R.id.list_item);
        String file = "person.txt";
        try {
            ArrayList list = new ArrayList();

            String data = "";
            FileInputStream fin = openFileInput(file);

            //Đọc văn bản trong file "person.txt" dùng để đọc dữ liệu theo từng dòng
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));

            //Tạo ra một chuỗi Builder với độ dài chỉ định là 1000
            StringBuilder builder = new StringBuilder(1000);
            while ((data = br.readLine()) != null){
                list.add(data);
                data = "";
            }

            lvItems.setAdapter(new ArrayAdapter<SinhVien>(MainActivity3.this, android.R.layout.simple_list_item_1,list));

        }catch (Exception e){
            ArrayList list2 = new ArrayList();
            lvItems.setAdapter(new ArrayAdapter<SinhVien>(MainActivity3.this, android.R.layout.simple_list_item_1,list2));
            Toast.makeText(MainActivity3.this, "Danh Sách Rỗng", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}