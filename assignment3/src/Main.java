public class Main {
    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
        testMyStack();
        testMyQueue();
        testMyMinHeap();
    }

    public static void testMyArrayList() {
        System.out.println("MyArrayList:");
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        System.out.println("Before sort: ");
        printList(list);
        list.sort();
        System.out.println("After sort: ");
        printList(list);
        System.out.println("Index of 8: " + list.indexOf(8));
        list.remove(1);
        printList(list);
    }

    public static void testMyLinkedList() {
        System.out.println("\n MyLinkedList: ");
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("world");
        list.addFirst("hello");
        list.addLast("!");
        printList(list);
        list.removeLast();
        list.set(1, "Java");
        printList(list);
    }

    public static void testMyStack() {
        System.out.println("\n MyStack: ");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    public static void testMyQueue() {
        System.out.println("\n MyQueue: ");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }

    public static void testMyMinHeap() {
        System.out.println("\n MyMinHeap: ");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(15);
        heap.add(10);
        heap.add(30);
        heap.add(5);
        while (!heap.isEmpty()) {
            System.out.println("Polled: " + heap.poll());
        }
    }

    public static <T> void printList(MyList<T> list) {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
