#include <iostream>
int cur, second;
int main(void) {
	int N, L;
	scanf("%d %d", &N, &L);
	for (int i = 0; i < N; i++) {
		int a, b, c;
		scanf("%d %d %d", &a, &b, &c);
		
		second += a - cur;
		cur = a;
		int temp = second % (b+ c);
		if (temp < b) {
			second += b - temp;
		}
	}
	second += L - cur;
	printf("%d\n", second);



}