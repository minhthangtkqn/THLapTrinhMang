/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoCaro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author TLDs
 */
class Ball {

    public int x, y, radius;
    public int xSpeed, ySpeed;
    public int WindowWidth, WindowHeight;
    public int red, green, blue;

    public int random(int MinValue, int MaxValue) {
        return (MaxValue - (int) Math.round(Math.random() * MinValue));
    }

    public Ball(int WindowWidth, int WindowHeight) {
        radius = random(10, 20);
        x = random(2 * radius, WindowWidth - 2 * radius);
        y = random(2 * radius, WindowHeight - 2 * radius);
        xSpeed = random(-5, 5);
        ySpeed = random(-5, 5);
        this.WindowWidth = WindowWidth;
        this.WindowHeight = WindowHeight;

        red = random(0, 255);
        green = random(0, 255);
        blue = random(0, 255);

    }

    public Ball() {
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

//        if (x - radius < 0 && xSpeed < 0) {
//            xSpeed = -xSpeed;
//        } else if (x + radius > this.WindowWidth && xSpeed > 0) {
//            xSpeed = -xSpeed;
//        } else if (y - radius < 0 && ySpeed < 0) {
//            ySpeed = -ySpeed;
//        } else if (y + radius > this.WindowHeight && ySpeed > 0) {
//            ySpeed = -ySpeed;
//        }
    }

}

public class bunchOfBalls extends JFrame implements Runnable {

    int numberOfBalls = 20;
    int widthOfWindow = 800;
    int heightOfWindows = 500;
    int framePerSecond = 24;
    int ballMaxSpeed = 4;

    Random random = new Random();

    Ball[] ball = new Ball[100];

    public bunchOfBalls() {

        this.setSize(widthOfWindow, heightOfWindows);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        for (int i = 0; i < numberOfBalls; i++) {
            ball[i] = new Ball();

            ball[i].radius = 10 + random.nextInt(10);
            ball[i].x = 2 * ball[i].radius + random.nextInt(widthOfWindow - 4 * ball[i].radius);
            ball[i].y = 2 * ball[i].radius + random.nextInt(heightOfWindows - 4 * ball[i].radius);

            ball[i].xSpeed = -ballMaxSpeed + random.nextInt(ballMaxSpeed * 2);
            ball[i].ySpeed = -ballMaxSpeed + random.nextInt(ballMaxSpeed * 2);

            ball[i].red = random.nextInt(255);
            ball[i].green = random.nextInt(255);
            ball[i].blue = random.nextInt(255);

            ball[i].WindowWidth = widthOfWindow;
            ball[i].WindowHeight = heightOfWindows;
        }

        Thread game = new Thread(this);
        game.start();
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < numberOfBalls; i++) {
                ball[i].move();
                collission(ball[i]);
            }

            repaint();

            try {
                Thread.sleep(1000 / framePerSecond);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void collission(Ball ba) {

        for (int i = 0; i < numberOfBalls; i++) {

            if (ba.x - ba.radius < 0) {
                ba.x = ba.radius;
                if (ba.xSpeed < 0) {
                    ba.xSpeed = -ba.xSpeed;
                }
            } else if (ba.x + ba.radius > this.getWidth()) {
                ba.x = this.getWidth() - ba.radius;
                if (ba.xSpeed > 0) {
                    ba.xSpeed = -ba.xSpeed;
                }
            } else if (ba.y - ba.radius < 0) {
                ba.y = ba.radius;
                if (ba.ySpeed < 0) {
                    ba.ySpeed = -ba.ySpeed;
                }
            } else if (ba.y + ba.radius > this.getHeight()) {
                ba.y = this.getHeight() - ba.radius;
                if (ba.ySpeed > 0) {
                    ba.ySpeed = -ba.ySpeed;
                }
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < numberOfBalls; i++) {
            g.setColor(new Color(ball[i].red, ball[i].green, ball[i].blue));
            g.fillOval(ball[i].x - ball[i].radius, ball[i].y - ball[i].radius,
                    ball[i].radius * 2, ball[i].radius * 2);
        }

    }

    public static void main(String[] args) {
        bunchOfBalls a = new bunchOfBalls();
    }

}
