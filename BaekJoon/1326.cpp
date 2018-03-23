#include <iostream>
#include <queue>
struct _pair {
	int v;
	int cnt;
	_pair(int a, int b) {
		v = a;
		cnt = b;
	}
};
using namespace std;
int N;
int arr[10002];
int visited[10002];
queue<_pair> q;

int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i + 1);

	}
	int s, d;
	scanf("%d %d", &s, &d);
	if (s == d) {
		printf("1\n");
		return 0;
	}
	q.push({ s, 0 });
	while (!q.empty()) {
		_pair pair = q.front();
		q.pop();
		if (pair.v == d) {
			printf("%d", pair.cnt);
			return 0;
		}
		int i = 1;
		int nextI;
		while ((nextI = pair.v + arr[pair.v] * i) <= N) {
			if ( visited[nextI]> 0) {
				i++;
				continue;
			}
			q.push({ nextI, pair.cnt + 1 });
			visited[nextI] = pair.cnt + 1;	
			i++;
		}
		i = -1;
		while ((nextI = pair.v + arr[pair.v] * i) > 0) {
			if (visited[nextI]> 0) {
				i--;
				continue;
			}
			q.push({ nextI, pair.cnt + 1 });
			visited[nextI] = pair.cnt + 1;
			i--;
		}

	}
	printf("-1\n");



}