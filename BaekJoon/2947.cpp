#include <iostream>
#include <stdlib.h>
void swap(int * a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}
int arr[5];
int main(void) {
	for (int i = 0; i < 5; i++) {
		scanf("%d", arr + i);
	}
	for (int i = 0; i < 5; i++) {
		for (int j = 1; j < 5; j++) {
			if (arr[j - 1] > arr[j]) {
				swap(&arr[j - 1], &arr[j]);
				for (int k = 0; k < 5; k++) {
					printf("%d ", arr[k]);
				}printf("\n");
			}
		}
	}
}



