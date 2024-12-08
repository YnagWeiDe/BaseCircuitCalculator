package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.myapplication.Tool.DataView;

import com.example.myapplication.Tool.MyList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mainListView;
    RadioButton Chinese,English;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chinese = findViewById(R.id.Main_Chinese);
        English = findViewById(R.id.Main_English);

        //存储页面数据
         mainListView = findViewById(R.id.main_list_view);
        ArrayList<DataView> items = new ArrayList<>();

        items.add(new DataView(" Mode 0:Series Impedance Calculation", new Intent(this, Mode0.class)));
        items.add(new DataView(" Mode 1:Parallel Impedance Calculation", new Intent(this, Mode1.class)));
        items.add(new DataView(" Mode 2:Polar to Expressions", new Intent(this, Mode2.class)));
        items.add(new DataView(" Mode 3:Capacitance and Inductance Calculation to Impedance", new Intent(this, Mode3.class)));
        items.add(new DataView(" Mode 4:Voltage and Current Calculation to Impedance", new Intent(this, Mode4.class)));
        items.add(new DataView(" Mode 5:Voltage and Impedance Calculation to Current", new Intent(this, Mode5.class)));
        items.add(new DataView(" Mode 6:Current and Impedance Calculation to Voltage", new Intent(this, Mode6.class)));
        items.add(new DataView(" Mode 7:Reactive Power", new Intent(this, Mode7.class)));
        items.add(new DataView(" Mode 8:Common Values of Series Resonance", new Intent(this, Mode8.class)));
        items.add(new DataView(" Mode 9:In resonance ,Capacitance and Inductance Calculation to Special value", new Intent(this, Mode9.class)));
        MyList list = new MyList(this, items);
        //使用适配器将数据显示在List控件中
        mainListView.setAdapter(list);


        Chinese.setOnClickListener(view -> {
            items.clear();
            items.add(new DataView(" Mode 0:阻抗串联计算", new Intent(this, Mode0.class)));
            items.add(new DataView(" Mode 1:阻抗并联计算", new Intent(this, Mode1.class)));
            items.add(new DataView(" Mode 2:极坐标转表达式", new Intent(this, Mode2.class)));
            items.add(new DataView(" Mode 3:容抗感抗计算", new Intent(this, Mode3.class)));
            items.add(new DataView(" Mode 4:电压、电流计算阻抗", new Intent(this, Mode4.class)));
            items.add(new DataView(" Mode 5:电压、阻抗计算电流", new Intent(this, Mode5.class)));
            items.add(new DataView(" Mode 6:电流、阻抗计算电压", new Intent(this, Mode6.class)));
            items.add(new DataView(" Mode 7:计算无功功率", new Intent(this, Mode7.class)));
            items.add(new DataView(" Mode 8:串联谐振常用值", new Intent(this, Mode8.class)));
            items.add(new DataView(" Mode 9:计算谐振电容电感值", new Intent(this, Mode9.class)));
            MyList list = new MyList(this, items);
            //使用适配器将数据显示在List控件中
            mainListView.setAdapter(list);
        });
        English.setOnClickListener(view -> {
            items.clear();
            items.add(new DataView(" Mode 0:Series Impedance Calculation", new Intent(this, Mode0.class)));
            items.add(new DataView(" Mode 1:Parallel Impedance Calculation", new Intent(this, Mode1.class)));
            items.add(new DataView(" Mode 2:Polar to Expressions", new Intent(this, Mode2.class)));
            items.add(new DataView(" Mode 3:Capacitance and Inductance Calculation to Impedance", new Intent(this, Mode3.class)));
            items.add(new DataView(" Mode 4:Voltage and Current Calculation to Impedance", new Intent(this, Mode4.class)));
            items.add(new DataView(" Mode 5:Voltage and Impedance Calculation to Current", new Intent(this, Mode5.class)));
            items.add(new DataView(" Mode 6:Current and Impedance Calculation to Voltage", new Intent(this, Mode6.class)));
            items.add(new DataView(" Mode 7:Reactive Power", new Intent(this, Mode7.class)));
            items.add(new DataView(" Mode 8:Common Values of Series Resonance", new Intent(this, Mode8.class)));
            items.add(new DataView(" Mode 9:In resonance ,Capacitance and Inductance Calculation to Special value", new Intent(this, Mode9.class)));
            MyList list = new MyList(this, items);
            //使用适配器将数据显示在List控件中
            mainListView.setAdapter(list);
        });



    }
}