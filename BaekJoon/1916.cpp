#include <stdio.h>
#include <memory.h>
#include <stdlib.h>
#define mod1 2097152
#define mod2 35184372088831
typedef unsigned long long ll;
struct _vector {
	int size;
	int capacity;
	ll * arr;
	_vector() {
		capacity = 2;
		arr = new ll[2];
	}
	void push(ll a) {
		if (size == capacity) {
			capacity *= 2;
			ll* temp = new ll[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = arr[i];
			}
			delete[] arr;
			arr = temp;
		}
		arr[size++] = a;
	}
	bool find(ll key) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == key) return true;
		}
		return false;
	}
	~_vector() {
		if (arr != nullptr) {
			delete arr;
		}
	}
};

ll key1, key2, pow1 = 1, pow2 = 1;
using namespace std;

const int LIMIT = 5000000;
const int CARDSIZE = sizeof(bool) * 10 * 7;

bool cards[LIMIT + 1][10][7];
int card_index;

_vector v[mod1 + 1];

void findCard(bool answer[10][7], bool mycards[LIMIT + 1][10][7], int myindex)
{
	for (int i = 0; i < myindex; i++) {
		
		key1 = key2 = 0;
		pow1 = pow2 = 1;
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < 7; k++) {
				answer[j][k] = mycards[i][j][k];
				key1 = (key1 + ((ll)answer[j][k] * pow1)%mod1)%mod1;
				key2 = (key2 + ((ll)answer[j][k] * pow2)%mod2)%mod2;
				pow1 *= 17;
				pow2 *= 31;
			}
		}
		if (key1 < 0) key1 = key1 * -1;
		if (key2 < 0) key2 = key2 * -1;
		if (v[key1].find(key2)) {
			return;
		}
		v[key1].push(key2);
	}
	for (int i = 0; i < mod1 + 1; i++) {
		v[i].size = 0;
		if (v[i].capacity > 2) {
			delete[] v[i].arr;
			v[i].capacity = 2;
			v[i].arr = new ll[v[i].capacity];
		}
	}
}

void swapCards(bool a[10][7], bool b[10][7])
{
	bool temp[10][7];
	memcpy(temp, a, CARDSIZE);
	memcpy(a, b, CARDSIZE);
	memcpy(b, temp, CARDSIZE);
}

int createCards(int y, int x, bool card[10][7])
{
	if (y >= 10) {
		memcpy(cards[card_index], card, CARDSIZE);
		card_index++;
		if (card_index == LIMIT)
			return 1;
		return 0;
	}

	int ny = y;
	int nx = x + 1;
	if (nx >= 7) {
		ny++;
		nx = 0;
	}

	int mode = rand() % 13;
	if (mode < 5) {
		card[y][x] = 0;
		if (createCards(ny, nx, card))
			return 1;
	}
	else if (mode < 10) {
		card[y][x] = 1;
		if (createCards(ny, nx, card))
			return 1;
	}
	else {
		card[y][x] = 0;
		if (createCards(ny, nx, card))
			return 1;
		card[y][x] = 1;
		if (createCards(ny, nx, card))
			return 1;
	}

	return 0;
}

int main()
{
	srand(3);

	bool result[10][7];
	bool answer[10][7];

	for (int TESTCASE = 0; TESTCASE < 10; TESTCASE++) {
		card_index = 0;
		createCards(0, 0, result);

		memcpy(result, cards[rand() % card_index], sizeof(result));
		memcpy(cards[card_index], result, sizeof(result));
		card_index++;

		for (int i = 0; i < card_index; i++) {
			int temp = rand() % card_index;
			swapCards(cards[i], cards[temp]);
		}

		findCard(answer, cards, card_index);

		bool check = true;
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 7; k++) {
				if (result[i][k] ^ answer[i][k]) {
					check = false;
				}
			}
		}

		if (check)
			printf("10\n");
		else
			printf("0\n");
	}
}