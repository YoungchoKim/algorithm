// 1922.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//
#include <iostream>
struct _node {
	int x;
	int y;
	int cost;
};

_node E[1000001];
int uf[1001];
int N, M;
int disjoint(int);
void _qsort(int, int);
int main()
{
	scanf("%d", &N);
	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		scanf("%d %d %d", &E[i].x, &E[i].y, &E[i].cost);
	}
	_qsort(0, M - 1);

	for (int i = 0; i < N + 1; i++) {
		uf[i] = i;
	}

	int ans = 0;
	for (int i = 0; i < M; i++) {
		if (disjoint(E[i].x) != disjoint(E[i].y)) {
			uf[disjoint(E[i].y)] = uf[E[i].x];
			ans += E[i].cost;
		}
	}
	printf("%d", ans);


    return 0;
}
int disjoint(int x) {
	if (x == uf[x]) {
		return x;
	}
	else {
		return uf[x] = disjoint(uf[x]);
	}
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
			_node temp = E[i];
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