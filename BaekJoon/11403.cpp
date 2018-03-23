#include <iostream>
#include <queue>
using namespace std;
int N;
bool E[101][101];
queue<int> q;
bool visited[101][101];
void bfs(int s, int d);
int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int a;
			scanf("%d", &a);
			E[i][j] = a;
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j]) {
				bfs(i, j);
			}
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j])
				printf("1 ");
			else
				printf("0 ");
		}printf("\n");
	}
}
void bfs(int s, int d) {
	q.push(s);
	while (!q.empty()) {
		int p = q.front();
		q.pop();
		for (int i = 0; i < N; i++) {
			if (E[p][i] && !visited[s][i]) {
				visited[s][i] = true;
				q.push(i);
			}
		}
	}
}