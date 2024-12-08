package com.example.myapplication;

import static com.example.myapplication.Tool.StaticFuc.GetCurrent;
import static com.example.myapplication.Tool.StaticFuc.GetVoltage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.Tool.Current;
import com.example.myapplication.Tool.Format;
import com.example.myapplication.Tool.Impedance;
import com.example.myapplication.Tool.Voltage;

import java.util.Set;

//Mode6 用阻抗和电流计算电压

public class Mode6 extends AppCompatActivity {
    EditText CurrentCoordinate, CurrentAngle, ImpedanceCoordinate, ImpedanceAngle, Impedance_real, Impedance_imag;
    TextView VoltageCoordinate, VoltageAngle;
    RadioButton Fuc1, Fuc2;
    Button Count;

    double voltage_coordinate, voltage_angle, current_coordinate, current_angle;
    double impedance_coordinate, impedance_angle, impedance_real, impedance_img;

    Voltage voltage;
    Current current;
    Impedance impedance = new Impedance();

    Boolean isFuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode6);

        VoltageCoordinate = findViewById(R.id.Mode6_VoltageCoordinate);
        VoltageAngle = findViewById(R.id.Mode6_VoltageAngle);
        CurrentCoordinate = findViewById(R.id.Mode6_CurrrentCoordinate);
        CurrentAngle = findViewById(R.id.Mode6_CurrrentAngle);
        ImpedanceCoordinate = findViewById(R.id.Mode6_Coordinate);
        ImpedanceAngle = findViewById(R.id.Mode6_Angle);
        Impedance_real = findViewById(R.id.Mode6_real);
        Impedance_imag = findViewById(R.id.Mode6_imag);
        Fuc1 = findViewById(R.id.Mode6_FucCheck0);
        Fuc2 = findViewById(R.id.Mode6_FucCheck1);
        Count = findViewById(R.id.Mode6_Button);

        Fuc1.setOnClickListener(view -> SetEnable(true));
        Fuc2.setOnClickListener(view -> SetEnable(false));

        Count.setOnClickListener(view -> {
            if (isFuc == null) return;

            current_coordinate = Double.parseDouble(CurrentCoordinate.getText().toString());
            current_angle = Double.parseDouble(CurrentAngle.getText().toString());
            current = new Current(current_angle, current_coordinate);

            if (isFuc) {
                impedance_real = Double.parseDouble(Impedance_real.getText().toString());
                impedance_img = Double.parseDouble(Impedance_imag.getText().toString());
                impedance.Impedance_Exp(impedance_real, impedance_img);
            } else {
                impedance_coordinate = Double.parseDouble(ImpedanceCoordinate.getText().toString());
                impedance_angle = Double.parseDouble(ImpedanceAngle.getText().toString());
                impedance.Impedance_PolarCoordinate(impedance_coordinate, impedance_angle);
            }
            voltage = GetVoltage(current, impedance);

            VoltageCoordinate.setText(Format.decimalFormat1.format(voltage.getVoltageCoordinate()));
            VoltageAngle.setText(String.valueOf(voltage.getVoltageAnlge()));
        });



    }

    public void SetEnable(boolean enable) {//EditText的状态转换
        isFuc = enable;
        ImpedanceCoordinate.setEnabled(!enable);
        ImpedanceAngle.setEnabled(!enable);
        Impedance_real.setEnabled(enable);
        Impedance_imag.setEnabled(enable);
        ImpedanceCoordinate.setText("");
        ImpedanceAngle.setText("");
        Impedance_real.setText("");
        Impedance_imag.setText("");
    }
}



