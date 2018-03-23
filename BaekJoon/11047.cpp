#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#define min(a, b) (a) < (b) ? (a) : (b)

typedef struct node {
	int num;
	int cnt;
}node;

node* q[1000000];
int front, rear;
node pop() {

	return *(q[front++]);
}
void push(node* n) {
	q[rear++] = n;
}
bool isEmpty() {
	if (front >= rear) {
		return true;
	}
	else
		return false;
}


int main(void) {
	int n, num;
	
	scanf("%d %d", &n, &num);

	for (int i = 0; i < n; i++) {
		
		
	}
	
	
	while (!isEmpty()) {
		printf("%d\n", pop().num);
	}
	
}