package com.example.myapplication.Tool;


//电压类
public class Voltage {
    private double VoltageAnlge;       // 位移
    private double VoltageCoordinate;       // 电流值

    public Voltage(double VoltageAnlge, double VoltageCoordinate) {
        this.VoltageAnlge = VoltageAnlge;
        this.VoltageCoordinate = VoltageCoordinate;
    }

    public double getVoltageAnlge() {
        return VoltageAnlge;
    }

    public void setVoltageAnlge(double voltageAnlge) {
        VoltageAnlge = voltageAnlge;
    }

    public double getVoltageCoordinate() {
        return VoltageCoordinate;
    }

    public void setVoltageCoordinate(double voltageCoordinate) {
        VoltageCoordinate = voltageCoordinate;
    }
}




