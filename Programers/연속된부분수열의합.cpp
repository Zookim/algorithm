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
    //ª�� ���� -> ����
    for (int len = 1; len <= n; len++) {
        for (int i = n; i >= len; i--) { // �ں��� ����. -> �ð��ʰ� �ذ�
            if (k > addlist.at(i) - addlist.at(i - len)) { // ���� Ŀ���� ���� �̰ͺ��� �۴ٸ� ����� �ʿ䵵 ����.
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