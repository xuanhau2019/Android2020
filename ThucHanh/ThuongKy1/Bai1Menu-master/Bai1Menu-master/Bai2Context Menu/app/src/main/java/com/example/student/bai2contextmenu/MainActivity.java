package com.example.student.bai2contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_showcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_showcontext=findViewById(R.id.btn_showcontext);
        registerForContextMenu(btn_showcontext);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.menu_demo,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.itemRed:
                btn_showcontext.setTextColor(getResources().getColor(R.color.clrred));
                break;
            case R.id.itemGreen:
                btn_showcontext.setTextColor(getResources().getColor(R.color.clrgreed));
                break;
            case R.id.itemBlue:
                btn_showcontext.setTextColor(getResources().getColor(R.color.clrblue));
                break;
            default:
                btn_showcontext.setTextColor(getResources().getColor(R.color.clrred));
        }
        return super.onContextItemSelected(item);
    }
}
