package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.Tool.Format;
//计算无功功率
public class Mode7 extends AppCompatActivity {
    EditText X, CurrrentCoordinate, VoltageCoordinate;
    TextView Result;
    Button Count;
    RadioButton Fuc1, Fuc2;
    Boolean isFuc;

    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode7);
        X = findViewById(R.id.Mode7_Impedance);
        CurrrentCoordinate = findViewById(R.id.Mode7_CurrrentCoordinate);
        VoltageCoordinate = findViewById(R.id.Mode7_VoltageCoordinate);
        Result = findViewById(R.id.Mode7_Q);
        Count = findViewById(R.id.Mode7_Button);
        Fuc1 = findViewById(R.id.Mode7_FucCheck0);
        Fuc2 = findViewById(R.id.Mode7_FucCheck1);

        Fuc1.setOnClickListener(v -> SetEnabled(true));
        Fuc2.setOnClickListener(v -> SetEnabled(false));

        Count.setOnClickListener(v -> {
            if (isFuc == null || X.getText().toString().equals("")) return;
            if (isFuc) {
                if (VoltageCoordinate.getText().toString().equals("") ) return;
                //U^2/X
                result = Math.pow(Double.parseDouble(VoltageCoordinate.getText().toString()), 2) / Double.parseDouble(X.getText().toString());
            } else {
                if (CurrrentCoordinate.getText().toString().equals("") ) return;
                //I^2*X
                result = Math.pow(Double.parseDouble(CurrrentCoordinate.getText().toString()), 2) * Double.parseDouble(X.getText().toString());
            }
            Result.setText(Format.decimalFormat1.format(result) +" var");
        });
    }

    private void ClearAll() {
        CurrrentCoordinate.setText("");
        VoltageCoordinate.setText("");
        Result.setText("");
    }

    private void SetEnabled(boolean enabled) {
        ClearAll();
        CurrrentCoordinate.setEnabled(!enabled);
        VoltageCoordinate.setEnabled(enabled);
        isFuc = enabled;
    }
}