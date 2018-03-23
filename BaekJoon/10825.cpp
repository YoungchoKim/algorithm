#include <iostream>
struct student {
	char name[11];
	int k;
	int e;
	int m;
};
int _strcmp(char *str1,char  *str2) {
	while (*str1 != 0 && *str2 != 0 && *str1 == *str2) {
		str1++;
		str2++;
	}
	return *str1 - *str2;
}
int _compare(student st1, student st2) {
	if (st1.k > st2.k) {
		return 1;
	}
	else if (st1.k < st2.k) {
		return -1;
	}
	else {
		if (st1.e < st2.e) {
			return 1;
		}
		else if (st1.e > st2.e) {
			return -1;
		}
		else {
			if (st1.m > st2.m) {
				return 1;
			}
			else if(st1.m < st2.m){
				return -1;
			}
			else {
				return _strcmp(st1.name, st2.name) * -1;
			}
		}
	}
}


student st[100001];
int N;
void _qsort(int l, int r) {
	student pivot = st[(l + r) / 2];
	int i = l;
	int j = r;

	while (i <= j) {
		while (_compare(st[i], pivot) > 0)i++;
		while (_compare(st[j], pivot) < 0) j--;
		if (i <= j) {
			student temp = st[i];
			st[i] = st[j];
			st[j] = temp;
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
		scanf(" %s %d %d %d", st[i].name, &st[i].k, &st[i].e, &st[i].m);
		
	}
	_qsort(0, N - 1);
	for (int i = 0; i < N; i++) {
		printf("%s\n", st[i].name);
	}

}
