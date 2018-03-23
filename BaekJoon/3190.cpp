#include <iostream>
#define max(a,b) ((a) > (b) ? (a) : (b))
#define min(a, b) ((a) < (b) ? (a) : (b))
struct _pair {
	bool isApple;
	int dir;
	int y;
	int x;
};
int dx[] = {1, 0, -1, 0};	//µ¿ ³² ¼­ ºÏ
int dy[] = {0, 1, 0, -1};
int N, K;
_pair map[101][101];
int dir = 0;
_pair head, tail;
bool checkYX(int y, int x) {
	return (min(y, x) >= 1 && max(y, x) <= N);
}
bool move() {
	head.y += dy[dir];
	head.x += dx[dir];
	if (checkYX(head.y, head.x)) {
		if (map[head.y][head.x].dir >= 0) {	//¸öÃ¼ÀÏ °æ¿ì
			return false;
		}

		map[head.y][head.x].dir = dir;
		
		if (map[head.y][head.x].isApple) {	//»ç°úÀÏ °æ¿ì
			map[head.y][head.x].isApple = false;
			
		}
		else {					//°Á ÀÌµ¿
			int yy = tail.y;
			int xx = tail.x;
			int d = map[yy][xx].dir;
			tail.y += dy[d];
			tail.x += dx[d];
			map[yy][xx].dir = -1;
		}
		return true;
	}
	else {
		return false;
	}
}
void print() {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			printf("%2d ", map[i][j].dir);
		}printf("\n");
	}printf("\n");
}
int main(void) {
	for (int i = 0; i < 101; i++) {
		for (int j = 0; j < 101; j++) {
			map[i][j].dir = -1;
		}
	}

	scanf("%d %d", &N, &K);
	for (int i = 0; i < K; i++) {
		int r, c;
		scanf("%d %d", &r, &c);
		map[r][c].isApple = true;
	}
	
	map[1][1].dir = 0;
	head.y = 1;
	head.x = 1;
	tail.y = 1;
	tail.x = 1;

	int L;
	scanf("%d", &L);
	int temp = 0;
	//¿À¸¥ + 1, ¿Ş -1
	int s;
	char a;
	for (int i = 0; i < L; i++) {
		scanf("%d %c", &s, &a);
		for (int j = 0; j < s - temp; j++) {
			if (!move()) {
				//print();
				printf("%d\n", temp + j + 1);
				return 0;
			}
			//print();
		}
		if (a == 'D') {
			dir = (dir + 1) % 4;
			map[head.y][head.x].dir = dir;
		}
		else {
			dir = (dir + 3) % 4;
			map[head.y][head.x].dir = dir;
		}
		temp = s;
	}
	do {
		s++;
	} while (move());
	
	printf("%d\n", s);

}
