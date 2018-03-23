#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#define R 51
#define C 51
#define QSIZE 2600
char map[R][C];
bool visited[R][C];
int gR, gC;

typedef struct _pair {
	int r;
	int c;
	int type;
	int cnt;
};
int front = 0, rear = 0;
_pair queue[QSIZE];
void add(_pair pair) {
	rear++;
	rear = rear % QSIZE;
	queue[rear] = pair;
}
_pair pop() {
	front++;
	front = front % QSIZE;
	return queue[front];
}
bool isEmpty() {
	if (front == rear) {
		return true;
	}
	return false;
}
void init();
void solve();
_pair src, dest;
int main(void) {
	init();
	solve();



	return 0;
}
void init() {
	scanf("%d %d", &gR, &gC);
	for (int i = 0; i < gR; i++) {
		scanf("%s", map[i]);
		for (int j = 0; j < gC; j++) {
			if (map[i][j] == '*') {
				_pair t;
				t.r = i;
				t.c = j;
				t.type = 1;
				t.cnt = 0;
				visited[i][j] = true;
				add(t);
			}
			else if (map[i][j] == 'D') {
				dest.r = i;
				dest.c = j;
			}
			else if (map[i][j] == 'S') {
				src.r = i;
				src.c = j;
			}
		}
	}
}

void solve() {
	src.cnt = 1;
	src.type = 2;
	add(src);
	visited[src.r][src.c] = true;

	while (!isEmpty()) {
		_pair p = pop();
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		for (int i = 0; i < 4; i ++ ) {
			int nR = p.r + dy[i];
			int nC = p.c + dx[i];
			if (nR < 0 || nR >= gR || nC < 0 || nC >= gC
				|| visited[nR][nC] || map[nR][nC] == 'X') {
				continue;
			}
			if (p.type == 1 && nR == dest.r && nC == dest.c) {
				continue;
			}
			_pair t;
			t.r = nR;
			t.c = nC;
			t.type = p.type;
			visited[nR][nC] = true;
			if (p.type == 2) {
				if (nR == dest.r && nC == dest.c) {
					printf("%d\n", p.cnt);
					return;
				}
				t.cnt = p.cnt + 1;
			}
			add(t);
		}
	}

	printf("KAKTUS\n");
}
