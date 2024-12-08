package com.example.myapplication.Tool;
//电流类
public class Current {
    private double CurrentAnlge;       // 角度值
    private double CurrentCoordinate;       // 电流有效值


    public Current( double CurrentAnlge, double CurrentCoordinate){
            this.CurrentAnlge = CurrentAnlge;
            this.CurrentCoordinate = CurrentCoordinate;
    }

    public double getCurrentAnlge() {
        return CurrentAnlge;
    }

    public void setCurrentAnlge(double currentAnlge) {
        CurrentAnlge = currentAnlge;
    }

    public double getCurrentCoordinate() {
        return CurrentCoordinate;
    }

    public void setCurrentCoordinate(double currentCoordinate) {
        CurrentCoordinate = currentCoordinate;
    }
}




