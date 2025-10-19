package practica_parcial_1;

public class Helado extends ProductoHeladeria implements IVendible{
    // Atributos privados
    private SaborHelado sabor;
    private CategoriaHelado categoriaHelado;
    
    public Helado(String nombre, double precio, Fabricante fabricante, CategoriaHelado categoriaHelado, SaborHelado sabor) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.categoriaHelado = categoriaHelado;
    }

    // (+) getPrecioTotal() : double : Método público y de instancia
    @Override
    public double getPrecioTotal() {
        double precioFinal = super.precio;
        
        switch (this.categoriaHelado){
            case CLASICO:
                precioFinal *= 1.05;
                break;
            case GOURMET:
                precioFinal *= 1.20;
                break;
            case VEGANO:
                precioFinal *= 1.10;
                break;
        }
        return precioFinal;
    }
    
    // (+) toString() : String 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Helado{");
        sb.append("nombre=").append(this.nombre);
        sb.append(", fabricante=").append(this.fabricante);
        sb.append(", sabor=").append(this.sabor);
        sb.append(", categoriaHelado=").append(this.categoriaHelado);
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
        if (!(obj instanceof Helado)){
            return false;
        }
        Helado otroHelado = (Helado) obj;
        return this.sabor == otroHelado.sabor;
    }
}
