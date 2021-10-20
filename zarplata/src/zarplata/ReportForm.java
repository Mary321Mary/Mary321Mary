package zarplata;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class ReportForm extends JFrame {

    static Menu              menu;
    private final JPanel     contentPane;
    private final JTextField textField;
    private final JLabel     lblNewLabel  = new JLabel("New label");
    private final JLabel     lblNewLabel1 = new JLabel("New label");
    final JComboBox<String>  comboBox     = new JComboBox<>();
    private String           repQ         = new String();
    private final Report     report       = new Report();

    /**
     * Create the frame.
     */
    public ReportForm() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 310, 328);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.lblNewLabel.setBounds(42, 13, 187, 25);
        this.contentPane.add(this.lblNewLabel);

        this.textField = new JTextField();
        this.textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent arg0) {
                if (Character.isAlphabetic(arg0.getKeyChar())) {
                    arg0.consume();
                }
            }
        });
        this.textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.textField.setBounds(33, 38, 213, 33);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);

        this.lblNewLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.lblNewLabel1.setBounds(42, 100, 187, 25);
        this.contentPane.add(this.lblNewLabel1);

        this.comboBox.setModel(new DefaultComboBoxModel<>(
                new String[] {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
                        "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"}));
        this.comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.comboBox.setBounds(33, 131, 213, 33);
        this.contentPane.add(this.comboBox);

        final JButton btnNewButton = new JButton("Показать");
        btnNewButton.addActionListener(arg0 -> {
            switch (this.getRepQ()) {
                case "Табель":
                    this.report.reportSotr(this);
                    break;
                case "Месяц":
                    this.report.reportMonth(this);
                    break;
                case "Год":
                    this.report.reportYear(this);
                    break;
            }
        });
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnNewButton.setBounds(42, 191, 187, 33);
        this.contentPane.add(btnNewButton);

        final JButton btnNewButton1 = new JButton("Отмена");
        btnNewButton1.addActionListener(arg0 -> this.setVisible(false));
        btnNewButton1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnNewButton1.setBounds(42, 237, 187, 31);
        this.contentPane.add(btnNewButton1);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final ReportForm frame = new ReportForm();
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

    public JLabel getLblNewLabel1() {
        return this.lblNewLabel1;
    }

    public String getRepQ() {
        return this.repQ;
    }

    public JTextField getTextField() {
        return this.textField;
    }

    public void setRepQ(final String rep) {
        this.repQ = rep;
    }
}
