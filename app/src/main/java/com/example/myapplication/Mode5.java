package com.example.myapplication;

import static com.example.myapplication.Tool.StaticFuc.GetCurrent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.Tool.Current;
import com.example.myapplication.Tool.Format;
import com.example.myapplication.Tool.Impedance;
import com.example.myapplication.Tool.Voltage;

//Mode5 用电压和阻抗计算电流
public class Mode5 extends AppCompatActivity {
    EditText Voltage_coordinate, Voltage_angle, ImpedanceReal, ImpedanceImg, Impedance_Coordinate, Impedance_angle;
    RadioButton ImpedanceRadio1, ImpedanceRadio2;
    TextView Current_coordinate, Current_angle;
    Button Count;
    Impedance impedance = new Impedance();
    Voltage voltage;
    Boolean isFuc;
    double voltage_coordinate, voltage_angle, impedance_real, impedance_img, impedance_angle, current_coordinate, current_angle, impedance_coordinate;
    Current Current;

    //还没赋值
//todo 逻辑功能还未实现
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode5);
        //Id赋值
        Voltage_coordinate = findViewById(R.id.Mode5_Voltage);
        Voltage_angle = findViewById(R.id.Mode5_VoltageAngle);
        ImpedanceReal = findViewById(R.id.Mode5_real);
        ImpedanceImg = findViewById(R.id.Mode5_imag);

        Impedance_Coordinate = findViewById(R.id.Mode5_Coordinate);
        Impedance_angle = findViewById(R.id.Mode5_Angle);
        ImpedanceRadio1 = findViewById(R.id.Mode5_FucCheck0);
        ImpedanceRadio2 = findViewById(R.id.Mode5_FucCheck1);
        Current_coordinate = findViewById(R.id.Mode5_Current);
        Current_angle = findViewById(R.id.Mode5_CurrentAngle);
        Count = findViewById(R.id.Mode5_Button);

        //ImpedanceRadio1是计算表达式;
        //ImpedanceRadio2是计算极坐标;
        ImpedanceRadio1.setOnClickListener(view -> SetEnable(true));
        ImpedanceRadio2.setOnClickListener(view -> SetEnable(false));

        Count.setOnClickListener(view -> {//将电压和阻抗转为电流
            if (isFuc == null) return;

            voltage_coordinate = Double.parseDouble(Voltage_coordinate.getText().toString());
            voltage_angle = Double.parseDouble(Voltage_angle.getText().toString());
            voltage = new Voltage(voltage_angle, voltage_coordinate);

            if (isFuc) {
                impedance_real = Double.parseDouble(ImpedanceReal.getText().toString());
                impedance_img = Double.parseDouble(ImpedanceImg.getText().toString());
                impedance.Impedance_Exp(impedance_real, impedance_img);
            } else {
                impedance_coordinate = Double.parseDouble(Impedance_Coordinate.getText().toString());
                impedance_angle = Double.parseDouble(Impedance_angle.getText().toString());
                impedance.Impedance_PolarCoordinate(impedance_coordinate, impedance_angle);
            }
            Current = GetCurrent(voltage, impedance);

            Current_coordinate.setText(Format.decimalFormat1.format(Current.getCurrentCoordinate()));
            Current_angle.setText(String.valueOf(Current.getCurrentAnlge()));

        });
    }

    public void SetEnable(boolean enable) {//EditText的状态转换
        isFuc = enable;
        Impedance_angle.setEnabled(!enable);
        Impedance_Coordinate.setEnabled(!enable);
        ImpedanceReal.setEnabled(enable);
        ImpedanceImg.setEnabled(enable);
        Impedance_angle.setText("");
        Impedance_Coordinate.setText("");
        ImpedanceReal.setText("");
        ImpedanceImg.setText("");
    }
}