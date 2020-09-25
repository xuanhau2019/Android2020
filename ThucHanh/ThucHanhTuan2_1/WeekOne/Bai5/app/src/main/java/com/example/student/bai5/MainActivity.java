package com.example.student.bai5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btnTinhTT;
CheckBox CheckBoxVIP;
EditText edtSoLuongSach;
TextView txtThanhTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTinhTT = findViewById(R.id.btnTinhTT);
        CheckBoxVIP = findViewById(R.id.CheckBoxVIP);
        edtSoLuongSach = findViewById(R.id.edtSoLuongSach);
        txtThanhTien = findViewById(R.id.txtThanhTien);

        btnTinhTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CheckBoxVIP.isChecked()){
                    int soluong = Integer.parseInt(edtSoLuongSach.getText().toString());
                    double thanhtien = soluong * 20000 * 0.9;
                    txtThanhTien.setText(String.valueOf(thanhtien));
                } else {
                    int soluong = Integer.parseInt(edtSoLuongSach.getText().toString());
                    double thanhtien = soluong * 20000;
                    txtThanhTien.setText(String.valueOf(thanhtien));
                }
            }
        });
    }
}
