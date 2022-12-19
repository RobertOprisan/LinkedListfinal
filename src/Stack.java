public class Stack {
    private LinkedList list;
    public Stack() {
        list = new LinkedList();
    }
    public void push(Object obj) {
        list.insertFirst(obj);
    }
    public Object pop() throws EmptyListException, ObjectNotFoundException {
        Object objectTemp = list.getFirstObject();
        list.remove(objectTemp);
        return objectTemp;
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void empty() {
        list = new LinkedList();
    }
    public void print() {
        list.print();
    }
}
