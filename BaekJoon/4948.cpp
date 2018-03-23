#include <iostream>
bool prime[300000];
int main(void) {
	for (int i = 2; i < 300000; i++) {
		prime[i] = true;
	}

	for (int i = 2; i* i < 300000; i++) {
		int t = i * 2;
		while (t < 300000) {
			prime[t] = false;
			t += i;
		}
	}
	while (true) {
		int n;
		scanf("%d", &n);
		if (n == 0) break;
		int cnt = 0;
		for (int i = n + 1; i <= 2 * n; i++) {
			if (prime[i]) cnt++;
		}
		printf("%d\n", cnt);


	}

}