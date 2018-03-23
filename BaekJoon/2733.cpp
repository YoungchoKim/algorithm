#include <iostream>
struct _stack {
	int top;
	int str[130000];
	void push(int a) {
		str[top++] = a;
	}
	int pop() {
		top--;
		return str[top];
	}
	bool isEmpty() {
		return top == 0;
	}
};
int T;
char str[130000];
char arr[32777];
int saveIndex[130000];

int size;
int left, right;
int ptr;
_stack st;
int main(void) {
	scanf("%d", &T);
	for(int t = 1; t <= T; t++) {
		printf("PROGRAM #%d:\n", t);
		scanf("%*c");
		for (int i = 0; i < size; i++) {	//초기화 작업.
			saveIndex[i] = 0;
		}
		for (int i = 0; i < 32777; i++) {
			arr[i] = 0;
		}
		size = 0;
		left = 0, right = 0;

		while (true) {
			char c = getchar();
			if (c == 'e') {
				c = getchar();
				if (c == 'n') {
					c = getchar();
					if (c == 'd') {
						break;
					}
				}
			}
			if (c == '%') {
				while (c != '\n') {
					c = getchar();
				}
			}
			if (c == '[') {
				left++;
				st.push(size);
			}
			else if (c == ']') {
				right++;
				if (!st.isEmpty()) {
					int a = st.pop();
					saveIndex[size] = a;
					saveIndex[a] = size;
				}
			}
			str[size++] = c;
		}

		////////////////////// 입력 끝
		if (left != right) {	//실패처리 괄호짝 안맞을경우
			printf("COMPILE ERROR\n");
			continue;
		}
		ptr = 0;
		/*printf("%d %d", saveIndex[111], saveIndex[103]);
		printf("\nsize: %d\n", size);*/
		for (int i = 0; i < size; i++) {
			switch (str[i]) {
			case '+':
				if (arr[ptr] == 255) {
					arr[ptr] = 0;
				}
				else {
					arr[ptr]++;
				}
				break;
			case '-':
				if (arr[ptr] == 0) {
					arr[ptr] = 255;
				}
				else {
					arr[ptr]--;
				}
				break;
			case '>':
				ptr++;
				if (ptr == 32768) {
					ptr = 0;
				}
				break;
			case '<':
				ptr--;
				if (ptr == -1) {
					ptr = 32767;
				}
				break;
			case '[':
				if (arr[ptr] == 0) {
					i = saveIndex[i] - 1;
				}
				break;
			case ']':
				if (arr[ptr] != 0) {
					i = saveIndex[i] - 1;
				}
				break;
			case '.':
				printf("%c", arr[ptr]);
				break;

			default:
				break;
			}
		}
		printf("\n");


	}
}