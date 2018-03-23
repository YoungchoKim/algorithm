#include <iostream>
#define max(a, b) ((a) > (b) ? (a) : (b))
int size1=1;
int size2=1;
char str1[5000];
char str2[5000];
int dp[5000][5000];
int result;
int main(void) {
	int ch;
	while ((ch = getchar()) != '\n') {
		str1[size1] = ch;
		size1++;
	}
	str1[size1] = 0;
	while ((ch = getchar()) != '\n') {
		str2[size2] = ch;
		size2++;
	}
	str2[size2] = 0;

	for (int i = 1; i < size1; i++) {
		for (int j = 1; j < size2; j++) {
			if (str1[i] == str2[j]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
				result = max(result, dp[i][j]);
			}
			else {
				dp[i][j] = 0;
			}
		}
	}
	printf("%d", result);
}