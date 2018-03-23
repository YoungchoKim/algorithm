#include <iostream>
struct stack {
	int p[300001];
	int top;

	void push(int a) {
		p[top] = a;
		top++;
	}
	int pop() {
		top--;
		return p[top];
	}
	int peek() {
		if (top - 1 >= 0) {
			return p[top - 1];
		}
		return -1;
	}
	bool isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}
};
int N, P;
stack st[7];
int main(void) {
	scanf("%d %d", &N, &P);

	int a, b;
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d %d", &a, &b);
		if (st[a].isEmpty()) {
			st[a].push(b);
			cnt++;
			continue;
		}
		if (st[a].peek() > b) {
			while (!st[a].isEmpty() && st[a].peek()> b) {
				st[a].pop();
				cnt++;
			}
			if (st[a].isEmpty()) {
				st[a].push(b);
				cnt++;
				continue;
			}
			if (st[a].peek() == b) {
				continue;
			}
			else {
				st[a].push(b);
				cnt++;
				continue;
			}
		}
		else if (st[a].peek() == b) {
			continue;
		}
		else {
			st[a].push(b);
			cnt++;
			continue;
		}
	}
	printf("%d\n", cnt);


}