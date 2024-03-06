import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginVentana extends JFrame {
    JLabel tituloJLabel;
    JLabel usuarioJLabel;
    JTextField usuarioJTextField;
    JLabel contraseniaJLabel;
    JPasswordField contraseniaJPasswordField;
    JButton iniciarJButton;
    JButton regristrarBJButton;

    public LoginVentana(String Titulo) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 300);
        setLayout(new GridBagLayout());
        createComponentes();

    }

    private void crearComponentes() {
        tituloJLabel = new JLabel("Iniciar Sesión");
        tituloJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usuarioJLabel = new JLabel("Usuario");
        usuarioJTextField = new JTextField(100);
        contraseniaJLabel = new JTextField("Contraseña");
        contraseniaJPasswordField = new JPasswordField();
        iniciarJButton = new JButton("Iniciar");
        regristrarBJButton = new JButton("Registrar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(tituloJLabel, gbc);
    }

}
