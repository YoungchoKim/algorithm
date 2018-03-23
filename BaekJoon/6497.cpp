#include <iostream>
struct _edge {
	int x;
	int y;
	int cost;
};
int M, N;
_edge E[200001];
int uf[200001];
int disjoint(int);
void _qsort(int, int);
int main(void) {

	scanf("%d %d", &M, &N);
	while (!(M == 0 && N == 0)) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			scanf(" %d %d %d", &E[i].x, &E[i].y, &E[i].cost);
			sum += E[i].cost;
		}

		for (int i = 0; i <= M; i++) {
			uf[i] = i;
		}
		_qsort(0, N - 1);
		int cost = 0;
		for (int i = 0; i < N; i++) {
			if (disjoint(E[i].x) != disjoint(E[i].y)) {
				uf[disjoint(E[i].y)] = uf[E[i].x];
				cost += E[i].cost;
			}
		}
		printf("%d\n", sum - cost);


		scanf("%d %d", &M, &N);
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
void _qsort(int l, int r) {
	int pivot = E[(l + r) / 2].cost;
	int i = l;
	int j = r;
	while (i <= j) {
		while (E[i].cost < pivot) i++;
		while (E[j].cost > pivot) j--;

		if (i <= j) {
			_edge temp = E[i];
			E[i] = E[j];
			E[j] = temp;
			i++; j--;
		}

	}
	if (l < j) _qsort(l, j);
	if (i < r) _qsort(i, r);
}