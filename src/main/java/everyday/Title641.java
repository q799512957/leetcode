package everyday;

/**
 * todo 设计循环双端队列
 * @author jijiahe
 * @version 1.0
 * @date 2022/8/15 17:10
 */
public class Title641 {
    static class MyCircularDeque {

        int [] array;
        int len,head,end = 0;
        public MyCircularDeque(int k) {
            array = new int[k];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                head = head == 0 ? array.length - 1 : head - 1;
                array[head] = value;
                len ++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                end = (end == array.length - 1) ? 0 : end + 1;
                array[end] = value;
                len ++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                head = (head == array.length - 1) ? 0 : head + 1;
                len--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                end = end == 0 ? array.length - 1 : end - 1;
                array[end] = 0;
                len--;
                return true;
            }
        }

        public int getFront() {
            return isEmpty() ? -1 : array[head];
        }

        public int getRear() {
            return isEmpty() ? -1 : array[end];
        }

        public boolean isEmpty() {
            return len == 0;
        }

        public boolean isFull() {
            return  len == array.length;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4
    }
}
