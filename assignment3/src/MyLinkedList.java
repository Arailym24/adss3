public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T item) {
        addLast(item);
    }

    public void addFirst(T item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T item) {
        Node node = new Node(item);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) current = current.next;

            Node node = new Node(item);
            node.prev = current.prev;
            node.next = current;
            current.prev.next = node;
            current.prev = node;
            size++;
        }
    }

    public void set(int index, T item) {
        getNode(index).data = item;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    public T getFirst() {
        if (head == null) throw new RuntimeException("Empty");
        return head.data;
    }

    public T getLast() {
        if (tail == null) throw new RuntimeException("Empty");
        return tail.data;
    }

    public void remove(int index) {
        Node node = getNode(index);
        removeNode(node);
    }

    public void removeFirst() {
        if (head == null) return;
        removeNode(head);
    }

    public void removeLast() {
        if (tail == null) return;
        removeNode(tail);
    }

    private void removeNode(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
    }

    public void sort() {
        if (size < 2) return;
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data.compareTo(j.data) > 0) {
                    T tmp = i.data;
                    i.data = j.data;
                    j.data = tmp;
                }
            }
        }
    }

    public int indexOf(Object object) {
        int i = 0;
        for (Node current = head; current != null; current = current.next, i++) {
            if (current.data.equals(object)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        int i = size - 1;
        for (Node current = tail; current != null; current = current.prev, i--) {
            if (current.data.equals(object)) return i;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node current = head; current != null; current = current.next) {
            arr[i++] = current.data;
        }
        return arr;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
