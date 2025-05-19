package cn.tx;

import javax.swing.*;
import java.awt.*;

/**
 * ClassName: EnemyPlane
 * Package: cn.tx
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/14 - 20:25
 */
public class EnemyPlane extends Thread{
    public  GameFrame gf;
    //敌机的坐标、大小、速度、血量
    public int x,y;
    public int width = 50,height = 50;
    public int speed = 1;
    public int blood = 3;

    //敌机样式
    public Image img = new ImageIcon("img/enemyPlane01.png").getImage();


    public EnemyPlane(GameFrame gf, int x, int y) {
        this.gf = gf;
        this.x = x;
        this.y = y;
    }
    public EnemyPlane(GameFrame gf, int x, int y, int width, int height) {
        this.gf = gf;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void run(){
        while (true){
            while (true){
                if(this.blood == 0) {
                    this.speed = 0;
                    this.img = new ImageIcon("img/die.png").getImage();
                    try {
                        this.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    gf.enemys.remove(this);
                    break;
                }
                if(hit()){
                    System.out.println("hit...............");
                    this.blood -= 1;
//                    System.out.println(blood);
                    break;
                }
                try {
                    this.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
                if(this.y >= 500){
                    break;
                }
            try {
                this.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //碰撞检测
    public boolean hit(){
        Rectangle myrect = new Rectangle(this.x, this.y, this.width, this.height);

        Rectangle rect = null;

        for (int i = 0; i < gf.bullets.size(); i++) {
            Bullet bullet = gf.bullets.get(i);
//            System.out.println("test hit");
            rect = new Rectangle(bullet.x, bullet.y-1, bullet.width, bullet.height);
            //碰撞检测
            if(myrect.intersects(rect)){
                gf.bullets.remove(bullet);
                return true;
            }
        }

        return false;
    }
}
