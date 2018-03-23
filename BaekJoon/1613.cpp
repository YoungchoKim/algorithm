#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

bool map[401][900];
int N, K;
int main(void) {
	scanf("%d %d", &N, &K);
	for (int i = 0; i < K; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		map[a][400 + b] = true;
		map[b][400 - a] = true;
	}
	int s = 0;
	scanf("%d", &s);
	while (s--) {
		int a, b;
		scanf("%d %d", &a, &b);
		if (map[a][400 + b] || map[b][400 - a]) {
			printf("-1\n");
		}
		else if (map[b][400 + a]  || map[a][400 - b]) {
			printf("1\n");
		}
		else {
			printf("0\n");
		}
	}


}