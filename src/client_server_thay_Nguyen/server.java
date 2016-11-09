package client_server_thay_Nguyen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class server {

    public static void ConnectionDatabase(String data) throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.print("Server is running............");
        try {
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String snhan = inputStream.readUTF();
                String stra = xulychuoi(snhan);
                outputStream.writeUTF(stra);

            }
        } catch (Exception ex) {
            System.out.println("Da co loi xay ra: " + ex);
        }
    }

    public static String xulychuoi(String s) {
        float ket_qua = 0;
        int i = 0;
        float giatritam = 0;
        while (i < s.length()) {
            while ((s.charAt(i) != '+') && ((s.charAt(i) != '-')) && (s.charAt(i) != '*') && (s.charAt(i) != '/')) {
                ket_qua = ket_qua * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                i++;
            }
            if (s.charAt(i) == '+') {
                i++;
                while ((i < s.length() && (s.charAt(i) != '+') && ((s.charAt(i) != '-')) && (s.charAt(i) != '*') && (s.charAt(i) != '/'))) {
                    giatritam = giatritam * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                    i++;
                }
                ket_qua += giatritam;
                giatritam = 0;
            }
            if ((i < s.length()) && (s.charAt(i) == '-')) {
                i++;
                while ((i < s.length() && (s.charAt(i) != '+') && ((s.charAt(i) != '-')) && (s.charAt(i) != '*') && (s.charAt(i) != '/'))) {
                    giatritam = giatritam * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                    i++;
                }
                ket_qua -= giatritam;
                giatritam = 0;
            }
            if ((i < s.length()) && (s.charAt(i) == '*')) {
                i++;
                while ((i < s.length() && (s.charAt(i) != '+') && ((s.charAt(i) != '-')) && (s.charAt(i) != '*') && (s.charAt(i) != '/'))) {
                    giatritam = giatritam * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                    i++;
                }
                ket_qua *= giatritam;
                giatritam = 0;
            }
            if ((i < s.length()) && (s.charAt(i) == '/')) {
                i++;
                while ((i < s.length() && (s.charAt(i) != '+') && ((s.charAt(i) != '-')) && (s.charAt(i) != '*') && (s.charAt(i) != '/'))) {
                    giatritam = giatritam * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                    i++;
                }
                ket_qua /= giatritam;
                giatritam = 0;
            }

        }
        System.out.print(ket_qua);
        return String.valueOf(ket_qua);
    }

}
