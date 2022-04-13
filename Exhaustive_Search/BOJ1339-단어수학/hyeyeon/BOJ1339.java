package A0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339�ܾ���� {
	
	public static String[] arr; //�Է� ���ڿ� �迭
	public static int[] alpha; //���ĺ��� ũ�� ����?�� ���� �迭
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		alpha = new int[26]; //���ĺ� �빮�� 26��
		for(int i=0;i<N;i++) {
			arr[i]=br.readLine();
		}
		for(int i=0;i<N;i++) {
			int x = (int)Math.pow(10, arr[i].length()-1);
			for(int j=0;j<arr[i].length();j++) {
				alpha[(int)arr[i].charAt(j)-65]+=x; //A�� 0, B�� 1 ... �� x(10^�ڸ���) ����
				x=x/10;
			}
		}
		
		Arrays.sort(alpha); //����, �ڿ������� 0������ 9���� ���ʷ� �Ҵ� �� ���ϱ�
		int tmp=9;
		int answer=0;
		for(int i=alpha.length-1;i>0;i--) {
			if(alpha[i]==0) break; //�ڿ�������(ū �ͺ���) 9���� ���ʷ� �ִٰ�, 0�� ������ �����
			else {
				answer+=alpha[i]*tmp;
				tmp--;
			}
		}
		System.out.println(answer);
		
	}

}
