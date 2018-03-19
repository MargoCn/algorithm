package algorithm;

import java.util.Scanner;

/**
 * ���ǻ��Ĵ�����Ŀ�������ִ�һ�鶯̬�滮�Ĵ������ӡ�󣬵��Ƕ�̬�滮�о�����ʵ�ֽ�Ϊ�򵥣���ͼ�����Ҫ����ʽ�����Ҫ
 *     �ͱ�������������ĵ�ǰ�Ƚ��ַ�һ������ô��ͬ���ַ����������������ַ���Ҫʱ����+1��
 *     ����ȽϽ����һ������ô��ͬ�����о��ǻص������֮ǰ�������֮ǰ�������������һ������ȥ��һ���ַ�������������������������ȡ���ֵ
 * ˼·�����û����ַ������ص㣬���ַ����� ��ת�������ͱ�������ַ����������������������
 * @author 10460
 *
 */
public class PalinDynamic {
	
	/**
	 * ��ò�Ҫ�����ݴ浽�������ԣ�����ÿ������һ����������㣬�����Բ��ã�����������Լ�������������
	 * @param s Ҫ������ַ���
	 * @return ������СҪɾ���ַ���Ŀ
	 */
	public int palinStrCount(String s) {
		//�Ƚ��ַ�����ת��builder�̲߳���ȫ��buffer��ư�ȫ
		StringBuilder sb = new StringBuilder(s);
		sb.reverse(); //���Լ��Ķ���ռ����޸�
		//���鳤�ȼ�һ���ҿ�ʼ��1��ʼ��Ӧ����Ϊ��count[i-1][j-1]��ʱ�򲻻�Խ��ɣ��Ͼ���̬�滮�Ĺ�ʽ������������ҪǨ����
		int [][] count = new int[s.length() + 1][sb.length() + 1];//���Զ���ʼ��Ϊ0
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
		System.out.println("�������ַ�����");
		while (in.hasNext()) {
			s = in.next();
			System.out.println("ɾ����С����Ŀ�ǣ�" + (s.length() - test.palinStrCount(s)));
		}
	}
}
