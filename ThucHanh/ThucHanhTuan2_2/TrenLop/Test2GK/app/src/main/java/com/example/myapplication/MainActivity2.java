package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity2 extends AppCompatActivity {
    Button btnLuu;
    EditText edtTen,edtDiaChi;
    private SinhVien sinhVien;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnLuu = findViewById(R.id.btnLuu);
        edtTen = findViewById(R.id.edtTen);
        edtDiaChi = findViewById(R.id.edtDiaChi);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                String diachi = edtDiaChi.getText().toString();

//                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
//                editor.putString("ten", ten);
//                editor.putString("diachi", diachi);
//                editor.apply();
//                finish();
                sinhVien = new SinhVien(ten, diachi);

                String file = "person.txt";
                try {

                    // Mở file tên person và cập nhật nội dung trong file, tạo file nếu chưa tồn tại
                    FileOutputStream fout = openFileOutput(file, Context.MODE_APPEND);

                    String data= "";
                    data += sinhVien;

                    //Ghi dữ liệu "data" xuống file theo từng byte.
                    fout.write(data.getBytes());
                    fout.close();//Đóng luồng file

                }catch (Exception e){
                    Toast.makeText(MainActivity2.this, "Add fail", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                finish();
            }
        });
    }
}