package ru.vsu.cs.vvp2022.teslyuk_n_v.utils;

import ru.vsu.cs.vvp2022.teslyuk_n_v.mylib.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListUtils {
    public static ArrayList<Integer> convertMatrixToList(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            list.add(matrix[0][i]);
        }
        return list;
    }
    public static ArrayList<Integer> convertArrayToList(int[] array){
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : array) {
            list.add(j);
        }
        return list;
    }
    public static int[] convertListToArray(ArrayList<Integer> arrayList) {
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }
    public static MyLL convertListToLL(ArrayList<Integer> arrayList){
        MyLL list = new MyLL();
        for (int i = 0; i < arrayList.size(); i++) {
            list.addLast(arrayList.get(i));
        }
        return list;
    }
    public static MyLL convertArrayToLL(int[] arr){
        MyLL list = new MyLL();
        for (int i = 0; i < arr.length; i++) {
            list.addLast(arr[i]);
        }
        return list;
    }

    public static int[] convertQueueToArr(MyQueue q) throws Exception {
        int[] arr = new int[q.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = q.poll();
        }
        return arr;
    }
    public static int[] convertJQueueToArr(Queue<Integer> q) throws Exception {
        int[] arr = new int[q.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = q.peek();
        }
        return arr;
    }

    public static MyQueue convertArrToQueue(int[] arr) throws Exception {
        MyQueue q = new MyQueue();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        return q;
    }
    public static Queue<Integer> convertArrToJQueue(int[] arr) throws Exception {
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        return q;
    }

    public static void sort(MyQueue q) throws Exception {
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
    }

    public static void sort(Queue<Integer> q) {
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
    }
}
