#include <iostream>
int arr[101];
int A, B, C;
int main(void) {
	scanf("%d %d %d", &A, &B, &C);

	for (int i = 0; i < 3; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		for (int j = a; j < b; j++) {
			arr[j]++;
		}
	}
	int sum = 0;
	for (int i = 0; i < 100; i++) {
		if (arr[i] == 1) {
			sum += A;
		}
		else if (arr[i] == 2) {
			sum += B * 2;
		}
		else if (arr[i] == 3) {
			sum += C * 3;
		}
	}
	printf("%d\n", sum);




}