public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = other.nextFirst;
        nextLast = addOne(nextFirst);

        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(nextLast));

        }
    }

    private int addOne(int x) {
        return (x + 1) % items.length;
    }

    private int subOne(int x) {
        return (x - 1 + items.length) % items.length;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        nextFirst = addOne(nextFirst);
        System.arraycopy(items, nextFirst, a, nextFirst, size);
        items = a;
        nextFirst = subOne(nextFirst);
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        size++;
        items[nextFirst] = item;
        nextFirst = subOne(nextFirst);
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        size++;
        items[nextLast] = item;
        nextLast = addOne(nextLast);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = addOne(nextFirst);
        for (int j = 0; j < size; j++) {
            System.out.print(items[i] + " ");
            i = addOne(i);
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = addOne(nextFirst);
        items[nextFirst] = null;
        size--;
        if (items.length > 16 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        return items[addOne(nextFirst)];
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = subOne(nextLast);
        items[nextLast] = null;
        size--;
        if (items.length > 16 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        return items[subOne(nextLast)];
    }

    public T get(int index) {
        if (index > items.length - 1) {
            return null;
        }
        return items[index];
    }
}
