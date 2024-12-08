package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Tool.Format;

//Mode 9 计算谐振时的电容和电感
//Z = 阻抗
//f = 频率
//C = 电容
//L = 电感
public class Mode9 extends AppCompatActivity {
EditText Impedance, Frequency;
TextView Result_C, Result_L;
Button Count;

double Z, f;
double C, L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode9);

        Impedance = (EditText) findViewById(R.id.Mode10_Impedance);
        Frequency = (EditText) findViewById(R.id.Mode10_Frequency);
        Result_C = (TextView) findViewById(R.id.Mode10_C);
        Result_L = (TextView) findViewById(R.id.Mode10_L);
        Count = (Button) findViewById(R.id.Mode10_Button1);

        Count.setOnClickListener(v -> {
            if(Impedance.getText().toString().equals("") ||Frequency.getText().toString().equals("")) return;
            Z = Double.parseDouble(Impedance.getText().toString());
            f = Double.parseDouble(Frequency.getText().toString());

            C = 1/(Z*f*Math.PI*2);
            L = Z/(2*Math.PI*f);

            String strC = Format.decimalFormat2.format(C);
            String strL = Format.decimalFormat2.format(L);

            Result_C.setText(strC+" F");
            Result_L.setText(strL+" H");
        });
    }
}