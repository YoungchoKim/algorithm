#include <stdio.h>
#define mx 10

char board[mx][mx];
int xRange, yRange;
int min = 11;

void search(int rx, int ry, int bx, int by, int modeX, int modeY, int time)
{
	int bTime, rTime;

	bTime = rTime = 0;

	if (time >= 11) return;
	if (modeX != 0 || modeY != 0)
	{
		while (board[bx + modeX][by + modeY] != '#')
		{
			bx += modeX; by += modeY; bTime++;
			if (board[bx][by] == 'O') return;
		}
		while (board[rx + modeX][ry + modeY] != '#')
		{
			rx += modeX; ry += modeY; rTime++;
			if (board[rx][ry] == 'O') {
				if (time<min) min = time; return;
			}
		}
	}

	if (rx == bx && ry == by)
	{
		if (rTime <= bTime) {
			bx -= modeX; by -= modeY;
		}
		else {
			rx -= modeX; ry -= modeY;
		}
	}

	if (modeX != 0 || modeY != -1) search(rx, ry, bx, by, 0, -1, time + 1);
	if (modeX != 0 || modeY != 1) search(rx, ry, bx, by, 0, 1, time + 1);
	if (modeX != -1 || modeY != 0) search(rx, ry, bx, by, -1, 0, time + 1);
	if (modeX != 1 || modeY != 0) search(rx, ry, bx, by, 1, 0, time + 1);
}
int main()
{
	int i, j;
	int rx, ry, bx, by;

	scanf("%d %d", &xRange, &yRange);
	for (i = 0; i < xRange; i++)
	{
		for (j = 0; j < yRange; j++)
		{
			scanf(" %c", &board[i][j]);
			if (board[i][j] == 'R') {
				rx = i; ry = j;
			}
			if (board[i][j] == 'B') {
				bx = i; by = j;
			}
		}
	}

	search(rx, ry, bx, by, 0, 0, 0);

	if (min < 11) printf("%d", min);
	else printf("-1");

	return 0;
}