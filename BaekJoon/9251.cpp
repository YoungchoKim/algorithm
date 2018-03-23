/**
strlen 은 string.h 필요... 이걸 쓰지 않아 백준에서 에러.


**/
#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <string.h>
#define Max(a, b) (a) > (b) ? (a) : (b)
int dp[1001][1001];
char str1[1002];
char str2[1002];
int main() {
	scanf("%s %s", str1 + 1, str2 + 1);
	str1[0] = ' ';
	str2[0] = ' ';
	int size1 = strlen(str1);
	int size2 = strlen(str2);
	for (int i = 1; i < size1; i++) {
		for (int j = 1; j < size2; j++) {
			if (str1[i] == str2[j]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			else {
				dp[i][j] = Max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}
	printf("%d\n", dp[size1 - 1][size2 - 1]);
}