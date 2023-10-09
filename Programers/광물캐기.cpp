#include <string>
#include <vector>
#include <iostream>

using namespace std;
//dia, iron, stone
int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    int num = minerals.size() / 5;
    if (minerals.size() % 5 != 0)  num++; // ÇÊ¿äÇÑ °î±ªÀÌÀÇ ¼ö

    char name[3] = { 'd','i','s' };
    vector<char> p;
    int j = 0;
    //cout << picks.at(2);
    for (int i = 0; i < num; i++) {
        //cout << picks.at(j)<<" ";
        while (j < 2 && picks.at(j) <= 0) {//
            j++;
        }

        picks.at(j)--;
        p.push_back(name[j]);
    }

    for (int i = 0; i < p.size(); i++) {
        cout << p.at(i) << " ";
    }

    return answer;
}