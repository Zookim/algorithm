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
        if (pre > mm.first) { //�����̿� ������ �ʴ°�
            answer = pre;
            return answer;
        }
        pre += mm.second;
        cout << mm.first << " " << pre << "\n";
        if (pre >= mm.first) { //����
            answer = mm.first;
            return answer;
        }
    }

    return answer = pre; //������ ��
}