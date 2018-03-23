#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

#define min(a, b) (a) < (b) ? (a) : (b)

int main(void) {
	int n;
	scanf("%d", &n);
	int cnt = 0;
	n = 1000 - n;
	int unit[] = {500, 100, 50, 10, 5, 1};
	int dp[1000];
	for (int i = 0; i < 1000; i++) {
		dp[i] = 9876543210;
	}
	for (int i = 0; i < 5; i++) {
		dp[unit[i]] = 1;
	}
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j < 5; j++) {
			if (i - unit[j] >= 1) {
				dp[i] = min(dp[i], dp[i - unit[j]] + 1);
			}
		}
	}
	printf("%d\n", dp[n]);

}