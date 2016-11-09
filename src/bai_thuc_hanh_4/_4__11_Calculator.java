/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_thuc_hanh_4;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author TLDs
 */
public class _4__11_Calculator extends JFrame implements ActionListener {

    private JTextField tfOutput;

    private JButton[] btnDial = new JButton[10];
    private JButton btnPlus, btnMinus, btnDiv, btnMul, btnBackspace, btnClear, btnExecute;

    private JPanel mainPanel;
    private JPanel[] subPanel = new JPanel[6];

    private boolean isCalculated = false;

    public _4__11_Calculator() {
        initGUI();
    }

    private void initGUI() {
        setSize(250, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        configComponents();
        componentsAddActionListener();

        setVisible(true);
    }

    private void initComponents() {
        tfOutput = new JTextField();

        for (int i = 0; i < btnDial.length; i++) {
            btnDial[i] = new JButton(i + "");
        }

        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");

        btnBackspace = new JButton("Backspace");
        btnClear = new JButton("C");
        btnExecute = new JButton("=");

        mainPanel = new JPanel(new GridLayout(6, 1));
        for (int i = 0; i < subPanel.length; i++) {
            subPanel[i] = new JPanel(new GridLayout(1, 4));
        }
    }

    private void configComponents() {
        tfOutput.setFont(new Font("Arial", Font.PLAIN, 18));

        subPanel[0].add(tfOutput);

        subPanel[1].add(btnBackspace);
        subPanel[1].add(btnClear);

        subPanel[2].add(btnPlus);
        subPanel[2].add(btnMinus);
        subPanel[2].add(btnMul);
        subPanel[2].add(btnDiv);

        subPanel[3].add(btnDial[0]);
        subPanel[3].add(btnDial[1]);
        subPanel[3].add(btnDial[2]);
        subPanel[3].add(btnDial[3]);

        subPanel[4].add(btnDial[4]);
        subPanel[4].add(btnDial[5]);
        subPanel[4].add(btnDial[6]);
        subPanel[4].add(btnDial[7]);

        subPanel[5].add(btnDial[8]);
        subPanel[5].add(btnDial[9]);
        subPanel[5].add(btnExecute);

        for (int i = 0; i < subPanel.length; i++) {
            mainPanel.add(subPanel[i]);
        }

        add(mainPanel);
    }

    private void componentsAddActionListener() {
        for (int i = 0; i < btnDial.length; i++) {
            btnDial[i].addActionListener(this);
        }
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnBackspace.addActionListener(this);
        btnClear.addActionListener(this);
        btnExecute.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < btnDial.length; i++) {
            if (e.getSource() == btnDial[i]) {
                if (isCalculated) {
                    tfOutput.setText("" + i);
                    isCalculated = false;
                } else {
                    tfOutput.setText(tfOutput.getText() + i);
                }
            }
        }

        if (e.getSource() == btnPlus && !isCalculated) {
            tfOutput.setText(tfOutput.getText() + "+");
        }
        if (e.getSource() == btnMinus && !isCalculated) {
            tfOutput.setText(tfOutput.getText() + "-");
        }
        if (e.getSource() == btnMul && !isCalculated) {
            tfOutput.setText(tfOutput.getText() + "*");
        }
        if (e.getSource() == btnDiv && !isCalculated) {
            tfOutput.setText(tfOutput.getText() + "/");
        }

        if (e.getSource() == btnBackspace) {
            if (isCalculated) {
                tfOutput.setText("");
                isCalculated = false;
            } else {
                tfOutput.setText(tfOutput.getText().substring(0, tfOutput.getText().length() - 1));
            }
        }
        if (e.getSource() == btnClear) {
            tfOutput.setText("");
        }
        if (e.getSource() == btnExecute) {
            String result = tinhToanBieuThucHauTo(chuyenSangDangHauTo(tfOutput.getText()));

            if (result != null) {
                tfOutput.setText(result);
                isCalculated = true;
            }
        }
    }

