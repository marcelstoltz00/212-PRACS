public class OrderedList<T extends Comparable<T>> {

    public Node<T> head;

    public OrderedList() {

    }

    public void insert(T data) {
        // if head was null
        if (head == null) {
            head = new Node<T>(data);
            return;
        }
        Node<T> curnode = head;
        Node<T> prev = head;

        // if data is the same as the head
        if (data.compareTo(head.data) == 1) {

            Node<T> oldhead = head;
            head = new Node<T>(data);
            head.next = oldhead;

            oldhead.next = null;

            return;

        }
        // just getting the right place
        while (curnode.next != null && curnode.data.compareTo(data) > -1) {
            prev = curnode;
            curnode = curnode.next;

        }
        // if there is nothing new,should be at the start
        if (curnode == head) {
            head = new Node<T>(data);
            head.next = curnode;
            return;
        }
        // at the end
        if (curnode.next == null) {
            curnode.next = new Node<T>(data);
            curnode.next.next = null;

            return;

        }

        //in the middle

        prev=curnode.next;
        curnode.next= new Node<T>(data);
        curnode.next.next=prev;



    }

    public String toString() {

        String output = "Head->";
        Node<T> curNode = head;
        while (curNode != null) {
            output += "[" + curNode.data.toString() + "]" + "->";
            curNode = curNode.next;

        }
        output += "NULL";

        return output;

    }
}
