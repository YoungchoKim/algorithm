#include <iostream>
#define HSIZE 100002
typedef long long ll;
struct _heap {
	int size;
	ll arr[HSIZE];
	_heap() {
		size = 1;
	}
	void push(ll a) {
		arr[size++] = a;
		int idx = size - 1;
		while (idx > 1 && arr[idx] < arr[idx/2]) {
			int temp = arr[idx];
			arr[idx] = arr[idx / 2];
			arr[idx / 2] = temp;
			idx /= 2;
		}

	}
	ll pop() {
		int v = arr[1];
		arr[1] = arr[--size];
		
		int j = 1;
		while (1) {
			int k = j * 2;
			if (k >= size) {
				break;
			}
			if (k + 1 < size && arr[k] > arr[k + 1]) k++;
			if (arr[j] > arr[k]) {
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
		int t;
		scanf("%d", &t);
		h.push(t);
	}
	ll sum = 0;
	while (h.size > 2) {
		ll num1 = h.pop();
		ll num2 = h.pop();
		ll temp = num1 + num2;
		sum += temp;
		h.push(temp);
	}
	printf("%lld", sum);
}