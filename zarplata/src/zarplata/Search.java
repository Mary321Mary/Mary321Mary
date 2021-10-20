package zarplata;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Search extends JFrame {

    static Menu              menu;
    private final JPanel     contentPane;
    private final JTextField textField;
    private String           tableName;
    private JLabel           lblNewLabel   = new JLabel();
    SearchRecords            searchRecords = new SearchRecords();
    private final JButton    btnNewButton_1;
    final JComboBox<String>  comboBox      = new JComboBox<>();

    /**
     * Create the frame.
     */
    public Search() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 700, 230);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.lblNewLabel = new JLabel("New label");
        this.lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.lblNewLabel.setBounds(186, 13, 272, 22);
        this.contentPane.add(this.lblNewLabel);

        this.textField = new JTextField();
        this.textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField.setBounds(126, 48, 398, 31);
        this.textField.setFocusable(true);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);

        final JButton btnNewButton = new JButton("Поиск");
        btnNewButton.addActionListener(arg0 -> {
            switch (this.tableName) {
                case "ПриемыФио":
                    Search.menu.getBuildTable().priemuTable(Search.menu);
                    Search.menu.setArrayOfID(this.searchRecords.searchPriemyFIO(Search.menu, this));
                    break;
                case "ПриемыДолжн":
                    Search.menu.getBuildTable().priemuTable(Search.menu);
                    Search.menu.setArrayOfID(
                            this.searchRecords.searchPriemyDoljnost(Search.menu, this));
                    break;
                case "ПриемыОтдел":
                    Search.menu.getBuildTable().priemuTable(Search.menu);
                    Search.menu
                            .setArrayOfID(this.searchRecords.searchPriemyOtdel(Search.menu, this));
                    break;
                case "Табель":
                    Search.menu.getBuildTable().tabelTable(Search.menu);
                    Search.menu.setArrayOfID(this.searchRecords.searchTabelya(Search.menu, this));
                    break;
                case "Табл нач":
                    Search.menu.getBuildTable().tablNachTable(Search.menu);
                    Search.menu.setArrayOfID(this.searchRecords.searchTablNach(Search.menu, this));
                    break;
                case "Табл уд":
                    Search.menu.getBuildTable().tablYderjTable(Search.menu);
                    Search.menu.setArrayOfID(this.searchRecords.searchTablYderj(Search.menu, this));
                    break;
                case "Начисл":
                    Search.menu.getBuildTable().nachTable(Search.menu);
                    Search.menu.setArrayOfID(this.searchRecords.searchNach(Search.menu, this));
                    break;
                case "Удерж":
                    Search.menu.getBuildTable().yderjTable(Search.menu);
                    Search.menu.setArrayOfID(this.searchRecords.searchYderj(Search.menu, this));
                    break;
                case "Дети":
                    Search.menu.getBuildTable().detiTable(Search.menu);
                    Search.menu.setArrayOfID(this.searchRecords.searchDeti(Search.menu, this));
                    break;
                case "ПользователиФио":
                    Search.menu.getBuildTable().polzovateliTable(Search.menu);
                    Search.menu.setArrayOfID(
                            this.searchRecords.searchPolzovateliFIO(Search.menu, this));
                    break;
                case "ПользователиРоль":
                    Search.menu.getBuildTable().polzovateliTable(Search.menu);
                    Search.menu.setArrayOfID(
                            this.searchRecords.searchPolzovateliRole(Search.menu, this));
                    break;
            }
        });
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnNewButton.setBounds(126, 122, 127, 25);
        this.contentPane.add(btnNewButton);

        this.btnNewButton_1 = new JButton("Отмена");
        this.btnNewButton_1.addActionListener(arg0 -> Search.menu.getSearch().setVisible(false));
        this.btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.btnNewButton_1.setBounds(397, 122, 127, 25);
        this.contentPane.add(this.btnNewButton_1);

        this.comboBox
                .setModel(new DefaultComboBoxModel<>(new String[] {"admin", "accountant", "user"}));
        this.comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.comboBox.setBounds(126, 48, 397, 29);
        this.contentPane.add(this.comboBox);
    }

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

    public JComboBox<String> getComboBox() {
        return this.comboBox;
    }

    public JLabel getLblNewLabel() {
        return this.lblNewLabel;
    }

    public String getTableName() {
        return this.tableName;
    }

    public JTextField getTextField() {
        return this.textField;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }
}
