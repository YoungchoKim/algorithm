#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#define max(a, b) (a) > (b) ? (a) : (b)
using namespace std;
int arr[100001];
int main(void) {
	int M, N;
	scanf("%d %d", &M, &N);

	int max = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
		max = max(arr[i], max);
	}
	
	sort(arr, arr + N);

	int l = 1, int r = max;
	int minSum = 1234567890;
	while (l <= r) {
		int mid = (l + r) / 2;
		long long sum = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] - mid >= 0) {
				sum += mid * mid;
				cnt += mid;
			}
			else if (arr[i] - mid < 0) {
				sum += arr[i] * arr[i];
				cnt += arr[i];
			}
		}
		if (cnt >= M && minSum > sum) {
			minSum = sum;
			l = mid - 1;
		}
		else {

		}


	}






}
