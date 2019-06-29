class LinkedList<usrType> {
    
    class Node<T> {
        public T value; 
        public Node<T> next;
        public Node<T> prev;

        public Node(T usrVal) {
            value = usrVal; 
            next = null; 
        }
    }

    private Node<usrType> head;
    private Node<usrType> tail;
    private Boolean reversed; 
    
    public LinkedList(usrType value) {
        head = new Node<usrType>(value);
        tail = head; 
        reversed = false; 
    }

    public LinkedList() {
        head = null;
        tail = null; 
        reversed = false;  
    }

    public void push_back(usrType value) {
        if (head == null) {
            head = new Node<usrType>(value); 
            tail = head;
        } else {
            Node<usrType> elem = new Node<usrType>(value);

            tail.next = elem;
            elem.prev = tail; 
            tail = elem;  
        }
    }

    public usrType pop_back() {
        usrType ret = tail.value; 
        tail = tail.prev; 

        return ret; 
    }

    public void reverse() {
        Node<usrType> iter = head;
        while(iter != null) {
            Node<usrType> tmp;
            tmp = iter.next;
            iter.next = iter.prev;
            iter.prev = tmp;
            iter = tmp;  
        }

        Node<usrType> tmp;
        tmp = head;
        head = tail;
        tail = tmp;
        
        reversed = true; 
    }

    public Boolean isEmpty() {
        return head == null; 
    }


    @Override
    public String toString(){
        if (head == null) {
            return "[ ]";
        }

        String ret = "[";
        Node<usrType> iter = head;

        while(iter.next != null) {
            ret += iter.value + ", "; 
            iter = iter.next; 
        }

        ret += iter.value + "]";
        reversed = !reversed; 
        return ret; 
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>("Doggo <3");
        list.push_back("uwu");
        list.reverse();
        list.reverse();
        System.out.println(list.toString());
    }
}