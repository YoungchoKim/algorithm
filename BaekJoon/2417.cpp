#include <iostream>

int main(void) {
	unsigned long long n;
	scanf("%lld", &n);

	unsigned long long i = 0;
	while (i * i < n) {
		i++;
	}
	printf("%lld", i);

}