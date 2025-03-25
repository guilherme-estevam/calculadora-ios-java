import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField visor;
    private String operador;
    private double valor1, valor2, resultado;
    private boolean novaOperacao;

    public Calculadora() {
        setTitle("Calculadora iPhone");
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        visor = new JTextField("0");
        visor.setEditable(false);
        visor.setFont(new Font("Arial", Font.BOLD, 40));
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        add(visor, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] botoes = {
                "AC", "+/-", "%", "÷",
                "7", "8", "9", "x",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "=", 
        };

        for (String txt : botoes) {
            JButton btn = new JButton(txt);
            btn.setFont(new Font("Arial", Font.BOLD, 28));
            btn.addActionListener(this);
            if (txt.equals("0")) {
                painelBotoes.add(btn);
                painelBotoes.add(new JLabel()); // espaço vazio
            } else {
                painelBotoes.add(btn);
            }
        }

        add(painelBotoes, BorderLayout.CENTER);

        operador = "";
        valor1 = 0;
        valor2 = 0;
        resultado = 0;
        novaOperacao = true;
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]") || cmd.equals(".")) {
            if (novaOperacao) {
                visor.setText("");
                novaOperacao = false;
            }
            if (cmd.equals(".") && visor.getText().contains(".")) return;
            visor.setText(visor.getText() + cmd);
        } else if (cmd.equals("AC")) {
            visor.setText("0");
            valor1 = 0;
            valor2 = 0;
            operador = "";
            novaOperacao = true;
        } else if (cmd.equals("+/-")) {
            double val = Double.parseDouble(visor.getText());
            val = val * -1;
            visor.setText(new DecimalFormat("0.##########").format(val));
        } else if (cmd.equals("%")) {
            double val = Double.parseDouble(visor.getText());
            val = val / 100;
            visor.setText(new DecimalFormat("0.##########").format(val));
        } else if (cmd.equals("=")) {
            valor2 = Double.parseDouble(visor.getText());
            switch (operador) {
                case "+":
                    resultado = valor1 + valor2;
                    break;
                case "-":
                    resultado = valor1 - valor2;
                    break;
                case "x":
                    resultado = valor1 * valor2;
                    break;
                case "÷":
                    resultado = valor2 != 0 ? valor1 / valor2 : 0;
                    break;
            }
            visor.setText(new DecimalFormat("0.##########").format(resultado));
            novaOperacao = true;
        } else {
            operador = cmd;
            valor1 = Double.parseDouble(visor.getText());
            novaOperacao = true;
        }
    }
}
