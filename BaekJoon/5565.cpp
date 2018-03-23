#include <iostream>
int sum;
int main(void) {
	scanf("%d", &sum);
	for (int i = 0; i < 9; i++) {
		int t;
		scanf("%d", &t);
		sum -= t;
	}
	printf("%d", sum);
}