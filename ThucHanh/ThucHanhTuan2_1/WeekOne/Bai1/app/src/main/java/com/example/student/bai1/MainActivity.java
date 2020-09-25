package com.example.student.bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnTong,btnHieu,btnTich,btnThuong,btnUSCLN,btnThoat;
    EditText edtSoA,edtSoB;
    TextView textViewKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUSCLN = findViewById(R.id.btnUSCLN);
        btnThoat = findViewById(R.id.btnThoat);
        textViewKetQua = findViewById(R.id.textViewKetQua);
        edtSoA = (EditText) findViewById(R.id.edtSoA);
        edtSoB = (EditText) findViewById(R.id.edtSoB);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Integer.parseInt(edtSoA.getText().toString());
                float b = Integer.parseInt(edtSoB.getText().toString());
                float tong = a + b;
                textViewKetQua.setText(String.valueOf(tong));
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Integer.parseInt(edtSoA.getText().toString());
                float b = Integer.parseInt(edtSoB.getText().toString());
                float hieu = a - b;
                textViewKetQua.setText(String.valueOf(hieu));
            }
        });

        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Integer.parseInt(edtSoA.getText().toString());
                float b = Integer.parseInt(edtSoB.getText().toString());
                float tich = a * b;
                textViewKetQua.setText(String.valueOf(tich));
            }
        });

        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Integer.parseInt(edtSoA.getText().toString());
                float b = Integer.parseInt(edtSoB.getText().toString());
                float thuong = a / b;
                textViewKetQua.setText(String.valueOf(thuong));
            }
        });
        btnUSCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtSoA.getText().toString());
                int b = Integer.parseInt(edtSoB.getText().toString());

                int temp1 = a;
                int temp2 = b;
                while (temp1 != temp2) {
                    if (temp1 > temp2) {
                        temp1 -= temp2;
                    } else {
                        temp2 -= temp1;
                    }
                }
                int uscln = temp1;
                textViewKetQua.setText(String.valueOf(uscln));
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
