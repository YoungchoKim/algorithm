#include <iostream>
#define min(a, b) ((a) < (b) ? (a) : (b))
char cmp1[100];
char cmp2[100];
int R, C;
char map[51][51];
int main(void) {
	scanf("%d %d", &R, &C);
	
	for (int r = 0; r < R; r++) {
		scanf("%*c");
		for (int c = 0; c < C; c++) {
			scanf("%c", map[r] + c);
		}
	}
	int result = 123456789;
	for (int i = 0; i < R; i++) {		//비교할값 전처리
		for (int j = 0; j < C; j++) {
			if ((i + j) % 2 == 0) {
				cmp1[i + j] = 'W';
				cmp2[i + j] = 'B';
			}
			else {
				cmp1[i + j] = 'B';
				cmp2[i + j] = 'W';
			}
		}
	}
	for (int r = 0; r < R - 8 + 1; r++) {
		for (int c = 0; c < C - 8 + 1; c++) {
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = r; i < r + 8; i++) {
				for (int j = c; j < c + 8; j++) {
					
					if (map[i][j] != cmp1[i + j]) {
						cnt1++;
					}
					if (map[i][j] != cmp2[i + j]) {
						cnt2++;
					}
				}
			}
			result = min(result, min(cnt1, cnt2));
		}
	}

	printf("%d", result);

}