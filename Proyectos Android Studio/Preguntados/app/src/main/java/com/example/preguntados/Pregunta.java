package com.example.preguntados;

public class Pregunta {

    private String pregun;
    private String opA;
    private String opB;
    private String opC;
    private String opD;
    private String opCorrecta;
    private String puntos;


    public Pregunta ( String pregun, String opA, String opB, String opC, String opD, String opCorrecta, String puntos){

        this.pregun= pregun;
        this.opA = opA;
        this.opB = opB;
        this.opC = opC;
        this.opD = opD;
        this.opCorrecta = opCorrecta;
        this.puntos = puntos;

    }

    public String getPregun() {
        return pregun;
    }

    public void setPregun(String pregun) {
        this.pregun = pregun;
    }

    public String getOpA() {
        return opA;
    }

    public void setOpA(String opA) {
        this.opA = opA;
    }

    public String getOpB() {
        return opB;
    }

    public void setOpB(String opB) {
        this.opB = opB;
    }

    public String getOpC() {
        return opC;
    }

    public void setOpC(String opC) {
        this.opC = opC;
    }

    public String getOpD() {
        return opD;
    }

    public void setOpD(String opD) {
        this.opD = opD;
    }

    public String getOpCorrecta() {
        return opCorrecta;
    }

    public void setOpCorrecta(String opCorrecta) {
        this.opCorrecta = opCorrecta;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
}
