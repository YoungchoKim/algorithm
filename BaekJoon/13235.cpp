#include <iostream>
char str[30];
bool check(int, int);

int main(void) {
	char c;
	int size = 0;
	while ((c = getchar()) != '\n' && c != EOF) str[size++] = c;
	if (check(0, size - 1)) {
		printf("true");
	}
	else {
		printf("false");
	}

}
bool check(int start, int end) {
	if (start == end || start > end) {
		return true;
	}

	if (str[start] == str[end] && check(start +1, end -1)) {
		return true;
	}
	return false;
}
