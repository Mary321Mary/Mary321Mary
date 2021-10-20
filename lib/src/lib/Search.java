package lib;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Search extends JFrame {

    private final JPanel     contentPane;
    private final JTextField textField;
    private final JTable     table;
    public int               t;
    public JLabel            lblNewLabel = new JLabel();

    public Search() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 762, 486);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        this.lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        this.lblNewLabel.setBounds(12, 35, 137, 16);
        this.contentPane.add(this.lblNewLabel);

        this.textField = new JTextField();
        this.textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField.setBounds(176, 35, 264, 22);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);

        final JButton btnNewButton = new JButton("Искать");
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    final String url = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=msdb;integratedSecurity=true";
                    final Connection con = DriverManager.getConnection(url);
                    final String value = Search.this.textField.getText();
                    String q;
                    final Statement st;
                    final ResultSet rs;
                    final DefaultTableModel m = (DefaultTableModel) Search.this.table.getModel();
                    switch (Search.this.t) {
                        case 0:
                            q = "select ФИО, Код_книги from Авторы_книги where ФИО = '" + value
                                    + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("ФИО");
                            m.addColumn("Код книги");
                            final Object[] row0 = new Object[2];
                            row0[0] = "ФИО";
                            row0[1] = "Код книги";
                            m.addRow(row0);
                            while (rs.next()) {
                                row0[0] = rs.getString("ФИО");
                                row0[1] = rs.getInt("Код_книги");
                                m.addRow(row0);
                            }
                            break;
                        case 1:
                            q = "select Код_книги, ФИО_читателя, Код_сотрудника, Дата_выдачи, Дата_возврата from Выдача_книги where ФИО_читателя = '"
                                    + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Код книги");
                            m.addColumn("ФИО читателя");
                            m.addColumn("Код сотрудника");
                            m.addColumn("Дата выдачи");
                            m.addColumn("Дата возврата");
                            final Object[] row1 = new Object[5];
                            row1[0] = "Код книги";
                            row1[1] = "ФИО читателя";
                            row1[2] = "Код сотрудника";
                            row1[3] = "Дата выдачи";
                            row1[4] = "Дата возврата";
                            m.addRow(row1);
                            while (rs.next()) {
                                row1[0] = rs.getInt("Код_книги");
                                row1[1] = rs.getString("ФИО_читателя");
                                row1[2] = rs.getInt("Код_сотрудника");
                                row1[3] = rs.getDate("Дата_выдачи");
                                row1[4] = rs.getDate("Дата_возврата");
                                m.addRow(row1);
                            }
                            break;
                        case 2:
                            q = "select Название, Издательство, Год_издания, Жанр, Цена from Книги where Издательство = '"
                                    + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Название");
                            m.addColumn("Издательство");
                            m.addColumn("Год издания");
                            m.addColumn("Жанр");
                            m.addColumn("Цена");
                            final Object[] row2 = new Object[5];
                            row2[0] = "Название";
                            row2[1] = "Издательство";
                            row2[2] = "Год издания";
                            row2[3] = "Жанр";
                            row2[4] = "Цена";
                            m.addRow(row2);
                            while (rs.next()) {
                                row2[0] = rs.getString("Название");
                                row2[1] = rs.getString("Издательство");
                                row2[2] = rs.getInt("Год_издания");
                                row2[3] = rs.getString("Жанр");
                                row2[4] = rs.getInt("Цена");
                                m.addRow(row2);
                            }
                            break;
                        case 3:
                            q = "select Наименование, Код_сотр, Дата_проведения from Мероприятия where Наименование = '"
                                    + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("Наименование");
                            m.addColumn("Код_сотр");
                            m.addColumn("Дата_проведения");
                            final Object[] row3 = new Object[3];
                            row3[0] = "Наименование";
                            row3[1] = "Код сотрудника";
                            row3[2] = "Дата проведения";
                            m.addRow(row3);
                            while (rs.next()) {
                                row3[0] = rs.getString("Наименование");
                                row3[1] = rs.getInt("Код_сотр");
                                row3[2] = rs.getDate("Дата_проведения");
                                m.addRow(row3);
                            }
                            break;
                        case 4:
                            q = "select ФИО, Должность, Дата_приема, Дата_увольнения from Сотрудники where ФИО = '"
                                    + value + "'";
                            st = con.createStatement();
                            rs = st.executeQuery(q);
                            con.prepareStatement(q);
                            m.addColumn("ФИО");
                            m.addColumn("Должность");
                            m.addColumn("Дата_приема");
                            m.addColumn("Дата_увольнения");
                            final Object[] row4 = new Object[4];
                            row4[0] = "ФИО";
                            row4[1] = "Должность";
                            row4[2] = "Дата приема";
                            row4[3] = "Дата увольнения";
                            m.addRow(row4);
                            while (rs.next()) {
                                row4[0] = rs.getString("ФИО");
                                row4[1] = rs.getString("Должность");
                                row4[2] = rs.getDate("Дата_приема");
                                row4[3] = rs.getDate("Дата_увольнения");
                                m.addRow(row4);
                            }
                            break;
                    }
                } catch (final Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        btnNewButton.setBounds(466, 34, 105, 25);
        this.contentPane.add(btnNewButton);

        final JButton btnClose = new JButton("Закрыть");
        btnClose.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.search.setVisible(false);
                Search.this.lblNewLabel.setText("");
                Search.this.lblNewLabel.setText("");
                final DefaultTableModel m = (DefaultTableModel) Search.this.table.getModel();
                m.setRowCount(0);
                m.setColumnCount(0);
            }
        });
        btnClose.setBounds(583, 34, 115, 25);
        this.contentPane.add(btnClose);

        this.table = new JTable();
        this.table.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.table.setBounds(12, 88, 698, 338);
        this.table.setRowHeight(22);
        this.contentPane.add(this.table);
    }

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final Search frame = new Search();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
