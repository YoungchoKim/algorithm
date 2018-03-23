#include <iostream>
#define max(a, b) ((a) > (b) ? (a) : (b))
int main(void) {
	int L, A, B, C, D;
	scanf("%d%d%d%d%d", &L, &A, &B, &C, &D);

	int r1 = A / C;
	int r2 = B / D;
	if (A % C != 0) r1++;
	if (B%D != 0) r2++;
	printf("%d", L - max(r1, r2));

}