package interfaces.logisticsService;

// se implementa una interfaz para hacer que el controlador no dependa de la implementación concreta del servicio, sino de la interfaz, lo que permite cambiar la implementación del servicio sin afectar al controlador
// Se separa la interfaz en varias partes para mejorar la especificidad de las interfaces.
public interface ILogisticsService extends ILogisticsServiceEnums, ILogisticsServiceOperations, ILogisticsServiceOutputs {}
