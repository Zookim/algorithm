#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

//string str;


int main() 
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	string str;
	while (true)
	{
		getline(cin, str);
		if (str == "END") break;
		reverse(str.begin(), str.end());
		cout << str<<"\n";
	}

	/*char str[500];
	while (true)
	{
		cin >> str;
		cout << str;
		cout << "\n";
		if (str[-1] == '\n') break;
	}*/

	//while (true)
	//{
	//	string str1;

	//	while (true)
	//	{
	//		string str;
	//		cin >> str;
	//		str1 += str + " ";
	//		//cout << str;
	//		if(str.at(str.length()-1) == '\n') break;
	//		//cout << str1;
	//	}
	//	cout << str1;
	//	if (str1 == "END ") break;
	//	reverse(str1.begin(), str1.end());

	//}
	//cout << "END";

}