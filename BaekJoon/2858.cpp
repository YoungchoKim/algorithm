#include <iostream>
int R, B;
int main(void) {
	scanf("%d %d", &R, &B);
	for (int x = 3; ; x++) {
		int y = (R + B) / x;
		if ((R + B) % x != 0) {
			continue;
		}
		if (2*(x-1 + y-1) == R) {
			printf("%d %d", y, x);
			break;
		}
	}
}