package cn.tx;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName: HeroPlane
 * Package: cn.tx
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/14 - 15:22
 */
public class HeroPlane extends Thread{
    //设置英雄机在画板的默认位置参数
    int x =125 , y = 430;
    int width = 50, height = 50;
    //飞机移动速度
    int speed = 10;

    //设置英雄机的图片
    Image img = new ImageIcon("img/10011.png").getImage();

    //定义方向键的标志
    boolean up,down,left,right,fire;


    public HeroPlane() {
    }

    public HeroPlane(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        while (true) {
            if (up) {
//                y -= speed;
//                if (y <= 38) {
//                    y = 38;
//                }
                y = y <= 38 ? 38 : y-speed;
            } else if (down) {
                y = y >= 440 ? 440 : y+speed;
            } else if (left) {
//                x -= speed;
//                if (x < 20) {
//                    break;
//                }
                x = x <= 20 ? 20 : x-speed;
            } else if (right) {
                x = x >= 230 ? 230 : x+speed;
            }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }

    }
}
