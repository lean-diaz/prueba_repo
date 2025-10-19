package practica_parcial_1;

import java.util.Objects;
import java.util.Random;

public abstract class ProductoHeladeria implements Comparable<ProductoHeladeria>{
    // Atributos protegidos
    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int puntaje;
    protected static Random generadorPuntaje;     

    // Constructores
    public ProductoHeladeria(String nombre, double precio, Fabricante fabricante){
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.puntaje = 0;
    }

    public ProductoHeladeria(String nombre, double precio, String nombreFabricante, String paisFabricante){
        this(nombre, precio, new Fabricante(nombreFabricante, paisFabricante));
    }

    // Bloque estatico para generadorPuntaje
    static{
        generadorPuntaje = new Random();
    }

    // Metodos getters
    public Fabricante getFabricante() {
        return fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static Random getGeneradorPuntaje() {
        return generadorPuntaje;
    }
    
    // + getPuntaje(): int 
    public int getPuntaje(){
        if (this.puntaje == 0){
            this.puntaje = ProductoHeladeria.generadorPuntaje.nextInt(10) + 1;
        }
        return this.puntaje;
    }
    
    // (-) mostrar(ProductoHeladeria): string
    public static String mostrar(ProductoHeladeria p) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(p.nombre).append("\n");
        sb.append("Fabricante: ").append(p.fabricante.getFabricante()).append("\n");
        sb.append("Precio Base: ").append(p.precio).append("\n");
        sb.append("Puntaje: ").append(p.getPuntaje()).append("\n");
        return sb.toString();
    }
    
    // (+) sonIguales(ProductoHeladeria, ProductoHeladeria): boolean
    public boolean sonIguales(ProductoHeladeria p1, ProductoHeladeria p2){
        if (p1 == null || p2 == null){
            return false;
        }
        return p1.equals(p2);
    }
    
    // compareTo()
    @Override
    public int compareTo(ProductoHeladeria otro){
        return this.nombre.compareTo(otro.nombre);
    }
    
    // (+) equals(Object):boolean
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || !(obj instanceof ProductoHeladeria)){
            return false;
        }
        ProductoHeladeria otro = (ProductoHeladeria) obj; // lo casteamos
        return Objects.equals(this.nombre, otro.nombre) && Objects.equals(this.fabricante, otro.fabricante);
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductoHeladeria{");
        sb.append("fabricante=").append(fabricante);
        sb.append(", nombre=").append(nombre);
        sb.append(", puntaje=").append(puntaje);
        sb.append('}');
        return sb.toString();
    }
}
