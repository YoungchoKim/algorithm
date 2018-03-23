#include <iostream>
#define min(a, b) ((a) < (b) ? (a) : (b))
int main(void) {
	int cost1 = 10000, cost2 = 10000;
	int t;
	scanf("%d", &t);
	cost1 = min(cost1, t);
	scanf("%d", &t);
	cost1 = min(cost1, t);
	scanf("%d", &t);
	cost1 = min(cost1, t);
	scanf("%d", &t);
	cost2 = min(cost2, t);
	scanf("%d", &t);
	cost2 = min(cost2, t);

	printf("%d", cost1 + cost2 - 50);

}