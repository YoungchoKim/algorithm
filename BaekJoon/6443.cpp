#include <iostream>
char arr[1111111];
void _qsort(int l, int r) {
	int pivot = arr[(l + r) / 2];
	int i = l;
	int j = r;
	while (i <= j) {
		while (arr[i] < pivot) i++;
		while (arr[j] > pivot)j--;
		if (i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++; j--;
		}
	}
	if (l < j) _qsort(l, j);
	if (i < r) _qsort(i, r);
}
int _strlen(char *str) {
	int cnt = 0;
	while (str[cnt]) {
		cnt++;
	}
	return cnt;
}
int main(void) {
	int T;
	scanf("%d", &T);
	scanf("%*c");
	while (T--) {
		scanf("%s", arr);
		int size = strlen(arr);
		_qsort(0, size - 1);




	}

}