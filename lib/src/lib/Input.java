package lib;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Input extends JFrame {

    private final JPanel    contentPane;
    public final JTextField textField;
    public final JTextField textField_1;
    public final JTextField textField_2;
    public final JTextField textField_3;
    public final JTextField textField_4;
    private final JButton   button;
    public final JLabel     lblNewLabel   = new JLabel();
    public final JLabel     lblNewLabel_1 = new JLabel();
    public final JLabel     label         = new JLabel();
    public final JLabel     label_1       = new JLabel();
    public final JLabel     label_2       = new JLabel();

    /**
     * Create the frame.
     */
    public Input() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 690, 475);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        this.lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        this.lblNewLabel.setBounds(12, 48, 200, 25);
        this.contentPane.add(this.lblNewLabel);

        this.textField = new JTextField();
        this.textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField.setBounds(246, 51, 291, 22);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);
        this.lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        this.lblNewLabel_1.setBounds(12, 100, 200, 25);
        this.contentPane.add(this.lblNewLabel_1);
        this.label.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        this.label.setBounds(12, 149, 200, 25);
        this.contentPane.add(this.label);
        this.label_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        this.label_1.setBounds(12, 197, 200, 25);
        this.contentPane.add(this.label_1);
        this.label_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        this.label_2.setBounds(12, 243, 200, 25);
        this.contentPane.add(this.label_2);

        this.textField_1 = new JTextField();
        this.textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField_1.setBounds(246, 103, 291, 22);
        this.contentPane.add(this.textField_1);
        this.textField_1.setColumns(10);

        this.textField_2 = new JTextField();
        this.textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField_2.setBounds(246, 154, 291, 22);
        this.contentPane.add(this.textField_2);
        this.textField_2.setColumns(10);

        this.textField_3 = new JTextField();
        this.textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField_3.setBounds(246, 200, 291, 22);
        this.contentPane.add(this.textField_3);
        this.textField_3.setColumns(10);

        this.textField_4 = new JTextField();
        this.textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField_4.setBounds(246, 246, 291, 22);
        this.contentPane.add(this.textField_4);
        this.textField_4.setColumns(10);

        final JButton btnNewButton = new JButton("Сохранить");
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    final String url = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=msdb;integratedSecurity=true";
                    final Connection con = DriverManager.getConnection(url);
                    final String q;
                    final PreparedStatement p;
                    switch (Input.this.lblNewLabel_1.getText()) {
                        case "ФИО читателя":
                            q = "insert into Выдача_книги(Код_книги, ФИО_читателя, Код_сотрудника, Дата_выдачи, Дата_возврата)values(?, ?, ?, ?, ?)";
                            p = con.prepareStatement(q);
                            p.setString(1, Input.this.textField.getText());
                            p.setString(2, Input.this.textField_1.getText());
                            p.setString(3, Input.this.textField_2.getText());
                            p.setString(4, Input.this.textField_3.getText());
                            p.setString(5, Input.this.textField_4.getText());
                            p.executeUpdate();
                            Input.this.textField.setText("");
                            Input.this.textField_1.setText("");
                            Input.this.textField_2.setText("");
                            Input.this.textField_3.setText("");
                            Input.this.textField_4.setText("");
                            JOptionPane.showMessageDialog(null, "Insert Successfully");
                            break;
                        case "Код книги":
                            q = "insert into Авторы_книги(ФИО, Код_книги)values(?, ?)";
                            p = con.prepareStatement(q);
                            p.setString(1, Input.this.textField.getText());
                            p.setString(2, Input.this.textField_1.getText());
                            p.executeUpdate();
                            Input.this.textField.setText("");
                            Input.this.textField_1.setText("");
                            JOptionPane.showMessageDialog(null, "Insert Successfully");
                            break;
                        case "Издательство":
                            q = "insert into Книги(Название, Издательство, Год_издания, Жанр, Цена)values(?, ?, ?, ?, ?)";
                            p = con.prepareStatement(q);
                            p.setString(1, Input.this.textField.getText());
                            p.setString(2, Input.this.textField_1.getText());
                            p.setString(3, Input.this.textField_2.getText());
                            p.setString(4, Input.this.textField_3.getText());
                            p.setString(5, Input.this.textField_4.getText());
                            p.executeUpdate();
                            Input.this.textField.setText("");
                            Input.this.textField_1.setText("");
                            Input.this.textField_2.setText("");
                            Input.this.textField_3.setText("");
                            Input.this.textField_4.setText("");
                            JOptionPane.showMessageDialog(null, "Insert Successfully");
                            break;
                        case "Код сотрудника":
                            q = "insert into Мероприятия(Наименование, Код_сотр, Дата_проведения)values(?, ?, ?)";
                            p = con.prepareStatement(q);
                            p.setString(1, Input.this.textField.getText());
                            p.setString(2, Input.this.textField_1.getText());
                            p.setString(3, Input.this.textField_2.getText());
                            p.executeUpdate();
                            Input.this.textField.setText("");
                            Input.this.textField_1.setText("");
                            Input.this.textField_2.setText("");
                            JOptionPane.showMessageDialog(null, "Insert Successfully");
                            break;
                        case "Должность":
                            q = "insert into Сотрудники(ФИО, Должность, Дата_приема, Дата_увольнения) values(?, ?, ?, ?)";
                            p = con.prepareStatement(q);
                            p.setString(1, Input.this.textField.getText());
                            p.setString(2, Input.this.textField_1.getText());
                            p.setString(3, Input.this.textField_2.getText());
                            p.setString(4, Input.this.textField_3.getText());
                            p.executeUpdate();
                            Input.this.textField.setText("");
                            Input.this.textField_1.setText("");
                            Input.this.textField_2.setText("");
                            Input.this.textField_3.setText("");
                            JOptionPane.showMessageDialog(null, "Insert Successfully");
                            break;
                    }

                } catch (final Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        btnNewButton.setBounds(176, 343, 136, 25);
        this.contentPane.add(btnNewButton);

        this.button = new JButton("Отмена");
        this.button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.in.setVisible(false);
            }
        });
        this.button.setBounds(440, 343, 97, 25);
        this.contentPane.add(this.button);
    }

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final Input frame = new Input();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
