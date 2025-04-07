public class Computador extends DispositivoTecnologico {
    private String resolucionPantalla;
    private String tipoTeclado;
    private int bateria; // en mAh

    public Computador(String marca, String modelo, int año, int ram, int almacenamiento, String procesador, int precio, int stock,
                      String resolucionPantalla, String tipoTeclado, int bateria) {
        super(marca, modelo, año, ram, almacenamiento, procesador, precio, stock);
        this.resolucionPantalla = resolucionPantalla;
        this.tipoTeclado = tipoTeclado;
        this.bateria = bateria;
    }

    @Override
    public String getTipo() {
        return "Computador";
    }

    @Override
    public String toString() {
        return super.getResumen() + " | Resolución: " + resolucionPantalla + " | Teclado: " + tipoTeclado + " | Batería: " + bateria + "mAh";
    }

    @Override
    public String toArchivo() {
        return "Computador;" + marca + ";" + modelo + ";" + año + ";" + ram + ";" + almacenamiento + ";" + procesador + ";" + precio + ";" + stock + ";" +
                resolucionPantalla + ";" + tipoTeclado + ";" + bateria;
    }

    public static Computador desdeArchivo(String[] datos) {
        return new Computador(
                datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]),
                datos[6], Integer.parseInt(datos[7]), Integer.parseInt(datos[8]),
                datos[9], datos[10], Integer.parseInt(datos[11])
        );
    }
}
