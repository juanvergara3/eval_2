# Añadir tipo de envío Express

Para agregar un nuevo tipo de envío llamado "Express" se solo se necesita:
1. Agregar el tipo de envío en el enum `ShipmentType` (modifica un solo archivo y una sola línea).
2. Crear la clase `ExpressShipment` que extienda de `Shipment` y sobrescriba el método `calculateCost()` (crear un nuevo archivo).
3. Crear la clase `ExpressFactory` que extienda de `ShipmentFactory` y sobrescriba el método `createShipment()` (crear un nuevo archivo).
4. Finalmente, agregar el caso `ShipmentType.EXPRESS` en el método `getFactory()` de la clase `ShipmentFactory` (modifica un solo archivo y una sola línea).

Es decir, para agregar un nuevo tipo de envío, sin tener en cuenta los archivos creados, solo se deben modificar 2 líneas de código. Adicional, el enum se puede considerar una constante, por lo que la única modificación "Real" necesaria es agregar la fábrica de express a la fábrica de envíos.
