#include <iostream>
#include <string>

int main()
{
	int n;
	std::cin >> n;

	std::string str1;
	getline(std::cin, str1);

	for (int i = 0; i < n; i++) 
	{
		//char str[255];
		std::string str;
		getline(std::cin,str);
		int list[26] = {0,};
		int j = 0;
		int max =0;
		int max_char = -1;
		bool flag = false;


		//std::cout << str.length();
		while (j<str.length())
		{
			char a = str.at(j);
			
			if (a == ' ') 
			{
				j++; continue;
			}
			//std::cout << list[(int)a - 'a'] << " ";
			list[(int)a -'a']++;

			if (max < list[(int)a - 'a'])
			{
				max = list[(int)a - 'a'];
				//std::cout << max;
				max_char = a;
				flag = false;
			}
			else if (max == list[(int)a - 'a'] && max_char != a)
			{
				flag = true;
			}

			j++;
		}
		if (flag) std::cout << "?";
		else std::cout << (char)max_char;
		std::cout << "\n";

	}

}