#include <iostream>
void _qsort(int, int);
int N, T, P;
struct user {
	int id;
	int result[2001];
	int solveCnt;
	int score;
};

user u[2001];
int main(void) {
	scanf("%d %d %d", &N, &T, &P);
	for (int i = 0; i < N; i++) {
		u[i].id = i + 1;
		for (int j = 0; j < T; j++) {
			scanf("%d", u[i].result + j);
		}
	}

	int score[2001] = { 0 };
	for (int i = 0; i < T; i++) {
		int cnt = 0;
		for (int j = 0; j < N; j++) {
			if (u[j].result[i] == 0) {
				cnt++;
			}
			else {
				u[j].solveCnt++;
			}
		}
		score[i] = cnt;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < T; j++) {
			u[i].score += u[i].result[j] * score[j];
		}
	}

	_qsort(0, N - 1);
	for (int i = 0; i < N; i++) {
		if (u[i].id == P) {
			printf("%d %d", u[i].score, i + 1);
			break;
		}
	}
}
void _qsort(int l, int r) {
	user pivot = u[(l + r) / 2];
	int i = l;
	int j = r;
	while (i <= j) {
		while (u[i].score >= pivot.score) {
			if (u[i].score == pivot.score) {
				if (u[i].solveCnt == pivot.solveCnt) {
					if (u[i].id < pivot.id) {
						i++;
					}
					else {
						break;
					}
				}
				else if (u[i].solveCnt > pivot.solveCnt) {
					i++;
				}
				else {
					break;
				}
				
			}
			else {
				i++;

			}
		}
		

		while (u[j].score <= pivot.score) {
			if (u[j].score == pivot.score) {
				if (u[j].solveCnt == pivot.solveCnt) {
					if (u[j].id > pivot.id) {
						j--;
					}
					else {
						break;
					}
				}
				else if (u[j].solveCnt < pivot.solveCnt) {
					j--;
				}
				else {
					break;
				}

			}
			else {
				j--;
			}
		}
		

		if (i <= j) {
			user temp = u[i];
			u[i] = u[j];
			u[j] = temp;
			i++;
			j--;
		}

	}
	if (l < j) {
		_qsort(l, j);
	}
	if (i < r) {
		_qsort(i, r);
	}
}