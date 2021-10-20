package zarplata;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignIn extends JFrame {

    private final JPanel         contentPane;
    private final JTextField     textField;
    private final JPasswordField passwordField;

    public SignIn() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 358, 203);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        final JLabel lblNewLabel = new JLabel("Логин");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblNewLabel.setBounds(12, 26, 86, 22);
        this.contentPane.add(lblNewLabel);

        final JLabel lblNewLabel_1 = new JLabel("Пароль");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(12, 70, 86, 22);
        this.contentPane.add(lblNewLabel_1);

        this.textField = new JTextField();
        this.textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField.setBounds(110, 22, 218, 31);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);

        this.passwordField = new JPasswordField();
        this.passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.passwordField.setBounds(110, 66, 218, 31);
        this.contentPane.add(this.passwordField);

        final JButton btnNewButton = new JButton("Войти");
        btnNewButton.addActionListener(arg0 -> {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// user admin
                                                                              // accountant
                final Connection con = DriverManager.getConnection(
                        "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=master;integratedSecurity=true");
                final String q = "select Роль, ID_сотр from Пользователи where Логин = '"
                        + this.textField.getText() + "' and Пароль = '"
                        + new String(this.passwordField.getPassword()) + "'";
                final Statement st = con.createStatement();
                final ResultSet rs = st.executeQuery(q);
                if (rs.next()) {
                    final String[] res = new String[2];
                    res[0] = rs.getString("Роль");
                    res[1] = rs.getString("ID_сотр");
                    Menu.main(res);
                    Menu.signIn = this;
                    this.setVisible(false);
                    this.textField.setText("");
                    this.passwordField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Неправильный логин или пароль");
                }
            } catch (final Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        });
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnNewButton.setBounds(93, 112, 127, 31);
        this.contentPane.add(btnNewButton);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final SignIn frame = new SignIn();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
