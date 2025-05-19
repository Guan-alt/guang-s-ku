package cn.tx;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName: bullet
 * Package: cn.tx
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/14 - 19:30
 */
public class Bullet {
    //面板上的坐标和大小
    int x, y;
    int width = 10, height = 15;

    //定义默认速度
    int speed = 10;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //定义子弹外观（贴图）
    Image image = new ImageIcon("img/bullet01.png").getImage();

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


}
