#include <iostream>
#define min(a, b) ((a) < (b) ? (a) : (b))
char str1[2600];
char str2[2600];

//ÇÔ¼ö
int _strlen(char * str) {
	int cnt = 0;
	while (*str != '\n' && *str != 0) {
		str++;
		cnt++;
	}
	return cnt;
}
bool isSameStr(char *ptr1, char* ptr2, int size) {
	int cnt1[26] = { 0 };
	int cnt2[26] = { 0 };

	while (size--) {
		cnt1[*ptr1 - 'a']++;
		cnt2[*ptr2 - 'a']++;
		ptr1++;
		ptr2++;
	}
	for (int i = 0; i < 26; i++) {
		if (cnt1[i] != cnt2[i]) {
			return false;
		}
	}
	return true;
}
void makeHash(int size1, int size2) {
	for (int i = 1; i <= size1; i++) {
		for (int j = 0; j < i; j++) {

		}
	}
}
int main(void) {
	scanf("%s", str1);
	scanf("%s", str2);
	int size1 = _strlen(str1);
	int size2 = _strlen(str2);
	int min = 0;
	min = min(size1, size2);
	
	int ans = 0;
	int l = 0, r = min - 1;
	while (l <= r) {
		int mid = (l + 9*r) / 10;
		bool success = false;
		for (int i = 0; i <= size1 - 1 - mid; i++) {
			for (int j = 0; j <= size2 - 1 - mid; j++) {
				if (isSameStr(str1 + i, str2 + j, mid + 1)) {
					ans = mid + 1;
					l = mid + 1;
					success = true;
					break;
				}
			}
			if (success) {
				break;
			}
		}
		if (!success) {
			r = mid - 1;
		}
	}

	printf("%d\n",ans);
}





