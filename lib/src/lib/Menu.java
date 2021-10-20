package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

    static Input         in      = new Input();
    static View          view    = new View();
    static Search        search  = new Search();
    static Queries       queries = new Queries();
    private final JPanel contentPane;

    /**
     * Create the frame.
     */
    public Menu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 736, 473);

        final JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        this.setJMenuBar(menuBar);

        final JMenu mnNewMenu = new JMenu("Работа с таблицами");
        mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        menuBar.add(mnNewMenu);

        final JMenu mnNewMenu_1 = new JMenu("Ввод данных");
        mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        mnNewMenu.add(mnNewMenu_1);

        final JMenuItem menuItem = new JMenuItem("Авторы книг");
        menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuItem.addActionListener(arg0 -> {
            Menu.in.textField.setVisible(true);
            Menu.in.textField_1.setVisible(true);
            Menu.in.textField_2.setVisible(false);
            Menu.in.textField_3.setVisible(false);
            Menu.in.textField_4.setVisible(false);
            Menu.in.lblNewLabel.setVisible(true);
            Menu.in.lblNewLabel_1.setVisible(true);
            Menu.in.label.setVisible(false);
            Menu.in.label_1.setVisible(false);
            Menu.in.label_2.setVisible(false);
            Menu.in.textField.setText("");
            Menu.in.textField_1.setText("");
            Menu.in.lblNewLabel.setText("ФИО");
            Menu.in.lblNewLabel_1.setText("Код книги");
            Menu.in.setVisible(true);
        });
        mnNewMenu_1.add(menuItem);

        final JMenuItem menuItem_5 = new JMenuItem("Выдача книг");
        menuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuItem_5.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.in.textField.setVisible(true);
                Menu.in.textField_1.setVisible(true);
                Menu.in.textField_2.setVisible(true);
                Menu.in.textField_3.setVisible(true);
                Menu.in.textField_4.setVisible(true);
                Menu.in.lblNewLabel.setVisible(true);
                Menu.in.lblNewLabel_1.setVisible(true);
                Menu.in.label.setVisible(true);
                Menu.in.label_1.setVisible(true);
                Menu.in.label_2.setVisible(true);
                Menu.in.textField.setText("");
                Menu.in.textField_1.setText("");
                Menu.in.textField_2.setText("");
                Menu.in.textField_3.setText("");
                Menu.in.textField_4.setText("");
                Menu.in.lblNewLabel.setText("Код книги");
                Menu.in.lblNewLabel_1.setText("ФИО читателя");
                Menu.in.label.setText("Код сотрудника");
                Menu.in.label_1.setText("Дата выдачи");
                Menu.in.label_2.setText("Дата возврата");
                Menu.in.setVisible(true);
            }
        });
        mnNewMenu_1.add(menuItem_5);

        final JMenuItem menuItem_10 = new JMenuItem("Книги");
        menuItem_10.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuItem_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.in.textField.setVisible(true);
                Menu.in.textField_1.setVisible(true);
                Menu.in.textField_2.setVisible(true);
                Menu.in.textField_3.setVisible(true);
                Menu.in.textField_4.setVisible(true);
                Menu.in.lblNewLabel.setVisible(true);
                Menu.in.lblNewLabel_1.setVisible(true);
                Menu.in.label.setVisible(true);
                Menu.in.label_1.setVisible(true);
                Menu.in.label_2.setVisible(true);
                Menu.in.textField.setText("");
                Menu.in.textField_1.setText("");
                Menu.in.textField_2.setText("");
                Menu.in.textField_3.setText("");
                Menu.in.textField_4.setText("");
                Menu.in.lblNewLabel.setText("Название");
                Menu.in.lblNewLabel_1.setText("Издательство");
                Menu.in.label.setText("Год издания");
                Menu.in.label_1.setText("Жанр");
                Menu.in.label_2.setText("Цена");
                Menu.in.setVisible(true);
            }
        });
        mnNewMenu_1.add(menuItem_10);

        final JMenuItem menuItem_15 = new JMenuItem("Мероприятия");
        menuItem_15.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuItem_15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.in.textField.setVisible(true);
                Menu.in.textField_1.setVisible(true);
                Menu.in.textField_2.setVisible(true);
                Menu.in.textField_3.setVisible(false);
                Menu.in.textField_4.setVisible(false);
                Menu.in.lblNewLabel.setVisible(true);
                Menu.in.lblNewLabel_1.setVisible(true);
                Menu.in.label.setVisible(true);
                Menu.in.label_1.setVisible(false);
                Menu.in.label_2.setVisible(false);
                Menu.in.textField.setText("");
                Menu.in.textField_1.setText("");
                Menu.in.textField_2.setText("");
                Menu.in.lblNewLabel.setText("Наименование");
                Menu.in.lblNewLabel_1.setText("Код сотрудника");
                Menu.in.label.setText("Дата проведения");
                Menu.in.setVisible(true);
            }
        });
        mnNewMenu_1.add(menuItem_15);

        final JMenuItem menuItem_20 = new JMenuItem("Сотрудники");
        menuItem_20.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuItem_20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.in.textField.setVisible(true);
                Menu.in.textField_1.setVisible(true);
                Menu.in.textField_2.setVisible(true);
                Menu.in.textField_3.setVisible(true);
                Menu.in.textField_4.setVisible(false);
                Menu.in.lblNewLabel.setVisible(true);
                Menu.in.lblNewLabel_1.setVisible(true);
                Menu.in.label.setVisible(true);
                Menu.in.label_1.setVisible(true);
                Menu.in.label_2.setVisible(false);
                Menu.in.textField.setText("");
                Menu.in.textField_1.setText("");
                Menu.in.textField_2.setText("");
                Menu.in.textField_3.setText("");
                Menu.in.lblNewLabel.setText("ФИО");
                Menu.in.lblNewLabel_1.setText("Должность");
                Menu.in.label.setText("Дата приема");
                Menu.in.label_1.setText("Дата увольнения");
                Menu.in.setVisible(true);
            }
        });
        mnNewMenu_1.add(menuItem_20);

        final JMenu menu = new JMenu("Просмотр и изменение данных");
        menu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        mnNewMenu.add(menu);

        final JMenuItem menuItem_1 = new JMenuItem("Авторы книг");
        menuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.view.t = 0;
                Menu.view.showLendingBooks();
                Menu.view.setVisible(true);
            }
        });
        menuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem_1);

        final JMenuItem menuItem_6 = new JMenuItem("Выдача книг");
        menuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuItem_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.view.t = 1;
                Menu.view.showLendingBooks();
                Menu.view.setVisible(true);
            }
        });
        menu.add(menuItem_6);

        final JMenuItem menuItem_11 = new JMenuItem("Книги");
        menuItem_11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.view.t = 2;
                Menu.view.showLendingBooks();
                Menu.view.setVisible(true);
            }
        });
        menuItem_11.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem_11);

        final JMenuItem menuItem_16 = new JMenuItem("Мероприятия");
        menuItem_16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.view.t = 3;
                Menu.view.showLendingBooks();
                Menu.view.setVisible(true);
            }
        });
        menuItem_16.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem_16);

        final JMenuItem menuItem21 = new JMenuItem("Сотрудники");
        menuItem21.addActionListener(args -> {
            Menu.view.t = 4;
            Menu.view.showLendingBooks();
            Menu.view.setVisible(true);
        });
        menuItem21.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu.add(menuItem21);

        final JMenu menu_3 = new JMenu("Поиск данных");
        menu_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        mnNewMenu.add(menu_3);

        final JMenuItem menuItem_4 = new JMenuItem("Авторы книг");
        menuItem_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.search.lblNewLabel.setText("ФИО");
                Menu.search.t = 0;
                Menu.search.setVisible(true);
            }
        });
        menuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu_3.add(menuItem_4);

        final JMenuItem menuItem_9 = new JMenuItem("Выдача книг");
        menuItem_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.search.lblNewLabel.setText("ФИО_читателя");
                Menu.search.t = 1;
                Menu.search.setVisible(true);
            }
        });
        menuItem_9.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu_3.add(menuItem_9);

        final JMenuItem menuItem_14 = new JMenuItem("Книги");
        menuItem_14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.search.lblNewLabel.setText("Издательство");
                Menu.search.t = 2;
                Menu.search.setVisible(true);
            }
        });
        menuItem_14.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu_3.add(menuItem_14);

        final JMenuItem menuItem_19 = new JMenuItem("Мероприятия");
        menuItem_19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.search.lblNewLabel.setText("Наименование");
                Menu.search.t = 3;
                Menu.search.setVisible(true);
            }
        });
        menuItem_19.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu_3.add(menuItem_19);

        final JMenuItem menuItem_24 = new JMenuItem("Сотрудники");
        menuItem_24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.search.lblNewLabel.setText("ФИО");
                Menu.search.t = 4;
                Menu.search.setVisible(true);
            }
        });
        menuItem_24.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menu_3.add(menuItem_24);

        final JMenu menu_4 = new JMenu("Обработка");
        menu_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        menuBar.add(menu_4);

        final JMenuItem menuItem_2 = new JMenuItem("Запросы");
        menuItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Menu.queries.textField.setText("");
                Menu.queries.setVisible(true);
            }
        });
        menu_4.add(menuItem_2);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);
    }

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
