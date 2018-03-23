#include <iostream>
bool arr[50000000];
int getHash(int i) {
	unsigned int key = (unsigned int)i;
	key = (key * 31) % 50000000;
	return key;
}
struct _vector {
	int capacity;
	int size;
	int* arr;
	_vector(){
		size = 1;
		arr = new int[4];
		capacity = 4;
	}
	void insert(int a) {
		if (size == capacity) {
			capacity *= 2;
			arr = (int *)realloc(arr, capacity * sizeof(int));
		}

	}
};

int main(void) {
	int N, M;
	scanf("%d ", &N);

	for (int i = 0; i < N; i++) {
		int t;
		scanf("%d", &t);
		arr[getHash(t)] = true;
	}
	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		int t;
		scanf("%d", &t);
		if (arr[getHash(t)]) {
			printf("1\n");
		}
		else {
			printf("0\n");
		}
	}
}
