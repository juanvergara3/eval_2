package enums;

public enum Headers {
    TIPO("Tipo"),
    CODIGO("Código"),
    CLIENTE("Cliente"),
    PESO("Peso (kg)"),
    DISTANCIA("Distancia (km)"),
    COSTO("Costo");

    public final String label;

    private Headers(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
