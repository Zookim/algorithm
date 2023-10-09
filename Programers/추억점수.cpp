#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    unordered_map<string, int> um;

    for (int i = 0; i < name.size(); i++) {
        um[name.at(i)] = yearning.at(i);
    }

    for (auto paper : photo) {
        int sum = 0;
        for (auto person : paper) {
            sum += um[person];

        }
        answer.push_back(sum);
    }
    return answer;
}