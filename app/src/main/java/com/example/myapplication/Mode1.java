package com.example.myapplication;

import static com.example.myapplication.Tool.StaticFuc.ImpedanceSub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.Tool.Format;
import com.example.myapplication.Tool.Impedance;

// Mode1 用于计算阻抗并联
public class Mode1 extends AppCompatActivity {
    EditText real1, real2, imag1, imag2, Coordinate1, Coordinate2, Angle1, Angle2;
    TextView Result_real, Result_imag, Result_Coordinate, Result_Angle;
    RadioButton Fuc1, Fuc2;
    Button Count;

    double Real1, Real2, Imag1, Imag2, coordinate1, coordinate2, angle1, angle2;

    Impedance Impedance1= new Impedance(), Impedance2 = new Impedance(), ResImpedance;

    Boolean isFuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode1);

        real1 = (EditText) findViewById(R.id.Mode0_ImpedanceReal1);
        real2 = (EditText) findViewById(R.id.Mode0_ImpedanceReal2);
        imag1 = (EditText) findViewById(R.id.Mode0_ImpedanceImg1);
        imag2 = (EditText) findViewById(R.id.Mode0_ImpedanceImg2);
        Coordinate1 = (EditText) findViewById(R.id.Mode0_ImpedanceCoordinate1);
        Coordinate2 = (EditText) findViewById(R.id.Mode0_ImpedanceCoordinate2);
        Angle1 = (EditText) findViewById(R.id.Mode0_ImpedanceAngle1);
        Angle2 = (EditText) findViewById(R.id.Mode0_ImpedanceAngle2);

        Result_real = (TextView) findViewById(R.id.Mode0_ImpedanceRealResult);
        Result_imag = (TextView) findViewById(R.id.Mode0_ImpedanceImgResult);
        Result_Coordinate = (TextView) findViewById(R.id.Mode0_ImpedanceCoordinateResult);
        Result_Angle = (TextView) findViewById(R.id.Mode0_ImpedanceAngleResult);

        Fuc1 = (RadioButton) findViewById(R.id.Mode0_FucCheck1);
        Fuc2 = (RadioButton) findViewById(R.id.Mode0_FucCheck2);
        Count = (Button) findViewById(R.id.Mode0_Button);

        Fuc1.setOnClickListener(view -> SetEnable(true));
        Fuc2.setOnClickListener(view -> SetEnable(false));

        Count.setOnClickListener(view -> {
            if (isFuc == null) return;
            if (isFuc) {
                if (real1.getText().toString().equals("") || imag1.getText().toString().equals("") || real2.getText().toString().equals("") || real2.getText().toString().equals(""))
                    return;
                Real1 = Double.parseDouble(real1.getText().toString());
                Imag1 = Double.parseDouble(imag1.getText().toString());
                Real2 = Double.parseDouble(real2.getText().toString());
                Imag2 = Double.parseDouble(imag2.getText().toString());
                Impedance1.Impedance_Exp(Real1, Imag1);
                Impedance2.Impedance_Exp(Real2, Imag2);

            } else {
                if (Coordinate1.getText().toString().equals("") || Coordinate2.getText().toString().equals("") || Angle1.getText().toString().equals("") || Angle2.getText().toString().equals(""))
                    return;
                coordinate1 = Double.parseDouble(Coordinate1.getText().toString());
                coordinate2 = Double.parseDouble(Coordinate2.getText().toString());
                angle1 = Double.parseDouble(Angle1.getText().toString());
                angle2 = Double.parseDouble(Angle2.getText().toString());
                Impedance1.Impedance_PolarCoordinate(coordinate1, angle1);
                Impedance2.Impedance_PolarCoordinate(coordinate2, angle2);
            }
            ResImpedance = ImpedanceSub(Impedance1, Impedance2);
            getResult(ResImpedance);

        });

    }


    public void ClearAll() {
        real1.setText("");
        real2.setText("");
        imag1.setText("");
        imag2.setText("");
        Coordinate1.setText("");
        Coordinate2.setText("");
        Angle1.setText("");
        Angle2.setText("");
    }

    public void getResult(Impedance self){
        Result_real.setText(Format.decimalFormat1.format(self.getReal()));
        Result_imag.setText(Format.decimalFormat1.format(self.getImaginary()));
        Result_Coordinate.setText(Format.decimalFormat1.format(self.getCoordinate()));
        Result_Angle.setText(Format.decimalFormat1.format(self.getAngle()));
    }

    public void SetEnable(boolean enable) {
        ClearAll();
        real1.setEnabled(enable);
        real2.setEnabled(enable);
        imag1.setEnabled(enable);
        imag2.setEnabled(enable);
        Coordinate1.setEnabled(!enable);
        Coordinate2.setEnabled(!enable);
        Angle1.setEnabled(!enable);
        Angle2.setEnabled(!enable);

        isFuc = enable;
    }
}