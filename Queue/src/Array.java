public class Array<E> {

    private E[] data;
    // size 是 Array 中含有的元素数
    private int size;

    // 构造函数，传入数组的容量，capacity，构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认的数组容量是10
    public Array(){
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向数组最后一个位置添加一个元素
    public void addLast(E e){
        add(size, e);
    }

    // 向 index 位置插入一个新元素 e
    public void add(int index, E e){
        if(index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <=size.");

        if(size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 在数组头添加一个元素
    public void addFirst(E e){
        add(0, e);
    }

    // 获取index位置的元素
    E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index <=size.");
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    // 将index位置的元素变为指定元素e
    void set(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index <=size.");
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    // 删除index位置的元素，并返回
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index <=size.");
        E ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering object

        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    // 从数组中删除第一个元素，并返回
    public E removeFirst(){
        return remove(0);
    }

    //从数组中删除最后一个元素，并返回
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, Capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
