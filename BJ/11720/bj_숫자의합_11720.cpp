#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<cstring>
using namespace std;

int main() 
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	char chlist[100];

	string str;
	cin >> str;

	strcpy(chlist, str.c_str());
	//cout << (int)chlist[0] - '0';
	//1.vector 2.null
	int res =0;
	/*for (int i = 0; i < N; i++) */
	int i = 0;
	while(true) 
	{	
		if (chlist[i] == '\0') break;
		res += (int)chlist[i] - '0';
		i++;
	}
	cout << res;
}