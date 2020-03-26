import java.util.Vector;

// class for implementing Priority Queue 
class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{
    // vector to store heap elements
    private Vector<E> vector;

    public VectorHeap(Vector<E> vector)
    {
        this.vector =  new Vector<E>();
        for (E  element:
             vector) {
            add(element);
        }
    }

    // return parent of A.get(i)
    private int parent(int i)
    {
        // if i is already a root node
        if (i == 0)
            return 0;

        return (i - 1) / 2;
    }

    private int getLeft(int i)
    {
        return (2 * i + 1);
    }

    private int getRight(int i)
    {
        return (2 * i + 2);
    }

    void swap(int x, int y)
    {
        E temp = vector.get(x);
        vector.setElementAt(vector.get(y), x);
        vector.setElementAt(temp, y);
    }

    // Recursive Heapify-down procedure. Here the node at index i
    // and its two direct children violates the heap property
    private void heapifyDown(int i)
    {
        // get left and right child of node at index i
        int left = getLeft(i);
        int right = getRight(i);

        int smallest = i;

        // compare A.get(i) with its left and right child
        // and find smallest value

        if (left < size() && vector.get(left).compareTo(vector.get(i)) < 0) {
            smallest = left;
        }

        if (right < size() && vector.get(left).compareTo(vector.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != i)
        {
            // swap with child having lesser value
            swap(i, smallest);

            // call heapify-down on the child
            heapifyDown(smallest);
        }
    }

    // Recursive Heapify-up procedure
    private void heapifyUp(int i)
    {

        if (i > 0 && vector.get(parent(i)).compareTo(vector.get(i)) > 0)
        {
            swap(i, parent(i));

            heapifyUp(parent(i));
        }
    }

    @Override
    public int size()
    {
        return vector.size();
    }

    @Override
    public boolean isEmpty()
    {
        return vector.isEmpty();
    }



    @Override
    public E getFirst() {
        return vector.firstElement();
    }

    @Override
    public void remove(E object) {
        vector.remove(object);
    }


    @Override
    public void add(E value) {
        vector.addElement(value);

        // get element index and call heapify-up procedure
        int index = size() - 1;
        heapifyUp(index);
    }


    @Override
    public E poll()
    {
        try {
            if (size() == 0) {
                throw new Exception("Index is out of range (Heap underflow)");
            }

            E root = vector.firstElement();

            vector.setElementAt(vector.lastElement(), 0);
            vector.remove(size()-1);

            heapifyDown(0);

            return root;
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public E peek()
    {
        try {
            // if heap has no elements, throw an exception
            if (size() == 0) {
                throw new Exception("Index out of range (Heap underflow)");
            }

            // else return the top (first) element
            return vector.firstElement();	// or A.get(0);
        }
        // catch the exception and print it, and return null
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void clear()
    {
        System.out.print("Emptying queue: ");
        while (!vector.isEmpty()) {
            System.out.print(poll() + " ");
        }
        System.out.println();
    }

    @Override
    public boolean contains(E i)
    {
        return vector.contains(i);
    }

}