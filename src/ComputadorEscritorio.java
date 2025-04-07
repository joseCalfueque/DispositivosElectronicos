public class ComputadorEscritorio extends DispositivoTecnologico {
    private String tarjetaVideo;
    private String fuentePoder;
    private String chasis;
    private Pantalla pantalla;

    public ComputadorEscritorio(String marca, String modelo, int año, int ram, int almacenamiento, String procesador,
                                int precio, int stock, String tarjetaVideo, String fuentePoder, String chasis, Pantalla pantalla) {
        super(marca, modelo, año, ram, almacenamiento, procesador, precio, stock);
        this.tarjetaVideo = tarjetaVideo;
        this.fuentePoder = fuentePoder;
        this.chasis = chasis;
        this.pantalla = pantalla;
    }

    @Override
    public String getTipo() {
        return "ComputadorEscritorio";
    }

    @Override
    public String toString() {
        return super.getResumen() + " | Video: " + tarjetaVideo + " | Fuente: " + fuentePoder + " | Chasis: " + chasis + " | Pantalla: " + pantalla;
    }

    @Override
    public String toArchivo() {
        return "ComputadorEscritorio;" + marca + ";" + modelo + ";" + año + ";" + ram + ";" + almacenamiento + ";" + procesador + ";" +
                precio + ";" + stock + ";" + tarjetaVideo + ";" + fuentePoder + ";" + chasis + ";" +
                pantalla.toArchivo(); // añade marca, modelo y año de pantalla
    }

    public static ComputadorEscritorio desdeArchivo(String[] datos) {
        Pantalla p = Pantalla.desdeArchivo(datos[12], datos[13], datos[14]);
        return new ComputadorEscritorio(
                datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]),
                datos[6], Integer.parseInt(datos[7]), Integer.parseInt(datos[8]),
                datos[9], datos[10], datos[11], p
        );
    }
}
