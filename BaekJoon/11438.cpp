#include <iostream>
#define MAX 18
struct _vector {
	int size;
	int capacity;
	int* arr;
	_vector() {
		capacity = 2;
		arr = new int[2];
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
};
_vector v[100001];
int depth[100001] = {-1};
int parent[100001][MAX] = {-1};
void dfs(int cur) {
	for (int i = 0; i < v[cur].size; i++) {
		if (depth[cur] == -1) {
			int next = v[cur].arr[i];
			depth[next] = depth[cur] + 1;
			parent[next][0] = cur;
			dfs(next);
		}
	}
}

int main(void) {
	int N;
	scanf("%d", &N);
	int a, b;
	for (int i = 0; i < N - 1; i++) {
		scanf("%d %d", &a, &b);
		--a; --b;
		v[a].push(b);
		v[b].push(a);
	}
	///////전처리
	depth[0] = 0; 
	dfs(0);
	for (int i = 0; i < MAX; i++) {
		for (int j = 0; j < 100001; j++) {
			if (parent[j][i] != -1) {
				parent[j][i + 1] = parent[parent[j][i]][i];

			}
		}
	}

	int M;
	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		///구현...
		--a; --b;
		if (depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		int diff = depth[a] - depth[b];
		for (int j = 0; diff; j++) {
			if (diff % 2) a = parent[a][j];
			diff /= 2;
		}



	}



}