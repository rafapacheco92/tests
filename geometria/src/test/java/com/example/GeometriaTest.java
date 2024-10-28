package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeometriaTest {
    private Geometria geometriaVar;

    @BeforeEach
    public void setUp() {
        geometriaVar = new Geometria();
    }

    @Test
    public void testAreaTriangulo(){
        assertEquals(2.0, geometriaVar.areaTriangulo(2.0, 2.0));
    }

    @Test
    public void testAreaCircunferencia() {
        assertEquals(12.56637, geometriaVar.areaCircunferencia(2.0), 0.0001);
    }

    @Test
    public void testAreaQuadrado(){
        assertEquals(4.0, geometriaVar.areaQuadrado(2.0));
    }

    @Test
    public void testAreaRetangulo(){
        assertEquals(12.0, geometriaVar.areaRetangulo(4.0, 3.0));
    }

    @Test
    public void testVolumeCubo(){
        assertEquals(8.0, geometriaVar.volumeCubo(2.0));
    }

    @Test
    public void testVolumeCilindro(){
        assertEquals(25.132741228718345, geometriaVar.volumeCilindro(2.0, 2.0));
    }

    @Test
    public void testVolumeEsfera(){
        assertEquals(33.510321638291124, geometriaVar.volumeEsfera(2.0));
    }
}
