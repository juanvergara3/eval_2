package enums;

public enum ShipmentType {
    SEA("Marítimo"),
    LAND("Terrestre"),
    AIR("Aéreo");

    public final String label;

    private ShipmentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public static ShipmentType fromLabel(String label) {
        for (ShipmentType type : values()) {
            if (type.label.equals(label)) {
                return type;
            }
        }

        return null;
    }
}
