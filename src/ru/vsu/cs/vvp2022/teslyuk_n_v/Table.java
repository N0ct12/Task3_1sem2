package ru.vsu.cs.vvp2022.teslyuk_n_v;

import ru.vsu.cs.vvp2022.teslyuk_n_v.utils.*;
import ru.vsu.cs.vvp2022.teslyuk_n_v.mylib.*;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class Table extends JFrame {
    private JPanel panel1;
    private JButton randomButton;
    private JButton importButton;

    private JTable inputTable;
    private JButton sortButton;
    private JTable outputTable;
    private JButton nSortButton;
    private JFileChooser fileChooserOpen;

    private JMenuBar menuBarMain;

    private JMenu menuLookAndFeel;

    ArrayList<Integer> list;
    public Table() throws ParseException {
        this.setTitle("FrameMain");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        JTableUtils.initJTableForArray(inputTable, 40, false, true, false, true);
        JTableUtils.initJTableForArray(outputTable, 40, false, true, false, false);
        //tableOutput.setEnabled(false);
        inputTable.setRowHeight(25);
        outputTable.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);


        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(inputTable, new int[]{
                0, 1, 2, 3, 4
        });
        this.pack();


        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panel1) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(inputTable, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = ArrayUtils.createRandomIntArray(inputTable.getColumnCount(),-100,100);
                    JTableUtils.writeArrayToJTable(inputTable, arr);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(inputTable);
                    MyQueue q = ListUtils.convertArrToQueue(arr);
                    ListUtils.sort(q);
                    arr = ListUtils.convertQueueToArr(q);
                    JTableUtils.writeArrayToJTable(outputTable, arr);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        nSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(inputTable);
                    Queue q = ListUtils.convertArrToJQueue(arr);
                    ListUtils.sort(q);
                    arr = ListUtils.convertJQueueToArr(q);
                    JTableUtils.writeArrayToJTable(outputTable, arr);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
