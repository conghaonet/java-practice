package algorithm;

/**
 * @description 双向链表
 * 设计一个栈型队列类：DoublyLinkedList，有三个方法：
 * push //将新的数据压入栈顶；
 * pop //以栈的方法取出一个数据；
 * pop2 //以队列的方法取出一个数据。
 * 注意:数据压入栈后，限定用双向链表结构存储，
 * 使用上面定义好的Node类。
 * 调试方法：main方法里面 Push 1 2 3，然后用POP和POP2取数验证。
 * @date 2025/03/26
 */
public class DoublyLinkedList<T> {
    
    // 栈顶
    private Node<T> head;
    // 队列头
    private Node<T> tail;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setDown(head);
            head.setUp(newNode);
            head = newNode;
        }
    }

    // 栈，后进先出
    public T pop() {
        if (head == null) return null;
        Node<T> nodeToRemove = head;
        head = head.getDown();
        if (head != null) {
            head.setUp(null);
        } else {
            tail = null;
        }
        return nodeToRemove.getData();
    }

    // 队列，先进先出
    public T pop2() {
        if (tail == null) return null;
        Node<T> nodeToRemove = tail;
        tail = tail.getUp();
        if (tail != null) {
            tail.setDown(null);
        } else {
            head = null;
        }
        return nodeToRemove.getData();
    }

    /**
     * @description 设计一个双向链表节点类Node，有三个属性：
     * up //指向上方节点down //指向下方节点
     * data //保存数据。
     * 注意:此处语法限定用泛型表达
     */
    public static class Node<T> {
        private Node<T> up;
        private Node<T> down;
        private T data;
    
        public Node(T data) {
            this.data = data;
            this.up = null;
            this.down = null;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
        public Node<T> getUp() {
            return up;
        }
        public void setUp(Node<T> up) {
            this.up = up;
        }
        public Node<T> getDown() {
            return down;
        }
        public void setDown(Node<T> down) {
            this.down = down;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> pipe = new DoublyLinkedList<>();
        pipe.push(1);
        pipe.push(2);
        pipe.push(3);

        System.out.println(pipe.pop());  // 输出 3
        System.out.println(pipe.pop2()); // 输出 1
    }
}

