import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



class OnlineTest extends JFrame implements ActionListener {

    JLabel label;
    JRadioButton[] radioButton = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int[] m = new int[10];

    OnlineTest(String message) {
        super(message);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 100, 20);
        radioButton[1].setBounds(50, 110, 100, 20);
        radioButton[2].setBounds(50, 140, 100, 20);
        radioButton[3].setBounds(50, 170, 100, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("1. Which of the following was introduced in Java 8?");
            radioButton[0].setText("Stream API");
            radioButton[1].setText("Serialization");
            radioButton[2].setText("Spliterator");
            radioButton[3].setText("Lambda Expression");

        }
        if (current == 1) {
            label.setText("2. Which of the following is NOT a Java feature?");
            radioButton[0].setText("Dynamic");
            radioButton[1].setText("Architecture Neutral");
            radioButton[2].setText("Use of pointers");
            radioButton[3].setText("Object-oriented");

        }
        if (current == 2) {
            label.setText("3. The '\u0021 article referred to as a");
            radioButton[0].setText("Unicode escape sequence");
            radioButton[1].setText("Octal escape");
            radioButton[2].setText("Hexadecimal");
            radioButton[3].setText("Line feed");

        }
        if (current == 3) {
            label.setText("4. (blank) is used to fix bugs in the Java programs.");
            radioButton[0].setText("JRE");
            radioButton[1].setText("JBD");
            radioButton[2].setText("JVM");
            radioButton[3].setText("JDK");

        }
        if (current == 4) {
            label.setText("5. What is the return type of the hashCode() method in the Object class?");
            radioButton[0].setText("Object");
            radioButton[1].setText("int");
            radioButton[2].setText("long");
            radioButton[3].setText("void");

        }
        if (current == 5) {
            label.setText("6. Which of the following is a valid long literal?");
            radioButton[0].setText("ACH689");
            radioButton[1].setText("987009");
            radioButton[2].setText("0xnf029L");
            radioButton[3].setText("L989776");

        }
        if (current == 6) {
            label.setText("7. What does the expression float a = 35 / 0 return?");
            radioButton[0].setText("Infinity");
            radioButton[1].setText("Not a Number");
            radioButton[2].setText("0");
            radioButton[3].setText("Run time exception");

        }
        if (current == 7) {
            label.setText("8. Which of the following is true about the anonymous inner class?");
            radioButton[0].setText("It has only methods");
            radioButton[1].setText("Objects can't be created");
            radioButton[2].setText("It has a fixed class name");
            radioButton[3].setText("It has no class name");

        }
        if (current == 8) {
            label.setText("9. Which package contains the Random class?");
            radioButton[0].setText("java.util package");
            radioButton[1].setText("java.lang package");
            radioButton[2].setText("java.awt package");
            radioButton[3].setText("java.io package");

        }
        if (current == 9) {
            label.setText("10. An interface with no fields or methods is known as a ?");
            radioButton[0].setText("Runnable Interface");
            radioButton[1].setText("Marker Interface");
            radioButton[2].setText("Abstract Interface");
            radioButton[3].setText("CharSequence Interface");

        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 450, 20);
    }

    boolean check() {
        if (current == 0) {
            return (radioButton[1].isSelected());
        }
        if (current == 1) {
            return (radioButton[2].isSelected());
        }
        if (current == 2) {
            return (radioButton[0].isSelected());
        }
        if (current == 3) {
            return (radioButton[1].isSelected());
        }
        if (current == 4) {
            return (radioButton[1].isSelected());
        }
        if (current == 5) {
            return (radioButton[2].isSelected());
        }
        if (current == 6) {
            return (radioButton[0].isSelected());
        }
        if (current == 7) {
            return (radioButton[3].isSelected());
        }
        if (current == 8) {
            return (radioButton[0].isSelected());
        }
        if (current == 9) {
            return (radioButton[1].isSelected());
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                btnBookmark.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct answers=" + count);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new OnlineTest("Multiple Choice Online Test");

    }


}