    private String[] chuyenSangDangHauTo(String inputLine) {
        Stack<String> stack = new Stack<>();
        String result[];
        String output = "";
        String number = "";

        //kiểm tra nếu ký tự bắt đầu hoặc kết thúc là toán tử
        if (isOperator(inputLine.charAt(0)) || isOperator(inputLine.charAt(inputLine.length() - 1))) {
            System.out.println("return null");
            return null;
        }

        for (int i = 0; i < inputLine.length(); i++) {
            char c = inputLine.charAt(i);

            //nếu c là số
            if (isNumber(c)) {
                //ghép các chữ số liền nhau thành một số
                number = number + c;

                //nếu ký tự cuối cùng là số
                //thì đưa number vào output luôn, nếu không sẽ thiếu 1 toán hạng
                if (i == inputLine.length() - 1) {

                    //lần đầu tiên thêm vào sẽ thừa 1 dấu 'khoảng trắng'
                    //sẽ được loại bỏ khi hoàn thành chuỗi output
                    output = output + " " + number;
                }
            } else {
                if (!number.equals("")) {
                    output = output + " " + number;
                    number = "";
                }

                //nếu c là toán tử
                if (isOperator(c)) {
                    switch (c) {
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                            //chừng nào (while) ở đỉnh stack là toán tử
                            //và toán tử đó ưu tiên hơn hoặc bằng toán tử hiện tại (c)
                            //toán tử trong stack --> output
                            while (!stack.isEmpty() && priority(stack.peek().charAt(0)) >= priority(c)) {
                                output = output + " " + stack.pop();
                            }

                            //cuối cùng: toán tử hiện tại --> stack
                            stack.push(c + "");
                            break;
                    }
                } else {
                    return null;
                }
            }
        }
        //đưa hết các phần tử còn lại ở stack vào output
        while (!stack.isEmpty()) {
            output = output + " " + stack.pop();
        }

        //loại bỏ dấu 'khoảng trống' đầu tiên trong chuỗi output
        output = output.substring(1);

        //tách output thành mảng các String và return
        result = output.split(" ");
        return result;
    }

    private String tinhToanBieuThucHauTo(String[] input) {
        Stack<String> stack = new Stack<>();

        if (input == null) {
            return null;
        } else {
            for (int i = 0; i < input.length; i++) {
                char c = input[i].charAt(0);

                //nếu là toán hạng thì đưa vào stack
                if (!isOperator(c)) {
                    stack.push(input[i]);
                } else {
                    double num = 0f;

                    //nếu là toán tử
                    //lấy 2 toán hạng ra
                    double num_1 = Float.parseFloat(stack.pop());
                    double num_2 = Float.parseFloat(stack.pop());

                    //tính kết quả của 2 toán hạng dựa trên toán tử hiện tại
                    switch (c) {
                        case '+':
                            num = num_2 + num_1;
                            break;
                        case '-':
                            num = num_2 - num_1;
                            break;
                        case '*':
                            num = num_2 * num_1;
                            break;
                        case '/':
                            num = num_2 / num_1;
                            break;
                        default:
                            break;
                    }
                    //push kết quả vừa tính vào stack
                    stack.push(Double.toString(num));
                }
            }
            //phần tử cuối cùng còn lại trong stack là kết quả phép tính
            return stack.pop();
        }
    }

    /**
     * Độ ưu tiên của các toán tử
     *
     * @param operator
     * @return
     */
    private int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;

    }

    /**
     * Kiểm tra ký tự có phải là toán tử không
     *
     * @param operator
     * @return
     */
    private boolean isOperator(char operator) {
        switch (operator) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    /**
     * Kiểm tra ký tự có phải là số không
     *
     * @param number
     * @return
     */
    private boolean isNumber(char number) {
        if ((int) number > 47 && (int) number < 58) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new _4__11_Calculator();
    }

}
