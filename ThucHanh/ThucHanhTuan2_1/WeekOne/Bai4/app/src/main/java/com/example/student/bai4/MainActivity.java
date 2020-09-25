package com.example.student.bai4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnGuiThongTin;
    EditText edtHoVaTen,edtCMND;
    RadioButton radioButton_TrungCap,radioButton_CaoDang,radioButton_DaiHoc;
    CheckBox checkbox_DocSach,checkbox_DocBao,checkbox_DocCoding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuiThongTin = findViewById(R.id.btnGuiThongTin);

        edtHoVaTen = findViewById(R.id.edtHoVaTen);
        edtCMND = findViewById(R.id.edtCMND);

        radioButton_TrungCap = findViewById(R.id.radioButton_TrungCap);
        radioButton_CaoDang = findViewById(R.id.radioButton_CaoDang);
        radioButton_DaiHoc = findViewById(R.id.radioButton_DaiHoc);

        checkbox_DocSach = findViewById(R.id.checkbox_DocSach);
        checkbox_DocBao = findViewById(R.id.checkbox_DocBao);
        checkbox_DocCoding = findViewById(R.id.checkbox_DocCoding);



        btnGuiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edtHoVaTen.getText().toString();
                String cmnd = edtCMND.getText().toString();
                String regexStr = "^[0-9]*$";
                if (hoten.length() < 3){
                    Toast.makeText(MainActivity.this, "Tên phải trên 3 ký tự", Toast.LENGTH_SHORT).show();
                } else if(cmnd.length() != 9){
                    Toast.makeText(MainActivity.this, "CMND phải là số có 9 chữ số", Toast.LENGTH_SHORT).show();
                } else if(!checkbox_DocSach.isChecked()&& !checkbox_DocBao.isChecked() && !checkbox_DocCoding.isChecked()){
                    Toast.makeText(MainActivity.this, "Sở thích ít nhất một lựa chọn", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Okok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
