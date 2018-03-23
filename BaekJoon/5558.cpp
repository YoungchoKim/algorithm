#include <iostream>
#include <queue>
using namespace std;
struct _pair {
	int y;
	int x;
	int cnt;
	int total;
};


queue<_pair> q;
int R, C, N;
char map[1001][1001];
bool visited[1001][1001][11];
int cur = 1;
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int main(void) {
	scanf("%d %d %d", &R, &C, &N);

	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			scanf(" %c", map[r] + c);
			if (map[r][c] == 'S') {
				map[r][c] =  '.';
				q.push({ r, c, 1, 0 });
				visited[r][c][1] = true;
			}
		}
	}
	

	while (!q.empty()) {
		_pair p = q.front();
		q.pop();
		if (p.cnt < cur) {
			continue;
		}
		for (int i = 0; i < 4; i++) {
			int nr = p.y + dy[i];
			int nc = p.x + dx[i];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc][p.cnt]) {
				continue;
			}
			visited[nr][nc][p.cnt] = true;
			if (map[nr][nc] == '.') {
				q.push({ nr, nc, p.cnt, p.total+1 });
			}
			if (map[nr][nc] >= '1' && map[nr][nc] <= '9') {
				if (p.cnt == map[nr][nc] - '0') {
					map[nr][nc] = '.';
					visited[nr][nc][p.cnt + 1] = true;
					q.push({ nr, nc, p.cnt + 1, p.total + 1 });
					cur = p.cnt;
					if (p.cnt == N) {
						printf("%d\n", p.total + 1);
						return 0;
					}
				}
				else {
					visited[nr][nc][p.cnt] = true;
					q.push({ nr, nc, p.cnt, p.total + 1 });

				}
			}

		}


	}
		

}