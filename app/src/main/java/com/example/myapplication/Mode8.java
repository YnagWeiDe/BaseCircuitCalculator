package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Tool.Format;

//Mode8:谐振子
//输入：电容C，电感L，谐振子阻抗阻值RES
//输出：谐振子阻抗阻值F0，谐振子阻抗阻值X，谐振子品质因数Q
public class Mode8 extends AppCompatActivity {
EditText C,L,RES;
TextView F0,Q,X;
Button button;
double c,l,f0,q,x,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode8);

        RES = findViewById(R.id.Mode8_R);
        C=findViewById(R.id.Mode8_C);
        L=findViewById(R.id.Mode8_L);
        F0=findViewById(R.id.Mode8_f0);
        Q=findViewById(R.id.Mode8_Q);
        X = findViewById(R.id.Mode8_x);

        button=findViewById(R.id.Mode8_Button);

        button.setOnClickListener(v -> {
            if(C.getText().toString().equals("")||L.getText().toString().equals(""))return;
            c=Double.parseDouble(C.getText().toString());
            l=Double.parseDouble(L.getText().toString());

            f0 = 1/(2*Math.PI*Math.sqrt(c*l));
            x = Math.sqrt(l/c);
            F0.setText(Format.decimalFormat1.format(f0) +"");
            X.setText(Format.decimalFormat1.format(x) +"");
            if((RES.getText().toString().equals("0"))||(RES.getText().toString().equals("")))
                Q.setText("谐振点处品质因数无穷大，近似短路");
            else
            {
                res = Double.parseDouble(RES.getText().toString());
                q = x/res;
                Q.setText(q+"");
            }
        });
    }
}