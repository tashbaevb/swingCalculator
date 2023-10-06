import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class Panel extends JPanel {

    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private JTextField output = new JTextField();
    private JButton backspace = new JButton("<-"), equ = new JButton("=");
    private JButton plus = new JButton("+"), minus = new JButton("-"), multi = new JButton("*"), div = new JButton("/");
    private JButton sinButton = new JButton("sin"), cosButton = new JButton("cos"), tanButton = new JButton("tan"), ctanButton = new JButton("ctg");
    private JButton expButton = new JButton("^"), clear = new JButton("C");
    private JButton sqrt = new JButton("√"), log10 = new JButton("lg10"), ln = new JButton("ln");
    private JButton ms = new JButton("MS"), mr = new JButton("MR"), mc = new JButton("MC"), mplus = new JButton("M+"), mminus = new JButton("M-"), m = new JButton("");
    private JButton p = new JButton("P"), toggleButton = new JButton("Too");

    private double num1 = 0;
    private char operator = ' ';
    private double ans = 0;
    double memory = 0;
    double number_p = 3.1415926535;
    private boolean isDegreesMode = true;

    public Panel() {
        setLayout(null);
        setFocusable(true);
        grabFocus();

        backspace.setBounds(10, 250, 50, 50);
        backspace.setFont(font);
        add(backspace);

        toggleButton.setBounds(130, 370, 50, 50);
        toggleButton.setFont(font);
        add(toggleButton);

        mr.setBounds(10, 310, 50, 50);
        mr.setFont(font);
        add(mr);

        mc.setBounds(70, 310, 50, 50);
        mc.setFont(font);
        add(mc);

        mplus.setBounds(130, 310, 50, 50);
        mplus.setFont(font);
        add(mplus);

        mminus.setBounds(190, 310, 50, 50);
        mminus.setFont(font);
        add(mminus);

        ms.setBounds(250, 310, 50, 50);
        ms.setFont(font);
        add(ms);

        p.setBounds(310, 310, 50, 50);
        p.setFont(font);
        add(p);

        equ.setBounds(130, 250, 50, 50);
        equ.setFont(font);
        add(equ);

        plus.setBounds(190, 70, 50, 50);
        plus.setFont(font);
        add(plus);

        minus.setBounds(190, 130, 50, 50);
        minus.setFont(font);
        add(minus);

        multi.setBounds(190, 190, 50, 50);
        multi.setFont(font);
        add(multi);

        div.setBounds(190, 250, 50, 50);
        div.setFont(font);
        add(div);

        sinButton.setBounds(250, 70, 50, 50);
        sinButton.setFont(font);
        add(sinButton);

        cosButton.setBounds(250, 130, 50, 50);
        cosButton.setFont(font);
        add(cosButton);

        tanButton.setBounds(250, 190, 50, 50);
        tanButton.setFont(font);
        add(tanButton);

        ctanButton.setBounds(250, 250, 50, 50);
        ctanButton.setFont(font);
        add(ctanButton);

        expButton.setBounds(310, 70, 50, 50);
        expButton.setFont(font);
        add(expButton);

        sqrt.setBounds(310, 130, 50, 50);
        sqrt.setFont(font);
        add(sqrt);

        log10.setBounds(310, 190, 65, 50);
        log10.setFont(font);
        add(log10);

        ln.setBounds(310, 250, 50, 50);
        ln.setFont(font);
        add(ln);

        clear.setBounds(310, 15, 50, 40);
        clear.setFont(font);
        add(clear);

        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50);
        numbers[0].setFont(font);
        add(numbers[0]);


        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                numbers[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + "");
                numbers[x * 3 + y + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);
                numbers[x * 3 + y + 1].setFont(font);
                add(numbers[x * 3 + y + 1]);
            }
        }

        output.setBounds(10, 10, 290, 50);
        output.setFont(font);
        output.setEditable(false);
        add(output);

        ActionListener l = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            output.setText(output.getText() + b.getText());
        };

        for (JButton b : numbers) {
            b.addActionListener(l);
        }

        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(output.getText());
                operator = '+';
                output.setText("");
            }
        });

        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(output.getText());
                operator = '-';
                output.setText("");
            }
        });

        multi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(output.getText());
                operator = '*';
                output.setText("");
            }
        });

        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(output.getText());
                operator = '/';
                output.setText("");
            }
        });

        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("");
                num1 = 0;
                operator = ' ';
            }
        });

        backspace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = output.getText();
                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                    output.setText(text);
                }
            }
        });

        expButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(output.getText());
                operator = '^';
                output.setText("");
            }
        });

        sqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(output.getText());
                operator = '√';
                output.setText("");
            }
        });

        log10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(output.getText());
                double result = Math.log10(num);
                output.setText(Double.toString(result));
            }
        });

        ln.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(output.getText());
                double result = Math.log(num);
                output.setText(Double.toString(result));
            }
        });

        sinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(output.getText());
                double result;

                if (isDegreesMode) {
                    result = Math.sin(Math.toRadians(num));
                } else {
                    result = Math.sin(num);
                }
                output.setText(formatResult(result));
            }
        });

        cosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(output.getText());
                double result = Math.cos(Math.toRadians(num));
                output.setText(formatResult(result));
            }
        });

        tanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(output.getText());
                double result = Math.tan(Math.toRadians(num));
                output.setText(formatResult(result));
            }
        });

        ctanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(output.getText());
                double result = 1 / Math.tan(Math.toRadians(num));
                output.setText(formatResult(result));
            }
        });

        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isDegreesMode = !isDegreesMode;
                toggleButton.setText(isDegreesMode ? "DEG" : "RAD");
            }
        });


        p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(String.valueOf(number_p));
            }
        });

        ms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                memory = Double.parseDouble(output.getText());
            }
        });

        mr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(String.valueOf(memory));
            }
        });

        mc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                memory = 0;
            }
        });

        mplus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                memory += Double.parseDouble(output.getText());
                num1 += memory;
            }
        });

        mminus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                memory -= Double.parseDouble(output.getText());
                num1 += memory;
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();

                if (!Character.isDigit(symbol) && symbol != '+' && symbol != '-' && symbol != '*' && symbol != '/' && symbol != '=')
                    return;

                if (symbol == '=') {
                    performOperation();
                } else {
                    output.setText(output.getText() + symbol);
                }
            }
        });

        ActionListener equalsListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation();
                operator = ' ';
            }
        };

        equ.addActionListener(equalsListener);

        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        inputMap.put(enterKeyStroke, "performEquals");
        actionMap.put("performEquals", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation();
                operator = ' ';
            }
        });
    }

    private String formatResult(double result) {
        DecimalFormat df = new DecimalFormat("#.#########");
        return df.format(result);
    }


    private void performOperation() {
        try {
            double num2 = Double.parseDouble(output.getText());
            switch (operator) {
                case '+':
                    ans = num1 + num2;
                    break;
                case '-':
                    ans = num1 - num2;
                    break;
                case '*':
                    ans = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        ans = num1 / num2;
                    } else {
                        output.setText("Дебил, Нельзя делить на 0");
                        return;
                    }
                    break;
                case '^':
                    ans = Math.pow(num1, num2);
                    break;
                case '√':
                    ans = Math.pow(num1, 1.0 / num2);
                    break;
                case ' ':
                    ans = num2;
                    break;
            }
            output.setText(formatResult(ans));
            operator = ' ';
            num1 = ans;
        } catch (NumberFormatException ex) {
            output.setText("Ошибка");
        }
    }
}
