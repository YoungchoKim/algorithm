#include <iostream>

char arr[101];
int _strlen(char *);
int main(void) {
	scanf("%s", arr);
	int n = _strlen(arr);
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		switch (arr[i]) {
		case 'c':
			cnt++;
			if (arr[i + 1] == '=' || arr[i + 1] == '-') {
				i++;
			}
			break;
		case 'd':
			cnt++;
			if (arr[i + 1] == '-') {
				i++;
			}
			else if (i + 2 < n && arr[i + 1] == 'z' && arr[i + 2] == '=') {
				i++;
				i++;
			}
			break;
		case 'l':
		case 'n':
			cnt++;
			if (arr[i + 1] == 'j') {
				i++;
			}
			break;

		case 's':
		case 'z':
			cnt++;
			if (arr[i + 1] == '=') {
				i++;
			}
			break;
		default:
			cnt++;
		}
	}
	printf("%d\n", cnt);
}

int _strlen(char *arr) {
	int cnt = 0;
	while (*arr != 0) {
		arr++;
		cnt++;
	}
	return cnt;
}