package zarplata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class AddToTables {
    static final String  URL       = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=master;integratedSecurity=true";
    static final Pattern PAT       = Pattern
            .compile("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
    private String       exception = "";

    public void addToDeti(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Дети(ФИО, ID_сотр, Дата_рождения) select ?, Сотрудники.ID, ? from Сотрудники "
                    + "where Сотрудники.ФИО = ?";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField().getText().isEmpty()
                    && !menu.getTextField2().getText().isEmpty()) {
                p.setString(1, menu.getTextField().getText());
                final Matcher matcher = AddToTables.PAT.matcher(menu.getTextField2().getText());
                if (matcher.find()) {
                    p.setString(2, menu.getTextField2().getText());
                } else {
                    this.exception = "Неверно указана Дата рождения";
                    throw new Exception();
                }
                p.setString(3, (String) menu.getComboBox().getSelectedItem());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField().setText("");
            menu.getTextField2().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToDoljnosti(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Должности values(?)";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField().getText().isEmpty()) {
                p.setString(1, menu.getTextField().getText());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToNach(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Начисления(ID_видаН, ID_табеля, Дата_начисления, Сумма) "
                    + "select Виды_начислений.ID, Табель.ID, ?, ? from Табель, Виды_начислений "
                    + "where Наименование = ? and dbo.NachYderj(Табель.ID) = ?";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField2().getText().isEmpty()
                    && !menu.getTextField3().getText().isEmpty()) {
                final Matcher matcher = AddToTables.PAT.matcher(menu.getTextField2().getText());
                if (matcher.find()) {
                    p.setString(1, menu.getTextField2().getText());
                } else {
                    this.exception = "Неверно указана Дата начисления";
                    throw new Exception();
                }
                p.setString(2, menu.getTextField3().getText());
                p.setString(3, (String) menu.getComboBox1().getSelectedItem());
                p.setString(4, (String) menu.getComboBox().getSelectedItem());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToOtdely(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Отделы values(?)";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField().getText().isEmpty()) {
                p.setString(1, menu.getTextField().getText());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToPolzovateli(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final String q = "insert into Пользователи(Роль, Логин, Пароль, ID_сотр) select ?, ?, ?, Сотрудники.ID "
                    + "from Сотрудники where Сотрудники.ФИО = ?";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField2().getText().isEmpty()
                    && !menu.getTextField3().getText().isEmpty()) {
                p.setString(1, (String) menu.getComboBox().getSelectedItem());
                p.setString(2, menu.getTextField2().getText());
                p.setString(3, menu.getTextField3().getText());
                p.setString(4, (String) menu.getComboBox1().getSelectedItem());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToPriemu(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Прием_на_работу(ID_сотр, ID_должн, ID_отдела, Ставка, Дата_приема, Дата_увольнения) "
                    + "select Сотрудники.ID, Должности.ID, Отделы.ID, ?, ?, ? from Сотрудники, Должности, Отделы "
                    + "where Сотрудники.ФИО = ? and Должности.Наименование = ? and Отделы.Наименование = ?";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField3().getText().isEmpty()
                    && !menu.getTextField4().getText().isEmpty()) {
                p.setString(1, menu.getTextField3().getText());
                Matcher matcher = AddToTables.PAT.matcher(menu.getTextField4().getText());
                if (matcher.find()) {
                    p.setString(2, menu.getTextField4().getText());
                } else {
                    this.exception = "Неверно указана Дата приема";
                    throw new Exception();
                }
                if (menu.getTextField5().getText().equals("")) {
                    p.setString(3, null);
                } else {
                    matcher = AddToTables.PAT.matcher(menu.getTextField5().getText());
                    if (matcher.find()) {
                        p.setString(3, menu.getTextField5().getText());
                    } else {
                        this.exception = "Неверно указана Дата увольнения";
                        throw new Exception();
                    }
                }
                p.setString(4, (String) menu.getComboBox1().getSelectedItem());
                p.setString(5, (String) menu.getComboBox().getSelectedItem());
                p.setString(6, (String) menu.getComboBox2().getSelectedItem());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
            menu.getTextField5().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToSotrudniki(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Сотрудники values(?, ?, ?)";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField().getText().isEmpty()
                    && !menu.getTextField1().getText().isEmpty()
                    && !menu.getTextField2().getText().isEmpty()) {
                p.setString(1, menu.getTextField().getText());
                p.setString(2, menu.getTextField1().getText());
                final Matcher matcher = AddToTables.PAT.matcher(menu.getTextField2().getText());
                if (matcher.find()) {
                    p.setString(1, menu.getTextField2().getText());
                } else {
                    this.exception = "Неверно указана Дата рождения";
                    throw new Exception();
                }
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToTabelya(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Табель(ID_приема, Дата, Кол_раб_дней, Кол_дней_отпуска, Кол_дней_бл) "
                    + "select ID, ?, ?, ?, ? from Прием_на_работу where dbo.Tabelya(ID) = ?";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField1().getText().isEmpty()
                    && !menu.getTextField2().getText().isEmpty()
                    && !menu.getTextField3().getText().isEmpty()
                    && !menu.getTextField4().getText().isEmpty()) {
                final Matcher matcher = AddToTables.PAT.matcher(menu.getTextField1().getText());
                if (matcher.find()) {
                    p.setString(1, menu.getTextField1().getText());
                } else {
                    this.exception = "Неверно указана Дата";
                    throw new Exception();
                }
                p.setString(2, menu.getTextField2().getText());
                p.setString(3, menu.getTextField3().getText());
                p.setString(4, menu.getTextField4().getText());
                p.setString(5, (String) menu.getComboBox1().getSelectedItem());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToTablNach(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Таблица_начислений(ID_видаН, ID_приема, Дата_назначения, Дата_отмены, Сумма) "
                    + "select Виды_начислений.ID, Прием_на_работу.ID, ?, ?, ? from Прием_на_работу, Виды_начислений "
                    + "where Наименование = ? and dbo.Tabelya(Прием_на_работу.ID) = ?";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField2().getText().isEmpty()
                    && !menu.getTextField4().getText().isEmpty()) {
                Matcher matcher = AddToTables.PAT.matcher(menu.getTextField2().getText());
                if (matcher.find()) {
                    p.setString(1, menu.getTextField2().getText());
                } else {
                    this.exception = "Неверно указана Дата назначения";
                    throw new Exception();
                }
                if (menu.getTextField3().getText().equals("")) {
                    p.setString(2, null);
                } else {
                    matcher = AddToTables.PAT.matcher(menu.getTextField3().getText());
                    if (matcher.find()) {
                        p.setString(2, menu.getTextField3().getText());
                    } else {
                        this.exception = "Неверно указана Дата отмены";
                        throw new Exception();
                    }
                }
                p.setString(3, menu.getTextField4().getText());
                p.setString(4, (String) menu.getComboBox1().getSelectedItem());
                p.setString(5, (String) menu.getComboBox().getSelectedItem());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToTablYderj(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Таблица_удержаний(ID_видаУ, ID_приема, Дата_назначения, Дата_отмены, Сумма) "
                    + "select Виды_удержаний.ID, Прием_на_работу.ID, ?, ?, ? from Прием_на_работу, Виды_удержаний "
                    + "where Наименование = ? and dbo.Tabelya(Прием_на_работу.ID) = ?";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField2().getText().isEmpty()
                    && !menu.getTextField4().getText().isEmpty()) {
                Matcher matcher = AddToTables.PAT.matcher(menu.getTextField2().getText());
                if (matcher.find()) {
                    p.setString(1, menu.getTextField2().getText());
                } else {
                    this.exception = "Неверно указана Дата назначения";
                    throw new Exception();
                }
                if (menu.getTextField3().getText().equals("")) {
                    p.setString(2, null);
                } else {
                    matcher = AddToTables.PAT.matcher(menu.getTextField3().getText());
                    if (matcher.find()) {
                        p.setString(2, menu.getTextField3().getText());
                    } else {
                        this.exception = "Неверно указана Дата отмены";
                        throw new Exception();
                    }
                }
                p.setString(3, menu.getTextField4().getText());
                p.setString(4, (String) menu.getComboBox1().getSelectedItem());
                p.setString(5, (String) menu.getComboBox().getSelectedItem());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToVidyNach(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Виды_начислений values(?)";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField().getText().isEmpty()) {
                p.setString(1, menu.getTextField().getText());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToVidyYderj(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Виды_удержаний values(?)";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField().getText().isEmpty()) {
                p.setString(1, menu.getTextField().getText());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void addToYderj(final Menu menu) {
        this.exception = "Нельзя вставить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(AddToTables.URL);
            final String q = "insert into Удержания(ID_видаУ, ID_табеля, Дата_удержания, Сумма) "
                    + "select Виды_удержаний.ID, Табель.ID, ?, ? from Табель, Виды_удержаний "
                    + "where Наименование = ? and dbo.NachYderj(Табель.ID) = ?";
            final PreparedStatement p = con.prepareStatement(q);
            if (!menu.getTextField2().getText().isEmpty()
                    && !menu.getTextField3().getText().isEmpty()) {
                final Matcher matcher = AddToTables.PAT.matcher(menu.getTextField2().getText());
                if (matcher.find()) {
                    p.setString(1, menu.getTextField2().getText());
                } else {
                    this.exception = "Неверно указана Дата удержания";
                    throw new Exception();
                }
                p.setString(2, menu.getTextField3().getText());
                p.setString(3, (String) menu.getComboBox1().getSelectedItem());
                p.setString(4, (String) menu.getComboBox().getSelectedItem());
            } else {
                this.exception = "Заполните все поля";
                throw new Exception();
            }
            p.executeUpdate();
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }
}
