public class Plato {
    private String nombre;
    private double precio;
    private int calorias;
    private int tiempoPreparacion;

    public Plato(String nombre, double precio, int calorias, int tiempoPreparacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
}


