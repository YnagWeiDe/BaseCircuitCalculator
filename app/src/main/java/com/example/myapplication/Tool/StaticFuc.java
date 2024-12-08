package com.example.myapplication.Tool;

import android.util.Log;
//静态方法类
public class StaticFuc {
    //计算阻抗串联
    public static Impedance ImpedanceAdd(Impedance self, Impedance other) {
        Impedance res = new Impedance();
        res.Impedance_Exp(self.getReal() + other.getReal(), self.getImaginary() + other.getImaginary());
        return res;
    }

    //计算阻抗并联
    public static Impedance ImpedanceSub(Impedance self, Impedance other) {
        Impedance res = new Impedance();
        Impedance temp1 = new Impedance(),temp2 = new Impedance();
        temp1.Impedance_PolarCoordinate(self.getCoordinate()* other.getCoordinate(),self.getAngle()+ other.getAngle() );
        temp2.Impedance_Exp(self.getReal()+ other.getReal(),self.getImaginary()+ other.getImaginary());

        res.Impedance_PolarCoordinate(temp1.getCoordinate()/ temp2.getCoordinate(),temp1.getAngle()- temp2.getAngle());

        return res;
    }

    //电压阻抗转换为电流
    public static Current GetCurrent(Voltage V, Impedance Z) {
        double CurrentCoordinate = V.getVoltageCoordinate() / Z.getCoordinate();
        double CurrentAngle = V.getVoltageAnlge() - Z.getAngle();
        Log.d("TAG", "GetCurrent: " + V.getVoltageCoordinate() + "   " + V.getVoltageAnlge());
        Log.d("TAG", "GetCurrent: " + Z.getCoordinate() + " +" + Z.getAngle());
        return new Current(CurrentAngle, CurrentCoordinate);
    }

    //电流阻抗转换为电压
    public static Voltage GetVoltage(Current A, Impedance Z) {
        double CurrentCoordinate = A.getCurrentCoordinate() * Z.getCoordinate();
        double CurrentAngle = A.getCurrentAnlge() + Z.getAngle();
        return new Voltage(CurrentAngle, CurrentCoordinate);
    }
}
