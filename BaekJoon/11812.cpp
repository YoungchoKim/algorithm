#include <iostream>
long long N;
int K, Q;
int main(void) {
	scanf("%lld %d %d", &N, &K, &Q);


	for (int i = 0; i < Q; i++) {
		long long a, b;
		scanf("%lld %lld", &a, &b);

		long long cnt = 0;
		while (a != b) {
			if (a > b) {
				if (K == 1) {
					break;
				}
				a = a + (K - 2);
				a /= K;
				
			}
			else {
				if (K == 1) {
					break;
				}
				b = b + (K - 2);
				b /= K;
				
			}
			cnt++;
		}
		if (K == 1) {
			if (a > b) {
				printf("%lld\n", a - b);
			}
			else{
				printf("%lld\n", b - a);
			}
		}
		else {
			printf("%lld\n", cnt);
		}
	}


}