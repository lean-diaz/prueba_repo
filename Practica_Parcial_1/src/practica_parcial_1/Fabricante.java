package practica_parcial_1;

public class Fabricante {
    // Atributos privados
    private String nombre;
    private String pais;
    
    // Constructor
    public Fabricante(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    
    // Metodos
    public boolean sonIguales(Fabricante f1, Fabricante f2){
        return f1.equals(f2);
    }
    
    public boolean equals(Object obj){
        // Comparamos referencias
        if (this == obj){
            return true;
        }
        
        //si obj es nulo && comparamos que ambas instancias sean iguales
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        
        // Casteamos obj por Fabricante
        Fabricante otro = (Fabricante) obj; 
        // Comparamos
        return this.nombre.equals(otro.nombre) && this.pais.equals(otro.pais);
    }
    
    public String getFabricante(){
        return this.nombre + " - " + this.pais;
    }
}
