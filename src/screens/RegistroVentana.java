package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;


import db.repositorys.LoginRepository;
import models.Empleado;
import models.Login;




public class RegistroVentana extends JFrame implements ActionListener{

    Empleado empleado;
    LoginRepository loginRepository;
    boolean mostrando;
    JLabel textLabel;
    JLabel nombreJLabel;
    JLabel  emaiJLabel;
    JLabel  usuarioJLabel;
    JLabel contraseniaJLabel;
    JTextField  nombreJTextField;     
    JTextField  emailJTextField;
    JTextField  usuarioJTextField;
    JPasswordField contraseniaJPasswordField;
    JRadioButton mostrarJRadioButton;
    JButton registrarJButton;


    public RegistroVentana(){
        super("Empleados CRUD");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        crearComponentes();
    }

    private void crearComponentes() {
        this.textLabel = new JLabel("Registrate");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreJLabel = new JLabel("Nombe");
        emaiJLabel = new JLabel("Email");
        usuarioJLabel = new JLabel("Usuario");
        contraseniaJLabel = new JLabel("Contraseña");   
        mostrarJRadioButton = new JRadioButton();
        nombreJTextField = new JTextField();
        emailJTextField = new JTextField();
        usuarioJTextField = new JTextField();
        contraseniaJPasswordField = new JPasswordField();
        registrarJButton = new JButton("Registrarte");


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets (10, 10, 10, 10);
        gbc.gridx = 0;    
        gbc.gridy = 0;
        gbc.gridwidth = 4; 
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(textLabel, gbc);


        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(nombreJLabel, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(emaiJLabel, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        add(usuarioJLabel, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        add(contraseniaJLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(nombreJTextField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(emailJTextField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(usuarioJTextField, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(mostrarJRadioButton, gbc);
        mostrarJRadioButton.addActionListener(this);

        gbc.gridy = 4;
        gbc.gridx = 2;
        gbc.gridwidth = 3;
        add(contraseniaJPasswordField, gbc);

        gbc.gridy = 5;
        gbc.gridx = 2;
        gbc.gridwidth = 2;
        add(registrarJButton, gbc);
        registrarJButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mostrarJRadioButton) {
            System.out.println("Mostrando Contraseña...");
            mostrarContraseña();
        }
        if (e.getSource() == registrarJButton) {
            System.out.println("Registrandote...");
            registrarUsuario();
        }
    }
    

    private void registrarUsuario() {
        char pwd[] = contraseniaJPasswordField.getPassword();
        String contraseña = String.valueOf(pwd);
        Login login = new Login(
            null,
            nombreJTextField.getText(),
            emailJTextField.getText(),
            usuarioJTextField.getText(),
            contraseña);
        loginRepository.agregar(login);

    }

    private void mostrarContraseña(){
    contraseniaJPasswordField.setEchoChar(mostrarJRadioButton.isSelected() ? '\0' :'*');
        
    
    }
    

}
