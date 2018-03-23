#include <iostream>
struct jewelry {
	int weight;
	int cost;
};

struct _heap {
	int size;
	jewelry arr[300020];
	_heap() {
		size = 1;
	}
	void push(jewelry a) {
		arr[size++] = a;
		int idx = size - 1;
		while (idx > 1 && arr[idx].cost > arr[idx >> 1].cost) {
			jewelry temp = arr[idx];
			arr[idx] = arr[idx >> 1];
			arr[idx >> 1] = temp;
			idx >>= 1;
		}
	}
	jewelry pop() {
		jewelry v = arr[1];
		arr[1] = arr[--size];
		int j = 1;
		while (true) {
			int k = j * 2;
			if (k >= size) {
				break;
			}
			if (k + 1 < size && arr[k].cost < arr[k + 1].cost) {
				k++;
			}
			if (arr[j].cost < arr[k].cost) {
				jewelry temp = arr[j];
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
int bag[300002];
bool use[300030];
void _qsort(int l, int r) {
	int pivot = bag[(l + r) / 2];
	int i = l;
	int j = r;
	while (i <= j) {
		while (bag[i] < pivot) i++;
		while (bag[j] > pivot) j--;
		if (i <= j) {
			int temp = bag[i];
			bag[i] = bag[j];
			bag[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsort(l, j);
	if (i < r) _qsort(i, r);
}
int main(void) {
	int N, K;	//보석, 가방수
	scanf("%d %d", &N, &K);

	for (int i = 0; i < N; i++) {
		int w, c;
		scanf("%d %d", &w, &c);
		h.push({ w, c });
	}
	int bWeight, bN;
	int cnt = 0;
	long long sum = 0;
	for (int i = 0; i < K; i++) {
		scanf("%d", bag + i);
	}

	_qsort(0, K - 1);
	while (cnt < K) {

	}


	printf("%lld", sum);


}