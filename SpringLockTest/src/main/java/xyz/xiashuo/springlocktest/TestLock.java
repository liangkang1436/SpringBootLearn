package xyz.xiashuo.springlocktest;

/**
 * @author xiashuo.xyz
 * @date 6/4/2024 10:23 AM
 */
public class TestLock {


    // the vulnerability DefaultLockRegistry
    public static void main(String[] args) {
        final int mask = 0xFF;
        System.out.println(Integer.toBinaryString(1726183714));
        System.out.println(Integer.toBinaryString(1726184738));
        // 可以看到他们的最后 8 位是一致的，
        // 因此他们进行 & mask 运算的结果也是一样的
        int result1 =  1726183714 & mask;
        int result2 =  1726184738 & mask;
        System.out.println(result1);
        System.out.println(result2);
    }

}
