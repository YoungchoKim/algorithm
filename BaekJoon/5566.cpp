#include <iostream>

int arr[1001];
int main(void) {
	int N, M;
	int cur = 0;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i);
	}

	for (int i = 0; i < M; i++) {
		int go;
		scanf("%d", &go);
		cur += go;
		if (cur >= N - 1) {
			printf("%d", i + 1);
			break;
		}
		//printf("%d\n", cur);
		cur += arr[cur];
		if (cur >= N -1) {
			printf("%d", i + 1);
			break;
		}
		//printf("%d\n", cur);
	}


}