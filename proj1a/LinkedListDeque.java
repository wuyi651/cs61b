public class LinkedListDeque<T> {
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;

        public IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }
    private IntNode sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /*public LinkedListDeque(LinkedListDeque other) {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }
    }*/

    public void addFirst(T item) {
        sentinel.next = new IntNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        sentinel.prev.next = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev = sentinel.prev.next;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        T a = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return a;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        T a = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return a;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        IntNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        } else {
            sentinel = sentinel.next;
            index--;
        }
        return getRecursive(index);
    }
}
