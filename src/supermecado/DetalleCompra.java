/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermecado;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author zeus
 */
@Entity
public class DetalleCompra implements Serializable{
    
    @Column
    int cantidadProductos;
    @OneToOne
    private Producto producto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

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

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    

 
    
    
    
    
    
    
}
