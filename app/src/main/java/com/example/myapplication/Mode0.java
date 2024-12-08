package com.example.myapplication;

import static com.example.myapplication.Tool.StaticFuc.ImpedanceAdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.Tool.Format;
import com.example.myapplication.Tool.Impedance;

// Mode0 这个界面用于计算阻抗串联
public class Mode0 extends AppCompatActivity {
    RadioButton RB1,RB2;
    EditText real1,real2,imag1,imag2,Coordinate1,Coordinate2,Angle1,Angle2;
    TextView Tresult_real,Tresult_imag,Tresult_Coordinate,Tresult_Angle;
    double real1_value,real2_value,imag1_value,imag2_value,result_real_value,result_imag_value,result_Coordinate,result_Angle;
    double Coordinate1_value,Coordinate2_value,Angle1_value,Angle2_value;
    Button Count;
    boolean isFucCheck1 = false;
    boolean isFucCheck2 = false;

    Impedance self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode0);

        RB1 = (RadioButton) findViewById(R.id.FucCheck0);
        RB2 = (RadioButton) findViewById(R.id.FucCheck1);

        real1 = (EditText) findViewById(R.id.ImpedanceReal1);
        real2 = (EditText) findViewById(R.id.ImpedanceReal2);
        imag1 = (EditText) findViewById(R.id.ImpedanceImg1);
        imag2 = (EditText) findViewById(R.id.ImpedanceImg2);
        Coordinate1 = (EditText) findViewById(R.id.ImpedanceCoordinate1);
        Coordinate2 = (EditText) findViewById(R.id.ImpedanceCoordinate2);
        Angle1 = (EditText) findViewById(R.id.ImpedanceAngle1);
        Angle2 = (EditText) findViewById(R.id.ImpedanceAngle2);

        Tresult_real = (TextView) findViewById(R.id.ImpedanceReal3);
        Tresult_imag = (TextView) findViewById(R.id.ImpedanceImg3);
        Tresult_Coordinate = (TextView) findViewById(R.id.ImpedanceCoordinate);
        Tresult_Angle = (TextView) findViewById(R.id.ImpedanceAngle);

        Count = (Button) findViewById(R.id.Mode1Count);

        RB1.setOnClickListener(view -> {Bool(true);});

        RB2.setOnClickListener(view -> {Bool(false);});

       Count.setOnClickListener(view -> {
           if(Coordinate1.getText().toString().equals("")||Coordinate1.getText().toString().equals("0") || Coordinate2.getText().toString().equals("")||Coordinate2.getText().toString().equals("0")) return;
           if(!isFucCheck1&&isFucCheck2){
               real1_value = Double.parseDouble(real1.getText().toString());
               real2_value = Double.parseDouble(real2.getText().toString());
               imag1_value = Double.parseDouble(imag1.getText().toString());
               imag2_value = Double.parseDouble(imag2.getText().toString());
               Impedance impedance1 = new Impedance();
               Impedance impedance2 = new Impedance();
               impedance1.Impedance_Exp(real1_value,imag1_value);
               impedance2.Impedance_Exp(real2_value,imag2_value);

               self =  ImpedanceAdd(impedance1,impedance2);

           }else if(isFucCheck1&&!isFucCheck2){
               Coordinate1_value = Double.parseDouble(Coordinate1.getText().toString());
               Coordinate2_value = Double.parseDouble(Coordinate2.getText().toString());
               Angle1_value = Double.parseDouble(Angle1.getText().toString());
               Angle2_value = Double.parseDouble(Angle2.getText().toString());
               self = new Impedance();
               self.Impedance_PolarCoordinate(Coordinate1_value/Coordinate2_value,(Angle1_value-Angle2_value));
           }else{
               return;
           }
           getResult(self);// 显示
       });
    }
    public void getResult(Impedance self){
        // 显示(保留两位小数)
        Tresult_real.setText(Format.decimalFormat1.format(self.getReal()));
        Tresult_imag.setText(Format.decimalFormat1.format(self.getImaginary()));
        Tresult_Coordinate.setText(Format.decimalFormat1.format(self.getCoordinate()));
        Tresult_Angle.setText(Format.decimalFormat1.format(self.getAngle()));

    }

    public void clear(){
        real1.setText("");
        real2.setText("");
        imag1.setText("");
        imag2.setText("");
        Coordinate1.setText("");
        Coordinate2.setText("");
        Angle1.setText("");
        Angle2.setText("");
    }

    public void  Bool(boolean T){

        clear();

        real1.setEnabled(!T);
        real2.setEnabled(!T);
        imag1.setEnabled(!T);
        imag2.setEnabled(!T);

        Coordinate1.setEnabled(T);
        Coordinate2.setEnabled(T);
        Angle1.setEnabled(T);
        Angle2.setEnabled(T);
        isFucCheck1 = T;
        isFucCheck2 = !T;


    }
}