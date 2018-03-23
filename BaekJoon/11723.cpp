#include <iostream>
bool visited[21];
int main(void) {
	int N;
	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		char a, b, c;
		int num;
		scanf(" %c%c%c", &a, &b, &c);
		if (a == 'a'&& b == 'd'&&c == 'd') {
			scanf("%d", num);
			visited[num] = true;
		}
		else if (a == 'a'&& b == 'l'&&c == 'l') {
			for (int i = 0; i <= 20; i++) {
				visited[i] = true;
			}
		}
		else if (a == 'c'&& b == 'h'&&c == 'e') {
			scanf("%*c"); scanf("%*c");
			scanf("%d", num);
			if (visited[num]) {
				printf("1\n");
			}
			else { printf("0\n"); }
		}
		else if (a == 'e'&& b == 'm'&&c == 'p') {
			scanf("%*c"); scanf("%*c");
			for (int i = 0; i <= 20; i++) {
				visited[i] = false;
			}
		}
		else if (a == 't'&& b == 'o'&&c == 'g') {
			scanf("%*c"); scanf("%*c"); scanf("%*c");
			scanf("%d", num);
			visited[num] = !visited[num];
		}
		else if (a == 'r'&& b == 'e'&&c == 'm') {
			scanf("%*c"); scanf("%*c"); scanf("%*c");
			scanf("%d", num);
			visited[num] = false;
		}

	}
}