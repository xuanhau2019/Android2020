package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
EditText txtHoten ,txtTuoi;
Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtHoten = findViewById(R.id.txtHoten);
        txtTuoi = findViewById(R.id.txtTuoi);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String thongtin = txtHoten.getText().toString() + txtTuoi.getText().toString();
                Intent intent =  new Intent();
                intent.putExtra("thongtin",thongtin);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}