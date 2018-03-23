#include <cstdio>
#define min(a,b) ((a)<(b)?(a):(b))
#define mod1 (int)(10007)
#define mod2 (int)(10099)
typedef long long ll;
template<typename T, typename P>
struct pair {
	pair() {}
	pair(T a, T b) :first(a), second(b) {}
	T first, second;
	bool operator==(const pair &other) {
		return first == other.first && second == other.second;
	}
};
template<typename T>
struct vector {
	T *arr;
	int s;
	int ptr;
	vector() :vector(8) {}
	vector(int size) :s(size) { arr = new T[size]; }
	~vector() { delete arr; }
	void clear() { ptr = 0; }
	int size() { return ptr; }
	bool empty() { return ptr == 0; }
	T front() { return arr[ptr - 1]; }
	T operator[](const int &idx) { return arr[idx]; }
	void push_back(T data) {
		if (ptr == s) {
			T *tmp = new T[s * 2];
			for (int n = 0; n < ptr; n++) tmp[n] = arr[n];
			delete arr;
			arr = tmp;
			s *= 2;
		}
		arr[ptr++] = data;
	}
};
int N, M;
char str[1000001];
char cmp[1000001];
int c;
vector<int> ans;
int change(char c) {
	return (c - 'A' + 1) < 0 ? 28 : c - 'A' + 1;
}
pair<int, int> getHash(char *s, int size) {
	ll ret1 = 0, r1 = 1;
	for (int n = size - 1; n >= 0; n--, r1 *= 29, r1 %= mod1) {
		ll g = change(s[n]);
		ret1 += g * r1;
		ret1 %= mod1;
	}

	ll ret2 = 0, r2 = 1;
	for (int n = size - 1; n >= 0; n--, r2 *= 29, r2 %= mod2) {
		ll g = change(s[n]);
		ret2 += g * r2;
		ret2 %= mod2;
	}
	return pair<int, int>(ret1, ret2);
}
pair<int, int> getPow() {
	pair<int, int> ret(1, 1);
	for (int n = 0; n < M - 1; n++) {
		ret.first *= 29, ret.first %= mod1;
		ret.second *= 29, ret.second %= mod2;
	}
	return ret;
}
int main() {
	while ((c = getchar()) != '\n') str[N++] = c;
	while ((c = getchar()) != EOF) {
		if (c == '\n') break;
		cmp[M++] = c;
	}
	pair<int, int> base = getHash(cmp, M);
	pair<int, int> get = getHash(str, min(N, M));
	pair<int, int> pow_x = getPow();

	if (base == get) ans.push_back(1);
	for (int n = M; n < N; n++) {
		int en = n - M;
		get.first = (get.first - (change(str[en]) * pow_x.first % mod1) + mod1) % mod1;
		get.second = (get.second - (change(str[en]) * pow_x.second % mod2) + mod2) % mod2;
		get.first *= 29; get.first %= mod1;
		get.second *= 29; get.second %= mod2;
		get.first += change(str[n]); get.first %= mod1;
		get.second += change(str[n]); get.second %= mod2;
		if (base == get) ans.push_back(en + 2);
	}
	printf("%d\n", ans.size());
	for (int n = 0; n < ans.size(); n++) printf("%d ", ans[n]);
	return 0;
}