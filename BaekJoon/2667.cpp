#include <iostream>
#define max(a, b) ((a) > (b) ? (a) : (b))
struct _vector {
	int size;
	int capacity;
	int* arr;
	_vector() {
		capacity = 2;
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

	void sort(int l, int r) {
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
		if (l < j) sort(l, j);
		if (i < r) sort(i, r);

	}
};
int N;
char map[26][26];
bool visited[26][26];
int result = 0;
int dy[] = {1, 0, -1, 0};
int dx[] = {0, 1, 0, -1};
void dfs(int y, int x, int cnt) {
	if (y < 0 || y >= N || x < 0 || x >= N || visited[y][x] || map[y][x] == '0') {
		return;
	}
	visited[y][x] = true;
	result++;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		dfs(ny, nx, cnt + 1);
	}
}
_vector v;
int main(void) {
	scanf("%d", &N);
	scanf("%*c");
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%c", map[i] + j);
		}
		scanf("%*c");
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] == '1' && !visited[i][j]) {
				result = 0;
				dfs(i, j, 0);
				v.push(result);
			}
		}
	}
	
	v.sort(0, v.size - 1);
	printf("%d\n", v.size);
	for (int i = 0; i < v.size; i++) {
		printf("%d ", v.arr[i]);
	}
}