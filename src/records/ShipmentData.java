package records;

public record ShipmentData(
    String customer,
    String code,
    double weight,
    double distance
) {}
