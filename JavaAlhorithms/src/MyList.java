public class MyList<T> {
    private Node<T> head;

    private Node<T> tail;

    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<>();
        node.value = value;
        if (head != null) {
            node.nextlink = head;
        }
        head = node;
        this.size++;
    }

    public Node<T> find(T value) {
        Node<T> currentN = new Node<>();
        currentN = head;
        while (currentN != null) {
            if (currentN.value == value) {
                return currentN;
            } else {
                currentN = currentN.nextlink;
            }
        }
        return null;
    }

    public int size() {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.nextlink;
        }
        return count;
    }

    public T get(int index) {
        int count = 0;
        Node<T> current = new Node<>();
        current = head;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            current = current.nextlink;
            count++;
        }
        return null;
    }

    public boolean contains(T value) {
        Node<T> current = new Node<>();
        current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.nextlink;
        }
        return false;
    }

    public int indexOf(T value) {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.value == value) {
                return count;
            }
            count++;
            current = current.nextlink;
        }
        return -1;
    }

    public void addbyIndex(T value, int index) {
        if (index > size() || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        if (index == 0) {
            add(value);
            return;
        }
        Node<T> current = head;
        while (index > 1) {
            current = current.nextlink;
            index--;
        }
        Node<T> newNode = new Node<>();
        newNode.value = value;
        newNode.nextlink = current.nextlink;
        current.nextlink = newNode;
        this.size++;
    }

    public void showmeList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.nextlink;
        }
    }

    public void addLast(T value){
        addbyIndex(value , size());
    }

    public int sizeM(){
        return this.size;
    }

    public MyList<T> reverse(MyList<T> list){
        MyList<T> reversed = new MyList<>();
        int lenght = size();
        int index = 0;
        while(index < lenght){
            reversed.add(list.get(index));
            index++;
        }
        return reversed;
    }
}