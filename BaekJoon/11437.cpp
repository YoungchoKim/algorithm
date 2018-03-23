#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
struct _vector {
	int capacity = 1;
	int size = 0;
	int *arr;
	_vector() {
		arr = new int[1];
	}
	~_vector() {
		free(arr);
	}

	void push(int a) {
		if (size == capacity) {
			capacity *= 2;
			arr = (int *)realloc(arr, capacity * sizeof(int));
		}
		arr[size++] = a;
	}
	int pop() {
		return arr[--size];
	}
};
struct _q {
	int arr[500001];
	int front;
	int rear;

	void push(int a) {
		rear++;
		rear = rear % 50001;
		arr[rear] = a;
	}
	int pop() {
		front++;
		front = front % 50001;
		return arr[front];
	}
	bool isEmpty() {
		if (rear == front) {
			return true;
		}
		return false;
	}
};
_vector v[50001];
bool visited[50001];
int parent[50001];
int level[50001];
_q q;
int N;
int gogo;
int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N - 1; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		v[a].push(b);
		v[b].push(a);
	}
	visited[1] = true;
	q.push(1);
	level[1] = 1;
	while (!q.isEmpty()) {
		int t = q.pop();
		for (int i = 0; i < v[t].size; i++) {
			if (!visited[v[t].arr[i]]) {
				visited[v[t].arr[i]] = true;
				parent[v[t].arr[i]] = t;
				q.push(v[t].arr[i]);
				level[v[t].arr[i]] = level[t] + 1;
			}
		}
	}

	scanf("%d", &gogo);
	for (int i = 0; i < gogo; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		int levelA = level[a];
		int levelB = level[b];
		int cnt = 0;
		while (levelA != levelB) {
			if (levelA > levelB) {
				a = parent[a];
			}
			else {
				b = parent[b];
			}
			levelA = level[a];
			levelB = level[b];
		}
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		printf("%d\n", a);
	}


}


