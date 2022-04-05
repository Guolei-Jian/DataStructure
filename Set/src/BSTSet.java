public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    /*
    时间复杂度分析：
    理想情况下，为满二叉树，增、删、查时间复杂度为 O(logN)
    平均为O(logN),最坏情况，就退化成了链表O(N)
    准确的说，复杂度为O(H) H为树的高度
    解决方法：创建平衡二叉树
     */
}
