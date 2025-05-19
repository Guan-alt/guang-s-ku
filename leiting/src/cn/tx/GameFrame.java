package cn.tx;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ClassName: GameFrame
 * Package: cn.tx
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/14 - 14:52
 */
public class GameFrame extends JFrame {
    //声明英雄机
    HeroPlane heroPlane;
    //定义子弹集合
//    Vector<Bullet> bullets =new Vector<>();
    CopyOnWriteArrayList<Bullet>  bullets = new CopyOnWriteArrayList<>();
    //定义敌机集合
    Vector<EnemyPlane> enemys = new Vector<>();
    GameFrame frame;
    public GameFrame(){
        frame = this;
        //实例化英雄机
        heroPlane = new HeroPlane();
        heroPlane.start();
        //设置窗体的宽高
        this.setSize(300,500);
        //标题
        this.setTitle("雷霆战机");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //窗口可见
        this.setVisible(true);

        //创建线程不断执行paint方法，实现动态效果
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }).start();

        //产生敌机的线程
        new Thread(new Runnable() {
            //创建随机数对象
            Random r = new Random();

            @Override
            public void run() {
                while (true){
                    //添加敌机时，让敌机x轴随机
                    EnemyPlane enemyPlane = new EnemyPlane(frame,r.nextInt(25,275),0);
                    enemyPlane.start();
                    enemys.add(enemyPlane);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }


    /**
     * 在窗口画内容，paint这个画笔的方法在窗口初始化时默认执行
     */
    public void  paint(Graphics g){
//        System.out.println("绘制画板");
        //画背景
        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width,this.getSize().height);
        //高效缓存的画笔
        Graphics bi = image.getGraphics();

        //绘制背景
        bi.drawImage(new ImageIcon("img/map01.jpg").getImage(),0,0,null);
        /**
         * 绘制英雄机
         * x,y为坐标值，width，height为飞机的大小
         */
        bi.drawImage(heroPlane.img,heroPlane.x,heroPlane.y,heroPlane.width,heroPlane.height,null);

        //绘制子弹
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if(bullet.y > 0)
                bi.drawImage(bullet.image,bullet.x,bullet.y -= bullet.speed,bullet.width,bullet.height,null);
            else
                bullets.remove(bullet);
        }

        //绘制敌机
        for (int i = 0; i < enemys.size(); i++) {
            EnemyPlane ep = enemys.get(i);

            if(ep.y < 500 )
                bi.drawImage(ep.img,ep.x,ep.y += ep.speed,ep.width,ep.height,null);
            else
                enemys.remove(ep);
        }
        //生效
        g.drawImage(image, 0,0,null);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        Player player = new Player(frame);
        //frame启动后使用player的按键控制
        frame.addKeyListener(player);
    }
}
