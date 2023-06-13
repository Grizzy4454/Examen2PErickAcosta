import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordenamiento {

    public static void ordenarPorNombre(List<Plato> platos) {
        Collections.sort(platos, Comparator.comparing(Plato::getNombre));
    }

    public static void ordenarPorPrecio(List<Plato> platos) {
        Collections.sort(platos, Comparator.comparing(Plato::getPrecio));
    }

    public static void ordenarPorCalorias(List<Plato> platos) {
        Collections.sort(platos, Comparator.comparing(Plato::getCalorias));
    }

    public static void ordenarPorTiempoPreparacion(List<Plato> platos) {
        Collections.sort(platos, Comparator.comparing(Plato::getTiempoPreparacion));
    }
}
