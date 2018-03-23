#include <iostream>
int T;
struct URL {
	char protocol[61];
	char host[61];
	char port[61];
	char path[61];
};
char url[1000];
URL result[1000];
int main(void) {
	scanf(" %d ", &T);
	for (int t = 1; t <= T; t++) {
		printf("URL #%d\n", t);
		fgets(url, 1000, stdin);
		
		int i = 0;
		int protocol = 0;
		while (url[i] != ':') {
			result[t].protocol[protocol] = url[i];
			i++;
			protocol++;
		}
		result[i].protocol[protocol] = '\0';
		i++;
		i++;
		i++;
		int host = 0;
		while (url[i] != '/' && url[i] != ':' && url[i] != 0) {
			result[t].host[host] = url[i];
			i++;
			host++;
		}
		result[t].host[host] = 0;
		
		if (url[i] == ':') {
			i++;
			int port = 0;
			while (url[i] != '/' && url[i] != 0) {
				result[t].port[port] = url[i];
				i++;
				port++;			
			}
			result[t].port[port] = 0;
		}
		else {
			result[t].port[0] = '<';
			result[t].port[1] = 'd';
			result[t].port[2] = 'e';
			result[t].port[3] = 'f';
			result[t].port[4] = 'a';
			result[t].port[5] = 'u';
			result[t].port[6] = 'l';
			result[t].port[7] = 't';
			result[t].port[8] = '>';
			result[t].port[9] = '\0';
		}

		if (url[i] == '/') {
			i++;
			int path = 0;
			while (url[i] != 0) {
				result[t].path[path] = url[i];
				i++;
				path++;
			}
			result[t].path[path] = 0;
		}
		else {
			result[t].path[0] = '<';
			result[t].path[1] = 'd';
			result[t].path[2] = 'e';
			result[t].path[3] = 'f';
			result[t].path[4] = 'a';
			result[t].path[5] = 'u';
			result[t].path[6] = 'l';
			result[t].path[7] = 't';
			result[t].path[8] = '>';
			result[t].path[9] = '\0';
		}
		printf("%-8s = %s\n", "Protocol", result[t].protocol);
		printf("%-8s = %s\n", "Host", result[t].host);
		printf("%-8s = %s\n", "Port", result[t].port);
		printf("%-8s = %s\n\n", "Path", result[t].path);
	}
}