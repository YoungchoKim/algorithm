#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#define Max(a, b) (a) > (b) ? (a) : (b)
#define Min(a, b) (a) < (b) ? (a) : (b)
using namespace std;

int arr[200001];
int main(void) {
	int N, C;
	scanf("%d %d", &N, &C);
	for (int i = 0; i < N; i++) {
		scanf(" %d", &arr[i]);
	}
	sort(arr, arr+N);
	int ans = 0;
	int left = arr[0];
	int right = arr[N - 1];
	while (left <= right) {
		int mid = (left + right) / 2;
		
		int index = 1;
		int cnt = 1;
		int tmp = arr[0];
		while (index < N) {
			if (arr[index] >= tmp + mid) {
				cnt++;
				tmp = arr[index];
			}
			index++;
		}
		if (cnt >= C) {
			ans = Max(ans, mid);
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}
	printf("%d\n", ans);
}