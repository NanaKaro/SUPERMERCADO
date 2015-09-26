/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author zeus
 */
public class DetalleCompra implements Serializable{
    
    int cantidadProductos;
    private Producto producto;

    public DetalleCompra(int cantidadProductos, Producto producto) throws Exception {
        if(producto==null) throw new Exception("El producto no puede ser nulo");
        this.cantidadProductos = cantidadProductos;
        this.producto = producto;
    }

    public int CostoProducto(){
         return this.cantidadProductos * this.producto.costoUnitario;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleCompra other = (DetalleCompra) obj;
        if (this.cantidadProductos != other.cantidadProductos) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

 
    

 
    
    
    
    
    
    
}
