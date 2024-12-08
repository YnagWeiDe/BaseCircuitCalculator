package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Mode4用于计算电容和电感的阻抗值
public class Mode3 extends AppCompatActivity {
EditText Capacitance,CapacitanceFrequency,Inductance,InductanceFrequency;
TextView Xc,Zc,Xl,Zl;
Button Count1,Count2;
double resXc,resXl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode3);
        Capacitance=findViewById(R.id.Mode3_Capacitance);
        CapacitanceFrequency = findViewById(R.id.Mode3_CapacitanceFrequency);
        Inductance = findViewById(R.id.Mode3_Inductance);
        InductanceFrequency = findViewById(R.id.Mode3_InductanceFrequency);
        Xc=findViewById(R.id.Mode3_Capacitance_Xc);
        Zc=findViewById(R.id.Mode3_Capacitance_Zc);
        Xl=findViewById(R.id.Mode3_Inductance_Xl);
        Zl=findViewById(R.id.Mode3_Inductance_Zl);
        Count1=findViewById(R.id.Mode3_Button1);
        Count2=findViewById(R.id.Mode3_Button2);
        Count1.setOnClickListener(v -> {
            if(Capacitance.getText().toString().isEmpty() || CapacitanceFrequency.getText().toString().isEmpty()){
                return;
            }
            double t = Double.parseDouble(Capacitance.getText().toString()) * (Double.parseDouble(CapacitanceFrequency.getText().toString())*2*Math.PI);

            if(t == 0){
                Xc.setText("∞ Ω");
                return;
            }
            resXc =1/t;
            String str = String.format("%.4f", resXc);
            Xc.setText(str+"Ω");
            Zc.setText("j"+str+"Ω");
        });

        Count2.setOnClickListener(v -> {
            if(Inductance.getText().toString().isEmpty() || InductanceFrequency.getText().toString().isEmpty()){
                return;
            }
            resXl =(Double.parseDouble(Inductance.getText().toString()) * (Double.parseDouble(InductanceFrequency.getText().toString())*2*Math.PI));
            String str = String.format("%.4f", resXl);
            Xl.setText(str+"Ω");
            Zl.setText("j"+str+"Ω");
        });
    }
}