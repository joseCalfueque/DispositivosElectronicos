public class Pantalla {
    private String marca;
    private String modelo;
    private int año;

    public Pantalla(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + año + ")";
    }

    public String toArchivo() {
        return marca + ";" + modelo + ";" + año;
    }

    public static Pantalla desdeArchivo(String marca, String modelo, String año) {
        return new Pantalla(marca, modelo, Integer.parseInt(año));
    }
}
