#include <iostream>
#define max(a, b) ((a) > (b) ? (a) : (b))
int main(void) {
	int max = 0;
	int sum = 0;
	for (int i = 0; i < 4; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		sum = sum - a + b;
		if (sum > 10000) {
			sum = 10000;
		}
		max = max(max, sum);
	}
	printf("%d\n", max);
}