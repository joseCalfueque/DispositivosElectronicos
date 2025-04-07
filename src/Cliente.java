public class Cliente {
    private String nombre;
    private String apellido;
    private String correo;
    private String numeroContacto;
    private String estadoCivil;
    private String ciudad;

    public Cliente(String nombre, String apellido, String correo, String numeroContacto, String estadoCivil, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroContacto = numeroContacto;
        this.estadoCivil = estadoCivil;
        this.ciudad = ciudad;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " | Correo: " + correo + " | Contacto: " + numeroContacto + " | Estado Civil: " + estadoCivil + " | Ciudad: " + ciudad;
    }

    public String toArchivo() {
        return nombre + ";" + apellido + ";" + correo + ";" + numeroContacto + ";" + estadoCivil + ";" + ciudad;
    }

    public static Cliente desdeArchivo(String linea) {
        String[] partes = linea.split(";");
        return new Cliente(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5]);
    }
}
