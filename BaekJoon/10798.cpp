#include <iostream>
char str[5][16];
int main(void) {
	int T = 0;
	while (T < 5) {
		scanf("%s", str[T]);
		T++;
	}

	for (int i = 0; i < 16; i++) {
		for (int j = 0; j < 5; j++) {
			if (str[j][i] == 0) continue;
			printf("%c", str[j][i]);
		}
	}

}