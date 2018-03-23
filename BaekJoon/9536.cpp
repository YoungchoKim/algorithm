#include <stdio.h>

struct stack {
	char foxSay[10200];
	int top;

	void push(char a) {
		foxSay[top] = a;
		top++;
	}
};
struct Hash {
	char* value;
	struct Hash* next;
	~Hash() {
		delete(next);
	}
};
int makeHash(char* str);
char * checkInput(char *);
void copyArrays(char *dest, int start1, char* src, int start2, int length);
Hash hashTable[1000000];
char arr[10201];
stack st;
int main(void) {
	int N;
	char c;
	scanf("%d ", &N);
	while (N--) {
		fgets(arr, 10201, stdin);
		char cry[201];
		fgets(cry, 201, stdin);
		char *ptr;
		while (ptr = checkInput(cry)) {
			int hash = makeHash(ptr);
			if (hashTable[hash].value == 0) {
				hashTable[hash].value = ptr;
			}
			else {
				if (hashTable[hash].next == nullptr) {
					hashTable[hash].next = new Hash({ptr, nullptr});
				}
				else {
					Hash* temp = new Hash({ ptr, nullptr });
					temp->next = hashTable[hash].next;
					hashTable[hash].next = temp;
				}
			}
			fgets(cry, 201, stdin);
		}
		int j = 0;
		char tp[101];
		int i = 0;
		for (; arr[i] != 0 && arr[i] != '\n'; i++) {	//탐색시작
			if (arr[i] == ' ') {
				copyArrays(tp, 0, arr, j, i - j);
				int idx = makeHash(tp);
				if (hashTable[idx].value == 0) {
					for (int k = j; k < i; k++) {
						st.push(arr[k]);
					}
					st.push(' ');
				}
				j = i + 1;
			}
		}
		if (arr[i] == 0) {
			int idx = makeHash(tp);
			copyArrays(tp, 0, arr, j, i - j);
			if (hashTable[idx].value == 0) {
				for (int k = j; k < i; k++) {
					st.push(arr[k]);
					
				}
				st.push(' ');
			}
		}//탐색끝
		printf("%s\n", st.foxSay);
	}
}
void copyArrays(char *dest, int start1, char* src, int start2, int length) {
	int s1 = start1;
	for (int i = start2; i < start2 + length; i++) {
		dest[s1++] = src[i];
	}
	dest[s1] = 0;
}
int makeHash(char* str) {
	int hash = 1;
	for (int i = 0; str[i] != 0; i++) {
		hash += (hash * 31 + str[i])%1000000;
		hash %= 1000000;
	}
	return hash;
}
char* checkInput(char *ptr) {
	char *result = 0;
	while (*ptr != 0 && *ptr != ' ') {
		ptr++;
	}
	if (*ptr == 0) {
		return 0;
	}
	if (*ptr == ' ') {
		ptr++;
		if (ptr[0] != 'g' || ptr[1] != 'o' || ptr[2] != 'e' && ptr[3] != 's') {
			return 0;
		}
		ptr += 4;
		if (*ptr != ' ') {
			return 0;
		}
		ptr++;
		//울음소리 주소
		result = ptr;

		while (*ptr != 0 && *ptr != ' ' && *ptr != '\n') {
			ptr++;
		}
		if (*ptr == ' ') {
			return 0;
		}
		if (*ptr == 0 || *ptr == '\n') {
			*ptr = 0;
			return result;
		}
	}

	return 0;
}




