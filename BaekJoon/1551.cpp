#include <iostream>
int N, K;
int arr[21];
int main(void) {
	scanf("%d %d", &N, &K);

	for (int i = 0; i < N; i++) {
		scanf("%*c");
		scanf("%d", arr + i);
	}

	for (int i = 0; i < K; i++) {
		for (int j = 0; j < N - 1; j++) {
			arr[j] = arr[j + 1] - arr[j];
		}
	}
	printf("%d", arr[0]);
	for (int i = 1; i < N - K; i++) {
		printf(",%d", arr[i]);
	}

}


