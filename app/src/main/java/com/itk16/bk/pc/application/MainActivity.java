package com.itk16.bk.pc.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt_1, edt_2;
    Button bt_send;
    final int REQUEST_CODE = 1;
    ListView lv;
    ArrayList<String> list;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_1 = findViewById(R.id.edt_1);
        edt_2 = findViewById(R.id.edt_2);
        bt_send = findViewById(R.id.bt_send);

        list = new ArrayList<>();

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                intent.putExtra("num1",edt_1.getText().toString());
                intent.putExtra("num2", edt_2.getText().toString());
                intent.putExtra("requestCode", REQUEST_CODE);

                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            list.add(data.getStringExtra("kq"));
             adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
             
        }
    }
}
