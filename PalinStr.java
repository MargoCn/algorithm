package algorithm;

import java.util.Scanner;

/**
 * ��Ŀ������һ���ַ���s������Դ���ɾ��һЩ�ַ���ʹ��ʣ�µĴ���һ�����Ĵ������ɾ������ʹ�û��Ĵ���أ� �����Ҫɾ�����ַ�������
 * ���룺�ַ�������   �����һ�����飬ÿ��Ԫ���Ǽ���Ľ��
 * @author 10460
 * 
 */
public class PalinStr {
	private int minCount = Integer.MAX_VALUE;
	
    /**
     * �ݹ麯�����������浽minCount
     * @param s �ַ���s
     * @param l ��Ҫ�Ƚϵ��±�
     * @param r �ұ�Ҫ�Ƚϵ��±�
     * @param count ��ǰ�Ѿ�ɾ������Ŀ
     */
    public void palinStrCount(String s, int l, int r, int count){
        //�жϲ��������ԣ�����������
        if(s.length() == 0) return;
        if(l < 0 || r < 0 || l > r) return;
        //�ݹ鷵������
        if(l == r) {
        	//�����������ʱ�ַ���ͬ��һ����һ һ����һ �ͱ��l > r�������������ֱ���ƶ�����һ���±꼴�ɣ���������������������l==r
        	if(this.minCount > count) minCount = count;
        	return;
        }
        //��β�����ַ���ͬ
        if (s.charAt(l) == s.charAt(r) && l != (r-1)) {
        	palinStrCount(s, l+1, r-1, count);
        }
        //�������ͬһ�ݹ���ֹ���
        else if((s.charAt(l) == s.charAt(r) && l == (r-1))) {
        	palinStrCount(s, l+1, r, count);
        }
        else {
        	//��������ĵݹ�
        	palinStrCount(s, l+1, r, count + 1);
        	palinStrCount(s, l, r-1, count + 1);
        }
		return;
        
    }
    
	public static void main(String []args) {
		PalinStr test;
		Scanner in = new Scanner(System.in);
		//����ss��ss.length String s��s.length() 
		//�������ּ򵥵Ľṹ��ֻ�з���[i] .length���� �̶�����
		String [] ss = new String[3];
		String s = null;
		System.out.println("�������ַ�����");
		while (in.hasNext()) {
			test = new PalinStr();
			s = in.next();
			test.palinStrCount(s, 0, s.length()-1, 0);
			System.out.println("Ҫɾ������Сλ���ǣ�" + test.minCount);
		}
	}
}

/**��̬�滮������
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