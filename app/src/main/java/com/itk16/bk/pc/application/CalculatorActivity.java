package com.itk16.bk.pc.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    TextView tv1, tv2;
    Button bt_cong, bt_pt;
    int requestcoed;
    int KQ, a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        final Intent intent = getIntent();
        requestcoed = intent.getIntExtra("requestCode",-1);
        tv1.setText(intent.getStringExtra("num1"));
        tv2.setText(intent.getStringExtra("num2"));

        bt_cong = findViewById(R.id.bt_cong);
        bt_pt = findViewById(R.id.bt_pt);

        bt_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(tv1.getText().toString());
                b = Integer.parseInt(tv2.getText().toString());
                KQ = a + b;
                requestcoed = 1;
                String st1 = a + " + " + b + " = " + KQ;
                intent.putExtra("kq", st1);
                setResult(requestcoed);
                finish();
            }
        });

        bt_pt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(tv1.getText().toString());
                b = Integer.parseInt(tv2.getText().toString());
                KQ = a % b;
                String st2 = a + " % " + b + " = " + KQ;
                intent.putExtra("kq", st2);
                requestcoed = 2;
                setResult(requestcoed);
                finish();
            }
        });



    }
}
