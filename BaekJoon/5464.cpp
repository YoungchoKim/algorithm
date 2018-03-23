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
int N;	//��������
int M;	//������

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
		if (i == N + 1) {	//������ �� ���
			while (actionQ.peek() > 0) {	//����� ��� ���ö����� ����
				watingQ.push(actionQ.pop());
			}
			int tp = actionQ.pop();			
			for (int j = 1; j <= N; j++) {	//�� ���� ��
				if (parked[j] + tp == 0) {
					parked[j] = 0;
					break;
				}
			}
		}
		else {		//����ִ� ���
			//��ٸ������� �ִ°�� 
			if (!watingQ.isEmpty()) {
				int p = watingQ.pop();
				parked[i] = p;
				sum += parkingCost[i] * carWeight[p];
			}
			
			else {	//���°��
				if (actionQ.peek() > 0) {	//���� ���� ��� 
					int tp = actionQ.pop();
					parked[i] = tp;
					sum += parkingCost[i] * carWeight[tp];
				}
				else {	//���� ���� ���
					int tp = actionQ.pop();
					for (int j = 1; j <= N; j++) {	//�� ���� ��
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