#include <iostream>
int N1, N2;
char arr[1000000];
char arr2[1000000];
int team[256];
void go(int start, int end, char *arr, int cnt, int total, bool startFlag, bool endFlag);
void swap(char *a, char* b) {
	char temp = *a;
	*a = *b;
	*b = temp;
}
int main(void) {
	scanf("%d %d", &N1, &N2);
	scanf("%s", arr);
	scanf("%s", arr + N1);

	for (int i = 0; i < N1; i++) {
		arr2[i] = arr[N1 - i - 1];
		team[arr2[i]] = 1;
	}
	for (int i = N1; i < N1 + N2; i++) {
		arr2[i] = arr[i];
		team[arr2[i]] = 2;
	}
	int t;
	scanf("%d", &t);
	for (int j = 0; j < t; j++) {
		for (int i = 0; i < N1 + N2 - 1; i++) {
			if (team[arr2[i]] != team[arr2[i + 1]] && team[arr2[i]] < team[arr2[i + 1]]) {
				swap(arr2 + i, arr2 + i + 1);
				i++;
			}
		}
	}
	printf("%s\n", arr2);
}
