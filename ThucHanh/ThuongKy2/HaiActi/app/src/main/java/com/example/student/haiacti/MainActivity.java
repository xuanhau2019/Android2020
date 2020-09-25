package com.example.student.haiacti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText edtHoTen,edtNamSinh;
    TextView txtXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btnSubmit);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtNamSinh = findViewById(R.id.edtNamSinh);
        txtXacNhan = findViewById(R.id.txtXacNhan);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                String hoten = edtHoTen.getText().toString();
                int namsinh = Integer.parseInt(edtNamSinh.getText().toString());

                intent.putExtra("hoten",hoten);
                intent.putExtra("namsinh",namsinh);

                // neu chi gui di
//                startActivity(intent);

                //gui di co nhan lai
                startActivityForResult(intent,999);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999 && resultCode == RESULT_OK ){
            String xacnhan = data.getStringExtra("xacnhan").toString();
            txtXacNhan.setText(xacnhan);
        }
    }
}

