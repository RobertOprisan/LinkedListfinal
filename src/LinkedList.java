import com.sun.source.tree.IfTree;

public class LinkedList {
    private Element first;
    private Element last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(Object obj) {
        Element element = new Element(obj);
        element.setNext(first);
        first = element;
        if (last == null) {
            last = element;
        }
    }

    public void insertLast(Object obj) {
        Element element = new Element(obj);
        if (last != null) {
            last.setNext(element);
        }
        last = element;

        if (first == null) {
            first = element;
        }
    }

    public void print() {
        Element element = first;
        while (element != null) {
            if (element != first) {
                System.out.println(", ");
            }
            System.out.println(element.getObject());
            element = element.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if (first == null)
            return true;
        else
            return false;
    }

    public void remove(Object obj) throws ObjectNotFoundException,
            EmptyListException {
        Element previous = first;
        Element e = first;
        if (first == null) {
            throw new EmptyListException();
        }
        while ((e != null) && (e.getObject() != obj)) {
            previous = e;
            e = e.getNext();
        }
        if (e == null) {
            throw new ObjectNotFoundException();
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            if (first == e) {
                first = e.getNext();
            }
            if (last == e) {
                last = previous;
            }
            previous.setNext(e.getNext());
        }
        e.delete();
    }
    public Object getLastObject() throws EmptyListException {
        if (first == null)
            throw new EmptyListException();
        return last.getObject();
    }
    public Object getFirstObject() throws EmptyListException {
        if (first == null)
            throw new EmptyListException();
        return first.getObject();
    }
    public Object getObjectAtPosition(int i) throws EmptyListException,
            InvalidIndexException {
        if (first == null) {
            throw new EmptyListException();
        }
        Element e = first;
        int cont = 0;
        while ((e != null) && (cont < i)) {
            e = e.getNext();
            cont++;
        }
        if ((cont == i) && (e != null)) {
            return e.getObject();
        } else {
            throw new InvalidIndexException();
        }
    }
    public int getNumElements() {
        Element e = first;
        int cont = 0;
        while (e != null) {
            e = e.getNext();
            cont++;
        }
        return cont;
    }
}
