#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define Max(a, b) (a) > (b) ? (a) : (b)
int N, M;
int arr[1000001];

int main(void) {
	scanf("%d", &N);
	scanf("%d", &M);
	int max = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
		max = Max(max, arr[i]);
	}

	int bottom = 0; 
	int top = max;
	int lastM =0 ;
	while (bottom <= top) {
		int mid = (bottom + top) / 2;
		long long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (arr[i] - mid) > 0 ? arr[i] - mid : 0;
		}
		if (sum >= M) {
			lastM = Max(lastM, mid);
			bottom = mid + 1;
		}
		else if (sum < M) {
			top = mid - 1;
		}
	
		//printf("%d\n", mid);
	}
	printf("%d\n", lastM);
}