package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import db.repositorys.EmpleadosRepository;
import db.repositorys.GenerosRepository;
import models.Empleado;
import models.Genero;

public class EmpleadosVentana extends JFrame implements ActionListener {

    Empleado empleado;
    GenerosRepository generosRepository = new GenerosRepository();
    EmpleadosRepository empleadosRepository = new EmpleadosRepository();
    JLabel textLabel;
    JLabel numeroempleadoJLabel;
    JLabel nombreJLabel;
    JLabel domicilioJLabel;
    JLabel telefonoJLabel;
    JLabel emaiJLabel;
    JLabel fechaJLabel;
    JLabel generoJLabel;
    JComboBox<Long> numeroEmpledoJComboBox;
    JTextField nombreJTextField;
    JTextField domicilioJTextField;
    JTextField telefonoJTextField;
    JTextField emailJTextField;
    JDateChooser fechaJDateChooser;
    JComboBox<Genero> generoJComboBox;
    JButton buscarJButton;
    JButton guardarJButton;
    JButton modificarJButton;
    JButton eliminarJButton;
    JButton limpiarJButton;

    public EmpleadosVentana() {
        super("Empleados CRUD");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        crearComponentes();
    }

    private void crearComponentes() {
        this.textLabel = new JLabel("Empleado");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numeroempleadoJLabel = new JLabel("#Empleado");
        nombreJLabel = new JLabel("Nombre");
        domicilioJLabel = new JLabel("Domicilio");
        telefonoJLabel = new JLabel("Telefono");
        emaiJLabel = new JLabel("Email");
        fechaJLabel = new JLabel("Fecha");
        generoJLabel = new JLabel("Genero");
        numeroEmpledoJComboBox = new JComboBox<Long>();
        nombreJTextField = new JTextField();
        domicilioJTextField = new JTextField();
        telefonoJTextField = new JTextField();
        emailJTextField = new JTextField();
        fechaJDateChooser = new JDateChooser();
        generoJComboBox = new JComboBox<>();
        buscarJButton = new JButton("buscar");
        guardarJButton = new JButton("guardar");
        modificarJButton = new JButton("modificar");
        eliminarJButton = new JButton("eliminar");
        limpiarJButton = new JButton("limpiar");
        llenarConboBox();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; /* comulnas */
        gbc.gridy = 0; /* filas */
        gbc.gridwidth = 4; /* Numero de columnas que ocupa */
        gbc.gridheight = 1; /* Numero de filas que ocupa */
        gbc.fill = GridBagConstraints.BOTH;
        add(textLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1; /* Numero de columnas que ocupa */
        add(numeroempleadoJLabel, gbc);

        gbc.gridx = 1; /* !Modifica columna */
        add(numeroEmpledoJComboBox, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2; /* numero de columnas que ocupa */
        buscarJButton.addActionListener(this);
        add(buscarJButton, gbc);
        // hasta aqui todo bien

        gbc.gridx = 0; /* ? Modifica columnas */
        gbc.gridy = 2; /* !Modifica filas */
        add(nombreJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2; /* numero de columnas que ocupa */
        add(nombreJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; /* numero de columnas que ocupa */
        add(domicilioJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(domicilioJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(telefonoJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(telefonoJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(emaiJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(emailJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        add(fechaJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(fechaJDateChooser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        add(generoJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        add(generoJComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        guardarJButton.addActionListener(this);
        add(guardarJButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        modificarJButton.addActionListener(this);
        add(modificarJButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        eliminarJButton.addActionListener(this);
        add(eliminarJButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        limpiarJButton.addActionListener(this);
        add(limpiarJButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guardarJButton) {
            System.out.println("Guardando...");
            empledoGuardar();

        }
        if (e.getSource() == modificarJButton) {
            System.out.println("Modificando...");
            modificandoEmpleado();
        }
        if (e.getSource() == eliminarJButton) {
            System.out.println("Eliminando...");
            empleadoEliminar();

        }
        if (e.getSource() == limpiarJButton) {
            System.out.println("Limpiando...");
            limpiarCampo();
        }
        if (e.getSource() == buscarJButton) {
            System.out.println("Buscando...");
            recuperarEmpleado();
        }
    }


    private void llenarConboBox() {
        List<Genero> generos = generosRepository.recuperarTodos();
        for (Genero genero : generos) {
            generoJComboBox.addItem(genero);
        }
        List<Empleado> empleados = empleadosRepository.recuperarTodos();
        for (Empleado empleado : empleados) {
            numeroEmpledoJComboBox.addItem(empleado.getId());
        }
    }    
    


    private void empledoGuardar() {
        java.util.Date utilDate = fechaJDateChooser.getDate();
        java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
        empleado = new Empleado(
            null,
            nombreJTextField.getText(),
            domicilioJTextField.getText(),
            telefonoJTextField.getText(),
            emailJTextField.getText(),
            fecha,
            generoJComboBox.getItemAt(generoJComboBox.getSelectedIndex())
            );
        empleadosRepository.agregar(empleado);
    }

    private void modificandoEmpleado() {
        java.util.Date utilDate = fechaJDateChooser.getDate();
        java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
        empleado.setNombre(nombreJTextField.getText());
        empleado.setDomicilio(domicilioJTextField.getText());
        empleado.setTelefono(telefonoJTextField.getText());
        empleado.setEmail(emailJTextField.getText());
        empleado.setFechaNacimiento(fecha);
        empleado.setGenero(generoJComboBox.getItemAt(generoJComboBox.getSelectedIndex()));
        empleadosRepository.modificar(empleado);

    }

    private void empleadoEliminar() {
        empleado = empleadosRepository.recuperarId((long)(numeroEmpledoJComboBox.getSelectedItem()));
        empleadosRepository.eliminar(empleado);
    }


    private void recuperarEmpleado() {
       empleado = empleadosRepository.recuperarId((long)(numeroEmpledoJComboBox.getSelectedItem()));
       nombreJTextField.setText(empleado.getNombre());
       domicilioJTextField.setText(empleado.getDomicilio());
       telefonoJTextField.setText(empleado.getTelefono());
       emailJTextField.setText(empleado.getEmail());
       fechaJDateChooser.setDate(empleado.getFechaNacimiento());
       generoJComboBox.setSelectedIndex(compararGenero(empleado.getGenero()));
    }


    private int compararGenero(Genero genero) {
       
        for (int i = 0; i < generoJComboBox.getItemCount(); i++) {
            if(genero.getNombre().equals( generoJComboBox.getItemAt(i).getNombre())){
                return i;
            }
        }
        return -1;
    }


    private void limpiarCampo() {
        empleado = null;
        nombreJTextField.setText("");
        domicilioJTextField.setText("");
        telefonoJTextField.setText("");
        emailJTextField.setText("");
        fechaJDateChooser.setDate(null);
        numeroEmpledoJComboBox.removeAllItems();
        generoJComboBox.removeAllItems();
    }

    //private Empleado dameEmpleado() {
    //    Long l = (Long) (generoJComboBox.getSelectedItem());
    //    Genero genero = generosRepository.recuperarId(l);
    //    java.util.Date utilDate = fechaJDateChooser.getDate();
    //    java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
    //    Empleado empleado = new Empleado(
    //            null,
    //            nombreJTextField.getText(),
    //            domicilioJTextField.getText(),
    //            telefonoJTextField.getText(),
    //            emailJTextField.getText(),
    //            fecha,
    //            genero);
    //    return empleado;
    //}

}
