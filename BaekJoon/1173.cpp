#include <iostream>
#include <queue>
using namespace std;
struct _pair {
	int heart;
	int exTime;
	int time;
};

int N, m, M, T, R;
queue<_pair> q;
int main(void) {
	scanf("%d %d %d %d %d", &N, &m, &M, &T, &R);

	int curHeart = m;
	int exTime = 0;
	int time = 0;
	while (true) {
		if (exTime == N) {
			printf("%d", time);
			return 0;
		}
		if (curHeart + T <= M) {
			curHeart += T;
			exTime++;
		}
		else if (curHeart > m) {
			curHeart -= R;
			if (curHeart < m) {
				curHeart = m;
			}
		}
		else {
			printf("-1\n");
			return 0;
		}
		time++;
	}

}