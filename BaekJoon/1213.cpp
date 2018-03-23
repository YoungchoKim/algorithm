#include <iostream>
int cnt[27];
int main(void) {
	char arr[100];

	scanf("%s", arr);

	for (int i = 0; arr[i] != 0; i++) {
		cnt[arr[i] - 'A']++;
	}
	int result = 0;
	char temp;
	for (int i = 0; i < 27; i++) {
		if (cnt[i] % 2) {
			temp = i + 'A';
			result++;
		}
	}
	if (result > 1) {
		printf("I'm Sorry Hansoo\n");
		return 0;
	}
	char r[51];
	int idx = 0;
	for (int i = 0; i < 26; i++) {
		for (int j = 0; j < cnt[i] / 2; j++) {
			r[idx++] = i + 'A';
		}
	}
	if (result == 1) {
		r[idx++] = temp;
	}
	for (int i = 25; i >= 0; i--) {
		for (int j = 0; j < cnt[i] / 2; j++) {
			r[idx++] = i + 'A';
		}
	}
	r[idx] = 0;
	printf("%s", r);
}