#include <string>
#include <vector>
#include <string>
#include <algorithm>
#include <iostream>
//#include <numeric>
using namespace std;
bool cmp(string a, string b) {

    string ab = a + b;
    string ba = b + a;

    return stoi(ab) > stoi(ba);
}
string solution(vector<int> numbers) {
    string answer = "";
    vector<string> num;

    for (auto str : numbers) {
        num.push_back(to_string(str));
    }
    sort(num.begin(), num.end(), cmp);
    if (num[0] == "0") {
        return "0";
    }

    for (auto str : num) {
        answer.append(str);
    }
    return answer;
}