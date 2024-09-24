package com.example;

public class Geometria {
    public double areaTriangulo(double base, double altura){
        return (base * altura) / 2;
    }

    public double areaQuadrado(double lado){
        return lado * lado;
    }

    public double areaRetangulo(double base, double altura){
        return base * altura;
    }

    public double areaCircunferencia(double raio){
        return Math.PI * (raio * raio);
    }

    public double volumeEsfera(double raio){
        return (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
    }

    public double volumeCubo(double lado){
        return lado * lado * lado;
    }

    public double volumeCilindro(double raio, double altura){
        return Math.PI * raio * raio * altura;
    }
}
