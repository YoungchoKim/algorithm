#include <iostream>
#define max(a, b) ((a) > (b) ? (a) : (b))
int dp[301][301][11];
int N;
int main(void) {
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			int num;
			scanf("%d", &num);
			for (int k = 1; k <= 10; k++) {
				dp[i][j][k] = max(dp[i-1][j][k], dp[i][j-1][k]);
			}
			dp[i][j][num]++;
		}
	}

	int M;
	scanf("%d", &M);
	for (int i = 0; i< M; i++) {
		int x1, y1, x2, y2;
		scanf("%d %d %d %d", &y1, &x1, &y2, &x2);
		int cmp[11];
		int cnt = 0;
		for (int k = 1; k <= 10; k++) {
			cmp[k] = dp[y2][x2][k];
			cmp[k] = cmp[k] - dp[y1 - 1][x1][k];
			cmp[k] = cmp[k] - dp[y1][x1 - 1][k];
			cmp[k] = cmp[k] + dp[y1 - 1][x1 - 1][k];
			if (cmp[k] > 0) {
				cnt++;	
			}
		}
		printf("%d\n", cnt);
	}
}