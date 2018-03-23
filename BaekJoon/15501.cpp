#include <iostream>
using namespace std;
struct _node {
	int v;
	_node* next;
	_node* prev;
};
_node node[3000001];
int nodeSize;
_node* getNode() {
	return node + nodeSize++;
}
_node* head1;
_node* head2;
bool check[1000001];
int main(void) {
	std::ios::sync_with_stdio(false);
	head1 = getNode();
	head1->next = head1;
	head1->prev = head1;
	head1->v = -1;

	head2 = getNode();
	head2->next = head2;
	head2->prev = head2;
	head2->v = -1;



	int N;
	cin>>N;
	_node* ptr = head1;;
	for (int i = 0; i < N; i++) {		//수열 1
		int n; cin >> n;
		check[n] = true;
		_node* temp = getNode();
		temp->v = n;
		temp->next = ptr->next;
		temp->prev = ptr;
		ptr->next->prev = temp;
		ptr->next = temp;
		ptr = ptr->next;
	}

	ptr = head2;
	bool flag = false;
	for (int i = 0; i < N; ++i) {	//수열 2
		int n; cin >> n;
		if (!check[n]) {	//틀리시..
			printf("bad puzzle");
			return 0;
		}
		_node* temp = getNode();
		temp->v = n;
		temp->next = ptr->next;
		temp->prev = ptr;
		ptr->next->prev = temp;
		ptr->next = temp;
		ptr = ptr->next;
	}

	ptr = head2;
	for (; ptr->next->v != head1->next->v; ) {	//수열의 앞 대가리 맞춤
		_node* temp = ptr->next;
		ptr->next->next->prev = ptr;
		ptr->next = ptr->next->next;
		
		
		temp->next = head2;
		temp->prev = head2->prev;
		head2->prev->next = temp;
		head2->prev = temp;
	}

	_node* ptr1 = head1;
	_node* ptr2 = head2;
	for (; ptr1->next->v != -1; ptr1 = ptr1->next) {	//두 수열이 같은지 검사
		if (ptr1->next->v != ptr2->next->v) break;
		ptr2 = ptr2->next;
	}

	if (ptr1->next->v == -1 && ptr2->next->v == -1) {
		printf("good puzzle\n");
		return 0;
	}




	ptr = head2;
	while (ptr->next->v != head1->prev->v) {	//수열의 앞과 뒷대가리 맞춤
		_node* temp = ptr->next;
		ptr->next->next->prev = ptr;
		ptr->next = ptr->next->next;

		temp->next = head2;
		temp->prev = head2->prev;
		head2->prev->next = temp;
		head2->prev = temp;
	}


	ptr1 = head1;
	ptr2 = head2;
	while (ptr1->next->v != -1 && ptr2->prev->v != -1) {
		if (ptr1->next->v != ptr2->prev->v) {
			break;
		}
		ptr1 = ptr1->next;
		ptr2 = ptr2->prev;
	}

	if (ptr1->next->v == -1 && ptr2->prev->v == -1) {
		printf("good puzzle\n");
		return 0;
	}
	else {
		printf("bad puzzle");
	}
}