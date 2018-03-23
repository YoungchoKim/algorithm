#include <iostream>
struct _q {
	int action[10000];
	int front;
	int rear;

	void push(int a) {
		rear++;
		rear = rear % 10000;
		action[rear] = a;
	}
	int pop() {
		front++;
		front = front % 10000;
		return  action[front];
	}
	int peek() {
		int temp = (front + 1) % 10000;
		return action[temp];
	}
	bool isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}
};
int N;	//주차공간
int M;	//차량수

int parkingCost[101];
int parked[101];
int carWeight[2001];
long long sum;
_q actionQ;
_q watingQ;
int main(void) {
	scanf("%d %d", &N, &M);
	for (int i = 1; i <= N; i++) {
		scanf("%d", parkingCost + i);
	}
	for (int i = 1; i <= M; i++) {
		scanf("%d", carWeight + i);
	}
	for (int i = 1; i <= 2 * M; i++) {
		int action;
		scanf("%d", &action);
		actionQ.push(action);
	}

	while (!actionQ.isEmpty() || !watingQ.isEmpty()) {
		int i = 1;
		for (; i <= N; i++) {
			if (parked[i] == 0) {
				break;
			}
		}
		if (i == N + 1) {	//주차장 찬 경우
			while (actionQ.peek() > 0) {	//빼라는 명령 나올때까지 빼고
				watingQ.push(actionQ.pop());
			}
			int tp = actionQ.pop();			
			for (int j = 1; j <= N; j++) {	//그 차를 뺌
				if (parked[j] + tp == 0) {
					parked[j] = 0;
					break;
				}
			}
		}
		else {		//비어있는 경우
			//기다리는차가 있는경우 
			if (!watingQ.isEmpty()) {
				int p = watingQ.pop();
				parked[i] = p;
				sum += parkingCost[i] * carWeight[p];
			}
			
			else {	//없는경우
				if (actionQ.peek() > 0) {	//차가 들어올 경우 
					int tp = actionQ.pop();
					parked[i] = tp;
					sum += parkingCost[i] * carWeight[tp];
				}
				else {	//차가 빠질 경우
					int tp = actionQ.pop();
					for (int j = 1; j <= N; j++) {	//그 차를 뺌
						if (parked[j] + tp == 0) {
							parked[j] = 0;
							break;
						}
					}
				}

			}
		}
	}
	printf("%lld\n", sum);


}