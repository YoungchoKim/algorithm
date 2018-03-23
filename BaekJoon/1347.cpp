#include <iostream>
#define max(a, b) ((a) > (b) ? (a) : (b))
#define min(a, b) ((a) < (b) ? (a) : (b))
char map[100][100];
int dx[] = {1, 0, -1, 0};	//µ¿ ³² ¼­ ºÏ
int dy[] = {0, 1, 0, -1};
int N;
int curR, curC, curDir = 1;
int maxR, maxC, minR, minC;
int main(void) {
	scanf("%d", &N);
	curR = curC = maxR = maxC = minR = minC = 50;
	map[curR][curC] = '.';
	scanf("%*c");
	for (int i = 0; i < N; i++) {
		char oper;
		scanf("%c", &oper);
		switch (oper) {
		case 'R':
			curDir++;
			curDir %= 4;
			break;
		case 'L':
			curDir = (curDir + 3) % 4;
			break;
		case 'F':
			curR += dy[curDir];
			curC += dx[curDir];
			maxR = max(maxR, curR);
			maxC = max(maxC, curC);
			minR = min(minR, curR);
			minC = min(minC, curC);
			map[curR][curC] = '.';
			
			break;
		}
	}
	for (int i = minR; i <= maxR; i++) {
		for (int j = minC; j <= maxC; j++) {
			
			printf("%c", map[i][j] == '.' ? '.' : '#');
		}printf("\n");
	}
}