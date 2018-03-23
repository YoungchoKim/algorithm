#include <iostream>
int cnt[10];
int main(void) {
	long long a;
	scanf("%lld", &a);
	long long sum = 1;
	for (int i = 1; i <= a; i++) {
		sum *= i;
	}
	
	printf("%lld", sum);


}