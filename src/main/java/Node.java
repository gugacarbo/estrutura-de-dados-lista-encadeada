
public class Node {

    private Node next = null;
    private int value;

    public Node(int value_) {
        this.value = value_;
    }

    public void setNext(Node next_) {
        this.next = next_;
    }

    public Node next() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    @Override
    public String toString() {
        return "[ " + Integer.toString(this.value) + " ]";
    }
}
