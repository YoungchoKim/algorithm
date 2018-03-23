#include <iostream>
int N, M;
int arr[100001];
long long dp[100001];
int main(void) {
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		scanf("%d", arr + i);
		dp[i] = dp[i - 1] + arr[i];
	}
	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		printf("%lld\n", dp[b] - dp[a - 1]);
	}
}