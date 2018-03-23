#include <iostream>
struct _node {
	int v;
	_node* next;
	_node* prev;
	_node() {
		v = -1;
		next = this;
		prev = this;
	}
};

_node* root;
int main(void) {
	root = new _node();
	int n;
	scanf("%d", &n);
	_node* ptr = root;
	for (int i = 1; i <= n; i++) {
		_node * temp = new _node();
		temp->v = i;
		temp->next = ptr->next;
		temp->prev = ptr;
		ptr->next->prev = temp;
		ptr->next = temp;

		ptr = ptr->next;
	}
	ptr = root;
	while (ptr->next->v != -1) {
		printf("%d ", ptr->next->v);
		_node* temp = ptr->next;
		ptr->next->next->prev = ptr;
		ptr->next = ptr->next->next;
		delete temp;

		temp = ptr->next;
		ptr->next->next->prev = ptr;
		ptr->next = ptr->next->next;
		
		temp->next = ptr;
		temp->prev = ptr->prev;
		ptr->prev->next = temp;
		ptr->prev = temp;
	}

}