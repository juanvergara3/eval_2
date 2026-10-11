package enums;

public enum Headers {
    TIPO("Tipo"),
    CODIGO("CÓdigo"),
    CLIENTE("Cliente"),
    PESO("Peso (kg)"),
    DISTANCIA("Distancia (km)"),
    COSTO("Costo");

    public final String label;

    private Headers(String label) {
        this.label = label;
    }

    public String getHeader() {
        return this.label;
    }
}
