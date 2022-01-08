public class Sum {
    /*
        初识递归，使用递归的方法解决数组求和问题
     */
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l, ......, n) 这个区间内所有数字的和
    private static int sum(int[] arr, int l){
        if(l == arr.length)  // 求解最基本的问题
            return 0;
        return arr[l] + sum(arr, l + 1); // 把原问题转化成更小的问题
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
