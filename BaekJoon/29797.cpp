#include <iostream>

int cost[4];
int truckNum[101];
int main(void) {
	for (int i = 1; i <= 3; i++) {
		scanf("%d", cost + i);
	}
	cost[2] *= 2;
	cost[3] *= 3;
	int T = 3;
	while (T--) {
		int s, d;
		scanf("%d %d", &s, &d);
		for (int i = s; i < d; i++) {
			truckNum[i]++;
		}
	}
	int sum = 0;
	for (int i = 0; i < 101; i++) {
		sum += cost[truckNum[i]];
	}
	printf("%d", sum);
}