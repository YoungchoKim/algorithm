#include <iostream>
struct _node {
	int idx;
	int value;
};
struct _vector {
	int capacity;
	int size;
	_node *arr;
	_vector() {
		capacity = 5;
		arr = new _node[5];
	}
	void push(_node a) {
		if (capacity == size) {
			capacity *= 2;
			arr = (_node *)realloc(arr, sizeof(_node) * capacity);
		}
		arr[size++] = a;
	}
	_node pop() {
		return arr[--size];
	}
};

int N, M;
_vector v[32001];

int compare(int a, int b) {
	for (int i = 0; i < v[a].size; i++) {
		if (v[a].arr[i].idx == b) {
			if (v[a].arr[i].value == b) {
				return 1;
			}
			else if (v[a].arr[i].value == a) {
				return -1;
			}
		}
	}
	return a - b;
}
void swap(int* a, int*b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}
struct _heap {
	int arr[33000];
	int size;
	_heap() {
		size = 1;
	}
	void push(int a) {
		arr[size++] = a;
		int idx = size - 1;
		while (idx > 1 && compare(arr[idx], arr[idx / 2]) < 0) {
			swap(arr+ idx, arr + idx / 2);
			idx /= 2;
		}
	}

	int pop() {
		int v = arr[1];
		arr[1] = arr[--size];
		int j = 1;
		while (true) {
			int k = j * 2;
			if (k >= size) {
				break;
			}
			if (k + 1 < size && compare(arr[k], arr[k + 1]) > 0) {
				k++;
			}
			if (compare(arr[j], arr[k]) > 0) {
				swap(arr + j, arr + k);
				j = k;
			}
			else {
				break;
			}
		}
		return v;
	}
	bool isEmpty() {
		if (size == 1) {
			return true;
		}
		return false;
	}

};
_heap h;
int main(void) {
	scanf("%d %d", &N, &M);


	for (int i = 0; i < M; i++) {
		int n1, n2;
		scanf("%d %d", &n1, &n2);
		v[n1].push({n2, n1});
		v[n2].push({ n1, n1 });
	}
	for (int i = 1; i <= N; i++) {
		h.push(i);
	}
	while (!h.isEmpty()) {
		printf("%d ", h.pop());
	}

}
