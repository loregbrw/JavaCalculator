import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;

public class btColor extends JButton {
    private String value;
    private Color bgColor;
    private Color txColor;

    btColor(String value, Color bgColor, Color txColor) {
        this.value = value;
        this.bgColor = bgColor;
        this.txColor = txColor;
        this.setText(value);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setForeground(txColor);
        this.setBackground(bgColor);
    }

    public String getValue() {
        return value;
    }
}
