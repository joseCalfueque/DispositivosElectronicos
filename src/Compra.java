import java.time.LocalDate;
import java.util.List;

public class Compra {
    private Cliente cliente;
    private List<DispositivoTecnologico> dispositivos;
    private LocalDate fecha;

    public Compra(Cliente cliente, List<DispositivoTecnologico> dispositivos) {
        this.cliente = cliente;
        this.dispositivos = dispositivos;
        this.fecha = LocalDate.now();
    }

    public String getResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compra realizada por: ").append(cliente.getNombreCompleto()).append(" el ").append(fecha).append("\n");
        for (DispositivoTecnologico d : dispositivos) {
            sb.append(" - ").append(d.getResumen()).append("\n");
        }
        return sb.toString();
    }

    public String toArchivo() {
        StringBuilder sb = new StringBuilder();
        sb.append(cliente.getCorreo()).append(";").append(fecha).append(";");
        for (DispositivoTecnologico d : dispositivos) {
            sb.append(d.getMarca()).append("-").append(d.getModelo()).append(",");
        }
        return sb.toString();
    }

}
