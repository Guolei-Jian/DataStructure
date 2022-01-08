public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
        }
        System.out.println(queue);


        queue.dequeue();
        System.out.println(queue);


        LoopQueue<Integer> loopqueue = new LoopQueue<>();
        for(int i = 0; i < 10; i++){
            loopqueue.enqueue(i);
        }
        System.out.println(loopqueue);


        loopqueue.dequeue();
        System.out.println(loopqueue);
    }
}

/*
数组实现队列有局限性，因为出队时，时间复杂度是O（n）
改进：使用循环数组
 */