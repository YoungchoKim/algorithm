#include <iostream>
#define QSIZE 40001
struct _node {
	int dest;
	int weight;
};


struct _vector {
	int capacity;
	int size;
	_node* arr;
	_vector() {
		capacity = 100;
		size = 0;
		arr = new _node[100];
	}
	~_vector() {
		free(arr);
	}
	void push(_node a) {
		if (size == capacity) {
			capacity *= 2;
			arr = (_node *)realloc(arr, sizeof(_node) * capacity);
		}
		arr[size++] = a;
	}
};
struct _queue {
	int front;
	int rear;
	_node arr[QSIZE];
	void push(_node a) {
		rear++;
		rear = rear % QSIZE;
		arr[rear] = a;
	}
	_node pop() {
		front++;
		front = front % QSIZE;
		return arr[front];
	}
	bool isEmpty() {
		if (front == rear) {
			return true;
		}
		return false;
	}
};

_vector v[40001];
int N;
int M;
bool visited[40001];
int level[40001];
int parent[40001];
int weight[40001];
_queue q;
int main(void) {
	scanf("%d", &N);
	int start;
	for (int i = 0; i < N - 1; i++) {
		int a, b, c;
		scanf("%d %d %d", &a, &b, &c);
		v[a].push({ b, c });
		v[b].push({ a, c });
		start = a;
	}
	//bfs를 돌려서 각 정보를 가져옴.
	for (int i = 0; i < v[start].size; i++) {
		q.push(v[start].arr[i]);
		visited[v[start].arr[i].dest] = true;
		level[v[start].arr[i].dest] = 1;
		parent[v[start].arr[i].dest] = start;
		weight[v[start].arr[i].dest] = v[start].arr[i].weight;
	}

	while (!q.isEmpty()) {
		_node temp= q.pop();
		for (int i = 0; i < v[temp.dest].size; i++) {
			if (!visited[v[temp.dest].arr[i].dest]) {
				visited[v[temp.dest].arr[i].dest] = true;
				q.push(v[temp.dest].arr[i]);
				level[v[temp.dest].arr[i].dest] = level[temp.dest] + 1;
				parent[v[temp.dest].arr[i].dest] = temp.dest;
				weight[v[temp.dest].arr[i].dest] = v[temp.dest].arr[i].weight;
			}
		}
	}

	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		int a, b;
		scanf("%d %d", &a, &b);

		int levelA = level[a];
		int levelB = level[b];
		long long sum = 0;
		while (levelA != levelB) {
			if (levelA > levelB) {
				
				sum += weight[a];
				a = parent[a];
				levelA--;
			}
			else {
			
				sum += weight[b];
				b = parent[b];
				levelB--;
				
			}
		}
		while (a != b) {
			
			sum += weight[a];
			sum += weight[b];
			a = parent[a];
			b = parent[b];
		}
		printf("%lld\n", sum);
	}
}