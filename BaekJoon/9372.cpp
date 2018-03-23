#include <stdio.h>
int main(void) {
	int T;
	scanf("%d", &T);
	while (T--) {
		int N, M;
		scanf("%d %d", &N, &M);
		for (int i = 0; i < M; i++) {
			scanf("%*d %*d");
		}
		printf("%d\n", N - 1);
	}
}