#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    map<int, int, greater<int>>  m;

    for (int i = 0; i < citations.size(); i++) {
        if (m.find(citations[i]) != m.end()) {
            m[citations[i]]++;
        }
        else {
            m[citations[i]] = 1;
        }
    }
    int pre = 0;
    for (auto mm : m) {
        if (pre > mm.first) { //값사이에 보이지 않는값
            answer = pre;
            return answer;
        }
        pre += mm.second;
        cout << mm.first << " " << pre << "\n";
        if (pre >= mm.first) { //적중
            answer = mm.first;
            return answer;
        }
    }

    return answer = pre; //이후의 값
}