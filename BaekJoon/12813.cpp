#include <iostream>

char arr1[100001];
char arr2[100001];

char andd[100001];
char orr[100001];
char xorr[100001];
char nott1[100001];
char nott2[100001];
int main(void) {
	scanf("%s", arr1);
	scanf("%s", arr2);

	for (int i = 0; i < 100000; i++) {

		if (arr1[i]=='0' ||  arr2[i]=='0') {
			andd[i] = '0';
		}
		else {
			andd[i] = '1';
		}
		if (arr1[i] == '1' || arr2[i] == '1') {
			orr[i] = '1';
		}
		else {
			orr[i] = '0';
		}
		if (arr1[i] == arr2[i]) {
			xorr[i] = '0';
		}
		else {
			xorr[i] = '1';
		}
		if (arr1[i] == '0') {
			nott1[i] = '1';
		}
		else {
			nott1[i] = '0';
		}
		if (arr2[i] == '0') {
			nott2[i] = '1';
		}
		else {
			nott2[i] = '0';
		}
	}
	andd[100000] = 0;
	orr[100000] = 0;
	xorr[100000] = 0;
	nott1[100000] = 0;
	nott2[100000] = 0;
	
	printf("%s\n", andd);
	printf("%s\n", orr);
	printf("%s\n", xorr);
	printf("%s\n", nott1);
	printf("%s\n", nott2);



}