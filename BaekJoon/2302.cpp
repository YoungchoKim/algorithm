#include<cstdio>

int N;
int M;
bool arr[41];
int arr2[41][2];
int main() {
	scanf("%d %d", &N, &M);

	for (int i = 0; i < M; i++) {
		int j = 0;
		scanf(" %d", &j);
		arr[j] = true;
	}
	arr2[1][0] = 1;	//1까지의 총합
	arr2[1][1] = 1;	//1로 끝난 수의 갯수
	for (int i = 2; i <= N; i++) {
		if (arr[i] || arr[i-1]) {
			arr2[i][0] = arr2[i - 1][0];
			arr2[i][1] = arr2[i][0];
		}
		else {
			arr2[i][0] = arr2[i - 1][0] + arr2[i - 1][1];
			arr2[i][1] = arr2[i - 1][0];
		}

	}
	printf("%d\n", arr2[N][0]);

}