#include <iostream>
struct _edge {
	int x;
	int y;
	int cost;
};
int disjoint(int x);
void _qsort(int, int);
_edge E[1000001];
int uf[100001];
int N, M;
int main(void) {
	scanf("%d %d", &N, &M);
	for (int i = 0; i < M; i++) {
		scanf("%d %d %d", &E[i].x, &E[i].y, &E[i].cost);
	}
	for (int i = 0; i <= N; i++) {
		uf[i] = i;
	}
	_qsort(0, M - 1);

	int ans = 0;
	int cnt = 0;
	for (int i = 0; i < M; i++) {
		if (disjoint(E[i].x) != disjoint(E[i].y)) {
			uf[disjoint(E[i].y)] = uf[E[i].x];
			ans += E[i].cost;
			cnt++;
			if (cnt == N - 2) {
				break;
			}
		}
	}

	printf("%d", ans);

}
void _qsort(int l, int r) {
	int pivot = E[(l + r) / 2].cost;
	int i = l;
	int j = r;
	while (i <= j) {
		while (E[i].cost < pivot) {
			i++;
		}
		while (E[j].cost > pivot) {
			j--;
		}
		if (i <= j) {
			_edge temp = E[i];
			E[i] = E[j];
			E[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) {
		_qsort(l, j);
	}
	if (i < r) {
		_qsort(i, r);
	}
}
int disjoint(int x) {
	if (uf[x] == x) {
		return x;
	}
	else {
		return uf[x] = disjoint(uf[x]);
	}
}