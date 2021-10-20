package zarplata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class DeleteRow {
    static final String URL = "jdbc:sqlserver://User-PC\\lacalhost:1433;databaseName=master;integratedSecurity=true";

    public void deleteFromDeti(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Дети where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
            menu.getTextField2().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromDoljnosti(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Должности where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromNach(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Начисления where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromOtdely(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Отделы where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromPolzovateli(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Пользователи where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromPriemu(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Прием_на_работу where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
            menu.getTextField5().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromSotrudniki(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Сотрудники where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromTabelya(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            System.out.print(value);
            final String q = "delete from Табель where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromTablNach(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Таблица_начислений where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromTablYderj(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Таблица_удержаний where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromVidyNach(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Виды_начислений where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromVidyYderj(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Виды_удержаний where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }

    public void deleteFromYderj(final Menu menu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(DeleteRow.URL);
            final int value = menu.getArrayOfID().get(menu.getTable().getSelectedRow());
            final String q = "delete from Удержания where ID = " + value;
            final PreparedStatement p = con.prepareStatement(q);
            p.executeUpdate();
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Нельзя удалить");
        }
    }
}
