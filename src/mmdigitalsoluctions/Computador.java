import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Computador {

    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Registar Computador");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        
        JLabel userLabel = new JLabel("Nome:");
        userLabel.setBounds(10, 20, 120, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(140, 20, 150, 25);
        frame.add(userText);

        JLabel emailLabel = new JLabel("Marca:");
        emailLabel.setBounds(10, 50, 120, 25);
        frame.add(emailLabel);

        JTextField emailText = new JTextField();
        emailText.setBounds(140, 50, 150, 25);
        frame.add(emailText);

        JLabel passwordLabel = new JLabel("Preco:");
        passwordLabel.setBounds(10, 80, 120, 25);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(140, 80, 150, 25);
        frame.add(passwordField);

        JButton registerButton = new JButton("Registrar");
        registerButton.setBounds(100, 120, 100, 25);
        frame.add(registerButton);


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String email = emailText.getText();
                String password = new String(passwordField.getPassword());
  String sql = "INSERT INTO Electronico (nome, marca, preco, tipo, atributos_especificos) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = ConexaoMySQl.obterConexao().prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "salvo");
        } catch (SQLException e) {
            System.out.println(e);
        }
               
                JOptionPane.showMessageDialog(frame, "Registrado com sucesso!");
            }
        });

        
        frame.setVisible(true);
    }
}
