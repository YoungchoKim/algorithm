#include <iostream>
#define QSIZE 1000000
struct _pair {
	int y;
	int x;
};
struct _queue {
	_pair arr[QSIZE];
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
template <typename T>
struct _vector {
	T* arr;
	int size;
	int capacity;
	_vector() {
		capacity = 2;
		arr = new T[2];
	}
	void push(T a) {
		if (size == capacity) {
			capacity *= 2;
			T* temp = new T[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = arr[i];
			}
			delete arr;
			arr = temp;
		}
		arr[size++] = a;
	}
	void qsort(int l, int r) {
		int pivot = arr[(l + r) / 2];
		int i = l;
		int j = r;
		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (l < j) qsort(l, j);
		if (i < r) qsort(i, r);
	}
};
int visited[210][410];
int map[210][410];
int R, C;
int dx[] = {1, 0, -1, 0, 1, 1, -1, -1};
int dy[] = {0, 1, 0, -1, 1, -1, 1, -1};
char num[][5] = { "0000","0001","0010","0011","0100","0101","0110","0111","1000",
					"1001","1010","1011","1100","1101","1110","1111"};

_vector<char> v;
bool checkbdr(int y, int x) {
	if (x < 0 || x > C*4 || y < 0 || y > R) {
		return false;
	}
	return true;
}
void fill(int, int, int);
int bfs(int, int);
_queue q;
int main(void) {
	int T = 1;
	scanf("%d %d", &R, &C);
	while(R != 0 && C != 0) {
		int tr = 1, tc = 1;
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				char t;
				scanf("%c", &t);
				for (int i = 0; i < 4; i++) {
					if (t >= '0' && t <= '9') map[tr][tc++] = num[t - '0'][i] - '0';
					else if (t >= 'a' && t <= 'z') map[tr][tc++] = num[t - 'a' + 10][i] - '0';
				}
			}scanf("%*c");
			tr++;
			tc = 0;
		}

		q.push({ 0, 0 });
		visited[0][0] = -1;
		while (!q.isEmpty()) {
			_pair p = q.pop();
			for (int i = 0; i < 8; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (!checkbdr(ny, nx) || map[ny][nx] > 0 || visited[ny][nx] == -1) {
					continue;
				}
				visited[ny][nx] = -1;
				q.push({ ny, nx });
			}
		}
		int result = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 0; j <= C * 4; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					result = bfs(i, j);
					if (result == 0) v.push('W');
					else if (result == 1) v.push('A');
					else if (result == 2) v.push('K');
					else if (result == 3) v.push('J');
					else if (result == 4) v.push('S');
					else if (result == 5) v.push('D');
				}
			}
		}
	
		v.qsort(0, v.size - 1);
		printf("Case %d: ",T++);
		for (int i = 0; i < v.size; i++) {
			printf("%c", v.arr[i]);
		}printf("\n");
		for (int i = 0; i <= R; i++) {
			for (int j = 0; j <= C * 4; j++) {
				map[i][j] = 0;
				visited[i][j] = 0;
			}
		}
		v.size = 0;
		scanf("%d %d", &R, &C);
	}
}

int bfs(int y, int x) {
	_pair p = {y, x};
	q.front = q.rear;
	q.push(p);
	visited[y][x] = -1;
	int cnt = 0;
	while (!q.isEmpty()) {
		_pair pp = q.pop();
		for (int i = 0; i < 8; i++) {
			int ny = pp.y + dy[i];
			int nx = pp.x + dx[i];
			if (!checkbdr(ny, nx) || visited[ny][nx] == -1 || map[ny][nx] != 1) {
				continue;
			}
			if(map[ny][nx] == 1){
				visited[ny][nx] = -1;
				q.push({ ny, nx });
				for (int j = 0; j < 8; j++) {
					int nny = ny + dy[j];
					int nnx = nx + dx[j];
					if (!checkbdr(nny, nnx) || visited[nny][nnx] == -1) {
						continue;
					}
					if (map[nny][nnx] == 0 && visited[nny][nnx] == 0 ) {
					
						fill(nny, nnx, ++cnt);
					}

				}
			}
		}
	}
	return cnt;
}



void fill(int y, int x, int value) {
	if (!checkbdr(y, x) || visited[y][x] == -1 || visited[y][x] > 0|| map[y][x] == 1) {
		return;
	}
	visited[y][x] = value;
	for (int i = 0; i < 8; i++) {
		fill(y + dy[i], x + dx[i], value);
	}
}

