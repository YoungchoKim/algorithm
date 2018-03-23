#include <iostream>
#define max(a, b) ((a) > (b) ? (a) : (b))
int cnt[28];
int main(void) {
	char c;
	while (scanf("%c", &c) != EOF) {
		if (c >= 'a' && c <= 'z') {
			cnt[c - 'a']++;
		}
	}
	int max = 0;
	int resultCnt = 0;
	char result[26];
	for (int i = 0; i < 26; i++) {
		if (max < cnt[i]) {
			max = cnt[i];
			/*resultCnt = 1;
			result[0] = i + 'a';*/
		}
		/*else if (max == cnt[i]) {
			result[resultCnt++] = i + 'a';
		}*/
	}
	for (int i = 0; i < 26; i++) {
		if (max == cnt[i]) {
			printf("%c", i + 'a');
		}
	}
	printf("\n");
	/*result[resultCnt] = 0;
	printf("%s\n", result);*/

}