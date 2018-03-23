#include <iostream>
#define QSIZE 1000001
struct _queue{
	int front;
	int rear;
	int arr[QSIZE];
	void push(int a) {
		rear++;
		rear %= QSIZE;
		arr[rear] = a;
	}
	int pop() {
		front++;
		front %= QSIZE;
		return arr[front];
	}
	bool isEmpty() {
		return front == rear;
	}
};
bool E[1001][1001];
bool V[1001];
_queue q;
_queue result;
int N, M, S;
void dfs(int a, int b);
int main(void) {
	scanf("%d %d %d", &N, &M, &S);
	for (int i = 0; i < M; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		E[a][b] = true;
		E[b][a] = true;

	}
	///////////////////dfs
	dfs(0, S);
	while (!result.isEmpty()) {
		printf("%d ", result.pop());
	}printf("\n");
	for (int i = 0; i <= N; i++) {
		V[i] = false;
	}

	//////////////////bfs
	q.push(S);
	V[S] = true;
	while (!q.isEmpty()) {
		int t = q.pop();
		result.push(t);
		for (int i = 0; i <= N; i++) {
			if (E[t][i] && !V[i]) {
				V[i] = true;
				q.push(i);
			}
		}
	}
	while (!result.isEmpty()) {
		printf("%d ", result.pop());
	}

}
void dfs(int a, int b) {
	V[b] = true;
	result.push(b);
	for (int i = 0; i <= N; i++) {
		if (E[b][i] && !V[i]) {
			V[i] = true;
			dfs(b, i);
		}
	}
}