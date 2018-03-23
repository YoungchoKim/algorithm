#include <iostream>
struct _node {
	int id;
	int x;
	int y;
	int z;
};
struct _edge {
	int x;
	int y;
	int cost;
};
int compareX(_node n1, _node n2);
int compareY(_node n1, _node n2);
int compareZ(_node n1, _node n2); 
int subAndAbs(int a, int b);
void _qsort(int l, int r, int(*compare)(_node, _node));
void _qsortX(int, int);
void _qsortY(int, int);
void _qsortZ(int, int);
void _qsortEdge(int, int);
int disjoint(int);
_node nod[100001];
_edge edge[900001];
int uf[100001];
int N;
int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		nod[i].id = i;
		scanf("%d %d %d", &nod[i].x, &nod[i].y, &nod[i].z);
	}
//	_qsortX(0, N - 1);
	_qsort(0, N - 1, compareX);
	for (int i = 0; i < N - 1; i++) {
		int cost = subAndAbs(nod[i].x, nod[i + 1].x);
		int x = nod[i].id;
		int y = nod[i + 1].id;
		edge[i] = {x, y, cost};
	}
	_qsort(0, N - 1, compareY);
//	_qsortY(0, N - 1);
	for (int i = N - 1; i < 2*N - 2; i++) {
		int cost = subAndAbs(nod[i-N + 1].y, nod[i - N+ 2].y);
		int x = nod[i -N + 1].id;
		int y = nod[i -N + 2].id;
		edge[i] = { x, y, cost };
	}
	_qsort(0, N - 1, compareZ);
//	_qsortZ(0, N - 1);
	for (int i = 2*N - 2; i < 3*N - 3; i++) {
		int cost = subAndAbs(nod[i - 2* N + 2].z, nod[i - 2* N + 3].z);
		int x = nod[i - 2* N + 2].id;
		int y = nod[i - 2* N + 3].id;
		edge[i] = { x, y, cost };
	}
	//¿§Áö Á¤·Ä
	_qsortEdge(0, 3 * N - 4);

	for (int i = 0; i < 100001; i++) {
		uf[i] = i;
	}
	int cost = 0;
	for (int i = 0; i < 3 * N - 3; i++) {
		if (disjoint(edge[i].x) != disjoint(edge[i].y)) {
			uf[disjoint(edge[i].y)] = uf[edge[i].x];
			cost += edge[i].cost;
		}
	}
	printf("%d", cost);
}
int disjoint(int x) {
	if (uf[x] == x) {
		return x;
	}
	else {
		return uf[x] = disjoint(uf[x]);
	}
}

int subAndAbs(int a, int b) {
	int result = a - b;
	if (result < 0) {
		result *= -1;
	}
	return result;
}

int compareX(_node n1, _node n2) {
	return n1.x - n2.x;
}
int compareY(_node n1, _node n2) {
	return n1.y - n2.y;
}
int compareZ(_node n1, _node n2) {
	return n1.z - n2.z;
}

void _qsort(int l, int r, int (*compare)(_node, _node)) {
	_node pivot = nod[(l + r) / 2];
	int i = l;
	int j = r;
	while (i <= j) {
		while (compare(nod[i], pivot)<0) i++;
		while (compare(nod[j], pivot)>0) j--;
		if (i <= j) {
			_node temp = nod[i];
			nod[i] = nod[j];
			nod[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsort(l, j, compare);
	if (i < r) _qsort(i, r, compare);
}

void _qsortX(int l, int r) {
	int pivot = nod[(l + r) / 2].x;
	int i = l;
	int j = r;
	while (i <= j) {
		while (nod[i].x < pivot) i++;
		while (nod[j].x > pivot) j--;
		if (i <= j) {
			_node temp = nod[i];
			nod[i] = nod[j];
			nod[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsortX(l, j);
	if (i < r) _qsortX(i, r);
}

void _qsortY(int l, int r) {
	printf("%d %d\n", l, r);
	for (int i = 0; i < N; i++) {
		printf("%d ", nod[i].y);
	}
	printf("\n");

	int pivot = nod[(l + r) / 2].y;
	int i = l;
	int j = r;
	while (i <= j) {
		while (nod[i].y < pivot) i++;
		while (nod[j].y > pivot) j--;
		if (i <= j) {
			_node temp = nod[i];
			nod[i] = nod[j];
			nod[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsortY(l, j);
	if (i < r) _qsortY(i, r);
}

void _qsortZ(int l, int r) {
	int pivot = nod[(l + r) / 2].z;
	int i = l;
	int j = r;
	while (i <= j) {
		while (nod[i].z < pivot) i++;
		while (nod[j].z > pivot) j--;
		if (i <= j) {
			_node temp = nod[i];
			nod[i] = nod[j];
			nod[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsortZ(l, j);
	if (i < r) _qsortZ(i, r);
}

void _qsortEdge(int l, int r) {
	int pivot = edge[(l + r) / 2].cost;
	int i = l;
	int j = r;
	while (i <= j) {
		while (edge[i].cost < pivot) i++;
		while (edge[j].cost > pivot) j--;
		if (i <= j) {
			_edge temp = edge[i];
			edge[i] = edge[j];
			edge[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsortEdge(l, j);
	if (i < r) _qsortEdge(i, r);
}