package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Tool.Format;
import com.example.myapplication.Tool.Impedance;
//Mode2类，用于实现两种坐标系之间的转换
public class Mode2 extends AppCompatActivity {
    EditText Coordinate,Real,Angle,Image;
    Button Count;
    TextView real_result,angle_result,image_result,coordinate_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode2);
        Coordinate=findViewById(R.id.MODE2_ImpedanceValue1);
        Angle=findViewById(R.id.MODE2_ImpedanceAngle1);
        Real=findViewById(R.id.Mode2_ImpedanceReal2);
        Image=findViewById(R.id.Mode2_ImpedanceImag2);
        real_result=findViewById(R.id.MODE2_ImpedanceReal1);
        angle_result=findViewById(R.id.Mode2_ImpedanceAngle2);
        image_result=findViewById(R.id.MODE2_ImpedanceImag1);
        coordinate_result=findViewById(R.id.Mode2_ImpedanceValue2);
        Count=findViewById(R.id.Mode2_Button);

        Count.setOnClickListener(v -> {//用于计算两种坐标系之间的转换
            Impedance temp =  new Impedance();
            if((!Coordinate.getText().toString().isEmpty()) && (!Angle.getText().toString().isEmpty())){
                temp.Impedance_PolarCoordinate(Double.parseDouble(Coordinate.getText().toString()),Double.parseDouble(Angle.getText().toString()));
                real_result.setText(Format.decimalFormat1.format(temp.getReal()));
                image_result.setText(String.valueOf(temp.getImaginary()));
            }
            if((!Real.getText().toString().isEmpty()) && (!Image.getText().toString().isEmpty())){
                temp.Impedance_Exp(Double.parseDouble(Real.getText().toString()),Double.parseDouble(Image.getText().toString()));
                coordinate_result.setText(Format.decimalFormat1.format(temp.getCoordinate()));
                angle_result.setText(String.valueOf(temp.getAngle()));
            }
        });
    }
}