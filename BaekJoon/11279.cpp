#include <iostream>
struct _heap {
	int size;
	int arr[100001];
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
		if (isEmpty()) {
			return 0;
		}
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
	bool isEmpty() {
		return size == 1;
	}

};
_heap h;
int main(void) {
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int a;
		scanf("%d", &a);
		if (a) {
			h.push(a);
		}
		else {
			
			printf("%d\n", h.pop());
		}


	}


}