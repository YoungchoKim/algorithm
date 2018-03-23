#include <iostream>
#define FRONT 100
#define BACK 200
#define UP 300
#define DWON 400
#define LEFT 500
#define RIGHT 600

char map[6][9];
void init() {
	for (int i = 0; i < 9; i++) {
		map[0][i] = 'o';
		map[1][i] = 'w';
		map[2][i] = 'r';
		map[3][i] = 'y';
		map[4][i] = 'g';
		map[5][i] = 'b';
	}
}

void goLeft(int n) {
	char temp[3];
	temp[0] = map[n][0];
	temp[1] = map[n][1];
	map[n][0] = map[n][2];
	map[n][1] = map[n][5];
	map[n][2] = map[n][8];

	map[n][5] = map[n][7];
	map[n][8] = map[n][6];

	map[n][7] = map[n][3];
	map[n][6] = temp[0];
	map[n][3] = temp[1];
}
void goFront() {
	char temp[3];
	temp[0] = map[4][6];
	temp[1] = map[4][7];
	temp[2] = map[4][8];

	map[4][6] = map[1][6];
	map[4][7] = map[1][7];
	map[4][8] = map[1][8];

	map[1][6] = map[5][6];
	map[1][7] = map[5][7];
	map[1][8] = map[5][8];

	map[5][6] = map[3][2];
	map[5][7] = map[3][1];
	map[5][8] = map[3][0];

	map[3][0] = temp[2];
	map[3][1] = temp[1];
	map[3][2] = temp[0];
}
void Back() {
	char temp[3];
	temp[0] = map[4][0];
	temp[1] = map[4][1];
	temp[2] = map[4][2];

	map[4][0] = map[1][0];
	map[4][1] = map[1][1];
	map[4][2] = map[1][2];

	map[1][0] = map[5][0];
	map[1][1] = map[5][1];
	map[1][2] = map[5][2];

	map[5][0] = map[3][8];
	map[5][1] = map[3][7];
	map[5][2] = map[3][6];

	map[3][6] = temp[2];
	map[3][7] = temp[1];
	map[3][8] = temp[0];
}
void go(int action, int dir) {
	switch (action) {
	case FRONT:
		if (dir == LEFT) {
			goFront();
			goLeft(2);
		}
		else {
			for (int i = 0; i < 3; i++) {
				goFront();
				goLeft(2);
			}
		}
		break;
	case BACK:
		if (dir == LEFT) {
			for (int i = 0; i < 3; i++) {
				Back();
				goLeft(0);
			}
		}
		else {
			Back();
			goLeft(0);
		}
		break;
	case UP:
		if (dir == LEFT) {

		}
		else {

		}
		break;
	case DWON:
		if (dir == LEFT) {

		}
		else {

		}
		break;
	case LEFT:
		if (dir == LEFT) {

		}
		else {

		}
		break;
	case RIGHT:
		if (dir == LEFT) {

		}
		else {

		}
		break;
	}
}

int T, N;
int main(void) {
	scanf("%d", &T);
	while (T--) {
		scanf("%d", &N);
		init();
		for (int i = 0; i < N; i++) {





		}
	}
}