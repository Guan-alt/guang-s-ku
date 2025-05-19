package demo1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * ClassName: ImageCode
 * Package: demo1
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/16 - 11:29
 */
public class ImageCode {
    static String[] strs = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
    };

    public static void main(String[] args) throws IOException {
        //定义图片的宽度、高度
        int width = 150;
        int height = 50;

        //1.画板  ctrl+p查看方法参数
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //图片颜色修改

        //获取画笔对象，可以在画板进行操作
        Graphics g = image.createGraphics();

        //设置画笔颜色来画矩形
        g.setColor(getRandomColor(255,0, 128));
        //画填充矩形,x,y为填充矩形起始位置
        g.fillRect(0, 0, width, height);

        //重新设置画笔颜色来写字符串
        g.setColor(getRandomColor(255,128, 256));
        //设置字体(字体，是否加粗（plain正常，bold加粗），字体大小)
        g.setFont(new Font("楷体", Font.BOLD, 25));
        //产生随机数
        Random random = new Random();
        //透明度设置


        //设置字的位置
        int x = 30;
        int y = 30;

        //for循环随机获取4个数据
        for (int i = 0; i < 4; i++) {
            //获取随机数
            int num = random.nextInt(strs.length);
            //每次取一个
            String str = strs[num];
            g.drawString(str, x, y);
            //每次写字符串都往后平移一段距离
            x += 25;
        }

        //重新设置画笔颜色画干扰线
        g.setColor(getRandomColor(200,0, 126));
        //画一些干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(30), y1 = random.nextInt(50);
            int x2 = random.nextInt(30) + 120, y2 = random.nextInt(50);
            //确定两个点才能画线（x1，y1）（x2，y2）
            g.drawLine(x1, y1, x2, y2);
        }

        //把image生成到本地磁盘
        ImageIO.write(image, "jpg", new File("D:\\Desktop\\Ideaproject\\tx_ImageCode\\img\\a.jpg"));
    }

    //随机颜色方法,高亮颜色
    public static Color getRandomColor(int a, int x, int y) {
        Random random = new Random();
        int r = random.nextInt(x, y);
        int g = random.nextInt(x, y);
        int b = random.nextInt(x, y);

        return new Color(a, r, g, b);
    }


}
