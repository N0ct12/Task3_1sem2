package ru.vsu.cs.vvp2022.teslyuk_n_v.mylib;


public class MyQueue {

    private static class QueueNode{

        private int value;
        private QueueNode next;

        public QueueNode(int value, QueueNode next) {
            this.value = value;
            this.next = next;
        }

        public QueueNode(int value) {
            this(value,null);
        }


        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public QueueNode getNext() {
            return next;
        }

        public void setNext(QueueNode next) {
            this.next = next;
        }
    }
    private QueueNode head;
    private QueueNode tail;

    private int size;

    public MyQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }


        public int poll() throws Exception {
            if (isEmpty()){
                throw new RuntimeException("List is empty");
            }
            QueueNode curr = head;
            head = head.next;
            if (size == 1) {
                tail = null;
            }
            size--;
            return curr.getValue();
        }


//    public int get(int index) throws Exception {
//        if (isEmpty()){
//            throw new RuntimeException("List is empty");
//        }
//        if(index<0 || index>size) throw new RuntimeException("Index is out of bounds");
//        QueueNode curr = head;
//        for (int i = 1; i <= index; i++) {
//            curr = curr.next;
//        }
//        return curr.getValue();
//    }


        public void add(int val){
            QueueNode n = new QueueNode(val);
            if (isEmpty()){
                head = tail = n;
                size++;
                return;
            }
            tail.next = n;
            tail = n;
            size++;
        }
    }
