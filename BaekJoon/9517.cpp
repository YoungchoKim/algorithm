#include <iostream>
int limit = 210;
int n, m;
int main(void) {
	scanf("%d %d", &n, &m);
	n--;
	while (m--) {
		int a; char b;
		scanf("%d %c", &a, &b);
		limit -= a;
		if (limit < 0) {
			printf("%d\n", n + 1);
			break;
		}
		if (b == 'T') {
			n = (n + 1) % 8;
		}
	}


}