public class Mapa<K,V> {

    private Node<K,V>[] nodes = new Node[16];

    private int size = 0;

    public V put(K key, V value) {
        Node<K,V> node = new Node<>();
        node.key = key;
        node.value = value;
        Node<K,V> currentnode = nodes[index(key)];
        while(currentnode!=null){
            if(currentnode.key == key){
                V tmp = currentnode.value;
                currentnode.value = value;
                return tmp;
            }
            currentnode = currentnode.NextLink;
        }
        node.NextLink = nodes[index(key)];
        nodes[index(key)] = node;
        size++;
        return null;
    }

    public int index(K key){
        return key.hashCode()%16;
    }

    public V get(K key){
        Node<K,V> current = nodes[index(key)];
        if (!current.key.equals(key)){
            while(current!=null){
                if(current.key.equals(key)){
                    return current.value;
                }
                current=current.NextLink;
            }
        }
        return current.value;
    }

    public int size(){
        int quantity = 0;
        int len = nodes.length;
        for (int i = 0; i < len; i++) {
            if(nodes[i]!=null){
                quantity++;
            }
        }
        return quantity;
    }

    public V remove(K key){
        Node<K,V> node = nodes[index(key)];
        if(node.NextLink == null){
            V result = node.value;
            nodes[index(key)] = null;
            return result;
        }
        while(node!= null){
            if(node.key.equals(key)){
                 Node<K,V> temp = node.NextLink;
                 node = null;
            }
            node = node.NextLink;
        }
        return null;
    }
    public void replays(K key , V value){
        Node<K,V> node = nodes[index(key)];
        if(node.NextLink == null){
            node.value = value;
        }
        while(node!= null){
            if(node.key.equals(key)){
                node.value = value;
            }
            node = node.NextLink;
        }
    }

    public boolean containsKey(K key){
        boolean flag = false;
        Node<K,V> node = nodes[index(key)];
        while(node!= null){
            if(node.key.equals(key)){
                flag = true;
            }
            node = node.NextLink;
        }
        return flag;
    }

    public boolean containsValue(V value){
        boolean flag = false;
        for (int i = 0; i < size(); i++) {
            if (nodes[i]!= null){
                if (nodes[i].value.equals(value)) {
                    flag = true;
                }
            }
        }
        return flag;
    }







}
