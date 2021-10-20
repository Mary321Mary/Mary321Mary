package lib;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Queries extends JFrame {

    private final JPanel    contentPane;
    public final JTextField textField;
    private final JTable    table;
    final JTextPane         textPane = new JTextPane();

    /**
     * Create the frame.
     */
    public Queries() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 798, 511);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.textField = new JTextField();
        this.textField.setBounds(12, 45, 340, 22);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);

        final JComboBox comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                switch (comboBox.getSelectedIndex()) {
                    case 0:
                        Queries.this.textPane
                                .setText("Выдать список книг, выданных заданным сотрудником");
                        break;
                    case 1:
                        Queries.this.textPane
                                .setText("Выдать список книг, выданных заданным издательством");
                        break;
                    case 2:
                        Queries.this.textPane
                                .setText("Выдать список книг, выданных заданному читателю");
                        break;
                    case 3:
                        Queries.this.textPane.setText(
                                "Выдать список читателей с указанием количества выданных книг и их общей стоимости");
                        break;
                    case 4:
                        Queries.this.textPane
                                .setText("Выдать список книг, не выданных ни одному читателю");
                        break;
                    case 5:
                        Queries.this.textPane.setText(
                                "Выдать список мероприятий, проведенных заданным сотрудником");
                        break;
                    case 6:
                        Queries.this.textPane
                                .setText("Выдать список книг, выданных в заданном году");
                        break;
                    case 7:
                        Queries.this.textPane
                                .setText("Выдать список сотрудников, не проводивших мероприятия");
                        break;
                }
            }
        });
        comboBox.setModel(
                new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
        comboBox.setToolTipText("");
        comboBox.setBounds(263, 80, 89, 22);
        this.contentPane.add(comboBox);

        this.textPane.setEnabled(false);
        this.textPane.setText("Выдать список книг, выданных заданным сотрудником");
        this.textPane.setBounds(376, 13, 392, 97);
        this.contentPane.add(this.textPane);

        this.table = new JTable();
        this.table.setBounds(12, 133, 756, 318);
        this.contentPane.add(this.table);

        final JButton btnNewButton = new JButton("Закрыть");
        btnNewButton.addActionListener(arg0 -> {
            Menu.queries.setVisible(false);
        });
        btnNewButton.setBounds(12, 79, 97, 25);
        this.contentPane.add(btnNewButton);

        final JButton button = new JButton("Выполнить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    final String url = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=msdb;integratedSecurity=true";
                    final Connection con = DriverManager.getConnection(url);
                    final String value = Queries.this.textField.getText();
                    String q;
                    final Statement st;
                    final ResultSet rs;
                    final DefaultTableModel m = (DefaultTableModel) Queries.this.table.getModel();
                    m.setRowCount(0);
                    m.setColumnCount(0);
                    switch (comboBox.getSelectedIndex()) {
                        case 0:
                            q = "select Название from Книги, Сотрудники, Выдача_книги where Сотрудники.Код = Выдача_книги.Код_сотрудника and Выдача_книги.Код_книги = Книги.Код and ФИО = '"
                                    + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Название");
                            final Object[] row0 = new Object[1];
                            row0[0] = "Название";
                            m.addRow(row0);
                            while (rs.next()) {
                                row0[0] = rs.getString("Название");
                                m.addRow(row0);
                            }
                            break;
                        case 1:
                            q = "select Название from Книги where Издательство = '" + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Название");
                            final Object[] row1 = new Object[1];
                            row1[0] = "Название";
                            m.addRow(row1);
                            while (rs.next()) {
                                row1[0] = rs.getString("Название");
                                m.addRow(row1);
                            }
                            break;
                        case 2:
                            q = "select Название from Книги, Выдача_книги where Выдача_книги.Код_книги = Книги.Код and ФИО_читателя = '"
                                    + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Название");
                            final Object[] row2 = new Object[1];
                            row2[0] = "Название";
                            m.addRow(row2);
                            while (rs.next()) {
                                row2[0] = rs.getString("Название");
                                m.addRow(row2);
                            }
                            break;
                        case 3:
                            q = "select ФИО_читателя, count(ФИО_читателя) [Кол-во книг], sum(Цена) [Стоимость книг] from Книги, Выдача_книги where Выдача_книги.Код_книги = Книги.Код group by ФИО_читателя";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("ФИО_читателя");
                            m.addColumn("Кол-во книг");
                            m.addColumn("Стоимость книг");
                            final Object[] row3 = new Object[3];
                            row3[0] = "ФИО_читателя";
                            row3[1] = "Кол-во книг";
                            row3[2] = "Стоимость книг";
                            m.addRow(row3);
                            while (rs.next()) {
                                row3[0] = rs.getString("ФИО_читателя");
                                row3[1] = rs.getInt("Кол-во книг");
                                row3[2] = rs.getInt("Стоимость книг");
                                m.addRow(row3);
                            }
                            break;
                        case 4:
                            q = "select distinct Название, Издательство, Год_издания, Жанр, Цена from Книги where Книги.Код not in (select Код_книги from Выдача_книги)";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Название");
                            m.addColumn("Издательство");
                            m.addColumn("Год_издания");
                            m.addColumn("Жанр");
                            m.addColumn("Цена");
                            final Object[] row4 = new Object[5];
                            row4[0] = "Название";
                            row4[1] = "Издательство";
                            row4[2] = "Год_издания";
                            row4[3] = "Жанр";
                            row4[4] = "Цена";
                            m.addRow(row4);
                            while (rs.next()) {
                                row4[0] = rs.getString("Название");
                                row4[1] = rs.getString("Издательство");
                                row4[2] = rs.getInt("Год_издания");
                                row4[3] = rs.getString("Жанр");
                                row4[4] = rs.getInt("Цена");
                                m.addRow(row4);
                            }
                            break;
                        case 5:
                            q = "select Наименование from Сотрудники, Мероприятия where Сотрудники.Код =  Мероприятия.Код_сотр and ФИО = '"
                                    + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Наименование");
                            final Object[] row5 = new Object[1];
                            row5[0] = "Наименование";
                            m.addRow(row5);
                            while (rs.next()) {
                                row5[0] = rs.getString("Наименование");
                                m.addRow(row5);
                            }
                            break;
                        case 6:
                            q = "select Название from Книги where Год_издания = '" + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Название");
                            final Object[] row6 = new Object[1];
                            row6[0] = "Название";
                            m.addRow(row6);
                            while (rs.next()) {
                                row6[0] = rs.getString("Название");
                                m.addRow(row6);
                            }
                            break;
                        case 7:
                            q = "select ФИО from Сотрудники where Код not in (select Код_сотр from Мероприятия)";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("ФИО");
                            final Object[] row7 = new Object[1];
                            row7[0] = "ФИО";
                            m.addRow(row7);
                            while (rs.next()) {
                                row7[0] = rs.getString("ФИО");
                                m.addRow(row7);
                            }
                            break;
                    }
                } catch (final Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        button.setBounds(121, 80, 115, 25);
        this.contentPane.add(button);
    }

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final Queries frame = new Queries();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
