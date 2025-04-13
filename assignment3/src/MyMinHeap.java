public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void add(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    public T peek() {
        return heap.get(0);
    }

    public T poll() {
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                T tmp = heap.get(index);
                heap.set(index, heap.get(parent));
                heap.set(parent, tmp);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest != index) {
                T tmp = heap.get(index);
                heap.set(index, heap.get(smallest));
                heap.set(smallest, tmp);
                index = smallest;
            } else break;
        }
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}
