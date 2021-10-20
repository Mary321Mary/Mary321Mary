package zarplata;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	static SignIn                   signIn       = new SignIn();
    static String                   role;
    static String                   id_sotr;

    private final JPanel            contentPane;
    final JMenuBar                  menuBar      = new JMenuBar();
    private JTable                  table        = new JTable();
    private JTextField              textField    = new JTextField();
    private JTextField              textField1   = new JTextField();
    private JTextField              textField2   = new JTextField();
    private JTextField              textField3   = new JTextField();
    private JTextField              textField4   = new JTextField();
    private JTextField              textField5   = new JTextField();
    private JLabel                  lblNewLabel  = new JLabel();
    private JLabel                  lblNewLabel1 = new JLabel();
    private JLabel                  lblNewLabel2 = new JLabel();
    private JLabel                  lblNewLabel3 = new JLabel();
    private JLabel                  lblNewLabel4 = new JLabel();
    private JLabel                  lblNewLabel5 = new JLabel();
    private JLabel                  lblNewLabel6 = new JLabel();
    private JScrollPane             scrollPane;
    private final JComboBox<String> comboBox     = new JComboBox<>();
    private final JComboBox<String> comboBox1    = new JComboBox<>();
    private final JComboBox<String> comboBox2    = new JComboBox<>();
    private final JButton           button;
    private final JButton           button1;
    private final JButton           button2;
    private final JButton           button3;
    private final JButton           button4;
    private List<Integer>           arrayOfID    = new ArrayList<>();
    private String                  tableName;
    private final BuildTable        buildTable   = new BuildTable();
    private final ShowTables        showTables   = new ShowTables();
    private final AddToTables       addToTables  = new AddToTables();
    private final UpdateTables      updateTables = new UpdateTables();
    private final DeleteRow         deleteRow    = new DeleteRow();
    private final Search            search       = new Search();
    private final ReportForm        reportForm   = new ReportForm();

    public Menu() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1399, 680);

        this.setJMenuBar(this.menuBar);

        final JMenu menu = new JMenu("Работа с таблицами");
        menu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.menuBar.add(menu);

        if (!Menu.role.equals("user")) {
            final JMenuItem menuItem1 = new JMenuItem("Сотрудники");
            menuItem1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItem1.addActionListener(arg0 -> {
                this.buildTable.sotrudnikiTable(this);
                this.setArrayOfID(this.showTables.showSotrudniki(this));
            });
            menu.add(menuItem1);
        }

        final JMenuItem menuItem = new JMenuItem("Приемы на работу");
        menuItem.addActionListener(arg0 -> {
            this.buildTable.priemuTable(this);
            this.setArrayOfID(this.showTables.showPriemu(this));
        });
        menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem);

        final JMenuItem menuItem11 = new JMenuItem("Табель");
        menuItem11.addActionListener(arg0 -> {
            this.buildTable.tabelTable(this);
            this.setArrayOfID(this.showTables.showTabelya(this));
        });
        menuItem11.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem11);

        final JMenuItem menuItem2 = new JMenuItem("Таблица начислений");
        menuItem2.addActionListener(arg0 -> {
            this.buildTable.tablNachTable(this);
            this.setArrayOfID(this.showTables.showTablNach(this));
        });
        menuItem2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem2);

        final JMenuItem menuItem3 = new JMenuItem("Таблица удержаний");
        menuItem3.addActionListener(arg0 -> {
            this.buildTable.tablYderjTable(this);
            this.setArrayOfID(this.showTables.showTablYderj(this));
        });
        menuItem3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem3);

        final JMenuItem menuItem4 = new JMenuItem("Начисления");
        menuItem4.addActionListener(arg0 -> {
            this.buildTable.nachTable(this);
            this.setArrayOfID(this.showTables.showNach(this));
        });
        menuItem4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem4);

        final JMenuItem menuItem5 = new JMenuItem("Удержания");
        menuItem5.addActionListener(arg0 -> {
            this.buildTable.yderjTable(this);
            this.setArrayOfID(this.showTables.showYderj(this));
        });
        menuItem5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem5);

        final JMenuItem menuItem6 = new JMenuItem("Виды начислений");
        menuItem6.addActionListener(arg0 -> {
            this.buildTable.vidyNachTable(this);
            this.setArrayOfID(this.showTables.showVidyNach(this));
        });
        menuItem6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem6);

        final JMenuItem menuItem7 = new JMenuItem("Виды удержаний");
        menuItem7.addActionListener(arg0 -> {
            this.buildTable.vidyYderjTable(this);
            this.setArrayOfID(this.showTables.showVidyYderj(this));
        });
        menuItem7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem7);

        final JMenuItem menuItem8 = new JMenuItem("Должности");
        menuItem8.addActionListener(arg0 -> {
            this.buildTable.doljnostiTable(this);
            this.setArrayOfID(this.showTables.showDoljnosti(this));
        });
        menuItem8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem8);

        final JMenuItem menuItem9 = new JMenuItem("Отделы");
        menuItem9.addActionListener(arg0 -> {
            this.buildTable.otdelyTable(this);
            this.setArrayOfID(this.showTables.showOtdely(this));
        });
        menuItem9.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem9);

        final JMenuItem menuItem10 = new JMenuItem("Дети");
        menuItem10.addActionListener(arg0 -> {
            this.buildTable.detiTable(this);
            this.setArrayOfID(this.showTables.showDeti(this));
        });
        menuItem10.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem10);

        if (Menu.role.equals("admin")) {
            final JMenuItem menuItem13 = new JMenuItem("Пользователи");
            menuItem13.addActionListener(arg0 -> {
                this.buildTable.polzovateliTable(this);
                this.setArrayOfID(this.showTables.showPolzovateli(this));
            });
            menuItem13.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menu.add(menuItem13);

            final JMenuItem menuItem14 = new JMenuItem("Протокол пользователей");
            menuItem14.addActionListener(arg0 -> {
                this.buildTable.polzovateliLogTable(this);
                this.setArrayOfID(this.showTables.showPolzovateliLog(this));
            });
            menuItem14.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menu.add(menuItem14);
        }

        if (!Menu.role.equals("admin")) {
            final JMenu mnNewMenu = new JMenu("Отчеты");
            mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            this.menuBar.add(mnNewMenu);

            String name = "";
            switch (Menu.role) {
                case "user":
                    name = "Табель";
                    break;
                case "accountant":
                    name = "Итого за месяц";
                    break;
            }
            final JMenuItem menuItem12 = new JMenuItem(name);
            menuItem12.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItem12.addActionListener(arg0 -> {
                this.reportForm.getLblNewLabel().setText("Год табеля");
                this.reportForm.getLblNewLabel1().setText("Месяц табеля");
                this.reportForm.getLblNewLabel1().setVisible(true);
                this.reportForm.getComboBox().setVisible(true);
                ReportForm.menu = this;
                switch (Menu.role) {
                    case "user":
                        this.reportForm.setRepQ("Табель");
                        break;
                    case "accountant":
                        this.reportForm.setRepQ("Месяц");
                        break;
                }
                this.reportForm.setVisible(true);
            });
            mnNewMenu.add(menuItem12);

            if (Menu.role.equals("accountant")) {
                final JMenuItem menuItem13 = new JMenuItem("Итого за год");
                menuItem13.addActionListener(arg0 -> {
                    this.reportForm.getLblNewLabel().setText("Год");
                    this.reportForm.getLblNewLabel1().setVisible(false);
                    this.reportForm.getComboBox().setVisible(false);
                    ReportForm.menu = this;
                    this.reportForm.setRepQ("Год");
                    this.reportForm.setVisible(true);
                });
                menuItem13.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                mnNewMenu.add(menuItem13);
            }
        }

        this.contentPane = new JPanel();
        this.getContentPane().setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.getContentPane());
        this.getContentPane().setLayout(null);

        this.setLblNewLabel(new JLabel("New label"));
        this.getLblNewLabel().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.getLblNewLabel());
        this.getLblNewLabel().setVisible(false);

        this.setLblNewLabel1(new JLabel("New label"));
        this.getLblNewLabel1().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.getLblNewLabel1());
        this.getLblNewLabel1().setVisible(false);

        this.setLblNewLabel2(new JLabel("New label"));
        this.getLblNewLabel2().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.getLblNewLabel2());
        this.getLblNewLabel2().setVisible(false);

        this.lblNewLabel3 = new JLabel("New label");
        this.lblNewLabel3.setBounds(22, 258, 342, 30);
        this.lblNewLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.lblNewLabel3);
        this.lblNewLabel3.setVisible(false);

        this.lblNewLabel4 = new JLabel("New label");
        this.lblNewLabel4.setBounds(22, 332, 342, 30);
        this.lblNewLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.lblNewLabel4);
        this.lblNewLabel4.setVisible(false);

        this.lblNewLabel5 = new JLabel("New label");
        this.lblNewLabel5.setBounds(22, 404, 342, 30);
        this.lblNewLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.lblNewLabel5);
        this.lblNewLabel5.setVisible(false);

        this.setTextField(new JTextField());
        this.getTextField().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.getTextField());
        this.getTextField().setColumns(10);
        this.getTextField().setVisible(false);

        this.setTextField1(new JTextField());
        this.getTextField1().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getTextField1().setColumns(10);
        this.getContentPane().add(this.getTextField1());
        this.getTextField1().setVisible(false);

        this.setTextField2(new JTextField());
        this.getTextField2().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getTextField2().setColumns(10);
        this.getContentPane().add(this.getTextField2());
        this.getTextField2().setVisible(false);

        this.textField3 = new JTextField();
        this.textField3.setBounds(12, 289, 352, 30);
        this.textField3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField3.setColumns(10);
        this.getContentPane().add(this.textField3);
        this.textField3.setVisible(false);

        this.textField4 = new JTextField();
        this.textField4.setBounds(12, 361, 352, 30);
        this.textField4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField4.setColumns(10);
        this.getContentPane().add(this.textField4);
        this.textField4.setVisible(false);

        this.textField5 = new JTextField();
        this.textField5.setBounds(12, 436, 352, 30);
        this.textField5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField5.setColumns(10);
        this.getContentPane().add(this.textField5);
        this.textField5.setVisible(false);

        this.button = new JButton("Добавить");
        this.button.addActionListener(arg0 -> {
            switch (this.tableName) {
                case "Сотрудники":
                    this.addToTables.addToSotrudniki(this);
                    this.setArrayOfID(this.showTables.showSotrudniki(this));
                    break;
                case "Приемы":
                    this.addToTables.addToPriemu(this);
                    this.setArrayOfID(this.showTables.showPriemu(this));
                    break;
                case "Табель":
                    this.addToTables.addToTabelya(this);
                    this.setArrayOfID(this.showTables.showTabelya(this));
                    break;
                case "Таблица начислений":
                    this.addToTables.addToTablNach(this);
                    this.setArrayOfID(this.showTables.showTablNach(this));
                    break;
                case "Таблица удержаний":
                    this.addToTables.addToTablYderj(this);
                    this.setArrayOfID(this.showTables.showTablYderj(this));
                    break;
                case "Начисления":
                    this.addToTables.addToNach(this);
                    this.setArrayOfID(this.showTables.showNach(this));
                    break;
                case "Удержания":
                    this.addToTables.addToYderj(this);
                    this.setArrayOfID(this.showTables.showYderj(this));
                    break;
                case "Виды начислений":
                    this.addToTables.addToVidyNach(this);
                    this.setArrayOfID(this.showTables.showVidyNach(this));
                    break;
                case "Виды удержаний":
                    this.addToTables.addToVidyYderj(this);
                    this.setArrayOfID(this.showTables.showVidyYderj(this));
                    break;
                case "Должности":
                    this.addToTables.addToDoljnosti(this);
                    this.setArrayOfID(this.showTables.showDoljnosti(this));
                    break;
                case "Отделы":
                    this.addToTables.addToOtdely(this);
                    this.setArrayOfID(this.showTables.showOtdely(this));
                    break;
                case "Дети":
                    this.addToTables.addToDeti(this);
                    this.setArrayOfID(this.showTables.showDeti(this));
                    break;
                case "Пользователи":
                    this.addToTables.addToPolzovateli(this);
                    this.setArrayOfID(this.showTables.showPolzovateli(this));
                    break;
            }
        });
        this.getButton().setBounds(12, 485, 220, 30);
        this.getButton().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.getButton());
        this.getButton().setVisible(false);

        this.button1 = new JButton("Изменить запись");
        this.button1.addActionListener(arg0 -> {
            switch (this.tableName) {
                case "Сотрудники":
                    this.updateTables.updateSotrudniki(this);
                    this.setArrayOfID(this.showTables.showSotrudniki(this));
                    break;
                case "Приемы":
                    this.updateTables.updatePriemu(this);
                    this.setArrayOfID(this.showTables.showPriemu(this));
                    break;
                case "Табель":
                    this.updateTables.updateTabelya(this);
                    this.setArrayOfID(this.showTables.showTabelya(this));
                    break;
                case "Таблица начислений":
                    this.updateTables.updateTablNach(this);
                    this.setArrayOfID(this.showTables.showTablNach(this));
                    break;
                case "Таблица удержаний":
                    this.updateTables.updateTablYderj(this);
                    this.setArrayOfID(this.showTables.showTablYderj(this));
                    break;
                case "Начисления":
                    this.updateTables.updateNach(this);
                    this.setArrayOfID(this.showTables.showNach(this));
                    break;
                case "Удержания":
                    this.updateTables.updateYderj(this);
                    this.setArrayOfID(this.showTables.showYderj(this));
                    break;
                case "Виды начислений":
                    this.updateTables.updateVidyNach(this);
                    this.setArrayOfID(this.showTables.showVidyNach(this));
                    break;
                case "Виды удержаний":
                    this.updateTables.updateVidyYderj(this);
                    this.setArrayOfID(this.showTables.showVidyYderj(this));
                    break;
                case "Должности":
                    this.updateTables.updateDoljnosti(this);
                    this.setArrayOfID(this.showTables.showDoljnosti(this));
                    break;
                case "Отделы":
                    this.updateTables.updateOtdely(this);
                    this.setArrayOfID(this.showTables.showOtdely(this));
                    break;
                case "Дети":
                    this.updateTables.updateDeti(this);
                    this.setArrayOfID(this.showTables.showDeti(this));
                    break;
                case "Пользователи":
                    this.updateTables.updatePolzovateli(this);
                    this.setArrayOfID(this.showTables.showPolzovateli(this));
                    break;
            }
        });
        this.getButton1().setBounds(12, 523, 220, 30);
        this.getButton1().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.getButton1());
        this.getButton1().setVisible(false);

        this.button2 = new JButton("Удалить");
        this.button2.addActionListener(arg0 -> {
            switch (this.tableName) {
                case "Сотрудники":
                    this.deleteRow.deleteFromSotrudniki(this);
                    this.setArrayOfID(this.showTables.showSotrudniki(this));
                    break;
                case "Приемы":
                    this.deleteRow.deleteFromPriemu(this);
                    this.setArrayOfID(this.showTables.showPriemu(this));
                    break;
                case "Табель":
                    this.deleteRow.deleteFromTabelya(this);
                    this.setArrayOfID(this.showTables.showTabelya(this));
                    break;
                case "Таблица начислений":
                    this.deleteRow.deleteFromTablNach(this);
                    this.setArrayOfID(this.showTables.showTablNach(this));
                    break;
                case "Таблица удержаний":
                    this.deleteRow.deleteFromTablYderj(this);
                    this.setArrayOfID(this.showTables.showTablYderj(this));
                    break;
                case "Начисления":
                    this.deleteRow.deleteFromNach(this);
                    this.setArrayOfID(this.showTables.showNach(this));
                    break;
                case "Удержания":
                    this.deleteRow.deleteFromYderj(this);
                    this.setArrayOfID(this.showTables.showYderj(this));
                    break;
                case "Виды начислений":
                    this.deleteRow.deleteFromVidyNach(this);
                    this.setArrayOfID(this.showTables.showVidyNach(this));
                    break;
                case "Виды удержаний":
                    this.deleteRow.deleteFromVidyYderj(this);
                    this.setArrayOfID(this.showTables.showVidyYderj(this));
                    break;
                case "Должности":
                    this.deleteRow.deleteFromDoljnosti(this);
                    this.setArrayOfID(this.showTables.showDoljnosti(this));
                    break;
                case "Отделы":
                    this.deleteRow.deleteFromOtdely(this);
                    this.setArrayOfID(this.showTables.showOtdely(this));
                    break;
                case "Дети":
                    this.deleteRow.deleteFromDeti(this);
                    this.setArrayOfID(this.showTables.showDeti(this));
                    break;
                case "Пользователи":
                    this.deleteRow.deleteFromPolzovateli(this);
                    this.setArrayOfID(this.showTables.showPolzovateli(this));
                    break;
            }
        });
        this.getButton2().setBounds(12, 561, 220, 30);
        this.getButton2().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.getContentPane().add(this.getButton2());
        this.getButton2().setVisible(false);

        this.table = new JTable();
        this.table.setColumnSelectionAllowed(true);

        this.setScrollPane(new JScrollPane());
        this.getScrollPane().setVisible(false);

        this.button3 = new JButton("Обновить \r\nтаблицу");
        this.button3.addActionListener(arg0 -> {
            switch (this.tableName) {
                case "Сотрудники":
                    this.setArrayOfID(this.showTables.showSotrudniki(this));
                    break;
                case "Приемы":
                    this.setArrayOfID(this.showTables.showPriemu(this));
                    break;
                case "Табель":
                    this.setArrayOfID(this.showTables.showTabelya(this));
                    break;
                case "Таблица начислений":
                    this.setArrayOfID(this.showTables.showTablNach(this));
                    break;
                case "Таблица удержаний":
                    this.setArrayOfID(this.showTables.showTablYderj(this));
                    break;
                case "Начисления":
                    this.setArrayOfID(this.showTables.showNach(this));
                    break;
                case "Удержания":
                    this.setArrayOfID(this.showTables.showYderj(this));
                    break;
                case "Виды начислений":
                    this.setArrayOfID(this.showTables.showVidyNach(this));
                    break;
                case "Виды удержаний":
                    this.setArrayOfID(this.showTables.showVidyYderj(this));
                    break;
                case "Должности":
                    this.setArrayOfID(this.showTables.showDoljnosti(this));
                    break;
                case "Отделы":
                    this.setArrayOfID(this.showTables.showOtdely(this));
                    break;
                case "Дети":
                    this.setArrayOfID(this.showTables.showDeti(this));
                    break;
                case "Пользователи":
                    this.setArrayOfID(this.showTables.showPolzovateli(this));
                    break;
            }
        });
        this.button3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.button3.setBounds(386, 511, 220, 30);
        this.button3.setVisible(false);
        this.contentPane.add(this.button3);

        this.button4 = new JButton("Откат таблицы");
        this.button4.addActionListener(arg0 -> {
            this.updateTables.updatePolzovateliLog(this);
            this.setArrayOfID(this.showTables.showPolzovateliLog(this));
        });
        this.button4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.button4.setBounds(386, 554, 220, 30);
        this.button4.setVisible(false);
        this.contentPane.add(this.button4);
        this.getScrollPane().setBounds(376, 56, 990, 442);
        this.contentPane.add(this.getScrollPane());

        this.getScrollPane().setViewportView(this.table);

        this.lblNewLabel6 = new JLabel("New label");
        this.lblNewLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.lblNewLabel6.setBounds(743, 12, 252, 30);
        this.lblNewLabel6.setVisible(false);
        this.contentPane.add(this.lblNewLabel6);

        final JButton btnNewButton = new JButton("Сменить пользователя");
        btnNewButton.addActionListener(arg0 -> {
            this.setVisible(false);
            Menu.signIn.setVisible(true);
        });
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnNewButton.setBounds(1117, 12, 252, 30);
        this.contentPane.add(btnNewButton);

        this.comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.comboBox.setBounds(12, 144, 352, 30);
        this.comboBox.setVisible(false);
        this.contentPane.add(this.comboBox);

        this.comboBox1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.comboBox1.setBounds(12, 72, 352, 30);
        this.comboBox1.setVisible(false);
        this.contentPane.add(this.comboBox1);

        this.comboBox2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.comboBox2.setBounds(12, 215, 352, 29);
        this.comboBox2.setVisible(false);
        this.contentPane.add(this.comboBox2);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Menu.role = args[0];
                Menu.id_sotr = args[1];
                final Menu frame = new Menu();
                if (!Menu.role.equals("user")) {
                    frame.init();
                }
                frame.setVisible(true);
            } catch (final Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        });
    }

    public List<Integer> getArrayOfID() {
        return this.arrayOfID;
    }
    
    public BuildTable getBuildTable() {
        return this.buildTable;
    }

    public JButton getButton() {
        return this.button;
    }

    public JButton getButton1() {
        return this.button1;
    }

    public JButton getButton2() {
        return this.button2;
    }

    public JButton getButton3() {
        return this.button3;
    }

    /**
     * @return the button4
     */
    public JButton getButton4() {
        return this.button4;
    }

    public JComboBox<String> getComboBox() {
        return this.comboBox;
    }

    /**
     * @return the comboBox1
     */
    public JComboBox<String> getComboBox1() {
        return this.comboBox1;
    }

    /**
     * @return the comboBox2
     */
    public JComboBox<String> getComboBox2() {
        return this.comboBox2;
    }

    @Override
    public JPanel getContentPane() {
        return this.contentPane;
    }

    public JLabel getLblNewLabel() {
        return this.lblNewLabel;
    }

    public JLabel getLblNewLabel1() {
        return this.lblNewLabel1;
    }

    public JLabel getLblNewLabel2() {
        return this.lblNewLabel2;
    }

    public JLabel getLblNewLabel3() {
        return this.lblNewLabel3;
    }

    public JLabel getLblNewLabel4() {
        return this.lblNewLabel4;
    }

    public JLabel getLblNewLabel5() {
        return this.lblNewLabel5;
    }

    public JLabel getLblNewLabel6() {
        return this.lblNewLabel6;
    }

    public ReportForm getReportForm() {
        return this.reportForm;
    }

    public JScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public Search getSearch() {
        return this.search;
    }

    public JTable getTable() {
        return this.table;
    }

    public String getTableName() {
        return this.tableName;
    }

    public JTextField getTextField() {
        return this.textField;
    }

    public JTextField getTextField1() {
        return this.textField1;
    }

    public JTextField getTextField2() {
        return this.textField2;
    }

    public JTextField getTextField3() {
        return this.textField3;
    }

    public JTextField getTextField4() {
        return this.textField4;
    }

    public JTextField getTextField5() {
        return this.textField5;
    }

    public void init() {
        final JMenu menu2 = new JMenu("Поиск");
        menu2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.menuBar.add(menu2);

        if (Menu.role.equals("accountant")) {
            final JMenu menuSub2 = new JMenu("Приемы на работу");
            menuSub2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menu2.add(menuSub2);

            final JMenuItem menuItemSec2 = new JMenuItem("По ФИО");
            menuItemSec2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec2.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("ФИО");
                this.search.setTableName("ПриемыФио");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menuSub2.add(menuItemSec2);

            final JMenuItem menuItemSec3 = new JMenuItem("По должности");
            menuItemSec3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec3.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("Должность");
                this.search.setTableName("ПриемыДолжн");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menuSub2.add(menuItemSec3);

            final JMenuItem menuItemSec4 = new JMenuItem("По отделу");
            menuItemSec4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec4.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("Отдел");
                this.search.setTableName("ПриемыОтдел");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menuSub2.add(menuItemSec4);

            final JMenuItem menuItemSec1 = new JMenuItem("Табель");
            menuItemSec1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec1.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("ФИО");
                this.search.setTableName("Табель");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menu2.add(menuItemSec1);

            final JMenuItem menuItemSec5 = new JMenuItem("Таблица начислений");
            menuItemSec5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec5.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("ФИО");
                this.search.setTableName("Табл нач");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menu2.add(menuItemSec5);

            final JMenuItem menuItemSec6 = new JMenuItem("Таблица удержаний");
            menuItemSec6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec6.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("ФИО");
                this.search.setTableName("Табл уд");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menu2.add(menuItemSec6);

            final JMenuItem menuItemSec7 = new JMenuItem("Начисления");
            menuItemSec7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec7.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("ФИО");
                this.search.setTableName("Начисл");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menu2.add(menuItemSec7);

            final JMenuItem menuItemSec8 = new JMenuItem("Удержания");
            menuItemSec8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec8.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("ФИО");
                this.search.setTableName("Удерж");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menu2.add(menuItemSec8);

            final JMenuItem menuItemSec9 = new JMenuItem("Дети");
            menuItemSec9.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec9.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("ФИО сотрудника (родителя)");
                this.search.setTableName("Дети");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menu2.add(menuItemSec9);
        } else {
            final JMenu menuSub2 = new JMenu("Пользователи");
            menuSub2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menu2.add(menuSub2);

            final JMenuItem menuItemSec2 = new JMenuItem("По ФИО");
            menuItemSec2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec2.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("ФИО");
                this.search.setTableName("ПользователиФио");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(true);
                this.search.getComboBox().setVisible(false);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menuSub2.add(menuItemSec2);

            final JMenuItem menuItemSec3 = new JMenuItem("По роли");
            menuItemSec3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            menuItemSec3.addActionListener(arg0 -> {
                this.search.getLblNewLabel().setText("Роль");
                this.search.setTableName("ПользователиРоль");
                this.search.getTextField().setText("");
                this.search.getTextField().setVisible(false);
                this.search.getComboBox().setVisible(true);
                Search.menu = this;
                this.search.setVisible(true);
            });
            menuSub2.add(menuItemSec3);
        }
    }

    public void setArrayOfID(final List<Integer> arrayOfID) {
        this.arrayOfID = arrayOfID;
    }

    public void setLblNewLabel(final JLabel lblNewLabel) {
        this.lblNewLabel = lblNewLabel;
        lblNewLabel.setBounds(22, 40, 342, 30);
    }

    public void setLblNewLabel1(final JLabel lblNewLabel1) {
        this.lblNewLabel1 = lblNewLabel1;
        lblNewLabel1.setBounds(22, 115, 342, 30);
    }

    public void setLblNewLabel2(final JLabel lblNewLabel2) {
        this.lblNewLabel2 = lblNewLabel2;
        lblNewLabel2.setBounds(22, 187, 342, 30);
    }

    public void setScrollPane(final JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    }

    public void setTable(final JTable table) {
        this.table = table;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    public void setTextField(final JTextField textField) {
        this.textField = textField;
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent arg0) {
                if (Character.isDigit(arg0.getKeyChar())) {
                    arg0.consume();
                }
            }
        });
        textField.setBounds(12, 72, 352, 30);
    }

    public void setTextField1(final JTextField textField1) {
        this.textField1 = textField1;
        textField1.setBounds(12, 144, 352, 30);
    }

    public void setTextField2(final JTextField textField2) {
        this.textField2 = textField2;
        textField2.setBounds(12, 215, 352, 30);
    }
}
