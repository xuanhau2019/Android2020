package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btnLayThongTinNguoiDung,btnChonSoThich;
TextView txtShow;
AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLayThongTinNguoiDung = findViewById(R.id.btnLayThongTinNguoiDung);
        btnChonSoThich = findViewById(R.id.btnChonSoThich);
        txtShow = findViewById(R.id.txtShow);


        btnLayThongTinNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,999);
            }
        });
        btnChonSoThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose some animals");

                    final String[] items = {"horse", "cow", "camel", "sheep", "goat"};
                final boolean[] arraycheck = {false, false, false, false, false};
                builder.setMultiChoiceItems(items, arraycheck, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i, boolean b) {
                    arraycheck[i] = b;
                }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String st = "";

                        for (int j = 0 ;j<items.length; j ++) {
                            if(arraycheck[j])
                                st+= items[j].toString()+ "\n";
                            txtShow.setText(st);
                        }
                    }
                });
                builder.setNegativeButton("Cancel", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999 && resultCode == RESULT_OK ){
            String xacnhan = data.getStringExtra("thongtin").toString();
            txtShow.setText(xacnhan);
        }
    }

}