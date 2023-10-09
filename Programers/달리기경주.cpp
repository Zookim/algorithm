
// ���ӵ� vector�� ���
//vector<string> solution(vector<string> players, vector<string> callings) {
//    vector<string> answer = players;
//    
//    // �̸��� �Ҹ��� �ٷ� �հ� ��ȯ�Ѵ�.
//    
//    for (int i = 0; i < callings.size(); i++) {
//        string name = callings.at(i);
//        vector<string>::iterator iter = find(answer.begin(), answer.end(), name);
//
//
//        string change = *(iter - 1);
//
//        *(iter - 1) = name;
//        *(iter) = change;
//
//
//    }
//    return answer;
//}
// ��ó�� map�� ������� ������ ���� ������.
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer = players;
    unordered_map<string, int> um;


    for (int i = 0; i < answer.size(); i++) {
        um[answer.at(i)] = i;
    }

    for (auto name : callings) {
        int num1 = um[name];

        string name2 = answer.at(num1 - 1);

        answer.at(num1) = name2;
        answer.at(num1 - 1) = name;

        um[name2]++;
        um[name]--;
    }


    return answer;
}

