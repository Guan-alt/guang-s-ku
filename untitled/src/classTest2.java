import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName: classtest2
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/14 - 16:53
 */
public class classTest2 {
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> newList = new ArrayList<>();

    public static void main(String[] args) {
        init();
        group(list);
    }

    public static void init(){
        Random random = new Random();
        for (int i = 0; i < 20; i++){
            list.add(random.nextInt(1,30));
        }
        System.out.println(list);
    }

    public static void group(List<Integer> list){
        for (Integer i : list) {
            if(i % 2 == 0){
                newList.add(i);
            }
        }
  /*      for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0){
                newList.add(list.get(i));
            }
        }*/
        System.out.println(newList);
    }
}
