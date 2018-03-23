#include <iostream>
struct _node {
	int value;
	_node* next;
	_node* prev;
};
_node* head;
int main(void) {
	head = new _node;
	head->next = head;
	head->prev = head;





}