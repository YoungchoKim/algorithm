#include <iostream>
int cnt[11];
int main(void) {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < 5; i++) {
		int t;
		scanf("%d", &t);
		cnt[t]++;
	}

	printf("%d\n", cnt[n]);


}