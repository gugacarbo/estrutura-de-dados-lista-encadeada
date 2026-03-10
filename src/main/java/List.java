
public class List {

    private Node firstNode;

    public List() {
        this.firstNode = null;
    }

    public List(int val) {
        this.firstNode = new Node(val);
    }

    public int getLength() {
        if (this.firstNode == null) {
            return 0;
        }

        int count = 0;

        Node aux = this.firstNode;

        while (aux != null) {
            count++;
            aux = aux.next();
        }

        return count;
    }

    public int getIndex(int value) {

        if (this.firstNode == null) {
            return -1;
        }

        int currPos = 0;

        Node aux = this.firstNode;

        while (aux != null && aux.getValue() != value) {
            currPos++;
            aux = aux.next();
        }

        return aux == null ? -1 : currPos;
    }

    public Node getByIndex(int index) {
        if (index < 0 || this.firstNode == null) {
            return null;
        }

        int currPos = 0;
        Node aux = this.firstNode;

        while (aux != null && currPos < index) {
            currPos++;
            aux = aux.next();
        }

        return aux;
    }

    public void push(Node newNode) {

        if (this.firstNode == null) {
            this.firstNode = newNode;
            return;
        }

        Node i = this.firstNode;

        while (i.next() != null) {
            i = i.next();
        }

        i.setNext(newNode);
    }

    public void unshift(Node newNode) {

        if (this.firstNode == null) {
            this.firstNode = newNode;
            return;
        }

        newNode.setNext(this.firstNode);

        this.firstNode = newNode;
    }

    public Node pop() {
        if (this.firstNode == null) {
            return null;
        }

        Node i = this.firstNode;
        Node previous = null;

        while (i.next() != null) {
            previous = i;
            i = i.next();
        }

        if (previous == null) {
            this.firstNode = null;
        } else {
            previous.setNext(null);
        }

        return i;
    }

    public Node shift() {
        if (this.firstNode == null) {
            return null;
        }

        Node removedNode = this.firstNode;
        this.firstNode = this.firstNode.next();

        return removedNode;
    }

    @Override
    public String toString() {
        String listStr = "";
        Node i = this.firstNode;

        while (i != null) {
            listStr += i.toString();

            if (i.next() != null) {
                listStr += " > ";
            }

            i = i.next();
        }

        return listStr;
    }
}
