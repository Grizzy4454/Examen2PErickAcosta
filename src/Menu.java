import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu {
    private List<Plato> platos;

    public Menu() {
        platos = new ArrayList<>();
    }

    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public void eliminarPlato(String nombre) {
        platos.removeIf(plato -> plato.getNombre().equals(nombre));
    }

    public Plato buscarPlato(String nombre) {
        for (Plato plato : platos) {
            if (plato.getNombre().equals(nombre)) {
                return plato;
            }
        }
        return null;
    }

    public List<Plato> getPlatos() {
        return platos;
    }
}

