#pragma optimize("", off)
#include <iostream>
struct _node {
	char v1;
	int v2;
};
struct _stack {
	int top;
	_node node[200];

	void push(_node a) {
		node[top++] = a;
	}
	_node pop() {
		top--;
		return node[top];
	}

	bool isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}
};
bool isNumber(char a) {
	if (a >= '0' && a <= '9') {
		return true;
	}
	return false;
}
bool isChar(char a) {
	if (a == 'H' || a == 'C' || a =='O') {
		return true;
	}
	return false;
}
int charToInt[26];
_stack st1, st2;
char arr[120];
int main(void) {
	scanf("%s", arr);
	charToInt['H' - 'A'] = 1;
	charToInt['C' - 'A'] = 12;
	charToInt['O' - 'A'] = 16;

	for (int i = 0; arr[i] != 0; i++) {
		st1.push({ arr[i], 0 });
		if (isNumber(arr[i])) {
			if (arr[i - 1] != ')') {
				st1.node[st1.top - 2].v2 = charToInt[st1.node[st1.top - 2].v1 - 'A'] * arr[i] - '0';
				st1.node[st1.top - 2].v1 = 0;
			}
		}
		int mul = 1;
		if (arr[i] == ')') {
			if (arr[i + 1] != 0 && isNumber(arr[i + 1])) {
				mul = arr[i + 1] - '0';
			}
			_node temp = st1.pop();
			while (temp.v1 != '(') {
				st2.push(temp);
				temp = st1.pop();
			}
			for (int j = 0; j < st2.top; j++) {
				if (isNumber(st2.node[j].v1)) {
					continue;
				}
				if (st2.node[j].v1 == '(' || st2.node[j].v1 == ')') {
					st2.node[j].v1 = 0;
					continue;
				}
				if (st2.node[j].v1 > 0) {
					st2.node[j].v2 += charToInt[(st2.node[j].v1 - 'A')] * mul;
					st2.node[j].v1 = 0;
				}
				else if (st2.node[j].v2 > 0) {
					st2.node[j].v2 *= mul;
				}
			}
			while (!st2.isEmpty()) {
				st1.push(st2.pop());
			}
		}
	}
	int sum = 0;
	for (int i = 0; i < st1.top; i++) {
		if (isChar(st1.node[i].v1)) {
			sum += charToInt[st1.node[i].v1 - 'A'];
			sum += st1.node[i].v2;
		}
		else if (isNumber(st1.node[i].v1)) {
			continue;
		}
		else if (st1.node[i].v2 > 0) {
			sum += st1.node[i].v2;
		}
	}
	printf("%d\n", sum);
}
