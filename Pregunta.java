package com.photogallery.camil.parcial;

public class Pregunta {

    String quiestion;
    String correct;
    String a,b,c;

    public Pregunta(String quiestion, String correct, String a, String b, String c) {
        this.quiestion = quiestion;
        this.correct = correct;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getQuiestion() {
        return quiestion;
    }

    public void setQuiestion(String quiestion) {
        this.quiestion = quiestion;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
