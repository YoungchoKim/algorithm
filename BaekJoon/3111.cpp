#include <iostream>
struct _stack {
	int top;
	char arr[300001];

	void push(char a) {
		arr[top++] = a;
	}
	char pop() {
		top--;
		return arr[top];
	}

	bool isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}
};





_stack left, right;
char arr1[300001];
char arr2[26];
int main(void) {
	scanf("%s %s", arr2, arr1);
	int size1 = 0, size2 = 0;
	for (int i = 0; arr1 != 0; i++) {
		size1++;
	}	
	for (int i = 0; arr2 != 0; i++) {
		size2++;
	}

	int pl = 0, pr = size1 - 1;

	while (true) {
		bool success = false;
		while (pl < pr) {
			left.push(pl);
			pl++;
			if (pl < size2 - 1) {
				continue;
			}
			int idx = 0;
			for (int i = left.top - size2; i < left.top; i++) {
				if (left.arr[i] != arr2[idx++]) {
					break;
				}
			}
			if (idx == size2) {
				success = true;
				int temp = size2;
				while (temp--) {
					left.pop();
				}
				//성공
				break;
			}
		}
		if (pl == pr) {	// 오른쪽 스택을 왼쪽 스택에 넣어가며 성공할수 있는지 확인

		}

		if (!success) {
			break;
		}
		while (pl < pr) {
			right.push(pr);
			pr--;
			if (size1 - 1 -pr < size2 - 1) {
				continue;
			}
		}
	}
}
