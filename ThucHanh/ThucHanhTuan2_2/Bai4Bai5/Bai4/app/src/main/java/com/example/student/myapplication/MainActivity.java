package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMaNV,edtTenNV;
    RadioGroup RadioGroupLoaiNV;
    RadioButton radioChinhThuc,radioThoiVu;
    ListView listviewKQ;

    ArrayList<Employee> ArrayListEmployees;
    Employee employee = null;
    ArrayAdapter<Employee> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMaNV = findViewById(R.id.edtMaNV);
        edtTenNV = findViewById(R.id.edtTenNV);
        RadioGroupLoaiNV = findViewById(R.id.RadioGroupLoaiNV);
        radioChinhThuc = findViewById(R.id.radioChinhThuc);
        radioThoiVu = findViewById(R.id.radioThoiVu);
        listviewKQ = findViewById(R.id.listviewKQ);

        ArrayListEmployees = new ArrayList<Employee>();
        arrayAdapter = new ArrayAdapter<Employee>(MainActivity.this,android.R.layout.simple_list_item_1,ArrayListEmployees);

        listviewKQ.setAdapter(arrayAdapter);

        Button btnNhapNV = findViewById(R.id.btnNhapNV);
        btnNhapNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int radID =  RadioGroupLoaiNV.getCheckedRadioButtonId();
               if(radID == R.id.radioChinhThuc){
                   employee = new EmployeeFullTime();
               }else {
                   employee = new EmployeePartTime();
               }
                employee.setId(edtMaNV.getText().toString());
                employee.setName(edtTenNV.getText().toString());

                ArrayListEmployees.add(employee);

                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
