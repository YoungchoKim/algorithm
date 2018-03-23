#include <iostream>

int arr[1000001];
void _qsort(int l, int r) {
	int pivot = arr[(l + r) / 2];
	int i = l;
	int j = r;
	while (i <= j) {
		while (arr[i] > pivot)i++;
		while (arr[j] < pivot)j--;
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
int main(void) {
	int N, M;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i);
	}

	int l = 2, r = 10000;
	int ans =1;
	while (l <= r) {
		int mid = (l + r) / 2;
		int cnt = 1;
		int sum = mid;
		for (int i = 0; i < N; i++) {
			if (cnt > M) break;
			sum -= arr[i];
			if (sum < 0) {
				cnt = cnt + (arr[i] - 1)/mid + 1;
				sum = mid - arr[i]%mid;
			}
		}
		if (cnt > M) {
			l = mid + 1;
		}
		else {
			ans = mid;
			r = mid - 1;
		}
	}
	printf("%d", ans);
}