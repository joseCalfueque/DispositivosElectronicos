public abstract class DispositivoTecnologico {
    protected String marca;
    protected String modelo;
    protected int año;
    protected int ram;
    protected int almacenamiento;
    protected String procesador;
    protected int precio;
    protected int stock;

    public DispositivoTecnologico(String marca, String modelo, int año, int ram, int almacenamiento, String procesador, int precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.procesador = procesador;
        this.precio = precio;
        this.stock = stock;
    }

    public abstract String getTipo();

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getStock() {
        return stock;
    }

    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    public String getResumen() {
        return "[" + getTipo() + "] " + marca + " " + modelo + " - Precio: $" + precio + " - Stock: " + stock;
    }

    public abstract String toArchivo();

    public static DispositivoTecnologico desdeArchivo(String linea) {
        String[] partes = linea.split(";");
        String tipo = partes[0];
        switch (tipo) {
            case "Computador":
                return Computador.desdeArchivo(partes);
            case "ComputadorEscritorio":
                return ComputadorEscritorio.desdeArchivo(partes);
            case "Tablet":
                return Tablet.desdeArchivo(partes);
            default:
                return null;
        }
    }
}
