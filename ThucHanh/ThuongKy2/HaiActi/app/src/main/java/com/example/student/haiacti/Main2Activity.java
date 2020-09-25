package com.example.student.haiacti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    TextView txtHoTen,txtNamSinh,txtTuoi;
    EditText edtXacNhan;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtHoTen = findViewById(R.id.txtHoTen);
        txtNamSinh = findViewById(R.id.txtNamSinh);
        txtTuoi = findViewById(R.id.txtTuoi);
        btnBack = findViewById(R.id.btnBack);
        edtXacNhan = findViewById(R.id.edtXacNhan);

        Intent intent = getIntent();

        String hoten = getIntent().getExtras().getString("hoten");
        int namsinh  = getIntent().getExtras().getInt("namsinh");
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int tuoi = yearCurrent - namsinh;

        txtHoTen.setText(hoten);
        txtNamSinh.setText(String.valueOf(namsinh));
        txtTuoi.setText(String.valueOf(tuoi));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xacnhan = edtXacNhan.getText().toString();

                Intent intent =  new Intent();
                intent.putExtra("xacnhan",xacnhan);
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}
