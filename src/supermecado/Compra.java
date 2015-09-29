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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author zeus
 */
@Entity
public class Compra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private int costoTotal=0;
    @OneToMany
    private List<DetalleCompra> detalleCompras = new ArrayList<>();
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Empleado empleado;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    

    public Compra( Empleado empleado, Cliente cliente) {
        this.cliente = cliente;
        this.empleado = empleado;
    }
    /**
     * Metodo para agregar Detalle de compra
     * @param detalle objeto tipo DetalleCompra
     */
    public void agregar(DetalleCompra detalle){
        try {
            
            DetalleCompra detail = buscar(detalle);
            detail.cantidadProductos += detalle.cantidadProductos;
            this.costoTotal += detalle.CostoProducto();
        } catch (Exception ex) {
            detalleCompras.add(detalle);
        this.costoTotal += detalle.CostoProducto();
        }
        
    }
    
    public void removerDetalle (int index){
        DetalleCompra detalle = detalleCompras.get(index);
        this.costoTotal -= detalle.CostoProducto();
        detalleCompras.remove(index);
        
    }
    
    public int puntosCompra(){
        int puntosCompra=0;
        if(costoTotal>=200000){
            puntosCompra= (int) Math.floor(costoTotal/10000.0);
        }
        this.cliente.incrementarPuntos(puntosCompra); //Correccion de asignacion de Puntos
        return puntosCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<DetalleCompra> getDetalleCompras() {
        return detalleCompras;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void setDetalleCompras(List<DetalleCompra> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    /**
     * 
     * @param detalle obejto detalle para buscar un producto en especifico
     * @return
     * @throws Exception Error al no encotrar el producto buscado
     */
    public DetalleCompra buscar(DetalleCompra detalle)throws Exception{
        DetalleCompra detalleFound=null;
        
        for(DetalleCompra detail : this.detalleCompras){
            if(detalle.equals(detail)){
                detalleFound = detail;
                break;
            }
        }
        
        if(detalleFound==null){
            throw new ObjectNotFoundException("Producto: +"+detalle.toString() +" no encontrado");
        }
        
        
        return detalleFound;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (this.costoTotal != other.costoTotal) {
            return false;
        }
        if (!Objects.equals(this.detalleCompras, other.detalleCompras)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
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
