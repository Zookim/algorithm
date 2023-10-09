#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    vector<int> addlist;
    int n = sequence.size();
    //cout << n;
    addlist.push_back(0);

    for (int i = 1; i <= n; i++) {
        addlist.push_back(addlist.at(i - 1) + sequence.at(i - 1));
    }
    //짧은 길이 -> 앞쪽
    for (int len = 1; len <= n; len++) {
        for (int i = n; i >= len; i--) { // 뒤부터 돈다. -> 시간초과 해결
            if (k > addlist.at(i) - addlist.at(i - len)) { // 가장 커야할 수가 이것보다 작다면 고려할 필요도 없다.
                break;
            }
            if (k == addlist.at(i) - addlist.at(i - len)) {
                answer.clear();
                answer.push_back(i - len);
                answer.push_back(i - 1);
                //return answer;
            }
        }
        if (answer.size() != 0) { return answer; }

    }
    return answer;
}