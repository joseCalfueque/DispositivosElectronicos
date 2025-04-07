import java.util.Arrays;
import java.util.List;

public class Tablet extends DispositivoTecnologico {
    private String resolucionPantalla;
    private List<String> accesorios;

    public Tablet(String marca, String modelo, int año, int ram, int almacenamiento, String procesador,
                  int precio, int stock, String resolucionPantalla, List<String> accesorios) {
        super(marca, modelo, año, ram, almacenamiento, procesador, precio, stock);
        this.resolucionPantalla = resolucionPantalla;
        this.accesorios = accesorios;
    }

    @Override
    public String getTipo() {
        return "Tablet";
    }

    @Override
    public String toString() {
        return super.getResumen() + " | Resolución: " + resolucionPantalla + " | Accesorios: " + String.join(", ", accesorios);
    }

    @Override
    public String toArchivo() {
        return "Tablet;" + marca + ";" + modelo + ";" + año + ";" + ram + ";" + almacenamiento + ";" + procesador + ";" +
                precio + ";" + stock + ";" + resolucionPantalla + ";" + String.join("-", accesorios);
    }

    public static Tablet desdeArchivo(String[] datos) {
        List<String> accesorios = Arrays.asList(datos[10].split("-"));
        return new Tablet(
                datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]),
                Integer.parseInt(datos[5]), datos[6], Integer.parseInt(datos[7]), Integer.parseInt(datos[8]),
                datos[9], accesorios
        );
    }
}
