import static sun.net.InetAddressCachePolicy.get;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/20 10:33
 * @Description:
 */

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            System.out.println(index);

        }
        int cd = get();
        System.out.println("结果："+cd);
        String s = "ss";
        System.out.println(s + "\t" + "saa");
    }
}
