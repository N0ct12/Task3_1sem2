package ru.vsu.cs.vvp2022.teslyuk_n_v;

import ru.vsu.cs.vvp2022.teslyuk_n_v.mylib.*;
import ru.vsu.cs.vvp2022.teslyuk_n_v.utils.ListUtils;
import ru.vsu.cs.vvp2022.teslyuk_n_v.utils.SwingUtils;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.*;


public class Main {

    public static class CmdParams {
        public boolean error;
        public boolean help;
        public boolean window;

        public boolean java;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args[0].equals("--help")) {
            params.help = true;
            return params;
        } else if (args[0].equals("--win")) {
            params.window = true;
            return params;
        } else if (args[0].equals("-j")) {
            params.java = true;
            return params;
        } else if (args[0].equals("n")) {
            params.java = false;
            return params;
        }
        return params;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("  <cmd> --help");
            out.println("  <cmd> -j // java method");
            out.println("  <cmd> -n // my method");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }
        if (params.window) {
            winMain();
        }
        if (params.java) {
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            q.add(3);
            q.add(2);
            q.add(0);
            q.add(11);
            q.add(10101);
            q.add(-100);
            ListUtils.sort(q);
            System.out.println(q);
        }
        if (!params.java && !params.window) {
            MyQueue queue = new MyQueue();
            queue.add(1);
            queue.add(3);
            queue.add(2);
            queue.add(0);
            queue.add(11);
            queue.add(10101);
            queue.add(-100);
            ListUtils.sort(queue);
            System.out.println(Arrays.toString(ListUtils.convertQueueToArr(queue)));
        }
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