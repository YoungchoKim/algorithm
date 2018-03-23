#include <iostream>
#define QSIZE 1000000
struct _pair {
	int y;
	int x;
};
struct _queue {
	_pair arr[1000000];
	int front;
	int rear;

	void push(_pair a) {
		rear++;
		rear %= QSIZE;
		arr[rear] = a;
	}
	_pair pop() {
		front++;
		front %= QSIZE;
		return arr[front];
	}
	bool isEmpty() {
		return front == rear;
	}
};
char map[12][6];
bool visited[12][6];
void down() {
	for (int j = 0; j < 6; j++) {
		int k = 0;
		int i = 0;
		while (i < 12 && k < 12) {
			while (i < 12 && map[i][j] != '.') {
				i++;
			}
			k = i + 1;
			while (k < 12 && map[k][j] == '.') {
				k++;
			}
			if (i < 12 && k < 12) {
				map[i][j] = map[k][j];
				map[k][j] = '.';
				i++;
				k++;
			}

		}
	}
}
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
_queue q;
_queue q2;
bool bfs(int i, int j) {
	q.push({ i, j });
	q2.push({ i, j });
	visited[i][j] = true;
	int cnt = 1;
	while (!q.isEmpty()) {
		_pair p = q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = p.y + dy[i];
			int nx = p.x + dx[i];
			if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6
				|| map[ny][nx] != map[p.y][p.x] || visited[ny][nx]) {
				continue;
			}
			cnt++;
			visited[ny][nx] = true;
			q.push({ ny, nx });
			q2.push({ ny, nx });
		}

	}
	if (cnt >= 4) {
		while (!q2.isEmpty()) {
			_pair p = q2.pop();
			map[p.y][p.x] = '.';
			visited[p.y][p.x] = false;
		}
		return true;
	}
	else {
		while (!q2.isEmpty()) {
			_pair p = q2.pop();
			visited[p.y][p.x] = false;
		}
		return false;
	}


}
void printMap() {
		for (int i = 11; i >= 0; i--) {
	for (int j = 0; j < 6; j++) {
	printf("%c", map[i][j]);
	}printf("\n");
	}
}
int main(void) {
	for (int i = 11; i >= 0; i--) {
		for (int j = 0; j < 6; j++) {
			scanf("%c", map[i] + j);
		}
		scanf("%*c");
	}
	int cnt = 0;

	bool flag = false;
	do {
		flag = false;
		for (int j = 0; j < 6; j++) {
			for (int i = 0; i < 12; i++) {
				if (!visited[i][j] && map[i][j] != '.') {
					flag = bfs(i, j) || flag;
				}
			}
		}
		down();
		//printMap();
		if (flag) cnt++;
	} while (flag);
	
	printf("%d\n", cnt);
}
