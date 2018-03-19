package algorithm;

import java.util.Scanner;

/**
 * 题目：给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？ 输出需要删除的字符个数。
 * 输入：字符串数组   输出：一个数组，每个元素是计算的结果
 * @author 10460
 * 
 */
public class PalinStr {
	private int minCount = Integer.MAX_VALUE;
	
    /**
     * 递归函数，计算结果存到minCount
     * @param s 字符串s
     * @param l 左要比较的下标
     * @param r 右边要比较的下标
     * @param count 当前已经删除的数目
     */
    public void palinStrCount(String s, int l, int r, int count){
        //判断参数合理性，和条件限制
        if(s.length() == 0) return;
        if(l < 0 || r < 0 || l > r) return;
        //递归返回条件
        if(l == r) {
        	//最后两个相遇时字符相同，一个加一 一个减一 就变成l > r，这种情况可以直接移动其中一个下标即可，反正就是让最后情况都是l==r
        	if(this.minCount > count) minCount = count;
        	return;
        }
        //首尾两个字符相同
        if (s.charAt(l) == s.charAt(r) && l != (r-1)) {
        	palinStrCount(s, l+1, r-1, count);
        }
        //这里就是同一递归终止情况
        else if((s.charAt(l) == s.charAt(r) && l == (r-1))) {
        	palinStrCount(s, l+1, r, count);
        }
        else {
        	//两种情况的递归
        	palinStrCount(s, l+1, r, count + 1);
        	palinStrCount(s, l, r-1, count + 1);
        }
		return;
        
    }
    
	public static void main(String []args) {
		PalinStr test;
		Scanner in = new Scanner(System.in);
		//数组ss是ss.length String s是s.length() 
		//数组是种简单的结构，只有访问[i] .length长度 固定长度
		String [] ss = new String[3];
		String s = null;
		System.out.println("请输入字符串：");
		while (in.hasNext()) {
			test = new PalinStr();
			s = in.next();
			test.palinStrCount(s, 0, s.length()-1, 0);
			System.out.println("要删除的最小位数是：" + test.minCount);
		}
	}
}

/**动态规划做法：
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = new StringBuilder(s1).reverse().toString();
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            for (int i = 1; i < dp.length; i ++ ) {
                for (int j = 1; j < dp[0].length; j ++ ) {
                    dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            System.out.println(s1.length() - dp[s1.length()][s2.length()]);
        }
    }
}
*/