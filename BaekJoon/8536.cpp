#include <iostream>
struct _node {
	char* str;
	_node* next;
	_node() {
	}
	~_node() {
		delete(next);
	}
};

_node* hashTable[1000000];
int strcmp(char* str1, char* str2);
char* check(char*);
int getKey(char*);
void addHash(char*, _node*);
bool findHash(char* temp);
void arrayscopy(char* src, int start, char* dest);
int T;
char cry[101][101];
char str[10201];
char result[10201];

int main(void) {
	scanf("%d ", &T);
	while (T--) {
		fgets(str, 10201, stdin);
		
		char temp[101];
		fgets(temp, 101, stdin);
		char* go;
		int size = 0;
		while (go = check(temp)) {
			int i = 0;
			for (; go[i] != '\n' && go[i] != 0; i++) {
				cry[size][i] = go[i];
			}
			cry[size][i] = 0;

			size++;
			fgets(temp, 101, stdin);
		}
		for (int i = 0; i < size; i++) {
			_node* ptr = new _node();
			ptr->str = cry[i];
			addHash(cry[i], ptr);
		}
		
		int start = 0;
		int resultIdx = 0;
		for (int i = 0; str[i] != 0 && str[i] != '\n'; i++) {
			if (str[i] == ' ') {
				str[i] = 0;
				char temp[110];
				arrayscopy(str, start, temp);
				if (!findHash(temp)) {
					for (int k = 0; temp[k] != 0; k++) {
						result[resultIdx] = temp[k];
						resultIdx++;
					}
					result[resultIdx++] = ' ';	
				}

				start = i + 1;
			}
		}

		arrayscopy(str, start, temp);	//마지막 단어 
		if (!findHash(temp)) {
			for (int k = 0; temp[k] != '\n' && temp[k] != 0; k++) {
				result[resultIdx] = temp[k];
				resultIdx++;
			}
			result[resultIdx++] = ' ';
		}
		result[resultIdx] = 0;
		printf("%s\n", result);

	}
}
void arrayscopy(char* src,int start, char* dest) {
	for (int i = start; src[i] != '\n' && src[i] != 0; i++) {
		*dest = src[i];
		dest++;
	}
	*dest = 0;
}
bool findHash(char* temp) {
	int key = getKey(temp);
	if (hashTable[key] == nullptr) {
		return false;
	}
	else {
		if (strcmp(hashTable[key]->str, temp) == 0) {
			return true;
		}
		else {
			_node* ptr = hashTable[key]->next;
			while (ptr != nullptr) {
				if (strcmp(ptr->str, temp) == 0) {
					return true;
				}
				ptr = ptr->next;
			}
		}
	}
	return false;
}

void addHash(char* str, _node* node) {
	int hash = getKey(str);
	if (hashTable[hash] == nullptr) {
		hashTable[hash] = node;
	}
	else {
		if (strcmp(hashTable[hash]->str, str) != 0) {
			node->next = hashTable[hash];
			hashTable[hash] = node;
		}
		else {
			return;
		}
	}
}
int strcmp(char* str1, char* str2) {
	
	while (*str1 != 0 && *str2 != 0  && *str1 == *str2) {
		str1++; str2++;
	}
	return *str1 - *str2;
}
int getKey(char* str) {
	int hash = 0;
	for (int i = 0; str[i] != 0 && str[i] != '\n'; i++) {
		hash = (hash * 31 + str[i] - 'a') % 1000000;
	}
	return hash;
}


char* check(char* str) {
	char * result = 0;
	while (*str != 0 && *str != ' ') {
		str++;
	}
	if (*str == 0) {
		return 0;
	}
	else if (*str == ' ') {
		str++;
		if (*str != 'g') return 0;
		str++;
		if (*str != 'o') return 0;
		str++;
		if (*str != 'e') return 0;
		str++;
		if (*str != 's')return 0;
		str++;
		if (*str != ' ')return 0;
		str++;
		result = str;
		if (*str != ' ' && *str != '\n' && *str != 0) {
			while (*str != ' ' && *str != '\n' && *str != 0) {
				str++;
			}
			if (*str == '\n') {
				return result;
			}
			else {
				return 0;
			}
		}
	}
	return 0;
}