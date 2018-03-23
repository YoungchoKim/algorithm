#include <iostream>
#define min(a, b) ((a) <(b) ? (a) : (b))
struct _node{
	int N;
	_node* next;
	_node* prev;
};
_node* head;
int main(void) {
	int N;
	head = new _node();
	head->next = head;
	head->prev = head;
	_node* ptr = head->next;
	ptr->N = 9999;
	scanf("%d", &N);
	for (int i = 0; i <= N; i++) {
		_node* temp = new _node();
		temp->N = 9999;
		temp->next = ptr->next;
		temp->prev = ptr;
		ptr->next->prev = temp;
		ptr->next = temp;
		
	}
	head->next->next->N = 0;
	ptr = head->next;
	for (int i = 0; i <= 3; i++) {
		ptr = ptr->next;
	}
	for (int i = 3; i <= N; i++) {
		int cmp1 = ptr->prev->prev->prev->N;
		int cmp2 = ptr->prev->prev->prev->prev->prev->N;
		if ( cmp1>= 0 && cmp1 < 9999) {
			ptr->N = min(ptr->prev->prev->prev->N + 1, ptr->N);
		}
		if (i >= 5 &&  cmp2>= 0 && cmp2 < 9999) {
			ptr->N = min(ptr->prev->prev->prev->prev->prev->N + 1, ptr->N);
		}
		ptr = ptr->next;
	}
	int cmp = ptr->prev->N;
	if ( cmp > 0 && cmp < 9999) {
		printf("%d", ptr->prev->N);
	}
	else {
		printf("-1");
	}

}