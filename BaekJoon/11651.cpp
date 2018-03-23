#include <iostream>
struct _pair {
	int x;
	int y;
};

int N;
_pair pair[100001];
int compare(_pair a, _pair b) {
	if (a.y > b.y) {
		return 1;
	}
	else if (a.y < b.y) {
		return -1;
	}
	else {
		if (a.x > b.x) {
			return 1;
		}
		else if (a.x < b.x) {
			return -1;
		}
		else {
			return 0;
		}
	}


}
void _qsort(int, int);
int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		pair[i] = {x, y};
	}
	_qsort(0, N - 1);
	for (int i = 0; i < N; i++) {
		printf("%d %d\n", pair[i].x, pair[i].y);
		
	}
}

void _qsort(int l, int r) {
	_pair pivot = pair[(l + r) / 2];
	int i = l;
	int j = r;
	while (i <= j) {
		while (compare(pair[i], pivot) < 0) i++;
		while (compare(pair[j], pivot) > 0)j--;
		if (i <= j) {
			_pair temp = pair[i];
			pair[i] = pair[j];
			pair[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsort(l, j);
	if (i < r) _qsort(i, r);
}