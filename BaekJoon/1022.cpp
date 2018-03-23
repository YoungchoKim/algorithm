#include <iostream>
#define Max(a, b) ((a) > (b) ? (a) : (b))
int dx[] = {1, 0, -1, 0};	//동 북 서 남
int dy[] = {0, -1, 0, 1};
int top, bottom, left, right;
int r1, r2, c1, c2;
int map[50][5];
int max;
int length;
int getLength(int n);
int main(void) {
	top = bottom = left = right = 5000;
	scanf("%d %d %d %d", &r1, &c1, &r2, &c2);
	max = Max(max, Max(r1, Max(r2, Max(c1, c2))));
	max = Max(max, Max(r1*(-1), Max(r2*(-1), Max(c1*(-1), c2*(-1)))));

	
	
	int y, x;
	int dir = 0;
	int value = 1;
	y = x = 5000;
	while (true) {
		if (y < 5000 - max || y > 5000 + max || x < 5000 - max || x > 5000 + max) {
			break;
		}
		if (y >= r1 + 5000 && y <= r2 + 5000 && x >= c1 + 5000 && x <= c2 + 5000) {
			map[y - 5000 - r1][x - 5000 - c1] = value;
		}
		y = y + dy[dir];
		x = x + dx[dir];
		if (y < top) {
			top--;
			dir = (dir + 1) % 4;
		}
		else if (y > bottom) {
			bottom++;
			dir = (dir + 1) % 4;
		}
		else if (x > right) {
			right++;
			dir = (dir + 1) % 4;
		}
		else if (x < left) {
			left--;
			dir = (dir + 1) % 4;
		}

		value++;
	}
	// 최대자리수 저장하기
	for (int i = 0; i <= r2 - r1; i++) {
		for (int j = 0; j <= c2 - c1; j++) {
			length = Max(length, getLength(map[i][j]));
		}
	}
	
	//최대자리수와 현재 자리수 비교해서 출력



	for (int i = 0; i <= r2 - r1; i++) {
		for (int j = 0; j <= c2 - c1; j++) {
			int t1 = length;
			int t2 = getLength(map[i][j]);
			for (int k = 0; k < t1 - t2; k++) {
				printf(" ");
			}
			printf("%d", map[i][j]);
			if (j < c2 - c1) printf(" ");

		}printf("\n");
	}
}
int getLength(int n) {
	int i = 0;
	while (n) {
		n /= 10;
		i++;
	}
	return i;
}



