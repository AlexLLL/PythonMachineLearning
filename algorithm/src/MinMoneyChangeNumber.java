/*
递归与动态规划---换钱的最少货币数（每种货币有无数张）
【题目】

给定一个数组arr，arr中所有的值都为正数且不重复，每个值代表一种面值的货币，每种面值的货币有无数张，再给定一个整数aim代表要找的钱数，求组成aim的最少货币数。

【基本思路】

生成行数为N、列数为aim+1的dp矩阵，dp[i][j]的含义是在可以任意使用arr[0…i]货币的情况下，组成j所需的最小张数，矩阵的每一行和每一列可以先确定，其他的位置dp[i][j] = min(dp[i-1][j], dp[i][j-arr[i]]+1)，接下来解释dp[i][j]的值怎么确定：　　

矩阵的第一行表示只使用货币arr[0]的情况下，可以组成的钱数，当然只有钱数等于arr[0]的倍数时才成立，所以把这些位置设置为j//arr[0]，其余部分设置为32位整数的最大值（为什么是32位整数的最大值？ 因为题目求的是换钱的最少货币数，所以找不开的情况下要设置的尽可能大）

矩阵的第一列表示找的钱数为0的情况下需要的最小张数，货币为0是完全不需要任何货币，所以全部设置为0。

矩阵的其他位置来自以下的情况： 
1）完全不使用货币arr[i]的情况下的最小张数，即dp[i-1][j]。 
2）只使用1张货币arr[i]的情况下的最小张数，即dp[i-1][j-arr[i]]+1。 
3）只使用2张货币arr[i]的情况下的最小张数，即dp[i-1][j-2*arr[i]]+2。 
…… 
k）只使用k张货币arr[i]的情况下的最小张数，即dp[i-1][j-k*arr[i]]+k。k >= 0
选择其中的最小值即可。
即min{dp[i-1][j-k*arr[i]]+k (k >= 0)}
min{dp[i-1][j],min{dp[i-1][j-x*arr[i]]+x (x >= 1)}}
min{dp[i-1][j],min{dp[i-1][j-arr[i]-y*arr[i]]+y+1 (y >= 0)}}

将dp[i][j-arr[i]]，即将j-arr[i]整体看作j，min{dp[i-1][j-arr[i]-y*arr[i]]+y+1 (y >= 0)}等价于dp[i][j-arr[i]] + 1。

推到出dp[i][j]的公式为dp[i][j] = min(dp[i-1][j], dp[i][j-arr[i]] + 1)。

*/
public class MinMoneyChangeNumber {
    public int getMinNumber(int arr[], int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int dp[][] = new int[n][aim + 1];
        int max = Integer.MAX_VALUE;
        //dp[0..N-1][0]默认值为0，表示找的钱数为0时需要的钱币最少张数，因为不需要任何钱币。默认为0就好了
        for (int j = 1; j <= aim; j++) {//求只能使用arr[0]货币的情况下，找1...aim所用的最少张数
            dp[0][j] = max;
            if (j >= arr[0] && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            //剩下的位置，从左到右，从上到下计算dp[i][j],dp[i][j]表示找的钱数为j时，
            // 所用的钱币类别从arr[0]到arr[i]为止，所用的最小钱币数量
            for (int j = 1; j <= aim; j++) {
                int left = max;
                if (j >= arr[i] && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;//如果j-arr[i]这些钱所用钱币数可数，那么j这些钱只需要再加上一张arr[i]钱币就可以了
                }
                dp[i][j] = Math.min(dp[i - 1][j], left);//跟不用arr[i]这种钱币所用的最少钱币数作比较，取一个最少值
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }
}