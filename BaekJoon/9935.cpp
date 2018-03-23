#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string.h>
char str[1000001];
char str2[37];
typedef struct _stack {
	char stack[1000001];
	int top;
	
	void push(char c) {
		stack[top] = c;
		top++;
	}
	char pop() {
		top--;
		return stack[top];
	}
	bool isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}
}_stack;
_stack st1;
int main(void) {

	st1.top = 0;

	scanf(" %s", str);
	scanf(" %s", str2);
	int size = 0;
	while (str2[size] != '\0') {
		size++;
	}
	int idx = 0;
	while (str[idx] != '\0') {
		st1.push(str[idx]);
		if (st1.top >= size) {
			int i = 0;
			for (; i < size; i++) {
				if (str2[size - 1 - i] != st1.stack[st1.top - 1 - i]) {
					break;
				}
			}
			if (i == size) {
				while (i--) {
					st1.pop();
				}
			}
		}
		idx++;
	}
	if (st1.isEmpty()) {
		printf("FRULA\n");
	}
	else {
		st1.push('\0');
		printf("%s", st1.stack);
	}
}
