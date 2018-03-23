#include <iostream>
#define QSIZE 20001;	
struct _pair {
	int n;
	int p;
};
struct _queue {
	_pair arr[20001];
	int front;
	int rear;

	void push(_pair a) {
		rear++;
		rear %= QSIZE;
		arr[rear] = a;
	}
	int getSize() {
		return front - rear;
	}
	_pair pop() {
		front++;
		front %= QSIZE;
		return arr[front];
	}
	bool isEmpty() {
		return front == rear;
	}

};
_queue q;
int main(void) {
	int T;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		int n, go;
		scanf("%d %d", &n, &go);
		for (int i = 0; i < n; i++) {
			int t;
			scanf("%d", &t);
			q.push({ i, t });
		}
		int cnt = 0;
		_pair temp;
		bool success = true;
		do {
			temp = q.pop();
			success = true;
			int idx = q.front + 1;
			for (int i = q.front + 1; i <= q.rear + 1; i++) {
				if (temp.p < q.arr[i].p) {
					success = false;
					break;
				}
			}
			
			if (!success) q.push(temp);
			else  cnt++;
			
		} while (!q.isEmpty() && !(temp.n == go && success));

		printf("%d\n", cnt);
		q.front = q.rear;
	}
}