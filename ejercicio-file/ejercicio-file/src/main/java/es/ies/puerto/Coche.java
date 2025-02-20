package es.ies.puerto;

public class Coche {
    private String color;
    private String tipo;

    public Coche() {
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Coche(String color, String tipo) {
        this.color = color;
        this.tipo = tipo;
    }

}
