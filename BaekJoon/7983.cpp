#include <iostream>
int N;
struct _pair {
	int d;
	int t;
};
int compare(int a, int b) {
	return b - a;
}
_pair pair[1000001];
void _qsort(int l, int r, int (*compare)(int, int)) {
	int pivot = pair[(l + r) / 2].t;
	int i = l;
	int j = r;
	while (i <= j) {
		while (compare(pair[i].t, pivot) < 0) i++;
		while (compare(pair[j].t, pivot) > 0) j--;
		if (i <= j) {
			_pair temp = pair[i];
			pair[i] = pair[j];
			pair[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsort(l, j, compare);
	if (i < r) _qsort(i, r, compare);
}
int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d %d", &pair[i].d, &pair[i].t);
	}
	_qsort(0, N - 1, compare);

	int cur = 1234567890;
	for (int i = 0; i < N; i++) {
		if (cur > pair[i].t) {
			cur = pair[i].t;
		}
		while (pair[i].d--) {
			cur--;
		}
	}
	printf("%d\n", cur);
}