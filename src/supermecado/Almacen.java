/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistence.ClienteJpaController;
import persistence.CompraJpaController;
import persistence.DetalleCompraJpaController;
import persistence.EmpleadoJpaController;
import persistence.ProductoJpaController;

/**
 *
 * @author zeus
 */
public class Almacen implements Serializable{

    private String nombre;
    private String NIT;
    private List<Producto> productos = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();
    public Empleado logueado; 

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperMecadoPU");
    private ClienteJpaController clienteJpa = new ClienteJpaController(emf);
    private CompraJpaController compraJpa = new CompraJpaController(emf);
    private DetalleCompraJpaController detalleCompraJpa = new DetalleCompraJpaController(emf);
    private EmpleadoJpaController empleadoJpa = new EmpleadoJpaController(emf);
    private ProductoJpaController productoJpa = new ProductoJpaController(emf);
            
    public Almacen(String nombre, String NIT) {
        this.nombre = nombre;
        this.NIT = NIT;
    }

    //*******************************    
    // Agregado de obejtos a las listas correspondientes
    public void add(Producto producto) throws Exception {
       productoJpa.create(producto);

    }

    public void add(Empleado empleado) throws Exception {
        empleadoJpa.create(empleado);

    }

    public void add(Cliente cliente) throws Exception {
        clienteJpa.create(cliente);

    }

    public void add(Compra compra) throws Exception {
        compraJpa.create(compra);

    }

    //Fin metodos de agregado
    //*******************************    
    //******************************
    // Metodos de Busqueda
    /**
     * Busca en la lista de empleado por numero de identificacion
     *
     * @param id del empleado a buscar
     * @return
     * @throws ObjectNotFoundException
     */
    public Empleado BuscarEmpleado(long id) throws ObjectNotFoundException {
        return empleadoJpa.findEmpleado(id);

    }

//    public Empleado BuscarEmpleado(String login) throws ObjectNotFoundException {
//        
//
//    }

    /**
     * busca el cliente en la lista de clientes por identificacion
     *
     * @param id
     * @return el Cliente que encuentra
     * @throws ObjectNotFoundException
     */
    public Cliente BuscarCliente(long id) throws ObjectNotFoundException {
            return clienteJpa.findCliente(id);
        
    }

    /**
     * Busca un producto por su codigo
     *
     * @param code
     * @return
     * @throws ObjectNotFoundException
     */
    public Producto BuscarProducto(String code) throws ObjectNotFoundException {
        return productoJpa.findProducto(code);

    }

    

    //******************************
    public String getNombre() {
        return nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    
}
