#include <iostream>
struct _vector {
	int capacity;
	int size;
	int *arr;
	_vector() {
		capacity = 1;
		arr = new int[capacity];
	}
	void push(int a) {
		if (size == capacity) {
			capacity *= 2;
			int *temp = new int[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = arr[i];
			}
			delete[] arr;
			arr = temp;
		}
		arr[size++] = a;
	}
};
int T, N;
_vector v[100001];
bool visited[100001];
bool visited2[100001];
int dfs(int start, int cur, int cnt);
int main(void) {
	freopen("input.txt", "r", stdin);
	scanf("%d", &T);

	while (T--) {
		scanf("%d ", &N);
		for (int i = 1; i <= N; i++) {
			int t;
			scanf("%d", &t);
			v[i].push(t);
		}
		for (int i = 1; i <= N; i++) {

			if (!visited[i])
				dfs(i, i, 0);
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited2[i]) {
				printf("%d ", i);
				cnt++;
			}
		}printf("\n");
		printf("%d\n", cnt);
		for (int i = 0; i <= N; i++) {
			v[i].size = 0;
			visited[i] = false;
			visited2[i] = false;
		}
	}

}
int dfs(int start, int cur, int cnt) {
	if (cnt != 0 && cur == start) {
		return -1;
	}
	if (visited[cur]) {
		return cur;
	}
	visited[cur] = true;
	int t = dfs(start, v[cur].arr[0], cnt + 1);
	if (t > 0) {
		visited2[cur] = true;
		if (cur == t) {
			return 0;
		}
		else {
			return t;
		}
	}
	if (t == -1) {
		visited2[cur] = true;
		return -1;
	}

	return 0;
}