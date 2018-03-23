#include <stdio.h>

typedef struct topNi {
	int index;
	int topNal[8];
}toNi;

bool visited[4];
topNi tp[4];


void check(int, int, int *);

int main() {

	

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 8; j++) {
			scanf("%1d", &(tp[i].topNal[j]));
		}
	}

	int N = 0;
	scanf("%d", &N);

	
	for (int i = 0; i < N; i++) {
		int copy[4] = { 0 };
		int index = 0, dir = 0;
		scanf("%d %d", &index, &dir);

		check(dir, index -1, copy);
		for (int j = 0; j < 4; j++) {
			tp[j].index = (tp[j].index + copy[j] + 8) % 8;
		}
		

	}
	int v = 1;
	int sum = 0;
	for (int i = 0; i < 4; i++) {
		int idx = tp[i].index;
		sum = sum +  tp[i].topNal[idx]* v;

		v = v * 2;
	}
	printf("%d\n", sum);

}
void check(int dir, int tIndex, int* copy) {
	if (dir == 1) {
		copy[tIndex] = -1;
	}
	else {
		copy[tIndex] = 1;
	}
	visited[tIndex] = true;

	if (tIndex - 1 >= 0 && !visited[tIndex - 1]) {	//왼쪽 가능하면
		int index1 = (tp[tIndex].index + 6) % 8;
		int index2 = (tp[tIndex - 1].index + 2) % 8;
		if ( tp[tIndex].topNal[index1] != tp[tIndex - 1].topNal[index2]) {
			if (dir == 1) {
				check(-1, tIndex - 1, copy);
			}
			else {
				check(1, tIndex - 1, copy);
			}
		}
	}

	if (tIndex + 1 < 4 && !visited[tIndex + 1]) {	//오른쪽 가능하면
		int index1 = (tp[tIndex].index + 2) % 8;
		int index2 = (tp[tIndex + 1].index + 6) % 8;
		if (tp[tIndex].topNal[index1] != tp[tIndex + 1].topNal[index2]) {
			if (dir == 1) {
				check(-1, tIndex + 1, copy);
			}
			else {
				check(1, tIndex + 1, copy);
			}
		}
	}



	visited[tIndex] = false;

}