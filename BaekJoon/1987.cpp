#include <iostream>
#define max(a, b) ((a) > (b) ? (a) : (b))
int R, C;
char map[21][21];
bool visited[200];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int result;
void dfs(int y, int x, int cnt) {
	if (y < 0 || y >= R || x < 0 || x >= C || visited[map[y][x]]) {
		return;
	}
	visited[map[y][x]] = true;
	result = max(result, cnt);
	for (int i = 0; i < 4; i++) {
		int nr = y + dy[i];
		int nc = x + dx[i];
		dfs(nr, nc, cnt + 1);
	}
	visited[map[y][x]] = false;
}
int main(void) {
	scanf("%d %d", &R, &C);
	scanf("%*c");
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			scanf("%c", map[i] + j);
		}
		scanf("%*c");
	}
	dfs(0, 0, 0);
	printf("%d", result + 1);
}