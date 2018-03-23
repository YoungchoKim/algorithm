#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

struct _node {
	_node * child[26];
	bool last;
	int size;
	~_node() {
		delete[] child;
	}
};
_node root;
int N;
char arr[100000][81];

int main(void) {
	while (scanf("%d", &N) != EOF) {
		
		root.size = 0;
		root.last = false;
		for (int i = 0; i < N; i++) {
			scanf("%s", arr[i]);
		}

		for (int i = 0; i < N; i++) {
			_node* ptr = &root;
			for (int a = 0; arr[i][a] != 0; a++) {
				int idx = arr[i][a] - 'a';
				if (ptr->child[idx] == nullptr) { //널 일 경우
					ptr->size++;
					ptr->child[idx] = new _node();
					if (arr[i][a + 1] == 0) {
						ptr->child[idx]->last = true;
					}
					ptr = ptr->child[idx];
				}
				else {
					ptr = ptr->child[idx];
					if (arr[i][a + 1] == 0) {
						ptr->last = true;
					}
				}
			}

		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			_node* ptr = &root;
			ptr = ptr->child[arr[i][0] - 'a'];
			int cnt = 1;
			for (int a = 1; 0 != arr[i][a]; a++) {
				int idx = arr[i][a] - 'a';
				if (ptr->size > 1) {
					cnt++;
					ptr = ptr->child[idx];
				}
				else if (ptr->last) {
					cnt++;
					ptr = ptr->child[idx];
				}
				else {
					ptr = ptr->child[idx];
				}

			}
			sum += cnt;
		}
		printf("%.2f\n", sum / (float)N);

	}
}