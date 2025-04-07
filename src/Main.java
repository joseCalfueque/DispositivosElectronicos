import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TiendaTecnologica tienda = new TiendaTecnologica("Temuco");

        Type tipoCliente = new TypeToken<List<Cliente>>() {}.getType();
        Type tipoDispositivo = new TypeToken<List<DispositivoTecnologico>>() {}.getType();
        Type tipoCompra = new TypeToken<List<Compra>>() {}.getType();

        List<Cliente> clientes = GestorArchivos.cargarLista("clientes.json", tipoCliente);
        List<DispositivoTecnologico> dispositivos = GestorArchivos.cargarLista("dispositivos.json", tipoDispositivo);
        List<Compra> compras = GestorArchivos.cargarLista("compras.json", tipoCompra);


        if (clientes != null) clientes.forEach(tienda::agregarCliente);
        if (dispositivos != null) dispositivos.forEach(tienda::agregarDispositivo);
        if (compras != null) compras.forEach(tienda::realizarCompraInterna); // método para cargar las compras ya hechas
        while (true) {
            System.out.println("\n===== MENÚ TIENDA TECNOLÓGICA =====");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar dispositivo");
            System.out.println("3. Mostrar dispositivos");
            System.out.println("4. Buscar dispositivo por marca/modelo/tipo");
            System.out.println("5. Realizar compra");
            System.out.println("6. Cambiar dirección de la tienda");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Estado civil: ");
                    String estadoCivil = sc.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudad = sc.nextLine();

                    tienda.agregarCliente(new Cliente(nombre, apellido, correo, telefono, estadoCivil, ciudad));
                    System.out.println("✅ Cliente agregado.");
                }

                case 2 -> {
                    System.out.println("Seleccione tipo: 1) Computador 2) Computador de escritorio 3) Tablet");
                    int tipo = Integer.parseInt(sc.nextLine());

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Año: ");
                    int año = Integer.parseInt(sc.nextLine());
                    System.out.print("RAM (GB): ");
                    int ram = Integer.parseInt(sc.nextLine());
                    System.out.print("Almacenamiento (GB): ");
                    int almacenamiento = Integer.parseInt(sc.nextLine());
                    System.out.print("Procesador: ");
                    String procesador = sc.nextLine();
                    System.out.print("Precio: ");
                    int precio = Integer.parseInt(sc.nextLine());
                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    if (tipo == 1) {
                        System.out.print("Resolución de pantalla: ");
                        String resolucion = sc.nextLine();
                        System.out.print("Tipo de teclado: ");
                        String teclado = sc.nextLine();
                        System.out.print("Batería (mAh): ");
                        int bateria = Integer.parseInt(sc.nextLine());

                        tienda.agregarDispositivo(new Computador(marca, modelo, año, ram, almacenamiento, procesador, precio, stock, resolucion, teclado, bateria));
                        System.out.println("✅ Computador agregado.");
                    } else if (tipo == 2) {
                        System.out.print("Tarjeta de video: ");
                        String tarjeta = sc.nextLine();
                        System.out.print("Fuente de poder: ");
                        String fuente = sc.nextLine();
                        System.out.print("Chasis: ");
                        String chasis = sc.nextLine();
                        System.out.print("Pantalla - Marca: ");
                        String marcaPantalla = sc.nextLine();
                        System.out.print("Pantalla - Modelo: ");
                        String modeloPantalla = sc.nextLine();
                        System.out.print("Pantalla - Año: ");
                        int añoPantalla = Integer.parseInt(sc.nextLine());

                        Pantalla pantalla = new Pantalla(marcaPantalla, modeloPantalla, añoPantalla);
                        tienda.agregarDispositivo(new ComputadorEscritorio(marca, modelo, año, ram, almacenamiento, procesador, precio, stock, tarjeta, fuente, chasis, pantalla));
                        System.out.println("✅ Computador de escritorio agregado.");
                    } else if (tipo == 3) {
                        System.out.print("Resolución de pantalla: ");
                        String resolucion = sc.nextLine();
                        System.out.print("Accesorios (separados por coma): ");
                        List<String> accesorios = Arrays.asList(sc.nextLine().split(","));

                        tienda.agregarDispositivo(new Tablet(marca, modelo, año, ram, almacenamiento, procesador, precio, stock, resolucion, accesorios));
                        System.out.println("✅ Tablet agregada.");
                    }
                }

                case 3 -> {
                    System.out.println("===== Dispositivos en tienda =====");
                    tienda.mostrarDispositivos();
                }

                case 4 -> {
                    System.out.println("Buscar por: 1) Marca 2) Modelo 3) Tipo");
                    int criterio = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese valor: ");
                    String valor = sc.nextLine();
                    List<DispositivoTecnologico> resultado = switch (criterio) {
                        case 1 -> tienda.buscarPorMarca(valor);
                        case 2 -> tienda.buscarPorModelo(valor);
                        case 3 -> tienda.buscarPorTipo(valor);
                        default -> new ArrayList<>();
                    };

                    if (resultado.isEmpty()) {
                        System.out.println("❌ No se encontraron dispositivos.");
                    } else {
                        resultado.forEach(System.out::println);
                    }
                }

                case 5 -> {
                    System.out.print("Correo del cliente: ");
                    String correo = sc.nextLine();

                    List<DispositivoTecnologico> carrito = new ArrayList<>();
                    while (true) {
                        System.out.print("Agregar dispositivo al carrito (marca o 'fin' para terminar): ");
                        String marcaBuscar = sc.nextLine();
                        if (marcaBuscar.equalsIgnoreCase("fin")) break;

                        List<DispositivoTecnologico> encontrados = tienda.buscarPorMarca(marcaBuscar);
                        if (encontrados.isEmpty()) {
                            System.out.println("❌ No encontrado.");
                        } else {
                            DispositivoTecnologico d = encontrados.get(0);
                            carrito.add(d);
                            System.out.println("✅ Agregado al carrito: " + d.getResumen());
                        }
                    }

                    tienda.realizarCompra(correo, carrito);
                }

                case 6 -> {
                    System.out.print("Nueva dirección: ");
                    String nuevaDir = sc.nextLine();
                    tienda.cambiarDireccion(nuevaDir);
                    System.out.println("✅ Dirección actualizada.");
                }

                case 0 -> {
                    System.out.println("👋 Saliendo del programa...");
                    return;
                }

                default -> System.out.println("❌ Opción inválida.");
            }
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                GestorArchivos.guardarLista("clientes.json", tienda.getClientes());
                GestorArchivos.guardarLista("dispositivos.json", tienda.getDispositivos());
                GestorArchivos.guardarLista("compras.json", tienda.getCompras());
                System.out.println("💾 Datos guardados correctamente.");
            }));
        }

    }
}
