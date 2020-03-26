public interface PriorityQueue<E extends Comparable<E>> {
    public E getFirst();
    public void remove(E object);
    public void add(E value);
    public boolean isEmpty();
    public int size();
    public boolean contains(E i);
    public void clear();
    public E peek();
    public E poll();
}
