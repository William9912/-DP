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
			int temp = 0;//这一包糖果用这一个数字表示
			for(int j=1;j<=k;++j) {
				int a = cin.nextInt();
				temp |= (1<<(a-1));
			}
//			System.out.print(temp);
//			System.out.print(" ");
//			System.out.println(Integer.toBinaryString(temp));
			candis[i] = temp;
			dp[temp] = 1;//达到这个状态只需要一包
			
		}
		for(int i=1;i<=n;++i) {//所有糖果
			for(int j=0;j<(1<<m);++j) {//所有状态
				if(dp[j]==-1) {//这个状态无法达到
					continue;
				}
				if(dp[j|candis[i]]==-1||dp[j]+1<dp[j|candis[i]]) {//获得了一个新状态或更优秀的到达此状态的办法
					dp[j|candis[i]] = dp[j]+1;//更新消耗
				}
			}
		}
		System.out.println(dp[(1<<m)-1]);
	}

}
