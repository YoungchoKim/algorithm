#include <iostream>
struct _vector {
	int size;
	int capacity;
	int* arr;
	_vector() {
		capacity = 1;
		arr = new int[capacity];
	}

	void push(int a) {
		if (size == capacity) {
			capacity *= 2;
			int* temp = new int[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = arr[i];
			}
			delete[] arr;
			arr = temp;
		}
		arr[size++] = a;
	}
	void _sort(int l, int r) {
		int pivot = arr[(l + r) / 2];
		int i = l;
		int j = r;
		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (l < j) _sort(l, j);
		if (i < r) _sort(i, r);
	}
};
bool map[100][100];
int M, N, K;
int max;
void dfs(int, int);
void printMap() {
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			printf("%d ", map[i][j]);
		}
		printf("\n");
	}
}
_vector v;
int main(void) {
	
	scanf("%d %d %d", &M, &N, &K);

	while (K--) {
		int x1, y1, x2, y2;
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);

		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				map[i][j] = true;
			}
		}
	}
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (!map[i][j]) {
				
				max = 0;
				//printMap();
				dfs(i, j);
				//printf("\n%d %d\n", i, j);
				//printMap();
				//printf("\n");
				v.push(max);
			}
		}
	}
	v._sort(0, v.size - 1);
	printf("%d\n", v.size);
	for (int i = 0; i < v.size; i++) {
		printf("%d ", v.arr[i]);
	}
}

void dfs(int y, int x) {
	if (y < 0 || y >= M || x < 0 || x >= N || map[y][x]) {
		return;
	}
	map[y][x] = true;
	max++;
	dfs(y + 1, x);
	dfs(y - 1, x);
	dfs(y, x + 1);
	dfs(y, x - 1);
}