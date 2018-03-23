#include <iostream>
#define min(a, b) ((a) < (b) ? (a) : (b))
#define max(a, b) ((a) > (b) ? (a) : (b))
char map[11][11];
int dx[] = { 1, 0, -1, 0 };
int dy[] = { 0, 1, 0, -1 };
int minR = 999, minC = 999, maxR, maxC;
int main(void) {
	int R, C;
	scanf("%d %d", &R, &C);
	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			scanf(" %c", map[r] + c);
		/*	if (map[r][c] == '.') {
				minR = min(minR, r);
				minC = min(minC, c);
				maxR = max(maxR, r);
				maxC = max(maxC, c);
			}*/
		}
	}
	//if (minR == maxR || minC == maxC) {
	//	printf("1\n");
	//	return 0;
	//}
	bool success = true;
	for (int r = 0; success && r < R; r++) {
		for (int c = 0; success && c < C; c++) {
			int cnt = 0;
			if (map[r][c] == '.') {
				for (int i = 0; i < 4; i++) {
					int nr = r + dy[i];
					int nc = c + dx[i];
					if (nr < 0 || nr >= R || c < 0 || c >= C) {
						cnt++;
						continue;
					}
					if (map[nr][nc] == 'X') {
						cnt++;
					}
				}
				if (cnt >= 3) {
					success = false;
				}

			}

		}
	}
	if (success) {
		printf("0\n");
	}
	else {
		printf("1\n");
	}

}