package ojs;
import java.util.*;

public class LanqiaoJava2019 {
	public static void main(String[] args) {
		int n,m,k;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		k = cin.nextInt();
		int[] dp = new int[1<<m];
		Arrays.fill(dp,-1);
		int[] candis = new int[n+1];
		for(int i=1;i<=n;++i) {
			int temp = 0;//��һ���ǹ�����һ�����ֱ�ʾ
			for(int j=1;j<=k;++j) {
				int a = cin.nextInt();
				temp |= (1<<(a-1));
			}
//			System.out.print(temp);
//			System.out.print(" ");
//			System.out.println(Integer.toBinaryString(temp));
			candis[i] = temp;
			dp[temp] = 1;//�ﵽ���״ֻ̬��Ҫһ��
			
		}
		for(int i=1;i<=n;++i) {//�����ǹ�
			for(int j=0;j<(1<<m);++j) {//����״̬
				if(dp[j]==-1) {//���״̬�޷��ﵽ
					continue;
				}
				if(dp[j|candis[i]]==-1||dp[j]+1<dp[j|candis[i]]) {//�����һ����״̬�������ĵ����״̬�İ취
					dp[j|candis[i]] = dp[j]+1;//��������
				}
			}
		}
		System.out.println(dp[(1<<m)-1]);
	}

}
