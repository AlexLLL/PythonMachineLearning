import java.util.*;

public class LIS {
	public int findLongest(int[] A, int n) {
		// write code here
		int dp[]=new int[n];
		int help[]=new int[n];
		int max_length=0;
		dp[0]=1;
		help[0]=A[0];
		int count=0;
		int right=0;
		int left=0;
		int middle=0;
		for(int i=1;i<n;i++)//遍历数字序列
		{
			left=0;
			right=count;//help[]的有效的区间：0-count
			while(left<=right){ // 查找A[i]更新help[]时的位置
				middle=(left+right)/2;
				if(A[i]>=help[middle]){
					left=middle+1;//A[i]大，做比较的help[]向右收敛，边界为right
				}else{
					right=middle-1;//
				}
			}//left大于right跳出循环
			help[left]=A[i];//更新help[]的值
			count=Math.max(count,left);
			dp[i]=left+1;//更新dp[]的值
			max_length=Math.max(max_length,dp[i]);
		}
		return max_length;
	}
}
