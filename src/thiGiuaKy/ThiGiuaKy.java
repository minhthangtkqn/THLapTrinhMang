/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiGiuaKy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author TLDs
 */
public class ThiGiuaKy extends JFrame {

    private final int n = 6;
    private final int boxSize = 50;
    private final int dx = 50;
    private final int dy = 50;

    private Random random = new Random();

    private MatrixNumbers matrix = new MatrixNumbers(n);

    private int[] rangeValue = new int[n];

    private boolean clickedFirst = false;
    private boolean wrongBox = false;

    private Point clickFirstPosition = new Point();
    private Point clickSecondPosition = new Point();

    class GameComponent extends JComponent implements MouseListener, Runnable {

        public GameComponent() {
            this.addMouseListener(this);
        }

        public void paint(Graphics g) {
            //ve nen mau trang
            g.setColor(Color.white);
            g.fillRect(0, 0, dx * 2 + n * boxSize, dy * 2 + n * boxSize);

            g.setColor(Color.black);

            //ve line
            for (int i = 0; i <= n; i++) {
                g.drawLine(dx, dy + i * boxSize, dx + n * boxSize, dy + i * boxSize);
                g.drawLine(dx + i * boxSize, dy, dx + i * boxSize, dy + n * boxSize);
            }

            //ve so
            for (int hang = 0; hang < n; hang++) {
                for (int cot = 0; cot < n; cot++) {
                    if (matrix.getCheck(hang, cot)) {
                        String chu = "" + matrix.getValue(hang, cot);

                        g.setFont(new Font("Times New Roman", Font.BOLD, boxSize * 2 / 3));
                        g.setColor(Color.black);

                        int x = dx + boxSize * cot + boxSize * 1 / 3;
                        int y = dy + boxSize * hang + boxSize * 3 / 4;

                        g.drawString(chu, x, y);
                    }
                }
            }
            
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
            //nếu ô bấm sai vẫn chưa úp lại thì không cho làm gì hết
            if(wrongBox){
                return;
            }
            
            int cot = (e.getX() - dx) / boxSize;
            int hang = (e.getY() - dy) / boxSize;

            if (e.getX() < dx || e.getY() < dy || e.getX() >= dx + n * boxSize || e.getY() >= dy + n * boxSize) {
                System.out.println("Đánh trật rồi cha, mấy ô trống ở kia kìa! -_-\"");
                return;
            }

            //kiểm tra lần bấm thứ mấy
            if (clickedFirst) {
                //xử lý lần bấm thứ 2
                System.out.println("Second Time");

                if (!matrix.getCheck(hang, cot)) {
                    int secondClick = matrix.getValue(hang, cot);

                    if (secondClick == matrix.getValue(clickFirstPosition.y, clickFirstPosition.x)) {
                        matrix.setCheck(hang, cot, true);
                    } else {
                        clickSecondPosition.setLocation(cot, hang);
                        System.out.println("Chon sai o roi ban");
                        matrix.setCheck(hang, cot, true);
                        
                        //tạo thread để chờ
                        //hiển thị nội dung ô sai
                        //rồi sau đó xóa cả 2 ô
                        Thread wait = new Thread(this);
                        wait.start();
                    }
                    clickedFirst = false;
                }

            } else {
                //xử lý lần bấm thứ nhất
                System.out.println("First Time");

                if (!matrix.getCheck(hang, cot)) {
                    clickFirstPosition.setLocation(cot, hang);
                    matrix.setCheck(hang, cot, true);
                    clickedFirst = true;
                }
            }

            this.repaint();

            System.out.println("Bạn đã click vào hàng: " + (hang + 1));
            System.out.println("Bạn đã click vào cột : " + (cot + 1));
            System.out.println("Giá trị tại ô này là : " + matrix.getValue(hang, cot));
            System.out.println("");

            showMatrix();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void run() {
            wrongBox = true;
            
            repaint();
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            matrix.setCheck(clickFirstPosition.y, clickFirstPosition.x, false);
            matrix.setCheck(clickSecondPosition.y, clickSecondPosition.x, false);
            
            repaint();
            wrongBox = false;
        }
    }

    public ThiGiuaKy() {

        Dimension window_size = new Dimension(dx * 2 + n * boxSize, dy * 2 + n * boxSize);

        setContentPane(new GameComponent());
        getContentPane().setPreferredSize(window_size);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Thi Giữa Kỳ - Hoàng Minh Thắng - 13TCLC");
        setLocationRelativeTo(null);
        setVisible(true);

        //khởi tạo các giá trị
        initChecked();
        initRangeValue();
        initValues();

        showMatrix();

        this.getContentPane().repaint();
    }

    private void showMatrix() {
        //show matrix on the console
        for (int hang = 0; hang < n; hang++) {
            for (int cot = 0; cot < n; cot++) {
                System.out.print(" " + matrix.getValue(hang, cot));
            }
            System.out.println("");
        }
    }

    private void initChecked() {
        //init checked value to all of boxs
        for (int hang = 0; hang < n; hang++) {
            for (int cot = 0; cot < n; cot++) {
                matrix.setCheck(hang, cot, false);
            }
        }
    }

    private void initRangeValue() {
        for (int i = 0; i < n; i++) {
            rangeValue[i] = 0;
        }
    }

    private void initValues() {
        //init value 0 to all of boxs
        for (int hang = 0; hang < n; hang++) {
            for (int cot = 0; cot < n; cot++) {
                matrix.setValue(hang, cot, 0);
            }
        }

        //change value to 1 -> n
        for (int hang = 0; hang < n; hang++) {
            for (int cot = 0; cot < n; cot++) {
                while (matrix.getValue(hang, cot) == 0) {
                    int randomNumber = 1 + random.nextInt(n);

                    if (rangeValue[randomNumber - 1] < n) {
                        matrix.setValue(hang, cot, randomNumber);
                        rangeValue[randomNumber - 1]++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ThiGiuaKy thiGiuaKy = new ThiGiuaKy();
    }

}
