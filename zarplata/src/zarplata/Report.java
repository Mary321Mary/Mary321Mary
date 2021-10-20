package zarplata;

import java.awt.Desktop;
import java.io.File;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Report {
    String[] month = new String[] {"", "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
            "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    public void reportMonth(final ReportForm report) {
        try (PrintStream out = new PrintStream("report2.doc")) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final int item = report.getComboBox().getSelectedIndex() + 1;
            final String q = "exec ТабеляМесяц " + item + ", " + report.getTextField().getText();
            final Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery(q);
            out.printf("Месяц: %s\n\n", this.month[item]);
            out.printf("               Отдел     Начислено       Удержано               Итого\n\n");
            while (rs.next()) {
                out.printf("%20s %12.2f %14.2f %20.2f\n", rs.getString("Наименование"),
                        rs.getDouble("Начислено"), rs.getDouble("Удержано"), rs.getDouble("Итого"));
            }
            rs.close();
            Desktop desk = null;
            if (Desktop.isDesktopSupported()) {
                desk = Desktop.getDesktop();
                desk.open(new File("report2.doc"));
            }
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void reportSotr(final ReportForm report) {
        try (PrintStream out = new PrintStream("report1.doc")) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            final int item = report.getComboBox().getSelectedIndex() + 1;
            final String q = "exec ТабеляСотрудн " + Menu.id_sotr + ", " + item + ", "
                    + report.getTextField().getText();
            final Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                out.printf("ФИО                     %s\n", rs.getString("ФИО"));
                out.printf("Месяц                   %s\n", rs.getString("Месяц"));
                out.printf("Количество рабочих дней %d\n", rs.getInt("Кол_раб_дней"));
                out.printf("Количество дней отпуска %d\n", rs.getInt("Кол_дней_отпуска"));
                out.printf("Количество дней б/л     %d\n", rs.getInt("Кол_дней_бл"));
                out.printf("Начислено               %.2f\n", rs.getDouble("Начислено"));
                out.printf("Удержано                %.2f\n", rs.getDouble("Удержано"));
                out.println();
                out.printf("Итого                   %.2f\n", rs.getDouble("Итого"));
            }
            rs.close();
            Desktop desk = null;
            if (Desktop.isDesktopSupported()) {
                desk = Desktop.getDesktop();
                desk.open(new File("report1.doc"));
            }
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка формирования отчета");
        }
    }

    public void reportYear(final ReportForm report) {
        try (PrintStream out = new PrintStream("report3.doc")) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection con = DriverManager.getConnection(ShowTables.URL);
            report.getComboBox().getSelectedIndex();
            final String q = "exec ИтоговыйОтчет " + report.getTextField().getText();
            final Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery(q);
            out.printf("Год: %s\n\n", report.getTextField().getText());
            out.printf(
                    "               Отдел     Месяц     Начислено       Удержано         Итого\n\n");
            while (rs.next()) {
                final String res = rs.getString("Наименование");
                if (!res.equals("Итого")) {
                    out.printf("%20s %10s %12.2f %14.2f %13.2f\n", res, rs.getString("Месяц"),
                            rs.getDouble("Начислено"), rs.getDouble("Удержано"),
                            rs.getDouble("Итого"));
                } else {
                    out.printf("%20s %23.2f %14.2f %13.2f\n", res, rs.getDouble("Начислено"),
                            rs.getDouble("Удержано"), rs.getDouble("Итого"));
                }
            }
            rs.close();
            Desktop desk = null;
            if (Desktop.isDesktopSupported()) {
                desk = Desktop.getDesktop();
                desk.open(new File("report3.doc"));
            }
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
