package lib;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class View extends JFrame {

    private final JPanel             contentPane;
    private final JTable             table;
    public int                       t;
    private final JTextField         textField;
    private final JTextField         textField1;
    private final JTextField         textField2;
    private final JTextField         textField3;
    private final JTextField         textField4;
    private JLabel                   label2       = new JLabel();
    private JLabel                   label1       = new JLabel();
    private JLabel                   label        = new JLabel();
    private JLabel                   lblNewlabel1 = new JLabel();
    private JLabel                   lblNewLabel  = new JLabel();
    private final ArrayList<Integer> a            = new ArrayList<>();

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1194, 480);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);

        this.table = new JTable();
        this.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = View.this.table.getSelectedRow();
                final TableModel m = View.this.table.getModel();
                switch (View.this.t) {
                    case 0:
                        View.this.textField.setText(m.getValueAt(i, 0).toString());
                        View.this.textField1.setText(m.getValueAt(i, 1).toString());
                        break;
                    case 1:
                        View.this.textField.setText(m.getValueAt(i, 0).toString());
                        View.this.textField1.setText(m.getValueAt(i, 1).toString());
                        View.this.textField2.setText(m.getValueAt(i, 2).toString());
                        View.this.textField3.setText(m.getValueAt(i, 3).toString());
                        View.this.textField4.setText(m.getValueAt(i, 4).toString());
                        break;
                    case 2:
                        View.this.textField.setText(m.getValueAt(i, 0).toString());
                        View.this.textField1.setText(m.getValueAt(i, 1).toString());
                        View.this.textField2.setText(m.getValueAt(i, 2).toString());
                        View.this.textField3.setText(m.getValueAt(i, 3).toString());
                        View.this.textField4.setText(m.getValueAt(i, 4).toString());
                        break;
                    case 3:
                        View.this.textField.setText(m.getValueAt(i, 0).toString());
                        View.this.textField1.setText(m.getValueAt(i, 1).toString());
                        View.this.textField2.setText(m.getValueAt(i, 2).toString());
                        break;
                    case 4:
                        View.this.textField.setText(m.getValueAt(i, 0).toString());
                        View.this.textField1.setText(m.getValueAt(i, 1).toString());
                        View.this.textField2.setText(m.getValueAt(i, 2).toString());
                        if (m.getValueAt(i, 3) == null) {
                            View.this.textField3.setText("");
                        } else {
                            View.this.textField3.setText(m.getValueAt(i, 3).toString());
                        }
                        break;
                }
            }
        });
        this.table.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
        this.table.setBounds(501, 13, 663, 356);
        this.table.setRowHeight(22);
        this.contentPane.setLayout(null);
        this.contentPane.add(this.table);

        final JButton button = new JButton("Закрыть");
        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button.addActionListener(arg0 -> {
            Menu.view.setVisible(false);
            final DefaultTableModel m = (DefaultTableModel) View.this.table.getModel();
            m.setRowCount(0);
            m.setColumnCount(0);
        });
        button.setBounds(353, 402, 121, 25);
        this.contentPane.add(button);

        this.label2 = new JLabel();
        this.label2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.label2.setBounds(12, 244, 200, 25);
        this.contentPane.add(this.label2);

        this.label1 = new JLabel();
        this.label1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.label1.setBounds(12, 198, 200, 25);
        this.contentPane.add(this.label1);

        this.label = new JLabel();
        this.label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.label.setBounds(12, 150, 200, 25);
        this.contentPane.add(this.label);

        this.lblNewlabel1 = new JLabel();
        this.lblNewlabel1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.lblNewlabel1.setBounds(12, 101, 200, 25);
        this.contentPane.add(this.lblNewlabel1);

        this.lblNewLabel = new JLabel();
        this.lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.lblNewLabel.setBounds(12, 49, 200, 25);
        this.contentPane.add(this.lblNewLabel);

        this.textField = new JTextField();
        this.textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField.setColumns(10);
        this.textField.setBounds(233, 50, 241, 22);
        this.contentPane.add(this.textField);

        this.textField1 = new JTextField();
        this.textField1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField1.setColumns(10);
        this.textField1.setBounds(233, 102, 241, 22);
        this.contentPane.add(this.textField1);

        this.textField2 = new JTextField();
        this.textField2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField2.setColumns(10);
        this.textField2.setBounds(233, 153, 241, 22);
        this.contentPane.add(this.textField2);

        this.textField3 = new JTextField();
        this.textField3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField3.setColumns(10);
        this.textField3.setBounds(233, 199, 241, 22);
        this.contentPane.add(this.textField3);

        this.textField4 = new JTextField();
        this.textField4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField4.setColumns(10);
        this.textField4.setBounds(233, 245, 241, 22);
        this.contentPane.add(this.textField4);

        final JButton btnNewButton = new JButton("Обновить");
        btnNewButton.addActionListener(arg0 -> {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                final String url = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=msdb;integratedSecurity=true";
                final Connection con = DriverManager.getConnection(url);
                final int row = View.this.table.getSelectedRow();
                final int value = View.this.a.get(row - 1);
                String q;
                PreparedStatement p;
                final DefaultTableModel m = (DefaultTableModel) View.this.table.getModel();
                switch (View.this.t) {
                    case 0:
                        q = "update Авторы_книги set ФИО = ?, Код_книги = ? where Код = " + value;
                        p = con.prepareStatement(q);
                        p.setString(1, View.this.textField.getText());
                        p.setString(2, View.this.textField1.getText());
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Update Successfully");
                        break;
                    case 1:
                        q = "update Выдача_книги set Код_книги = ?, ФИО_читателя = ?, Код_сотрудника = ?, Дата_выдачи = ?, Дата_возврата = ? where Код = "
                                + value;
                        p = con.prepareStatement(q);
                        p.setString(1, View.this.textField.getText());
                        p.setString(2, View.this.textField1.getText());
                        p.setString(3, View.this.textField2.getText());
                        p.setString(4, View.this.textField3.getText());
                        p.setString(5, View.this.textField4.getText());
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Update Successfully");
                        break;
                    case 2:
                        q = "update Книги set Название = ?, Издательство = ?, Год_издания = ?, Жанр = ?, Цена = ? where Код = "
                                + value;
                        p = con.prepareStatement(q);
                        p.setString(1, View.this.textField.getText());
                        p.setString(2, View.this.textField1.getText());
                        p.setString(3, View.this.textField2.getText());
                        p.setString(4, View.this.textField3.getText());
                        p.setString(5, View.this.textField4.getText());
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Update Successfully");
                        break;
                    case 3:
                        q = "update Мероприятия set Наименование = ?, Код_сотр = ?, Дата_проведения = ? where Код = "
                                + value;
                        p = con.prepareStatement(q);
                        p.setString(1, View.this.textField.getText());
                        p.setString(2, View.this.textField1.getText());
                        p.setString(3, View.this.textField2.getText());
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Update Successfully");
                        break;
                    case 4:
                        q = "update Сотрудники set ФИО = ?, Должность = ?, Дата_приема = ?, Дата_увольнения = ? where Код = "
                                + value;
                        p = con.prepareStatement(q);
                        p.setString(1, View.this.textField.getText());
                        p.setString(2, View.this.textField1.getText());
                        p.setString(3, View.this.textField2.getText());
                        p.setString(4, View.this.textField3.getText());
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Update Successfully");
                        break;
                }
            } catch (final Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        });
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnNewButton.setBounds(29, 402, 136, 25);
        this.contentPane.add(btnNewButton);

        final JButton button1 = new JButton("Удалить");
        button1.addActionListener(arg0 -> {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                final String url = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=msdb;integratedSecurity=true";
                final Connection con = DriverManager.getConnection(url);
                final int row = View.this.table.getSelectedRow();
                final int value = View.this.a.get(row - 1);
                String q;
                PreparedStatement p;
                final DefaultTableModel m = (DefaultTableModel) View.this.table.getModel();
                switch (View.this.t) {
                    case 0:
                        q = "delete from Авторы_книги where Код = " + value;
                        p = con.prepareStatement(q);
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Delete Successfully");
                        break;
                    case 1:
                        q = "delete from Выдача_книги where Код = " + value;
                        p = con.prepareStatement(q);
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Delete Successfully");
                        break;
                    case 2:
                        q = "delete from Книги where Код = " + value;
                        p = con.prepareStatement(q);
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Delete Successfully");
                        break;
                    case 3:
                        q = "delete from Мероприятия where Код = " + value;
                        p = con.prepareStatement(q);
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Delete Successfully");
                        break;
                    case 4:
                        q = "delete from Сотрудники where Код = " + value;
                        p = con.prepareStatement(q);
                        p.executeUpdate();
                        m.setRowCount(0);
                        m.setColumnCount(0);
                        View.this.showLendingBooks();
                        JOptionPane.showMessageDialog(null, "Delete Successfully");
                        break;
                }
            } catch (final Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        });
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button1.setBounds(177, 402, 140, 25);
        this.contentPane.add(button1);
    }

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                final View frame = new View();
                frame.setVisible(true);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void showLendingBooks() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final String url = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=msdb;integratedSecurity=true";
            final Connection con = DriverManager.getConnection(url);
            final String q;
            final Statement st;
            final ResultSet rs;
            final DefaultTableModel m = (DefaultTableModel) this.table.getModel();
            switch (this.t) {
                case 0:
                    this.textField.setVisible(true);
                    this.textField1.setVisible(true);
                    this.textField2.setVisible(false);
                    this.textField3.setVisible(false);
                    this.textField4.setVisible(false);
                    this.lblNewLabel.setVisible(true);
                    this.lblNewlabel1.setVisible(true);
                    this.label.setVisible(false);
                    this.label1.setVisible(false);
                    this.label2.setVisible(false);
                    this.textField.setText("");
                    this.textField1.setText("");
                    this.lblNewLabel.setText("ФИО");
                    this.lblNewlabel1.setText("Код книги");
                    q = "select * from Авторы_книги";
                    st = con.createStatement();
                    rs = st.executeQuery(q);
                    m.addColumn("ФИО");
                    m.addColumn("Код книги");
                    final Object[] row0 = new Object[2];
                    row0[0] = "ФИО";
                    row0[1] = "Код книги";
                    m.addRow(row0);
                    this.a.clear();
                    while (rs.next()) {
                        this.a.add(rs.getInt("Код"));
                        row0[0] = rs.getString("ФИО");
                        row0[1] = rs.getInt("Код_книги");
                        m.addRow(row0);
                    }
                    break;
                case 1:
                    this.textField.setVisible(true);
                    this.textField1.setVisible(true);
                    this.textField2.setVisible(true);
                    this.textField3.setVisible(true);
                    this.textField4.setVisible(true);
                    this.lblNewLabel.setVisible(true);
                    this.lblNewlabel1.setVisible(true);
                    this.label.setVisible(true);
                    this.label1.setVisible(true);
                    this.label2.setVisible(true);
                    this.textField.setText("");
                    this.textField1.setText("");
                    this.textField2.setText("");
                    this.textField3.setText("");
                    this.textField4.setText("");
                    this.lblNewLabel.setText("Код книги");
                    this.lblNewlabel1.setText("ФИО читателя");
                    this.label.setText("Код сотрудника");
                    this.label1.setText("Дата выдачи");
                    this.label2.setText("Дата возврата");
                    q = "select * from Выдача_книги";
                    st = con.createStatement();
                    rs = st.executeQuery(q);
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
                    this.a.clear();
                    while (rs.next()) {
                        this.a.add(rs.getInt("Код"));
                        row1[0] = rs.getInt("Код_книги");
                        row1[1] = rs.getString("ФИО_читателя");
                        row1[2] = rs.getInt("Код_сотрудника");
                        row1[3] = rs.getDate("Дата_выдачи");
                        row1[4] = rs.getDate("Дата_возврата");
                        m.addRow(row1);
                    }
                    break;
                case 2:
                    this.textField.setVisible(true);
                    this.textField1.setVisible(true);
                    this.textField2.setVisible(true);
                    this.textField3.setVisible(true);
                    this.textField4.setVisible(true);
                    this.lblNewLabel.setVisible(true);
                    this.lblNewlabel1.setVisible(true);
                    this.label.setVisible(true);
                    this.label1.setVisible(true);
                    this.label2.setVisible(true);
                    this.textField.setText("");
                    this.textField1.setText("");
                    this.textField2.setText("");
                    this.textField3.setText("");
                    this.textField4.setText("");
                    this.lblNewLabel.setText("Название");
                    this.lblNewlabel1.setText("Издательство");
                    this.label.setText("Год издания");
                    this.label1.setText("Жанр");
                    this.label2.setText("Цена");
                    q = "select * from Книги";
                    st = con.createStatement();
                    rs = st.executeQuery(q);
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
                    this.a.clear();
                    while (rs.next()) {
                        this.a.add(rs.getInt("Код"));
                        row2[0] = rs.getString("Название");
                        row2[1] = rs.getString("Издательство");
                        row2[2] = rs.getInt("Год_издания");
                        row2[3] = rs.getString("Жанр");
                        row2[4] = rs.getInt("Цена");
                        m.addRow(row2);
                    }
                    break;
                case 3:
                    this.textField.setVisible(true);
                    this.textField1.setVisible(true);
                    this.textField2.setVisible(true);
                    this.textField3.setVisible(false);
                    this.textField4.setVisible(false);
                    this.lblNewLabel.setVisible(true);
                    this.lblNewlabel1.setVisible(true);
                    this.label.setVisible(true);
                    this.label1.setVisible(false);
                    this.label2.setVisible(false);
                    this.textField.setText("");
                    this.textField1.setText("");
                    this.textField2.setText("");
                    this.lblNewLabel.setText("Наименование");
                    this.lblNewlabel1.setText("Код сотрудника");
                    this.label.setText("Дата проведения");
                    q = "select * from Мероприятия";
                    st = con.createStatement();
                    rs = st.executeQuery(q);
                    m.addColumn("Наименование");
                    m.addColumn("Код_сотр");
                    m.addColumn("Дата_проведения");
                    final Object[] row3 = new Object[3];
                    row3[0] = "Наименование";
                    row3[1] = "Код сотрудника";
                    row3[2] = "Дата проведения";
                    m.addRow(row3);
                    this.a.clear();
                    while (rs.next()) {
                        this.a.add(rs.getInt("Код"));
                        row3[0] = rs.getString("Наименование");
                        row3[1] = rs.getInt("Код_сотр");
                        row3[2] = rs.getDate("Дата_проведения");
                        m.addRow(row3);
                    }
                    break;
                case 4:
                    this.textField.setVisible(true);
                    this.textField1.setVisible(true);
                    this.textField2.setVisible(true);
                    this.textField3.setVisible(true);
                    this.textField4.setVisible(false);
                    this.lblNewLabel.setVisible(true);
                    this.lblNewlabel1.setVisible(true);
                    this.label.setVisible(true);
                    this.label1.setVisible(true);
                    this.label2.setVisible(false);
                    this.textField.setText("");
                    this.textField1.setText("");
                    this.textField2.setText("");
                    this.textField3.setText("");
                    this.lblNewLabel.setText("ФИО");
                    this.lblNewlabel1.setText("Должность");
                    this.label.setText("Дата приема");
                    this.label1.setText("Дата увольнения");
                    q = "select * from Сотрудники";
                    st = con.createStatement();
                    rs = st.executeQuery(q);
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
                    this.a.clear();
                    while (rs.next()) {
                        this.a.add(rs.getInt("Код"));
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
}
