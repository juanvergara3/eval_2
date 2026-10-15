package interfaces.logisticsService;

public interface ILogisticsServiceOutputs {

    // método(s) que se usan exclusivamente para obtener datos de salida del servicio, es decir, no son datos estáticos como en la interfaz de enums, ni son operaciones que modifiquen el estado del servicio como en la interfaz de operaciones.
    public String[][] getShipmentsTableData();
}
