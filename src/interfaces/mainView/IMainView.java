package interfaces.mainView;

// se crea una interfaz con todos los métodos que el controlador necesita para interactuar con la vista. Esto permite que el controlador no dependa de la implementación concreta de la vista, sino de una abstracción.
// Se separa la interfaz en varias partes para mejorar la especificidad de las interfaces; la separación se realiza basado en el tipo de operación, y se agrupa de una forma en la que cada interfaz hace operaciones que pertenecen a un mismo contexto.
public interface IMainView extends IMainViewWindows, IMainViewOutputs, IMainViewInteractions, IMainViewEventActions {
}
