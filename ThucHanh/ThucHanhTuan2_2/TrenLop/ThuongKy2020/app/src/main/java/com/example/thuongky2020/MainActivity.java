package com.example.thuongky2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtFullNamme, edtPhoneNumber, edtAddress;
    private Button btnSave, btnRead, btnDelete;
    private ListView lvItems;


    private Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFullNamme = (EditText) findViewById(R.id.edt_full_name);
        edtPhoneNumber = (EditText) findViewById(R.id.edit_phone_number);
        edtAddress = (EditText) findViewById(R.id.edit_address);

        lvItems = (ListView) findViewById(R.id.list_item);

        btnSave = (Button) findViewById(R.id.button_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName, phoneNumber, address;
                fullName = edtFullNamme.getText().toString();
                phoneNumber = edtPhoneNumber.getText().toString();
                address = edtAddress.getText().toString();

                person = new Person(fullName, phoneNumber, address);

                String file = "person.txt";
                try {

                    // Mở file tên person và cập nhật nội dung trong file, tạo file nếu chưa tồn tại
                    FileOutputStream fout = openFileOutput(file, Context.MODE_APPEND);

                    String data= "";
                    data += person;

                    //Ghi dữ liệu "data" xuống file theo từng byte.
                    fout.write(data.getBytes());
                    fout.close();//Đóng luồng file

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Add fail", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        btnRead = (Button) findViewById(R.id.button_read);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                    lvItems.setAdapter(new ArrayAdapter<Person>(MainActivity.this, android.R.layout.simple_list_item_1,list));

                }catch (Exception e){
                    ArrayList list2 = new ArrayList();
                    lvItems.setAdapter(new ArrayAdapter<Person>(MainActivity.this, android.R.layout.simple_list_item_1,list2));
                    Toast.makeText(MainActivity.this, "Danh Sách Rỗng", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        btnDelete = (Button) findViewById(R.id.button_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Xoá Thành Công", Toast.LENGTH_SHORT).show();
                String file = "person.txt";
                deleteFile(file);
            }
        });
    }

}