#include <iostream>
int cnt[2];
int main(void) {
	int N;
	scanf("%d", &N);
	while (N--) {
		int t = 0;
		scanf("%d", &t);
		cnt[t]++;
	}
	if (cnt[0] > cnt[1]) {
		printf("Junhee is not cute!");
	}
	else {
		printf("Junhee is cute!");
	}

}