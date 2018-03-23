#include <iostream>
#define QSIZE 4000001
struct _pair {
	int x;
	int y;
	int cnt;
};
struct _queue {
	_pair que[QSIZE];
	int front;
	int rear;

	_pair pop() {
		front++;
		front = front % QSIZE;
		return que[front];
	}
	void push(_pair a) {
		rear++;
		rear = rear % QSIZE;
		que[rear] = a;
	}

	bool isEmpty() {
		if (rear == front) {
			return true;
		}
		return false;
	}
};
int N, K;
bool visited[2001][2001];
int ufMap[4001000];
int disjoint(int);
_pair p[100001];
_queue q;
int main(void) {
	scanf("%d %d", &N, &K);
	for (int i = 0; i < K; i++) {
		int r, c;
		scanf("%d %d", &c, &r);
		p[i] = { c, r, 0 };
		visited[r][c] = true;
		q.push(p[i]);
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			ufMap[(i - 1)*N + j] = (i - 1)*N + j;
		}
	}


	while (!q.isEmpty()) {
		_pair pair = q.pop();
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			int nr = pair.y + dy[i];
			int nc = pair.x + dx[i];
			if (nr < 1 || nr > N || nc < 1 || nc > N) {
				continue;
			}
			if (visited[nr][nc]) {
				if (disjoint((nr - 1) * N + nc) == disjoint((pair.y - 1)* N + pair.x)) {
					continue;
				}
				else {
					ufMap[disjoint((nr - 1) * N + nc)] = ufMap[(pair.y - 1)* N + pair.x];
					continue;
				}
			}
			visited[nr][nc] = true;
			q.push({ nc, nr, pair.cnt + 1 });
			ufMap[disjoint((nr - 1) * N + nc)] = ufMap[(pair.y - 1)* N + pair.x];
			
			for (int k = 0; k < 4; k++) {
				int nnr = nr + dy[k];
				int nnc = nc + dx[k];
				if (nnr < 1 || nnr > N || nnc < 1 || nnc > N) {
					continue;
				}
				if (visited[nnr][nnc] && disjoint((nr - 1) * N + nc) != disjoint((nnr - 1) * N + nnc)) {
					ufMap[disjoint((nnr - 1) * N + nnc)] = ufMap[(nr - 1) * N + nc];
				}


				int compare = disjoint((p[0].y - 1)* N + p[0].x);
				int j = 1;
				for (; j < K; j++) {
					if (compare != disjoint((p[j].y - 1) * N + p[j].x)) {
						break;
					}
				}
				if (j == K) {
					printf("%d\n", pair.cnt + 1);
					return 0;
				}

			}

		
		}
	}

}
int disjoint(int x) {
	if (ufMap[x] == x ){
		return x;
	}
	else {
		return ufMap[x] = disjoint(ufMap[x]);
	}
}