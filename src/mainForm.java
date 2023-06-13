import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;

    private Menu menu;

    public mainForm() {
        menu = new Menu();

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textIngresoNombre.getText();
                double precio = Double.parseDouble(textIngresoPrecio.getText());
                int calorias = Integer.parseInt(textIngresoCalorias.getText());
                int tiempoPreparacion = Integer.parseInt(textIngresoPreparacion.getText());

                Plato plato = new Plato(nombre, precio, calorias, tiempoPreparacion);
                menu.agregarPlato(plato);

                textAIngresoPlatos.append("Plato ingresado: " + plato.getNombre() + "\n"+plato.getPrecio() + "\n"+plato.getCalorias() + "\n"+plato.getTiempoPreparacion() + "\n");
            }
        });

        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agregar datos de prueba
                menu.agregarPlato(new Plato("Cuy", 12.0, 800, 30));
                menu.agregarPlato(new Plato("Hamburguesa", 8.0, 600, 20));
                menu.agregarPlato(new Plato("Fritada", 6.0, 300, 15));
                menu.agregarPlato(new Plato("Pasta", 10.0, 700, 25));

                textAIngresoPlatos.setText(""); // Limpiar el campo de texto antes de mostrar los platos

                for (Plato plato : menu.getPlatos()) {
                    String platoInfo = plato.getNombre() + ", Precio: " + plato.getPrecio() + ", Calorías: " + plato.getCalorias() + ", Tiempo de preparación: " + plato.getTiempoPreparacion() + "\n";
                    textAIngresoPlatos.append(platoInfo);
                }
            }
        });

        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textoModifNombre.getText();
                Plato plato = menu.buscarPlato(nombre);

                if (plato != null) {
                    textoModifPrecio.setText(String.valueOf(plato.getPrecio()));
                    textoModifCalorias.setText(String.valueOf(plato.getCalorias()));
                    textoModifPreparacion.setText(String.valueOf(plato.getTiempoPreparacion()));
                    textoModifPrecio.setEditable(true);
                    textoModifCalorias.setEditable(true);
                    textoModifPreparacion.setEditable(true);

                } else {
                    textAModif.append("Plato no encontrado.\n");
                }
            }
        });

        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textoModifNombre.getText();
                Plato plato = menu.buscarPlato(nombre);

                if (plato != null) {
                    plato.setPrecio(Double.parseDouble(textoModifPrecio.getText()));
                    plato.setCalorias(Integer.parseInt(textoModifCalorias.getText()));
                    plato.setTiempoPreparacion(Integer.parseInt(textoModifPreparacion.getText()));

                    textAModif.append("Plato modificado: " + plato.getNombre() + "\n"+ "\n"+plato.getPrecio() + "\n"+plato.getCalorias() + "\n"+plato.getTiempoPreparacion() + "\n");
                } else {
                    textAModif.append("Plato no encontrado.\n");
                }
            }
        });

        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textNombreEliminar.getText();
                Plato plato = menu.buscarPlato(nombre);

                if (plato != null) {
                    textAEliminar.setText("Nombre: " + plato.getNombre() + "\n" +
                            "Precio: " + plato.getPrecio() + "\n" +
                            "Calorias: " + plato.getCalorias() + "\n" +
                            "Tiempo de preparación: " + plato.getTiempoPreparacion() + "\n");
                } else {
                    textAEliminar.setText("Plato no encontrado.\n");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textNombreEliminar.getText();
                menu.eliminarPlato(nombre);
                textAEliminar.setText("Plato eliminado: " + nombre + "\n");
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orden = (String) comboBoxOrder.getSelectedItem();
                List<Plato> platos = menu.getPlatos();

                switch (orden) {
                    case "Nombre":
                        Ordenamiento.ordenarPorNombre(platos);
                        break;
                    case "Precio":
                        Ordenamiento.ordenarPorPrecio(platos);
                        break;
                    case "Calorias":
                        Ordenamiento.ordenarPorCalorias(platos);
                        break;
                    case "Tiempo de preparación":
                        Ordenamiento.ordenarPorTiempoPreparacion(platos);
                        break;
                }

                textAMostrar.setText("");
                for (Plato plato : platos) {
                    textAMostrar.append("Nombre: " + plato.getNombre() + "\n" +
                            "Precio: " + plato.getPrecio() + "\n" +
                            "Calorias: " + plato.getCalorias() + "\n" +
                            "Tiempo de preparación: " + plato.getTiempoPreparacion() + "\n\n");
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textBuscarPlatoOrden.getText();
                Plato plato = menu.buscarPlato(nombre);

                if (plato != null) {
                    textAMostrar.setText("Nombre: " + plato.getNombre() + "\n" +
                            "Precio: " + plato.getPrecio() + "\n" +
                            "Calorias: " + plato.getCalorias() + "\n" +
                            "Tiempo de preparación: " + plato.getTiempoPreparacion() + "\n");
                } else {
                    textAMostrar.setText("Plato no encontrado.\n");
                }
            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}




