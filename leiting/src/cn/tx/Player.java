package cn.tx;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * ClassName: Player
 * Package: cn.tx
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/14 - 15:39
 */
public class Player extends KeyAdapter {
    GameFrame frame;

    public Player(GameFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //获取键盘输入
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        //键盘的上下左右分别对应38,40,37,39，空格是32
        final int[] directionControl = {38 ,40 ,37 ,39};
        final int fireKey = 32;

        /*final int[] directionControl = {87 ,83 ,65 ,68};
        final int fireKey = 32;*/
        /*switch (keyCode){
            case 38:
                frame.heroPlane.up = true;
                break;
            case 40:
                frame.heroPlane.down = true;
                break;
            case 37:
                frame.heroPlane.left = true;
                break;
            case 39:
                frame.heroPlane.right = true;
                break;
            case fireKey:
                fire();
                break;
        }*/
        if(keyCode == directionControl[0])
            frame.heroPlane.up = true;
        else if (keyCode == directionControl[1])
            frame.heroPlane.down = true;
        else if (keyCode == directionControl[2])
            frame.heroPlane.left = true;
        else if (keyCode == directionControl[3])
            frame.heroPlane.right = true;
        else if (keyCode == fireKey)
            fire();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //获取键盘输入
        int keyCode = e.getKeyCode();
        //键盘的上下左右分别对应38,40,37,39
        switch (keyCode){
            case 38:
                frame.heroPlane.up = false;
                break;
            case 40:
                frame.heroPlane.down = false;
                break;
            case 37:
                frame.heroPlane.left = false;
                break;
            case 39:
                frame.heroPlane.right = false;
                break;
        }
    }

    //发射子弹
    public void fire(){
        //子弹发射的位置
        frame.bullets.add(new Bullet(frame.heroPlane.x+20,frame.heroPlane.y-10));
    }
}
