import MyBib.*;
import utils.SwingUtils;

import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {   /**Standart JAVA Util*/
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(3);
        q.add(2);
        q.add(0);
        q.add(11);
        q.add(10101);
        q.add(-100);
        System.out.println(q+" "+q.size());
        int tmp = 0;
        for (int i = 0; i < q.size(); i++) {
            tmp = q.poll();
            for (int j = 0; j < q.size(); j++) {
                int tmp2 = q.poll();
                if(tmp2>tmp){
                    q.add(tmp);
                    tmp = tmp2;
                }else {
                    q.add(tmp2);
                }
            }
            q.add(tmp);
        }
        System.out.println(q + "\n##############################");
        main2();
    }
    public static void main2() throws Exception {   /**MyQueue*/
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(3);
        q.add(2);
        q.add(0);
        q.add(11);
        q.add(10101);
        q.add(-100);
        System.out.println(q.asString() + " " + q.size());
        int tmp = 0;
        for (int i = 0; i < q.size(); i++) {
            tmp = q.poll();
            for (int j = 0; j < q.size(); j++) {
                int tmp2 = q.poll();
                if (tmp2 > tmp) {
                    q.add(tmp);
                    tmp = tmp2;
                } else {
                    q.add(tmp2);
                }
            }
            q.add(tmp);
        }
        System.out.println(q.asString());
        winMain();
    }
    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Table().setVisible(true);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}