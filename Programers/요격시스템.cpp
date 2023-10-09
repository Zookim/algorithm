#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<vector<int>> targets;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string str;
    cin >> str;
    cout << str;

}
bool cmp(vector<int> a, vector<int> b ) {
    if (a[1] == b[1]) { // 뒤부터 정렬한다.
        return a[0] > b[0];
    }else {
        return a[1] > b[1];
    }
}
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
bool cmp(vector<int> a, vector<int> b) {
    if (a[1] == b[1]) { // 뒤부터 정렬한다.
        return a[0] < b[0];
    }
    else {
        return a[1] < b[1];
    }
}
int solution(vector<vector<int>> targets) {

    int n = 0;
    int answer = 0;

    sort(targets.begin(), targets.end(), cmp);
    n = targets.at(0).at(1);
    answer++;
    //cout << "n : " << n;

    for (int i = 1; i < targets.size(); i++) {
        if (targets.at(i).at(0) >= n) {
            n = targets.at(i).at(1);
            answer++;
        }
        //     for(int j=0;j<targets.at(i).size();j++){
        //     cout << targets.at(i).at(j) << ",";
        // }
            //cout << "\n";
    }

    return answer;
}