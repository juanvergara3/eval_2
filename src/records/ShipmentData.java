package records;

public record ShipmentData(
    String customer,
    String code,
    double weight,
    double distance
) {
    // se añade este constructor chiquito para normalizar las entradas de texto, quitando espacios al inicio y al final de los strings, y dejando null si el string es null. 
    // este tipo de procesamiento se debería hacer en el servicio, pero me pareció mejor hacerlo aquí para que las entradas de texto se normalicen sin importar la implementación del servicio.
    public ShipmentData {
        customer = customer == null ? null : customer.strip();
        code = code == null ? null : code.strip();
    }
}
