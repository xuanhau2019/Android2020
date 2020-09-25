package com.example.student.bai1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDangNhap, btnThoat;
    CheckBox CheckBoxLuuThongTin;
    EditText edtTaiKhoan,edtMatKhau;
    AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBoxLuuThongTin = findViewById(R.id.CheckBoxLuuThongTin);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnThoat = findViewById(R.id.btnThoat);
        edtTaiKhoan = findViewById(R.id.edtTaiKhoan);
        edtMatKhau = findViewById(R.id.edtMatKhau);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtTaiKhoan.getText().toString().trim().isEmpty()){

                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên đăng nhập!", Toast.LENGTH_SHORT).show();

                }else if (edtMatKhau.getText().toString().trim().isEmpty()){

                    Toast.makeText(MainActivity.this, "Vui lòng nhập Mật khẩu!", Toast.LENGTH_SHORT).show();

                }else if(CheckBoxLuuThongTin.isChecked()){

                    Toast.makeText(MainActivity.this, "Chào Mừng Bạn Đăng Nhập Vào Hệ Thống, Thông Tin Của Bạn Đã Được Lưu", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity.this, "Chào Mừng Bạn Đăng Nhập Vào Hệ Thống, Thông Tin Của Bạn Không Được Lưu", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Thông báo");
                dialog.setMessage("Bạn có muốn thoát không?");
                dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
    }
}
