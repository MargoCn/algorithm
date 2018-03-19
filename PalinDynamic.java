package algorithm;

import java.util.Scanner;

/**
 * 还是回文串的题目，打算手打一遍动态规划的代码加深印象，但是动态规划感觉代码实现较为简单，画图理解重要，公式理解重要
 *     就比如如果两个串的当前比较字符一样，那么相同的字符个数就是这两个字符不要时的数+1；
 *     如果比较结果不一样，那么相同的序列就是回到最近的之前的情况，之前的情况就是其中一个序列去掉一个字符的情况咯，所以有两种情况，取最大值
 * 思路：利用会问字符串的特点，把字符串先 逆转过来，就变成两个字符串的最长公共子序列问题了
 * @author 10460
 *
 */
public class PalinDynamic {
	
	/**
	 * 最好不要将数据存到对象属性，这样每次生成一个对象才能算，分离性不好，比如这道题自己做的深搜做法
	 * @param s 要计算的字符串
	 * @return 返回最小要删除字符数目
	 */
	public int palinStrCount(String s) {
		//先将字符串逆转，builder线程不安全，buffer相称安全
		StringBuilder sb = new StringBuilder(s);
		sb.reverse(); //在自己的对象空间做修改
		//数组长度加一而且开始从1开始，应该是为了count[i-1][j-1]的时候不会越界吧，毕竟动态规划的公式摆在那里，计算机要迁就她
		int [][] count = new int[s.length() + 1][sb.length() + 1];//会自动初始化为0
		for(int i = 1; i < count.length; i++) {
			for(int j = 1; j < count.length; j++) {
				if(s.charAt(i-1) == sb.charAt(j-1)) count[i][j] = count[i-1][j-1] + 1;
				else {
					count[i][j] = Math.max(count[i][j-1], count[i-1][j]);
				}
			}
		}
		return count[s.length()][s.length()];
	}
	public static void main(String [] args) {
		PalinDynamic test = new PalinDynamic();
		Scanner in = new Scanner(System.in);
		String s = null;
		System.out.println("请输入字符串：");
		while (in.hasNext()) {
			s = in.next();
			System.out.println("删除最小的数目是：" + (s.length() - test.palinStrCount(s)));
		}
	}
}
