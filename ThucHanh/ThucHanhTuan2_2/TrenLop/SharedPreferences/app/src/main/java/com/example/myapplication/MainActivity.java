package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    TextView response;
    Button saveButton,readButton,findExternalStorage;
    ListView listviewA;

    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listviewA = findViewById(R.id.listviewA);

        inputText = (EditText) findViewById(R.id.myInputText);
        response = (TextView) findViewById(R.id.response);


        saveButton =
                (Button) findViewById(R.id.saveExternalStorage);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = new FileOutputStream(myExternalFile);
                    fos.write(inputText.getText().toString().getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputText.setText("");
                Toast.makeText(MainActivity.this, "Đã lưu dữ liệu", Toast.LENGTH_SHORT).show();

                ArrayList<String> lines = new ArrayList<String>();
                try {
                    FileInputStream fis = new FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br =
                            new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        myData = myData+ "\n" + strLine;
                        String line =  br.readLine();
                        lines.add(line);
                    }
                    fis.close();
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                response.setText(myData);

            }
        });

        findExternalStorage = findViewById(R.id.findExternalStorage);
        findExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String check = inputText.getText().toString();
                try {
                    FileInputStream fis = new FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br =
                            new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        if(strLine.equalsIgnoreCase(check)){
                            Toast.makeText(MainActivity.this, "Tìm thấy", Toast.LENGTH_SHORT).show();
                            response.setText(check);
                        }else{
                            Toast.makeText(MainActivity.this,"Không tìm thấy" , Toast.LENGTH_SHORT).show();
                            response.setText("");
                        }
                    }
                    in.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

//        readButton = (Button) findViewById(R.id.getExternalStorage);
//        readButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ArrayList<String> lines = new ArrayList<String>();
//                try {
//                    FileInputStream fis = new FileInputStream(myExternalFile);
//                    DataInputStream in = new DataInputStream(fis);
//                    BufferedReader br =
//                            new BufferedReader(new InputStreamReader(in));
//                    String strLine;
//                    while ((strLine = br.readLine()) != null) {
//                        myData = myData+ "\n" + strLine;
//                        String line =  br.readLine();
//                        lines.add(line);
//                    }
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
////                inputText.setText(myData);
//                Toast.makeText(MainActivity.this, "Lấy dữ liệu thành công", Toast.LENGTH_SHORT).show();
//                response.setText(myData);
//
////                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,lines);
//
////                listviewA.setAdapter(adapter);
//            }
//        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveButton.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
    }
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }


}