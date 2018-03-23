#include <iostream>
#define min(a, b) ((a) < (b) ? (a) : (b))
struct _node {
	int value;
	int team;
};
int teamCnt[1001];
_node arr[1000000];
void _qsort(int l, int r) {
	int pivot = arr[(l + r) / 2].value;
	int i = l;
	int j = r;
	while (i <= j) {
		while (arr[i].value < pivot) i++;
		while (arr[j].value > pivot) j--;
		if (i <= j) {
			_node temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsort(l, j);
	if (i < r) _qsort(i, r);
}
int N, M;
int low, high;
int result = 1234567890;

int main(void) {
	scanf("%d %d", &N, &M);
	int size = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			int t;
			scanf("%d", &t);
			arr[size++] = {t, i};
		}
	}
	arr[size].value = -1;
	_qsort(0, size - 1);
	int SZ = 0;
	while (high < size) {
		teamCnt[arr[high].team]++;
		if (teamCnt[arr[high].team] == 1) {
			SZ++;
		}
		
		while (low < high && SZ == N) {
			result = min(result, arr[high].value - arr[low].value);
			teamCnt[arr[low].team]--;
			if (teamCnt[arr[low].team] == 0) {
				SZ--;
			}
			low++;
		}
		high++;
	}
	printf("%d", result);
}