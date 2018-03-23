#include <iostream>
int N;
int arr[1000][1000];
int result[1000];
int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &arr[i][j]);
			result[i] |= arr[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		printf("%d ", result[i]);
	}

}