#include <iostream>
int N, M;
long long dp[1025][1025];
int main(void) {
	scanf("%d %d", &N, &M);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			int a;
			scanf("%d", &a);
			dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + a;
		}
	}
	for (int i = 0; i < M; i++) {
		int x1, y1, x2, y2;
		scanf("%d %d %d %d", &y1, &x1, &y2, &x2);
		printf("%lld\n", dp[y2][x2] - (dp[y2][x1-1] + dp[y1-1][x2] - dp[y1 - 1][x1 - 1]));
	}

}