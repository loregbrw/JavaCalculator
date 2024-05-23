import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class frCalculator extends JFrame {
    private String calculus = "";

    frCalculator() {
        this.setSize(350, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel pnCalculator = new JPanel(new BorderLayout());

        JPanel pnDisplay = new JPanel();
        pnDisplay.setLayout(new GridLayout(2, 1));
        pnDisplay.setPreferredSize(new Dimension(this.getWidth(), 150));

        JPanel pnDisplay1 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JLabel lbDisplay1 = new JLabel("");
        lbDisplay1.setFont(new Font("Arial", Font.BOLD, 30));
        lbDisplay1.setForeground(Color.GRAY);

        JPanel pnDisplay2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JLabel lbDisplay2 = new JLabel(calculus);
        lbDisplay2.setFont(new Font("Arial", Font.BOLD, 35));

        JPanel pnButtons = new JPanel();
        pnButtons.setLayout(new GridLayout(5, 4));

        String[] stringi = { "%", "c", "⌫", "÷", "1", "2", "3", "x", "4", "5", "6", "-", "7", "8", "9", "+", "#", "0", ".", "=" };
        Color[] bgcolori = {
                Color.GRAY, Color.GRAY, Color.GRAY, Color.ORANGE,
                Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.ORANGE,
                Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.ORANGE,
                Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.ORANGE,
                Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.ORANGE
        };
        Color[] txcolori = {
                Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK,
                Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK,
                Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK,
                Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK,
                Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK
        };

        char[] standardOperators = { '%', '÷', 'x', '-', '+' };
        for (int i = 0; i < 20; i++) {
            btColor newButton = new btColor(stringi[i], bgcolori[i], txcolori[i]);

            if (stringi[i] == "⌫") {
                newButton.addActionListener(l -> {
                    if (calculus.length() < 2) {
                        calculus = "";
                        lbDisplay2.setText(calculus);
                        pnDisplay2.revalidate();
                        return;
                    }
                    calculus = calculus.substring(0, calculus.length() - 2);
                    lbDisplay2.setText(calculus);
                    pnDisplay2.revalidate();
                });
            }

            if (stringi[i] == "c") {
                newButton.addActionListener(l -> {
                    calculus = "";
                    lbDisplay1.setText("");
                    lbDisplay2.setText(calculus);
                    pnDisplay1.revalidate();
                    pnDisplay2.revalidate();
                });
            }

            if (stringi[i] == "=") {
                newButton.addActionListener(l -> {

                    for (char c : standardOperators) {
                        if ((calculus.charAt(calculus.length() - 1) == c && calculus.charAt(calculus.length() - 1) != '%') || (calculus.charAt(calculus.length() - 1) == '.')) {
                            calculus = calculus.substring(0, calculus.length() - 1);
                        }
                    }

                    Operations cal = new Operations(calculus);
                    lbDisplay1.setText(calculus);
                    calculus = String.valueOf(cal.Calculate());
                    lbDisplay2.setText(calculus);
                });
            } else {
                int index = i;
                newButton.addActionListener(l -> {

                    if (Operations.isOperator(stringi[index].charAt(0)) && stringi[index] != "%" && calculus.charAt(calculus.length() - 1) == '%' && !(calculus.length() < 1)) {}
                    else if (Operations.isOperator(stringi[index].charAt(0)) && (calculus.length() < 1 || Operations.isOperator(calculus.charAt(calculus.length() - 1)))) {
                        return;
                    }

                    calculus += newButton.getText();
                    lbDisplay2.setText(calculus);
                    pnDisplay2.revalidate();
                });
            }

            pnButtons.add(newButton);
        }

        pnDisplay.add(pnDisplay1);
        pnDisplay.add(pnDisplay2);

        pnDisplay1.add(lbDisplay1);
        pnDisplay2.add(lbDisplay2);
        pnCalculator.add(pnDisplay, BorderLayout.NORTH);
        pnCalculator.add(pnButtons, BorderLayout.CENTER);

        this.add(pnCalculator);
        this.setVisible(true);
    }
}
