package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Tool.Format;
import com.example.myapplication.Tool.Impedance;

//Mode4 用电压和电流计算阻抗
public class Mode4 extends AppCompatActivity {
EditText Current,CurrentAngle,Voltage,VoltageAngle;

TextView Impedance_read,Impedance_angle,Impendance_img,Impedance_Coordinate;
Button Count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode4);
        Current = findViewById(R.id.Mode4_Current);
        CurrentAngle = findViewById(R.id.Mode4_CurrentAngle);
        Voltage = findViewById(R.id.Mode4_Voltage);
        VoltageAngle = findViewById(R.id.Mode4_VoltageAngle);
        Impedance_read = findViewById(R.id.MODE4_ImpedanceReal);
        Impedance_angle = findViewById(R.id.Mode4_ImpedanceAngle);
        Impendance_img = findViewById(R.id.MODE4_ImpedanceImag);
        Impedance_Coordinate = findViewById(R.id.Mode4_ImpedanceValue);
        Count = findViewById(R.id.Mode4_Button);
        Count.setOnClickListener(v -> {
            if(Current.getText().toString().isEmpty() || CurrentAngle.getText().toString().isEmpty() || Voltage.getText().toString().isEmpty() || VoltageAngle.getText().toString().isEmpty()){
                return;
            }
            double current = Double.parseDouble(Current.getText().toString());
            double currentAngle = Double.parseDouble(CurrentAngle.getText().toString());
            double voltage = Double.parseDouble(Voltage.getText().toString());
            double voltageAngle = Double.parseDouble(VoltageAngle.getText().toString());

            double Coordinate = voltage/current;
            double Angle = voltageAngle-currentAngle;

            Impedance impedance = new Impedance();

            impedance.Impedance_PolarCoordinate(Coordinate,Angle);

            Impedance_read.setText(Format.decimalFormat1.format(impedance.getReal()));
            Impedance_angle.setText(Format.decimalFormat1.format(impedance.getAngle()));
            Impendance_img.setText(Format.decimalFormat1.format(impedance.getImaginary()));
            Impedance_Coordinate.setText(Format.decimalFormat1.format(impedance.getCoordinate()));
        });
    }
}