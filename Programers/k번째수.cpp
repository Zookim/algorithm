#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
bool cmp(int a, int b) {
    return a < b;
}
vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    vector<int> slice;

    for (int testcase = 0; testcase < commands.size(); testcase++) {

        int start = commands[testcase][0] - 1;
        int end = commands[testcase][1] - 1;
        int k = commands[testcase][2] - 1;
        for (int i = start; i <= end; i++) {
            slice.push_back(array[i]);
        }

        sort(slice.begin(), slice.end(), cmp);
        answer.push_back(slice[k]);
        slice.clear();
    }


    return answer;
}