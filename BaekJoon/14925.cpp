#include <iostream>
#define min(a, b) ((a) < (b) ? (a) : (b))
#define max(a, b) ((a) > (b) ? (a) : (b))
int map[1001][1001];
int dp[1001][1001];
int main(void) {
	int M, N;
	scanf("%d %d", &M, &N);
	for (int i = 1; i <= M; i++) {
		for (int j = 1; j <= N; j++) {
			scanf(" %d", &map[i][j]);
		}
	}
	int result = 0;
	for (int i = 1; i <= M; i++) {
		for (int j = 1; j <= N; j++) {
			if (map[i][j] == 1 || map[i][j] == 2) {
				dp[i][j] = 0;
			}
			else {
				dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i-1][j-1])) + 1;
			}
			result = max(result, dp[i][j]);
		}
	}
	
	printf("%d\n", result);


}