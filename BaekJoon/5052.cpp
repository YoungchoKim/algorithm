#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

typedef struct _node {
	struct _node* next[10];
	bool fail;
};

int N;
char phoneNumber[20001][11];

_node root;
int main(void) {
	int T;
	scanf("%d", &T);
	while (T--) {
		scanf("%d", &N);
		for (int i = 0; i < 11; i++) {
			root.next[i] = nullptr;
			root.fail = false;
		}
		for (int i = 0; i < N; i++) {
			scanf("%s", phoneNumber[i]);
		}
		bool flag = false;
		for (int i = 0; i < N; i++) {
			_node* ptr = &root;
			
			int k = 0;
			for (; phoneNumber[i][k] != 0; k++) {
				if (ptr->next[phoneNumber[i][k] - '0'] == nullptr) {
					_node* ppp = new _node;
					ppp->fail = false;
					for (int tt = 0; tt < 11; tt++) {
						ppp->next[tt] = nullptr;

					}
					ptr->next[phoneNumber[i][k] - '0'] = ppp;
					ptr = ppp;
					if (phoneNumber[i][k + 1] == 0) {
						ptr->fail = true;
					}
				}
				else {
					if (ptr->next[phoneNumber[i][k] - '0']->fail) {
						printf("NO\n");
						flag = true;
						break;
					}
					else {
						ptr = ptr->next[phoneNumber[i][k] - '0'];
						if (phoneNumber[i][k + 1] == 0) {
							for (int i = 0; i < 11; i++) {
								if (ptr->next != nullptr) {
									printf("NO\n");
									flag = true;
									break;
								}
							}
						}
					}
				}

			}

			if (flag) {
				break;
			}
			
		}
		if (flag) {
			continue;
		}
		printf("YES\n");
	}

}