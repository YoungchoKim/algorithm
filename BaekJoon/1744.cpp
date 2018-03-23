#include <iostream>
int arr[10001];
void _qsort(int l, int r) {
	int pivot = arr[(l + r) / 2];
	int i = l;
	int j = r;
	while (i <= j) {
		while (arr[i] < pivot) i++;
		while (arr[j] > pivot) j--;
		if (i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsort(l, j);
	if (i < r) _qsort(i, r);
}
int N;
int main(void) {
	scanf("%d", &N);
	long long sum = 0;
	int cnt1 = 0, cnt2 = 0, cnt3 = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i);
		
	}
	_qsort(0, N - 1);
	int i = 0;
	while (arr[i+1] < 1) {
		sum += arr[i] * arr[i + 1];
		i += 2;
	}
	int j = N - 1;
	while (arr[j-1] > 1) {
		sum += arr[j] * arr[j -1];
		j -= 2;
	}
	//printf("%d %d\n", i, j);
	for (; i <= j; i++) {
		sum += arr[i];
	}
	printf("%d", sum);
	


}