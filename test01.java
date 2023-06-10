package practice01;
import java.util.Scanner;
import java.util.Arrays;
public class test01 {
        public static int[][] dp;
        public static int[] item;
        static int[] w;
        static int[] v;

        public static void main(String[] args) {
            System.out.println("请输入物品的个数：");
            Scanner sc=new Scanner(System.in);
            int  n=sc.nextInt();
            System.out.println("请输入物品的容量：");
            Scanner sc1=new Scanner(System.in);
             int  capacity=sc1.nextInt();
            w = new int[n];
            v = new int[n];
            System.out.println("请输出每个物品的重量");
            Scanner sc2=new Scanner(System.in);
            for (int i = 0; i < n; i++) {
                System.out.print("请输入第" + (i+1) + "个物品的重量：");
               w[i]= sc2.nextInt();
            }
            System.out.println(Arrays.toString(w));//输出数组，将数组转换成String类型输出的
            Scanner sc3=new Scanner(System.in);
            for (int i = 0; i < n; i++) {
                System.out.print("请输入第" + (i+1) + "个物品的价值：");
                v[i]= sc3.nextInt();
            }
            System.out.println(Arrays.toString(v));
            int num = n;
            dp = new int[num + 1][capacity + 1];
            item = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= capacity; j++) {
                    if (j >= w[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[num][capacity]);
            findWhat(num, capacity);
            for (int i = 1; i <= num; i++) {
                System.out.print(item[i] + " ");
            }
            System.out.println();
        }

        public static void findWhat(int i, int j) {
            if (i >= 1) {
                // 第i件商品没放
                if (dp[i][j] == dp[i - 1][j]) {
                    item[i] = 0;
                    findWhat(i - 1, j);
                }
                //第i件商品放了
                else if (j - w[i - 1] >= 0 && dp[i][j] == dp[i - 1][j - w[i - 1]] + v[i - 1]) {
                    item[i] = 1;
                    findWhat(i - 1, j - w[i - 1]);
                }
            }
        }
    }
// 输出
// 10
// 0 1 0 1


//运行结果为300，符合最佳解决方案。

