package zarplata;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SearchRecords {
    static final String URL  = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=master;integratedSecurity=true";
    static final String FONT = "Segoe UI";
    List<Integer>       a    = new ArrayList<>();

    public List<Integer> searchDeti(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"ФИО", "Родитель", "Дата рождения"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(3);
            String q = "select Дети.ID as ID, Дети.ФИО as ФИО, Сотрудники.ФИО as родитель, Дети.Дата_рождения as Дата "
                    + "from Дети, Сотрудники where ID_сотр = Сотрудники.ID and Сотрудники.ФИО like '%"
                    + search.getTextField().getText() + "%' order by родитель";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[3];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("ФИО");
                row[1] = rs.getString("родитель");
                row[2] = rs.getString("Дата");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select ФИО from Сотрудники order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox().setModel(model);
            menu.getComboBox().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getTextField().setText(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getTextField2().setText(m.getValueAt(i, 2).toString());
            }
        });
        return this.a;
    }

    public List<Integer> searchNach(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"Вид начисления", "ФИО -- Дата табеля", "Дата начисления",
                    "Сумма"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(4);
            String q = "select Начисления.ID, Наименование, dbo.NachYderj(ID_табеля) as ФИО, Дата_начисления, Сумма "
                    + "from Начисления, Виды_начислений where ID_видаН = Виды_начислений.ID and dbo.NachYderj(ID_табеля) like '%"
                    + search.getTextField().getText() + "%'";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[4];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("Наименование");
                row[1] = rs.getString("ФИО");
                row[2] = rs.getString("Дата_начисления");
                row[3] = rs.getString("Сумма");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select Наименование from Виды_начислений order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);

            q = "select dbo.NachYderj(ID) as ФИО from Табель order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model1.getIndexOf(temp) == -1) {
                    model1.addElement(temp);
                }
            }
            menu.getComboBox().setModel(model1);
            menu.getComboBox().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getTextField2().setText(m.getValueAt(i, 2).toString());
                menu.getTextField3().setText(m.getValueAt(i, 3).toString());
            }
        });
        return this.a;
    }

    public List<Integer> searchPolzovateliFIO(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"ФИО", "Роль", "Логин", "Пароль"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(4);
            String q = "select Пользователи.ID as ID, ФИО, Роль, Логин, Пароль "
                    + "from Пользователи, Сотрудники where ID_сотр = Сотрудники.ID and ФИО like '%"
                    + search.getTextField().getText() + "%'";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[4];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("ФИО");
                row[1] = rs.getString("Роль");
                row[2] = rs.getString("Логин");
                row[3] = rs.getString("Пароль");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            menu.getComboBox().setModel(
                    new DefaultComboBoxModel<>(new String[] {"admin", "accountant", "user"}));
            menu.getComboBox().setSelectedIndex(0);

            q = "select ФИО from Сотрудники order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getTextField2().setText(m.getValueAt(i, 2).toString());
                menu.getTextField3().setText(m.getValueAt(i, 3).toString());
            }
        });
        return this.a;
    }

    public List<Integer> searchPolzovateliRole(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"ФИО", "Роль", "Логин", "Пароль"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(4);
            String q = "select Пользователи.ID as ID, ФИО, Роль, Логин, Пароль "
                    + "from Пользователи, Сотрудники where ID_сотр = Сотрудники.ID and Роль = '"
                    + (String) search.getComboBox().getSelectedItem() + "'";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[4];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("ФИО");
                row[1] = rs.getString("Роль");
                row[2] = rs.getString("Логин");
                row[3] = rs.getString("Пароль");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            menu.getComboBox().setModel(
                    new DefaultComboBoxModel<>(new String[] {"admin", "accountant", "user"}));
            menu.getComboBox().setSelectedIndex(0);

            q = "select ФИО from Сотрудники order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getTextField2().setText(m.getValueAt(i, 2).toString());
                menu.getTextField3().setText(m.getValueAt(i, 3).toString());
            }
        });
        return this.a;
    }

    public List<Integer> searchPriemyDoljnost(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"ФИО", "Должность", "Отдел", "Ставка", "Дата приема",
                    "Дата увольнения"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(6);
            String q = "select Прием_на_работу.ID as ID, ФИО, Должности.Наименование as Должность, Отделы.Наименование"
                    + " as Отдел, Ставка, Дата_приема, Дата_увольнения from Прием_на_работу, Сотрудники, Должности, Отделы"
                    + " where Сотрудники.ID = ID_сотр and Должности.ID = ID_должн and Отделы.ID = ID_отдела and "
                    + "Должности.Наименование like '%" + search.getTextField().getText()
                    + "%' order by ФИО";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[6];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("ФИО");
                row[1] = rs.getString("Должность");
                row[2] = rs.getString("Отдел");
                row[3] = rs.getString("Ставка");
                row[4] = rs.getString("Дата_приема");
                row[5] = rs.getString("Дата_увольнения");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select ФИО from Сотрудники order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);

            q = "select Наименование from Должности order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model1.getIndexOf(temp) == -1) {
                    model1.addElement(temp);
                }
            }
            menu.getComboBox().setModel(model1);
            menu.getComboBox().setSelectedIndex(0);

            q = "select Наименование from Отделы order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model2.getIndexOf(temp) == -1) {
                    model2.addElement(temp);
                }
            }
            menu.getComboBox2().setModel(model2);
            menu.getComboBox2().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getComboBox2().setSelectedItem(m.getValueAt(i, 2).toString());
                menu.getTextField3().setText(m.getValueAt(i, 3).toString());
                menu.getTextField4().setText(m.getValueAt(i, 4).toString());
                if (m.getValueAt(i, 5) == null) {
                    menu.getTextField5().setText("");
                } else {
                    menu.getTextField5().setText(m.getValueAt(i, 5).toString());
                }
            }
        });
        return this.a;
    }

    public List<Integer> searchPriemyFIO(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"ФИО", "Должность", "Отдел", "Ставка", "Дата приема",
                    "Дата увольнения"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(6);
            String q = "select Прием_на_работу.ID as ID, ФИО, Должности.Наименование as Должность, Отделы.Наименование "
                    + "as Отдел, Ставка, Дата_приема, Дата_увольнения from Прием_на_работу, Сотрудники, Должности, Отделы "
                    + "where Сотрудники.ID = ID_сотр and Должности.ID = ID_должн and Отделы.ID = ID_отдела and ФИО like '%"
                    + search.getTextField().getText() + "%' order by ФИО";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[6];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("ФИО");
                row[1] = rs.getString("Должность");
                row[2] = rs.getString("Отдел");
                row[3] = rs.getString("Ставка");
                row[4] = rs.getString("Дата_приема");
                row[5] = rs.getString("Дата_увольнения");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select ФИО from Сотрудники order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);

            q = "select Наименование from Должности order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model1.getIndexOf(temp) == -1) {
                    model1.addElement(temp);
                }
            }
            menu.getComboBox().setModel(model1);
            menu.getComboBox().setSelectedIndex(0);

            q = "select Наименование from Отделы order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model2.getIndexOf(temp) == -1) {
                    model2.addElement(temp);
                }
            }
            menu.getComboBox2().setModel(model2);
            menu.getComboBox2().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        menu.getTable().setFont(new Font(ShowTables.FONT, Font.PLAIN, 18));
        menu.getContentPane().add(menu.getTable());
        menu.getTable().setRowHeight(22);
        // menu.getTable().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        menu.getScrollPane().setViewportView(menu.getTable());
        menu.getScrollPane().setVisible(true);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getComboBox2().setSelectedItem(m.getValueAt(i, 2).toString());
                menu.getTextField3().setText(m.getValueAt(i, 3).toString());
                menu.getTextField4().setText(m.getValueAt(i, 4).toString());
                if (m.getValueAt(i, 5) == null) {
                    menu.getTextField5().setText("");
                } else {
                    menu.getTextField5().setText(m.getValueAt(i, 5).toString());
                }
            }
        });
        return this.a;
    }

    public List<Integer> searchPriemyOtdel(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"ФИО", "Должность", "Отдел", "Ставка", "Дата приема",
                    "Дата увольнения"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(6);
            String q = "select Прием_на_работу.ID as ID, ФИО, Должности.Наименование as Должность, Отделы.Наименование "
                    + "as Отдел, Ставка, Дата_приема, Дата_увольнения from Прием_на_работу, Сотрудники, Должности, Отделы "
                    + "where Сотрудники.ID = ID_сотр and Должности.ID = ID_должн and Отделы.ID = ID_отдела and "
                    + "Отделы.Наименование like '%" + search.getTextField().getText()
                    + "%' order by ФИО";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[6];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("ФИО");
                row[1] = rs.getString("Должность");
                row[2] = rs.getString("Отдел");
                row[3] = rs.getString("Ставка");
                row[4] = rs.getString("Дата_приема");
                row[5] = rs.getString("Дата_увольнения");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select ФИО from Сотрудники order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);

            q = "select Наименование from Должности order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model1.getIndexOf(temp) == -1) {
                    model1.addElement(temp);
                }
            }
            menu.getComboBox().setModel(model1);
            menu.getComboBox().setSelectedIndex(0);

            q = "select Наименование from Отделы order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model2.getIndexOf(temp) == -1) {
                    model2.addElement(temp);
                }
            }
            menu.getComboBox2().setModel(model2);
            menu.getComboBox2().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getComboBox2().setSelectedItem(m.getValueAt(i, 2).toString());
                menu.getTextField3().setText(m.getValueAt(i, 3).toString());
                menu.getTextField4().setText(m.getValueAt(i, 4).toString());
                if (m.getValueAt(i, 5) == null) {
                    menu.getTextField5().setText("");
                } else {
                    menu.getTextField5().setText(m.getValueAt(i, 5).toString());
                }
            }
        });
        return this.a;
    }

    public List<Integer> searchTabelya(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"ФИО", "Дата -- Ставка -- Дата приема", "Кол раб дней",
                    "Кол дней отпуска", "Кол дней бл"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(5);
            String q = "select ID, dbo.Tabelya(ID_приема) ФИО, Дата, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл "
                    + "from Табель where dbo.Tabelya(ID_приема) like '%"
                    + search.getTextField().getText() + "%'";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[5];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("ФИО");
                row[1] = rs.getString("Дата");
                row[2] = rs.getString("Кол_раб_дней");
                row[3] = rs.getString("Кол_дней_отпуска");
                row[4] = rs.getString("Кол_дней_бл");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select dbo.Tabelya(ID) ФИО from Прием_на_работу order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model1.getIndexOf(temp) == -1) {
                    model1.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model1);
            menu.getComboBox1().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getTextField1().setText(m.getValueAt(i, 1).toString());
                menu.getTextField2().setText(m.getValueAt(i, 2).toString());
                menu.getTextField3().setText(m.getValueAt(i, 3).toString());
                menu.getTextField4().setText(m.getValueAt(i, 4).toString());
            }
        });
        return this.a;
    }

    public List<Integer> searchTablNach(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"Вид начисления", "ФИО -- Ставка -- Дата приема",
                    "Дата назначения", "Дата отмены", "Сумма"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(5);
            String q = "select Таблица_начислений.ID ID, Наименование, dbo.Tabelya(ID_приема) as ФИО, Дата_назначения, "
                    + "Дата_отмены, Сумма from Таблица_начислений, Виды_начислений where ID_видаН = Виды_начислений.ID "
                    + "and dbo.Tabelya(ID_приема) like '%" + search.getTextField().getText() + "%'";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[5];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("Наименование");
                row[1] = rs.getString("ФИО");
                row[2] = rs.getString("Дата_назначения");
                row[3] = rs.getString("Дата_отмены");
                row[4] = rs.getString("Сумма");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select Наименование from Виды_начислений order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);

            q = "select dbo.Tabelya(ID) as ФИО from Прием_на_работу order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model1.getIndexOf(temp) == -1) {
                    model1.addElement(temp);
                }
            }
            menu.getComboBox().setModel(model1);
            menu.getComboBox().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getTextField2().setText(m.getValueAt(i, 2).toString());
                if (m.getValueAt(i, 3) == null) {
                    menu.getTextField3().setText("");
                } else {
                    menu.getTextField3().setText(m.getValueAt(i, 3).toString());
                }
                menu.getTextField4().setText(m.getValueAt(i, 4).toString());
            }
        });
        return this.a;
    }

    public List<Integer> searchTablYderj(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"Вид удержания", "ФИО -- Ставка -- Дата приема",
                    "Дата назначения", "Дата отмены", "Сумма"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(5);
            String q = "select Таблица_удержаний.ID ID, Наименование, dbo.Tabelya(ID_приема) as ФИО, Дата_назначения, "
                    + "Дата_отмены, Сумма from Таблица_удержаний, Виды_удержаний where ID_видаУ = Виды_удержаний.ID "
                    + "and dbo.Tabelya(ID_приема) like '%" + search.getTextField().getText() + "%'";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[5];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("Наименование");
                row[1] = rs.getString("ФИО");
                row[2] = rs.getString("Дата_назначения");
                row[3] = rs.getString("Дата_отмены");
                row[4] = rs.getString("Сумма");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select Наименование from Виды_удержаний order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);

            q = "select dbo.Tabelya(ID) as ФИО from Прием_на_работу order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model1.getIndexOf(temp) == -1) {
                    model1.addElement(temp);
                }
            }
            menu.getComboBox().setModel(model1);
            menu.getComboBox().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getTextField2().setText(m.getValueAt(i, 2).toString());
                if (m.getValueAt(i, 3) == null) {
                    menu.getTextField3().setText("");
                } else {
                    menu.getTextField3().setText(m.getValueAt(i, 3).toString());
                }
                menu.getTextField4().setText(m.getValueAt(i, 4).toString());
            }
        });
        return this.a;
    }

    public List<Integer> searchYderj(final Menu menu, final Search search) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String[] columnNames = {"Вид удержания", "ФИО -- Дата табеля", "Дата удержания",
                    "Сумма"};
            final DefaultTableModel m = new DefaultTableModel(null, columnNames);
            m.setRowCount(0);
            m.setColumnCount(4);
            String q = "select Удержания.ID, Наименование, dbo.NachYderj(ID_табеля) as ФИО, Дата_удержания, Сумма "
                    + "from Удержания, Виды_удержаний where ID_видаУ = Виды_удержаний.ID and dbo.NachYderj(ID_табеля) like '%"
                    + search.getTextField().getText() + "%'";
            final Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            final Object[] row = new Object[4];
            this.a.clear();
            while (rs.next()) {
                this.a.add(rs.getInt("ID"));
                row[0] = rs.getString("Наименование");
                row[1] = rs.getString("ФИО");
                row[2] = rs.getString("Дата_удержания");
                row[3] = rs.getString("Сумма");
                m.addRow(row);
            }
            menu.setTable(new JTable(m));

            q = "select Наименование from Виды_удержаний order by Наименование";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("Наименование");
                if (model.getIndexOf(temp) == -1) {
                    model.addElement(temp);
                }
            }
            menu.getComboBox1().setModel(model);
            menu.getComboBox1().setSelectedIndex(0);

            q = "select dbo.NachYderj(ID) as ФИО from Табель order by ФИО";
            rs = st.executeQuery(q);
            final DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new String[] {});
            while (rs.next()) {
                final String temp = rs.getString("ФИО");
                if (model1.getIndexOf(temp) == -1) {
                    model1.addElement(temp);
                }
            }
            menu.getComboBox().setModel(model1);
            menu.getComboBox().setSelectedIndex(0);
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.setTableProp(menu);
        menu.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                final int i = menu.getTable().getSelectedRow();
                final TableModel m = menu.getTable().getModel();
                menu.getComboBox1().setSelectedItem(m.getValueAt(i, 0).toString());
                menu.getComboBox().setSelectedItem(m.getValueAt(i, 1).toString());
                menu.getTextField2().setText(m.getValueAt(i, 2).toString());
                menu.getTextField3().setText(m.getValueAt(i, 3).toString());
            }
        });
        return this.a;
    }

    public void setTableProp(final Menu menu) {
        menu.getTable().setFont(new Font(SearchRecords.FONT, Font.PLAIN, 18));
        menu.getContentPane().add(menu.getTable());
        menu.getTable().setRowHeight(22);
        menu.getScrollPane().setViewportView(menu.getTable());
        menu.getScrollPane().setVisible(true);
    }
}
