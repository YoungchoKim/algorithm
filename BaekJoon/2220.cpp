#include <iostream>
struct _heap {
	int arr[100002];
	int size;
	_heap() {
		size = 1;
	}
	void push(int a) {
		arr[size++] = a;
		int idx = size - 1;
		while (idx > 1 && arr[idx] > arr[idx / 2]) {
			int temp = arr[idx];
			arr[idx] = arr[idx / 2];
			arr[idx / 2] = temp;
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
			if (k + 1 < size && arr[k] < arr[k + 1]) {
				k++;
			}
			if (arr[j] < arr[k]) {
				int temp = arr[j];
				arr[j] = arr[k];
				arr[k] = temp;
				j = k;
			}
			else {
				break;
			}
		}
		return v;
	}
};
int N;
_heap h;
int main(void) {
	scanf("%d", &N);
	for (int i = N; i > 0; i--) {
		h.push(i);
	}
	for (int i = 1; i < h.size; i++) {
		printf("%d ", h.arr[i]);
	}

}