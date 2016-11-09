/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLDs
 */
public class _1_2_server extends Thread {

    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void main(String[] args) {

        int port = 7777;

        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("Server is running............");
        while (true) {
            try {
                socket = serverSocket.accept();
                new ClientThread(socket).start();

            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
    }

    static class ClientThread extends Thread {

        private Socket socket = null;
        private DataInputStream inputStream = null;
        private DataOutputStream outputStream = null;

        public ClientThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                inputStream = new DataInputStream(this.socket.getInputStream());
                outputStream = new DataOutputStream(this.socket.getOutputStream());
                String inputLine, processedLine = "";
                while (true) {
                    inputLine = inputStream.readUTF();
                    System.out.println(inputLine);
                    processedLine = tinhToanBieuThucHauTo(chuyenSangDangHauTo(inputLine));
                    outputStream.writeUTF(processedLine);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        }

        private String[] chuyenSangDangHauTo(String inputLine) {
            Stack<String> stack = new Stack<>();
            String result[];
            String output = "";
            String number = "";

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
                            case '(':
                                stack.push(c + "");
                                break;
                            case ')':
                                //lấy hết các toán hạng đứng giữa 2 dấu ngoặc bỏ vào output
                                while (stack.peek().charAt(0) != '(') {
                                    output += " " + stack.pop();
                                }
                                //bỏ dấu mở ngoặc '(' khỏi stack
                                stack.pop();
                                break;
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

            //kiểm tra nếu còn dư dấu '(' hay ')' nào tức là sai cú pháp
            if (output.contains("(") || output.contains(")")) {
                return null;
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
                System.out.println("KET QUA TINH TOAN: nhap sai roi!");
                return "Bạn nhập sai cú pháp rồi !";
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
                case '(':
                case ')':
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

    }
}
