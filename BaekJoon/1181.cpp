#include <iostream>
#include<string.h>
int N;
char arr[20001][60];
void _qsort(int, int);
int _strcmp(char *, char*);
void _strcpy(char*, char*);
bool hashTable[1000000];
int getHash(char *str) {
	int hash = 0;
	for (int i = 0; str[i] != 0; i++) {
		hash = ((((hash % 1000000) * 31) % 1000000) + str[i] - 'a') % 1000000;
	}
	return hash;
}

int main(void) {
	scanf("%d ", &N);
	for (int i = 0; i < N; i++) {
		scanf("%s", arr + i);
	}
	_qsort(0, N - 1);
	for (int i = 0; i < N; i++) {
		if (i > 0 && strcmp(arr[i - 1], arr[i]) == 0) {
			continue;
		}
		printf("%s\n", arr[i]);
	}
}

int compare(char* a, char* b) {
	int size1 = strlen(a);
	int size2 = strlen(b);
	if (size1 < size2) {
		return -1;
	}
	else if (size1 > size2) {
		return 1;
	}
	else {
		return strcmp(a, b);
	}
	
}
int strlen(char *str) {
	int i = 0;
	for (; str[i] != 0 && str[i] != '\n'; i++) {

	}
	return i;
}
void _qsort(int l, int r) {
	char pivot[60];
	_strcpy(pivot,arr[(l + r) / 2]);
	int i = l;
	int j = r;
	while (i <= j) {
		while (compare(arr[i], pivot) < 0) i++;
		while (compare(arr[j], pivot) > 0) j--;
		if (i <= j) {
			char temp[60];
			_strcpy(temp, arr[i]);
			_strcpy(arr[i], arr[j]);
			_strcpy(arr[j], temp);
			i++;
			j--;
		}
	}

	if (l < j) _qsort(l, j);
	if (i < r) _qsort(i, r);
}

int _strcmp(char* str1, char* str2) {
	while (*str1 != 0 && *str2 != 0 && *str1 == *str2) {
		str1++;
		str2++;
	}
	return *str1 - *str2;
}

void _strcpy(char* dest, char* src) {
	while (*src != 0) {
		*dest = *src;
		dest++;
		src++;
	}
	*dest = 0;
}