#include <iostream>
struct _vector{
	int size;
	int capacity;
	int *arr;
	_vector() {
		capacity = 1;
		arr = new int[capacity];
	}
	void push(int a) {
		if (size == capacity) {
			capacity *= 2;
			int * temp = new int[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = arr[i];
			}
			delete[] arr;
			arr = temp;
		}
		arr[size++] = a;
	}
};
int n;
_vector v[5001];
bool student[5001][52];
int main(void) {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		int nn; scanf("%d", &nn);
		for (int j = 0; j < nn; j++) {
			int a; scanf("%d", &a);
			v[i].push(a);
		}
	}

	int s;
	scanf("%d", &s);
	for (int i = 0; i < s; i++) {	//학생 수
		int nn; scanf("%d", &nn);
		for (int k = 0; k < nn; k++) {		//여유있는 시간의 수
			int t; scanf("%d", &t);
			student[i][t] = true;
		}
		int cnt = 0;
		for (int j = 0; j < n; j++) {		//과목의 수
		
			bool success = true;
			for (int k = 0; k < v[j].size; k++) {
				int idx = v[j].arr[k];
				if (!student[i][idx]) {
					success = false;
					break;
				}

			}
			if (success) cnt++;
		}
		printf("%d\n", cnt);
	}

}