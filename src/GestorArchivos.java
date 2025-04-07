import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class GestorArchivos {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void guardarLista(String nombreArchivo, List<T> lista) {
        try (Writer writer = new FileWriter(nombreArchivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar archivo: " + e.getMessage());
        }
    }

    public static <T> List<T> cargarLista(String nombreArchivo, Type tipoLista) {
        try (Reader reader = new FileReader(nombreArchivo)) {
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            System.out.println("⚠️ No se pudo leer el archivo: " + nombreArchivo);
            return null;
        }
    }
}
