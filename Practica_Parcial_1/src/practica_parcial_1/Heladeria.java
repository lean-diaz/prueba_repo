package practica_parcial_1;

import java.util.ArrayList;
import java.util.Collections;

public class Heladeria {
    // Atributos privados
    private int capacidad;
    private ArrayList<ProductoHeladeria> productos;

    // Constructor Heladeria(): Inicializa la colección y le da valor por defecto 3 a la capacidad.
    public Heladeria() {
        this(3);
    }
    
    // Heladeria(int): Recibe un entero con la capacidad.
    public Heladeria(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }
    
    // (-) sonIguales(ProductoHeladeria p) : boolean
    private boolean sonIguales(ProductoHeladeria p) {
        return this.productos.contains(p);
    }
    
    // (+) agregar(ProductoHeladeria): void
    public void agregar(ProductoHeladeria producto){
        if (producto == null){
            System.out.println("Error. Producto nulo");
            return;
        }
        
        if (this.productos.size() >= this.capacidad){
            System.out.println("Error. La capacidad esta llena");
            return;
        }
        
        if (this.sonIguales(producto)){
            System.out.println("Error. El producto se encuentra en la Heladeria");
            return;
        }
        
        this.productos.add(producto);
        System.out.println("Producto: " + producto.getNombre() + " agregado con exito");  
    }
    
    // (-) getPrecioProductos(TipoProducto) : double
    private double getPrecioProductos(TipoProducto tipo) {
        double total = 0.0; // acumulador

        // recorremos los productos
        for (ProductoHeladeria item : this.productos) {
            boolean sumar = false; // si decidimos sumar

            if (tipo == TipoProducto.TODOS) {
                sumar = true;
            } else if (tipo == TipoProducto.HELADOS && item instanceof Helado) {
                sumar = true;
            } else if (tipo == TipoProducto.POSTRES && item instanceof Helado) {
                sumar = true;
            }

            if (sumar) {
                total += ((IVendible) item).getPrecioTotal();
            }
        }
        return total;
    }
    
    private double getPrecioDeHelados() {
        return this.getPrecioProductos(TipoProducto.HELADOS);
    }

    private double getPrecioDePostres() {
        return this.getPrecioProductos(TipoProducto.POSTRES);
    }

    private double getPrecioTotal() {
        return this.getPrecioProductos(TipoProducto.TODOS);
    }

    private void ordenarPorNombre() {
        Collections.sort(this.productos);
    }
    
    // toString
    // toString
    @Override
    public String toString() {
        // Esta parte se mantiene igual
        this.ordenarPorNombre();
        
        StringBuilder sb = new StringBuilder();
        sb.append("--- Detalle de la Heladería ---\n");
        sb.append("Capacidad: ").append(this.capacidad).append("\n");
        sb.append("Cantidad de Productos: ").append(this.productos.size()).append("\n\n");
        sb.append("--- Listado de Productos (Ordenados por nombre) ---\n");
        for (ProductoHeladeria p : this.productos) {
            sb.append(p.toString()).append("\n");
        }
        
        // --- SECCIÓN MODIFICADA ---
        // Aquí removemos String.format()
        sb.append("\n--- Totales ---\n");
        sb.append("Precio total de Helados: $").append(this.getPrecioDeHelados()).append("\n");
        sb.append("Precio total de Postres: $").append(this.getPrecioDePostres()).append("\n");
        sb.append("Precio total General: $").append(this.getPrecioTotal()).append("\n");
        
        return sb.toString();
    }
}
