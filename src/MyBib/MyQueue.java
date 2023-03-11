package MyBib;

public class MyQueue extends MyLL{

        public int poll() throws Exception {
            int tmp = this.element();
            this.removeFirst();
            return tmp;
        }

    public int get(int index) throws Exception {
        return this.getByIndex(index);
    }

        public int element() throws Exception {
            if (this.isEmpty()) {
                throw new Exception("Queue is empty");
            }
            return this.getFirst();
        }

        public void add(int val){
            this.addLast(val);
        }

        public void sort() throws Exception {
            int tmp = 0;
            for (int i = 0; i < this.size(); i++) {
                tmp = poll();
                for (int j = 0; j < this.size(); j++) {
                    int tmp2 = poll();
                    if(tmp2>tmp){
                        add(tmp);
                        tmp = tmp2;
                    }else {
                        add(tmp2);
                    }
                }
                add(tmp);
            }
        }
}
