public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        T top = list.getLast();
        list.removeLast();
        return top;
    }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
