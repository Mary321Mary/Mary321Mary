package zarplata;

public class BuildTable {

    public void detiTable(final Menu menu) {
        menu.setTableName("Дети");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Дети");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("ФИО");
            menu.getLblNewLabel1().setText("Родитель");
            menu.getLblNewLabel2().setText("Дата рождения(гггг-мм-дд)");
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");

            menu.getComboBox1().setVisible(false);
            menu.getComboBox().setVisible(true);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(true);
            menu.getLblNewLabel2().setVisible(true);
            menu.getLblNewLabel3().setVisible(false);
            menu.getLblNewLabel4().setVisible(false);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(true);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(true);
            menu.getTextField3().setVisible(false);
            menu.getTextField4().setVisible(false);
            menu.getTextField5().setVisible(false);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void doljnostiTable(final Menu menu) {
        menu.setTableName("Должности");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Должности");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("Наименование");
            menu.getTextField().setText("");

            menu.getComboBox1().setVisible(false);
            menu.getComboBox().setVisible(false);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(false);
            menu.getLblNewLabel2().setVisible(false);
            menu.getLblNewLabel3().setVisible(false);
            menu.getLblNewLabel4().setVisible(false);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(true);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(false);
            menu.getTextField3().setVisible(false);
            menu.getTextField4().setVisible(false);
            menu.getTextField5().setVisible(false);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void nachTable(final Menu menu) {
        menu.setTableName("Начисления");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Начисления");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("Вид начисления");
            menu.getLblNewLabel1().setText("ФИО - Ставка - Дата табеля");
            menu.getLblNewLabel2().setText("Дата начисления(гггг-мм-дд)");
            menu.getLblNewLabel3().setText("Сумма");
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");

            menu.getComboBox1().setVisible(true);
            menu.getComboBox().setVisible(true);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(true);
            menu.getLblNewLabel2().setVisible(true);
            menu.getLblNewLabel3().setVisible(true);
            menu.getLblNewLabel4().setVisible(false);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(false);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(true);
            menu.getTextField3().setVisible(true);
            menu.getTextField4().setVisible(false);
            menu.getTextField5().setVisible(false);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void otdelyTable(final Menu menu) {
        menu.setTableName("Отделы");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Отделы");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("Наименование");
            menu.getTextField().setText("");

            menu.getComboBox1().setVisible(false);
            menu.getComboBox().setVisible(false);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(false);
            menu.getLblNewLabel2().setVisible(false);
            menu.getLblNewLabel3().setVisible(false);
            menu.getLblNewLabel4().setVisible(false);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(true);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(false);
            menu.getTextField3().setVisible(false);
            menu.getTextField4().setVisible(false);
            menu.getTextField5().setVisible(false);
            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void polzovateliLogTable(final Menu menu) {
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Протокол пользователей");

        menu.getComboBox1().setVisible(false);
        menu.getComboBox().setVisible(false);
        menu.getComboBox2().setVisible(false);
        menu.getLblNewLabel().setVisible(false);
        menu.getLblNewLabel1().setVisible(false);
        menu.getLblNewLabel2().setVisible(false);
        menu.getLblNewLabel3().setVisible(false);
        menu.getLblNewLabel4().setVisible(false);
        menu.getLblNewLabel5().setVisible(false);
        menu.getTextField().setVisible(false);
        menu.getTextField1().setVisible(false);
        menu.getTextField2().setVisible(false);
        menu.getTextField3().setVisible(false);
        menu.getTextField4().setVisible(false);
        menu.getTextField5().setVisible(false);

        menu.getButton().setVisible(false);
        menu.getButton1().setVisible(false);
        menu.getButton2().setVisible(false);
        menu.getButton3().setVisible(false);
        menu.getButton4().setVisible(true);
    }

    public void polzovateliTable(final Menu menu) {
        menu.setTableName("Пользователи");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Пользователи");

        menu.getLblNewLabel().setText("ФИО");
        menu.getLblNewLabel1().setText("Роль");
        menu.getLblNewLabel2().setText("Логин");
        menu.getLblNewLabel3().setText("Пароль");
        menu.getTextField().setText("");
        menu.getTextField1().setText("");
        menu.getTextField2().setText("");
        menu.getTextField3().setText("");

        menu.getComboBox1().setVisible(true);
        menu.getComboBox().setVisible(true);
        menu.getComboBox2().setVisible(false);
        menu.getLblNewLabel().setVisible(true);
        menu.getLblNewLabel1().setVisible(true);
        menu.getLblNewLabel2().setVisible(true);
        menu.getLblNewLabel3().setVisible(true);
        menu.getLblNewLabel4().setVisible(false);
        menu.getLblNewLabel5().setVisible(false);
        menu.getTextField().setVisible(false);
        menu.getTextField1().setVisible(false);
        menu.getTextField2().setVisible(true);
        menu.getTextField3().setVisible(true);
        menu.getTextField4().setVisible(false);
        menu.getTextField5().setVisible(false);

        menu.getButton().setVisible(true);
        menu.getButton1().setVisible(true);
        menu.getButton2().setVisible(true);
        menu.getButton3().setVisible(true);
        menu.getButton4().setVisible(false);
    }

    public void priemuTable(final Menu menu) {
        menu.setTableName("Приемы");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Приемы");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("ФИО");
            menu.getLblNewLabel1().setText("Должность");
            menu.getLblNewLabel2().setText("Отдел");
            menu.getLblNewLabel3().setText("Ставка");
            menu.getLblNewLabel4().setText("Дата приема(гггг-мм-дд)");
            menu.getLblNewLabel5().setText("Дата увольнения(гггг-мм-дд)");
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");
            menu.getTextField5().setText("");

            menu.getComboBox1().setVisible(true);
            menu.getComboBox().setVisible(true);
            menu.getComboBox2().setVisible(true);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(true);
            menu.getLblNewLabel2().setVisible(true);
            menu.getLblNewLabel3().setVisible(true);
            menu.getLblNewLabel4().setVisible(true);
            menu.getLblNewLabel5().setVisible(true);
            menu.getTextField().setVisible(false);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(false);
            menu.getTextField3().setVisible(true);
            menu.getTextField4().setVisible(true);
            menu.getTextField5().setVisible(true);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void sotrudnikiTable(final Menu menu) {
        menu.setTableName("Сотрудники");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Сотрудники");

        menu.getLblNewLabel().setText("ФИО");
        menu.getLblNewLabel1().setText("Адрес");
        menu.getLblNewLabel2().setText("Дата рождения(гггг-мм-дд)");
        menu.getTextField().setText("");
        menu.getTextField1().setText("");
        menu.getTextField2().setText("");

        menu.getComboBox1().setVisible(false);
        menu.getComboBox().setVisible(false);
        menu.getComboBox2().setVisible(false);
        menu.getLblNewLabel().setVisible(true);
        menu.getLblNewLabel1().setVisible(true);
        menu.getLblNewLabel2().setVisible(true);
        menu.getLblNewLabel3().setVisible(false);
        menu.getLblNewLabel4().setVisible(false);
        menu.getLblNewLabel5().setVisible(false);
        menu.getTextField().setVisible(true);
        menu.getTextField1().setVisible(true);
        menu.getTextField2().setVisible(true);
        menu.getTextField3().setVisible(false);
        menu.getTextField4().setVisible(false);
        menu.getTextField5().setVisible(false);

        menu.getButton().setVisible(true);
        menu.getButton1().setVisible(true);
        menu.getButton2().setVisible(true);
        menu.getButton3().setVisible(true);
        menu.getButton4().setVisible(false);
    }

    public void tabelTable(final Menu menu) {
        menu.setTableName("Табель");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Табель");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("ФИО - Ставка - Дата приема");
            menu.getLblNewLabel1().setText("Дата(гггг-мм-дд)");
            menu.getLblNewLabel2().setText("Кол раб дней");
            menu.getLblNewLabel3().setText("Кол дней отпуска");
            menu.getLblNewLabel4().setText("Кол дней бл");
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");

            menu.getComboBox1().setVisible(true);
            menu.getComboBox().setVisible(false);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(true);
            menu.getLblNewLabel2().setVisible(true);
            menu.getLblNewLabel3().setVisible(true);
            menu.getLblNewLabel4().setVisible(true);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(false);
            menu.getTextField1().setVisible(true);
            menu.getTextField2().setVisible(true);
            menu.getTextField3().setVisible(true);
            menu.getTextField4().setVisible(true);
            menu.getTextField5().setVisible(false);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void tablNachTable(final Menu menu) {
        menu.setTableName("Таблица начислений");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Таблица начислений");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("Вид начисления");
            menu.getLblNewLabel1().setText("ФИО - Ставка - Дата приема");
            menu.getLblNewLabel2().setText("Дата назначения(гггг-мм-дд)");
            menu.getLblNewLabel3().setText("Дата отмены(гггг-мм-дд)");
            menu.getLblNewLabel4().setText("Сумма");
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");

            menu.getComboBox1().setVisible(true);
            menu.getComboBox().setVisible(true);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(true);
            menu.getLblNewLabel2().setVisible(true);
            menu.getLblNewLabel3().setVisible(true);
            menu.getLblNewLabel4().setVisible(true);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(false);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(true);
            menu.getTextField3().setVisible(true);
            menu.getTextField4().setVisible(true);
            menu.getTextField5().setVisible(false);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void tablYderjTable(final Menu menu) {
        menu.setTableName("Таблица удержаний");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Таблица удержаний");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("Вид удержаний");
            menu.getLblNewLabel1().setText("ФИО - Ставка - Дата приема");
            menu.getLblNewLabel2().setText("Дата назначения(гггг-мм-дд)");
            menu.getLblNewLabel3().setText("Дата отмены(гггг-мм-дд)");
            menu.getLblNewLabel4().setText("Сумма");
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");
            menu.getTextField4().setText("");

            menu.getComboBox1().setVisible(true);
            menu.getComboBox().setVisible(true);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(true);
            menu.getLblNewLabel2().setVisible(true);
            menu.getLblNewLabel3().setVisible(true);
            menu.getLblNewLabel4().setVisible(true);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(false);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(true);
            menu.getTextField3().setVisible(true);
            menu.getTextField4().setVisible(true);
            menu.getTextField5().setVisible(false);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void vidyNachTable(final Menu menu) {
        menu.setTableName("Виды начислений");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Виды начислений");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("Наименование");
            menu.getTextField().setText("");

            menu.getComboBox1().setVisible(false);
            menu.getComboBox().setVisible(false);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(false);
            menu.getLblNewLabel2().setVisible(false);
            menu.getLblNewLabel3().setVisible(false);
            menu.getLblNewLabel4().setVisible(false);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(true);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(false);
            menu.getTextField3().setVisible(false);
            menu.getTextField4().setVisible(false);
            menu.getTextField5().setVisible(false);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void vidyYderjTable(final Menu menu) {
        menu.setTableName("Виды удержаний");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Виды удержаний");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("Наименование");
            menu.getTextField().setText("");

            menu.getComboBox1().setVisible(false);
            menu.getComboBox().setVisible(false);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(false);
            menu.getLblNewLabel2().setVisible(false);
            menu.getLblNewLabel3().setVisible(false);
            menu.getLblNewLabel4().setVisible(false);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(true);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(false);
            menu.getTextField3().setVisible(false);
            menu.getTextField4().setVisible(false);
            menu.getTextField5().setVisible(false);
            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }

    public void yderjTable(final Menu menu) {
        menu.setTableName("Удержания");
        menu.getLblNewLabel6().setVisible(true);
        menu.getLblNewLabel6().setText("Удержания");

        if (!Menu.role.equals("user")) {
            menu.getLblNewLabel().setText("Вид удержаний");
            menu.getLblNewLabel1().setText("ФИО - Ставка - Дата табеля");
            menu.getLblNewLabel2().setText("Дата удержания(гггг-мм-дд)");
            menu.getLblNewLabel3().setText("Сумма");
            menu.getTextField().setText("");
            menu.getTextField1().setText("");
            menu.getTextField2().setText("");
            menu.getTextField3().setText("");

            menu.getComboBox1().setVisible(true);
            menu.getComboBox().setVisible(true);
            menu.getComboBox2().setVisible(false);
            menu.getLblNewLabel().setVisible(true);
            menu.getLblNewLabel1().setVisible(true);
            menu.getLblNewLabel2().setVisible(true);
            menu.getLblNewLabel3().setVisible(true);
            menu.getLblNewLabel4().setVisible(false);
            menu.getLblNewLabel5().setVisible(false);
            menu.getTextField().setVisible(false);
            menu.getTextField1().setVisible(false);
            menu.getTextField2().setVisible(true);
            menu.getTextField3().setVisible(true);
            menu.getTextField4().setVisible(false);
            menu.getTextField5().setVisible(false);

            menu.getButton().setVisible(true);
            menu.getButton1().setVisible(true);
            menu.getButton2().setVisible(true);
            menu.getButton3().setVisible(true);
            menu.getButton4().setVisible(false);
        }
    }
}
