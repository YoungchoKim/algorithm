#include <iostream>
struct _queue {
	int arr[50002];
	int front;
	int rear;
	void push(int a) {
		front++;
		front = front % 50002;
		arr[front] = a;
	}
	int pop() {
		rear++;
		rear = rear % 50002;
		return arr[rear];
	}
	bool isEmpty() {
		return front == rear;
	}
};
int N, M;
_queue q, q2;

int main(void) {
	scanf("%d %d", &N, &M);
	for (int i = 1; i <= N; i++) {
		q.push(i);
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M - 1; j++) {
			q.push(q.pop());
		}
		q2.push(q.pop());
	}
	printf("<%d", q2.pop());
	while (!q2.isEmpty()) {
		printf(", %d", q2.pop());
	}printf(">");
}