/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoCaro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author TLDs
 */
public class TestSnake extends JFrame {

    private final int BOX_WIDTH = 500;
    private final int BOX_HEIGHT = 500;
    private final int DOT_SIZE = 20;
    private final int NUM_DOTS = 10;
    private final int DELAY = 200;

//    private int deltaHeight;
    //default direction is 3 -> right
    //          2 : up
    //  1: left         3:right
    //          4: down
    private int DIRECTION = 3;

    ArrayList<Point> snakeBody;

    class SnakeComponent extends JComponent implements KeyListener, Runnable {

        public SnakeComponent() {
            addKeyListener(this);
        }
        
        public void startGame(){
            Thread snakeGame = new Thread(this);
            snakeGame.start();
        }

        @Override
        public void paint(Graphics g) {
            //vẽ nền trắng
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            //vẽ rắn
            for (int i = 0; i < snakeBody.size(); i++) {
                g.setColor(Color.green);
                if (i == 0) {
                    g.setColor(Color.red);
                }
                g.fillRect(snakeBody.get(i).x * DOT_SIZE, snakeBody.get(i).y * DOT_SIZE, DOT_SIZE, DOT_SIZE);
                g.setColor(Color.black);
                g.drawRect(snakeBody.get(i).x * DOT_SIZE, snakeBody.get(i).y * DOT_SIZE, DOT_SIZE, DOT_SIZE);
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyCode() == 38) {
                if (snakeBody.get(1).y >= snakeBody.get(0).y) {
                    DIRECTION = 2;
                    //up
                    System.out.println("up");
                }
            } else if (e.getKeyCode() == 40) {
                if (snakeBody.get(1).y <= snakeBody.get(0).y) {
                    DIRECTION = 4;
                    //down
                    System.out.println("down");
                }
            } else if (e.getKeyCode() == 37) {
                if (snakeBody.get(1).x >= snakeBody.get(0).x) {
                    DIRECTION = 1;
                    //left
                    System.out.println("left");
                }
            } else if (e.getKeyCode() == 39) {
                if (snakeBody.get(1).x <= snakeBody.get(0).x) {
                    DIRECTION = 3;
                    //right
                    System.out.println("right");
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 38) {
                if (snakeBody.get(1).y >= snakeBody.get(0).y) {
                    DIRECTION = 2;
                    //up
                    System.out.println("up");
                }
            } else if (e.getKeyCode() == 40) {
                if (snakeBody.get(1).y <= snakeBody.get(0).y) {
                    DIRECTION = 4;
                    //down
                    System.out.println("down");
                }
            } else if (e.getKeyCode() == 37) {
                if (snakeBody.get(1).x >= snakeBody.get(0).x) {
                    DIRECTION = 1;
                    //left
                    System.out.println("left");
                }
            } else if (e.getKeyCode() == 39) {
                if (snakeBody.get(1).x <= snakeBody.get(0).x) {
                    DIRECTION = 3;
                    //right
                    System.out.println("right");
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == 38) {
                if (snakeBody.get(1).y >= snakeBody.get(0).y) {
                    DIRECTION = 2;
                    //up
                    System.out.println("up");
                }
            } else if (e.getKeyCode() == 40) {
                if (snakeBody.get(1).y <= snakeBody.get(0).y) {
                    DIRECTION = 4;
                    //down
                    System.out.println("down");
                }
            } else if (e.getKeyCode() == 37) {
                if (snakeBody.get(1).x >= snakeBody.get(0).x) {
                    DIRECTION = 1;
                    //left
                    System.out.println("left");
                }
            } else if (e.getKeyCode() == 39) {
                if (snakeBody.get(1).x <= snakeBody.get(0).x) {
                    DIRECTION = 3;
                    //right
                    System.out.println("right");
                }
            }
        }

        @Override
        public void run() {
            while (true) {

                move();
                repaint();

                try {
                    Thread.sleep(DELAY);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        private void move() {
            switch (DIRECTION) {
                //left
                case 1:
                    for (int i = snakeBody.size() - 1; i >= 0; i--) {
                        if (i == 0) {
                            if (snakeBody.get(i).x > 0) {
                                snakeBody.get(i).x -= 1;
                            } else {
                                snakeBody.get(i).x = BOX_WIDTH / DOT_SIZE - 1;
                            }
                        } else {
                            snakeBody.get(i).x = snakeBody.get(i - 1).x;
                            snakeBody.get(i).y = snakeBody.get(i - 1).y;
                        }
                    }
                    break;

                //up    
                case 2:
                    for (int i = snakeBody.size() - 1; i >= 0; i--) {
                        if (i == 0) {
                            if (snakeBody.get(i).y > 0) {
                                snakeBody.get(i).y -= 1;
                            } else {
                                snakeBody.get(i).y = BOX_HEIGHT / DOT_SIZE - 1;
                            }
                        } else {
                            snakeBody.get(i).x = snakeBody.get(i - 1).x;
                            snakeBody.get(i).y = snakeBody.get(i - 1).y;
                        }
                    }

                    break;

                //right
                case 3:
                    for (int i = snakeBody.size() - 1; i >= 0; i--) {
                        if (i == 0) {
                            if (snakeBody.get(i).x < BOX_WIDTH / DOT_SIZE - 1) {
                                snakeBody.get(i).x += 1;
                            } else {
                                snakeBody.get(i).x = 0;
                            }
                        } else {
                            snakeBody.get(i).x = snakeBody.get(i - 1).x;
                            snakeBody.get(i).y = snakeBody.get(i - 1).y;
                        }
                    }

                    break;

                //down
                case 4:
                    for (int i = snakeBody.size() - 1; i >= 0; i--) {
                        if (i == 0) {
                            if (snakeBody.get(i).y < BOX_HEIGHT / DOT_SIZE - 1) {
                                snakeBody.get(i).y += 1;
                            } else {
                                snakeBody.get(i).y = 0;
                            }
                        } else {
                            snakeBody.get(i).x = snakeBody.get(i - 1).x;
                            snakeBody.get(i).y = snakeBody.get(i - 1).y;
                        }
                    }

                    break;
            }
        }

    }

    public TestSnake() {
        initSnakeBody();

        setContentPane(new SnakeComponent());
        getContentPane().setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
        pack();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setVisible(true);

        getContentPane().repaint();
        
    }

    private void initSnakeBody() {
        snakeBody = new ArrayList<>();

        for (int i = 0; i < NUM_DOTS; i++) {
            snakeBody.add(new Point(BOX_WIDTH / (2 * DOT_SIZE) - i, BOX_HEIGHT / (2 * DOT_SIZE)));
        }
    }

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//
//        for (int i = 0; i < snakeBody.size(); i++) {
//            g.setColor(Color.green);
//            if (i == 0) {
//                g.setColor(Color.red);
//            }
//            g.fillRect(snakeBody.get(i).x * DOT_SIZE, snakeBody.get(i).y * DOT_SIZE + deltaHeight, DOT_SIZE, DOT_SIZE);
//            g.setColor(Color.black);
//            g.drawRect(snakeBody.get(i).x * DOT_SIZE, snakeBody.get(i).y * DOT_SIZE + deltaHeight, DOT_SIZE, DOT_SIZE);
//        }
//    }
//    private void move() {
//        switch (DIRECTION) {
//            //left
//            case 1:
//                for (int i = snakeBody.size() - 1; i >= 0; i--) {
//                    if (i == 0) {
//                        if (snakeBody.get(i).x > 0) {
//                            snakeBody.get(i).x -= 1;
//                        } else {
//                            snakeBody.get(i).x = BOX_WIDTH / DOT_SIZE - 1;
//                        }
//                    } else {
//                        snakeBody.get(i).x = snakeBody.get(i - 1).x;
//                        snakeBody.get(i).y = snakeBody.get(i - 1).y;
//                    }
//                }
//                break;
//
//            //up    
//            case 2:
//                for (int i = snakeBody.size() - 1; i >= 0; i--) {
//                    if (i == 0) {
//                        if (snakeBody.get(i).y > 0) {
//                            snakeBody.get(i).y -= 1;
//                        } else {
//                            snakeBody.get(i).y = BOX_HEIGHT / DOT_SIZE - 1;
//                        }
//                    } else {
//                        snakeBody.get(i).x = snakeBody.get(i - 1).x;
//                        snakeBody.get(i).y = snakeBody.get(i - 1).y;
//                    }
//                }
//
//                break;
//
//            //right
//            case 3:
//                for (int i = snakeBody.size() - 1; i >= 0; i--) {
//                    if (i == 0) {
//                        if (snakeBody.get(i).x < BOX_WIDTH / DOT_SIZE - 1) {
//                            snakeBody.get(i).x += 1;
//                        } else {
//                            snakeBody.get(i).x = 0;
//                        }
//                    } else {
//                        snakeBody.get(i).x = snakeBody.get(i - 1).x;
//                        snakeBody.get(i).y = snakeBody.get(i - 1).y;
//                    }
//                }
//
//                break;
//
//            //down
//            case 4:
//                for (int i = snakeBody.size() - 1; i >= 0; i--) {
//                    if (i == 0) {
//                        if (snakeBody.get(i).y < BOX_HEIGHT / DOT_SIZE - 1) {
//                            snakeBody.get(i).y += 1;
//                        } else {
//                            snakeBody.get(i).y = 0;
//                        }
//                    } else {
//                        snakeBody.get(i).x = snakeBody.get(i - 1).x;
//                        snakeBody.get(i).y = snakeBody.get(i - 1).y;
//                    }
//                }
//
//                break;
//        }
//    }
    public static void main(String[] args) {
        Snake snake = new Snake();
    }

}
