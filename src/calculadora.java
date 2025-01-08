import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {

    private JFrame frame;
    private JTextField textField;
    private StringBuilder currentInput;
    private String operator;
    private double result;
    private boolean isOperatorClicked;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Calculadora window = new Calculadora();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Calculadora() {
        currentInput = new StringBuilder();
        operator = "";
        result = 0;
        isOperatorClicked = false;

        frame = new JFrame();
        frame.setBounds(100, 100, 300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                if (isOperatorClicked) {
                    currentInput.setLength(0);
                    isOperatorClicked = false;
                }
                currentInput.append(command);
                textField.setText(currentInput.toString());
            } else if (command.charAt(0) == 'C') {
                currentInput.setLength(0);
                textField.setText("");
                result = 0;
                operator = "";
                isOperatorClicked = false;
            } else if (command.charAt(0) == '=') {
                if (!operator.isEmpty()) {
                    double number = Double.parseDouble(currentInput.toString());
                    switch (operator) {
                        case "+": result += number; break;
                        case "-": result -= number; break;
                        case "*": result *= number; break;
                        case "/": result /= number; break;
                    }
                    textField.setText(String.valueOf(result));
                    currentInput.setLength(0);
                    currentInput.append(result);
                    operator = "";
                    isOperatorClicked = true;
                }
            } else {
                if (operator.isEmpty()) {
                    result = Double.parseDouble(currentInput.toString());
                } else {
                    double number = Double.parseDouble(currentInput.toString());
                    switch (operator) {
                        case "+": result += number; break;
                        case "-": result -= number; break;
                        case "*": result *= number; break;
                        case "/": result /= number; break;
                    }
                }
                operator = command;
                isOperatorClicked = true;
                currentInput.setLength(0);
            }
        }
    }
}
