import java.util.ArrayList;
import java.util.List;

public class TiendaTecnologica{
    private String direccion;
    private List<Cliente> clientes;
    private List<DispositivoTecnologico> dispositivos;
    private List<Compra> compras;

    public TiendaTecnologica(String direccion) {
        this.direccion = direccion;
        this.clientes = new ArrayList<>();
        this.dispositivos = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    public void cambiarDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarDispositivo(DispositivoTecnologico dispositivo) {
        dispositivos.add(dispositivo);
    }

    public Cliente buscarClientePorCorreo(String correo) {
        for (Cliente c : clientes) {
            if (c.getCorreo().equalsIgnoreCase(correo)) return c;
        }
        return null;
    }

    public List<DispositivoTecnologico> buscarPorMarca(String marca) {
        List<DispositivoTecnologico> resultado = new ArrayList<>();
        for (DispositivoTecnologico d : dispositivos) {
            if (d.getMarca().equalsIgnoreCase(marca)) {
                resultado.add(d);
            }
        }
        return resultado;
    }

    public List<DispositivoTecnologico> buscarPorModelo(String modelo) {
        List<DispositivoTecnologico> resultado = new ArrayList<>();
        for (DispositivoTecnologico d : dispositivos) {
            if (d.getModelo().equalsIgnoreCase(modelo)) {
                resultado.add(d);
            }
        }
        return resultado;
    }

    public List<DispositivoTecnologico> buscarPorTipo(String tipo) {
        List<DispositivoTecnologico> resultado = new ArrayList<>();
        for (DispositivoTecnologico d : dispositivos) {
            if (d.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(d);
            }
        }
        return resultado;
    }

    public void realizarCompra(String correoCliente, List<DispositivoTecnologico> dispositivosSeleccionados) {
        Cliente cliente = buscarClientePorCorreo(correoCliente);
        if (cliente != null && !dispositivosSeleccionados.isEmpty()) {
            for (DispositivoTecnologico d : dispositivosSeleccionados) {
                d.reducirStock(1);
            }
            Compra compra = new Compra(cliente, dispositivosSeleccionados);
            compras.add(compra);
            System.out.println("✅ Compra realizada con éxito:\n" + compra.getResumen());
        } else {
            System.out.println("❌ Compra no realizada. Verifica los datos.");
        }
    }

    public void mostrarDispositivos() {
        for (DispositivoTecnologico d : dispositivos) {
            System.out.println(d.toString());
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Cliente> getClientes() { return clientes; }
    public List<DispositivoTecnologico> getDispositivos() { return dispositivos; }
    public List<Compra> getCompras() { return compras; }

    public void realizarCompraInterna(Compra compra) {
        this.compras.add(compra); //solo para cargar compras anteriores
    }


}
