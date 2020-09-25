package com.example.student.bai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtF,edtC;
    Button btnConverbToC, btnConverbToF,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtF = findViewById(R.id.edtF);
        edtC = findViewById(R.id.edtC);
        btnConverbToC = findViewById(R.id.btnConverbToC);
        btnConverbToF = findViewById(R.id.btnConverbToF);
        btnClear = findViewById(R.id.btnClear);

        btnConverbToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float f = Integer.parseInt(edtF.getText().toString());
                float c = (f-32) * 5/9;
                edtC.setText(String.valueOf(c));
            }
        });

        btnConverbToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float c = Integer.parseInt(edtC.getText().toString());
                float f = c * 9/5 + 32;
                edtF.setText(String.valueOf(f));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}
