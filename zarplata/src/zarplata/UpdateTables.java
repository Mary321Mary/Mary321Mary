package zarplata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class UpdateTables {
    static final String  URL       = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=master;integratedSecurity=true";
    static final Pattern PAT       = Pattern
            .compile("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
    private String       exception = "";

    public void updateDeti(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Дети set ФИО = ?, ID_сотр = Сотрудники.ID, Дата_рождения = ? from Сотрудники "
                    + "where Сотрудники.ФИО = ? and Дети.ID = " + value;
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

    public void updateDoljnosti(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Должности set Наименование = ? where ID = " + value;
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

    public void updateNach(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Начисления set ID_видаН = Виды_начислений.ID, ID_табеля = t.ID, "
                    + "Дата_начисления = ?, Сумма = ? from Начисления n, Виды_начислений, Табель t "
                    + "where Наименование = ? and dbo.NachYderj(t.ID) = ? and n.ID = " + value;
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

    public void updateOtdely(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Отделы set Наименование = ? where ID = " + value;
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

    public void updatePolzovateli(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Пользователи set Роль = ?, Логин = ?, Пароль = ?, ID_сотр = Сотрудники.ID from Сотрудники "
                    + "where Сотрудники.ФИО = ? and Пользователи.ID = " + value;
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

    public void updatePolzovateliLog(final Menu menu) {
        this.exception = "Нельзя совершить откат";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "exec restoreПользователи " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, this.exception);
        }
    }

    public void updatePriemu(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Прием_на_работу set ID_сотр = Сотрудники.ID, ID_должн = Должности.ID, "
                    + "ID_отдела = Отделы.ID, Ставка = ?, Дата_приема = ?, Дата_увольнения = ? from Сотрудники, Должности, "
                    + "Отделы where Сотрудники.ФИО = ? and Должности.Наименование = ? and Отделы.Наименование = ? and "
                    + "Прием_на_работу.ID = " + value;
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

    public void updateSotrudniki(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Сотрудники set ФИО = ?, Адрес = ?, Дата_рождения = ? where ID = "
                    + value;
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

    public void updateTabelya(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Табель set ID_приема = t.ID_приема, Дата = ?, Кол_раб_дней = ?, Кол_дней_отпуска = ?, "
                    + "Кол_дней_бл = ? from Табель t where dbo.Tabelya(ID_приема) = ? and t.ID = "
                    + value;
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

    public void updateTablNach(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Таблица_начислений set ID_видаН = Виды_начислений.ID, ID_приема = p.ID, "
                    + "Дата_назначения = ?, Дата_отмены = ?, Сумма = ? from Таблица_начислений t, Виды_начислений, "
                    + "Прием_на_работу p where Наименование = ? and dbo.Tabelya(p.ID) = ? and t.ID = "
                    + value;
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

    public void updateTablYderj(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Таблица_удержаний set ID_видаУ = Виды_удержаний.ID, ID_приема = p.ID, "
                    + "Дата_назначения = ?, Дата_отмены = ?, Сумма = ? from Таблица_удержаний t, Виды_удержаний, "
                    + "Прием_на_работу p where Наименование = ? and dbo.Tabelya(p.ID) = ? and t.ID = "
                    + value;
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

    public void updateVidyNach(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Виды_начислений set Наименование = ? where ID = " + value;
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

    public void updateVidyYderj(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Виды_удержаний set Наименование = ? where ID = " + value;
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

    public void updateYderj(final Menu menu) {
        this.exception = "Нельзя изменить";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(UpdateTables.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "update Удержания set ID_видаУ = Виды_удержаний.ID, ID_табеля = t.ID, "
                    + "Дата_удержания = ?, Сумма = ? from Удержания y, Виды_удержаний, Табель t "
                    + "where Наименование = ? and dbo.NachYderj(t.ID) = ? and y.ID = " + value;
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
