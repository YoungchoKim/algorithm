#include <iostream>

int map[20][20];
int dx[] = {1, 0, 1, -1};
int dy[] = {0, 1, 1, 1};
bool visited[20][20][4];
int dfs(int y, int x, int dir, int value, int cnt);
int main(void) {
	for (int i = 1; i <= 19; i++) {
		for (int j = 1; j <= 19; j++) {
			scanf("%d", &map[i][j]);
		}
	}
	
	for (int i = 1; i <= 19; i++) {
		for (int j = 1; j <= 19; j++) {
			if (map[i][j] > 0) {
				for (int k = 0; k < 4; k++) {
					visited[i][j][k] = true;
					int cnt = dfs(i + dy[k], j + dx[k], k, map[i][j], 1);
					if (cnt == 5) {
						printf("%d\n", map[i][j]);
						if (k == 3) {
							printf("%d %d\n", i + 4, j - 4);
							return 0;
						}
						printf("%d %d\n", i, j);
						return 0;
					}
				}
			}
		}
	}

	
	printf("0\n");
}
int dfs(int y, int x, int dir, int value, int cnt) {
	if (y < 1 || y >= 20 || x < 1 || x >= 20 || map[y][x] != value || visited[y][x][dir]) {
		return cnt;
	}
	visited[y][x][dir] = true;
	
	return dfs(y + dy[dir], x + dx[dir], dir, value, cnt + 1);
}