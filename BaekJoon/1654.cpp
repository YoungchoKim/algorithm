#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#define Max(a, b) (a) > (b) ? (a) : (b)
int N, K;
long long arr[10001];
int main(void) {
	scanf("%d %d", &K, &N);

	int max = 0;
	for (int i = 0; i < K; i++) {
		scanf(" %d", &arr[i]);
		max = Max(max, arr[i]);
	}

	long long top = max;
	long long bottom = 1;
	int maxLength = 0;
	while (bottom <= top) {
		long long mid = (bottom + top) / 2;
		long long cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += arr[i] / mid;
		}
		if (cnt >= N) {
			maxLength = Max(maxLength, mid);
			bottom = mid + 1;
		}
		else if (cnt < N) {
			top = mid - 1;
		}
	}
	printf("%d\n", maxLength);
}