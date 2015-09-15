
package supermecado;

import GUI.Principal;
import GUI.Ventana;

/**
 *
 * @author Polker
 */
public class SuperMecado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Datos Base
        Almacen tienda = new Almacen("SuperMercado MERCAMAX", "800.456.123-1");
        
         try {

            Empleado[] worker = {new Empleado(12345, "Fabio", "Mendez", "Fer", "F123"),
                new Empleado(123, "Esperanza", "Gomez", "Esgo", "gomez123"),
                new Empleado(789, "Juan", "Perez", "admin", "admin"),
                new Empleado(654, "Carlos", "Martinez", "admin1", "1234"),
                new Empleado(321, "Pedro", "salas", "admin2", "password")};
            Producto[] item = {new Producto("001", "RAM 4GB", 90000),
                new Producto("002", "RAM 8GB", 180000),
                new Producto("003", "SDD 256GB", 320000),
                new Producto("004", "HUB USB", 10000)};
//        DetalleCompra detalle = new DetalleCompra(4,item);
            Cliente[] customer = {new Cliente(123456789, "Pol", "KER"),
                new Cliente(12345, "Carlos", "Lara")};

            for (int x = 0; x < worker.length; x++) {
                tienda.add(worker[x]);
            }

            for (int x = 0; x < customer.length; x++) {
                tienda.add(customer[x]);
            }

            for (int x = 0; x < item.length; x++) {
                tienda.add(item[x]);
            }

        } catch (ObjectNotFoundException notFound) {
            notFound.printStackTrace();
        } catch (Exception error) {
            error.printStackTrace();
        }
        
        Principal w = new Principal (tienda);
       w.setVisible(true);
       
    }
    
}
