#include <iostream>
int N;
struct user {
	int age;
	char name[101];
	int i;
};
user u[100001];
int _strcmp(char* str1, char* str2) {
	while (*str1 != 0 && *str2 != 0 && *str1 == *str2) {
		str1++;
		str2++;
	}
	return *str1 - *str2;
}
int compare(user u1, user u2) {
	if (u1.age < u2.age) {
		return 1;
	}
	else if (u1.age > u2.age) {
		return -1;
	}
	else {
		return u2.i - u1.i;
	}
}

void _qsort(int l, int r) {
	user pivot = u[(l + r) / 2];
	int i = l;
	int j = r;
	while (i <= j) {
		while (compare(u[i], pivot) > 0) i++;
		while (compare(u[j], pivot) < 0)j--;
		if (i <= j) {
			user temp = u[i];
			u[i] = u[j];
			u[j] = temp;
			i++;
			j--;
		}
	}
	if (l < j) _qsort(l, j);
	if (i < r) _qsort(i, r);
}
int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d %s", &u[i].age, u[i].name);
		u[i].i = i;
	}
	_qsort(0, N - 1);
	for (int i = 0; i < N; i++) {
		printf("%d %s\n", u[i].age, u[i].name);
	}

}