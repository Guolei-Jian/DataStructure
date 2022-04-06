public class MaxHeap<E extends Comparable<E>>{

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    // heapify 将数组转换成堆的形状，O(N)复杂度
    public MaxHeap(E[] arr){
        // 从最后一个非叶子节点开始下沉操作，就建立了堆
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    // 返回堆元素中的个数
    public int size(){
        return data.getSize();
    }

    // 返回堆中元素个数
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't hava parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 查看堆中最大元素
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not finMax when heap is empty!");
        return data.get(0);
    }

    // 从堆中取出最大元素
    public E extractMax(){
        E ret = findMax();
        // 取出堆顶的元素，用堆中最后一个元素代替堆顶，然后从新调整
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        // k 是叶子节点时， 停止循环
        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(k);
            // data[j] 是 leftChild 与 rightChild 中的最大值
            if(data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }



/*
二叉堆是一棵完全二叉树，（最大堆） 堆中的每一个节点，都要大于等于它的叶子节点。
 */

}
