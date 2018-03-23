#include <iostream>

int arr[4];
int main(void) {
	arr[1] = 1;
	int N;
	scanf("%d ", &N);
	for (int i = 0; i < N; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	for (int i = 0; i < 4; i++) {
		if (arr[i]) {
			printf("%d", i);
		}
	}



}