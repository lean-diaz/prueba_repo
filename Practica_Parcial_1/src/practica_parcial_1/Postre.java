package practica_parcial_1;

public class Postre extends ProductoHeladeria implements IVendible{
    // Atributo privado
    private TipoPostre tipoPostre;

    // Constructor
    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }
    
    public Postre(String nombre, double precio, String nombreFabricante, String paisFabricante, TipoPostre tipo) {
        super(nombre, precio, nombreFabricante, paisFabricante);
        this.tipoPostre = tipo;
    }

    // (+) getPrecioTotal() : double : Método público y de instancia
    @Override
    public double getPrecioTotal() {
        double precioFinal = super.precio;
        
        switch (this.tipoPostre){
            case TORTA_HELADA:
                precioFinal *= 1.30;
                break;
            case COPA_BROWNIE:
                precioFinal *= 1.20;
                break;
            case SUNDAE:
                precioFinal *= 1.10;
                break;
        }
        return precioFinal;
    }
    
    // (+) toString() : String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Postre{");
        sb.append("nombre=").append(this.nombre);
        sb.append(", fabricante=").append(this.fabricante);
        sb.append(", tipoPostre=").append(tipoPostre);
        sb.append(", precioBase=").append(this.precio);
        sb.append(", precioTotal=").append(this.getPrecioTotal());
        sb.append(", puntaje=").append(this.puntaje);
        sb.append('}');
        return sb.toString();
    }
    
    // equals
    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj)){
            return false;
        }
        if (!(obj instanceof Postre)){
            return false;
        }
        Postre otroPostre = (Postre) obj;
        return this.tipoPostre == otroPostre.tipoPostre;
    }
    
}
