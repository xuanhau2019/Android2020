package com.example.thuongky;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences  mPrefs = getPreferences(MODE_PRIVATE);

        final EditText name = findViewById(R.id.name);
        final EditText address = findViewById(R.id.address);
        Button save = findViewById(R.id.button);
        Button read = findViewById(R.id.read);

        final ArrayList<String> arrPackage;
        final SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);

        final TextView result = findViewById(R.id.result);
        lv = findViewById(R.id.listproduct);

        arrPackage = new ArrayList<>();
        read.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String json = sharedPreferences.getString("Set", "");
                if (json.isEmpty()) {
                    Toast.makeText(MainActivity.this, "There is something error", Toast.LENGTH_LONG).show();
                } else {
                    Type type = new TypeToken<List<String>>() {
                    }.getType();
                    List<String> arrPackageData = gson.fromJson(json, type);
                    for (String data : arrPackageData) {
                        result.setText(data);
                    }
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() && address.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Plz Enter all the data", Toast.LENGTH_LONG).show();
                } else {
                    String nameData = name.getText().toString().trim();
                    String addressData = address.getText().toString().trim();
                    arrPackage.add(nameData);
                    arrPackage.add(addressData);
                    Gson gson = new Gson();
                    String json = gson.toJson(arrPackage);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Set", json);
                    editor.commit();
                }
            }
        });
    }
}