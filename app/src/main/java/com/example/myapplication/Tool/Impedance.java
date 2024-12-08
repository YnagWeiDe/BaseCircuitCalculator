package com.example.myapplication.Tool;

import android.util.Log;
//阻抗类
public class Impedance {
    private double real,imaginary;
    private double Coordinate,angle;


    public Impedance() {
    }

    //构造函数，传入实部和虚部 计算复阻抗的极坐标系
    public void Impedance_Exp(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        PolarCoordinate_Impedance(real, imaginary);
    }

    //构造函数，传入极坐标系的坐标和角度 计算复阻抗的实部和虚部
    public void Impedance_PolarCoordinate(double Coordinate, double angle) {
        this.Coordinate = Coordinate;
        this.angle = angle;
        double radian = Math.toRadians(angle);
        this.real = Coordinate*(Math.cos(radian));
        this.imaginary = Coordinate*(Math.sin(radian));
    }

    //计算复阻抗的极坐标系
    private void PolarCoordinate_Impedance(double real, double imaginary) {
        this.Coordinate = Math.sqrt(((real*real) + (imaginary*imaginary)));
        double temp = imaginary/real;
        this.angle =Math.toDegrees( Math.atan(temp));
    }
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getCoordinate() {
        return Coordinate;
    }

    public double getAngle() {
        return angle;
    }

}


