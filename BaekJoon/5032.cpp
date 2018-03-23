#include <iostream>
int main(void) {
	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);
	int cnt = 0;
	int sum = a + b;
	while (sum / c) {
		int temp = sum / c;
		cnt += temp;
		sum = sum % c + temp;
	}
	printf("%d", cnt);
}