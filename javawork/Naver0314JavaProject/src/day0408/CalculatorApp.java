import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField numField1, numField2;
    private JLabel resultLabel;

    public CalculatorApp() {
        setTitle("간단한 계산기");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("첫 번째 숫자: "));
        numField1 = new JTextField();
        panel.add(numField1);

        panel.add(new JLabel("두 번째 숫자: "));
        numField2 = new JTextField();
        panel.add(numField2);

        JButton addButton = new JButton("더하기");
        panel.add(addButton);

        JButton subButton = new JButton("빼기");
        panel.add(subButton);

        JButton mulButton = new JButton("곱하기");
        panel.add(mulButton);

        JButton divButton = new JButton("나누기");
        panel.add(divButton);

        resultLabel = new JLabel("결과: ");
        panel.add(resultLabel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('+');
            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('-');
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('*');
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('/');
            }
        });

        add(panel);
    }

    private void performOperation(char operator) {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "0으로 나눌 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    return;
            }
            resultLabel.setText("결과: " + result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "숫자를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorApp().setVisible(true);
            }
        });
    }
}
