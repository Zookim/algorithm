#include <string>
#include <vector>
#include <iostream>
#include <cmath>
using namespace std;


long long solution(int r1, int r2) {
    long long answer = 0;
    int n = 0;
    for (int x = 1; x <= r2; x++) {
        int y1 = 0, y2 = 0;
        y2 = (int)floor(sqrt(pow(r2, 2) - pow(x, 2)));
        //cout << "y2 : " << y2 << " ";
        if (r1 > x) {
            y1 = (int)ceil(sqrt(pow(r1, 2) - pow(x, 2)));
            //cout << "y1 : " << y1;
        }
        answer += y2 - y1 + 1; // 1은 r1이 없을때도 축위의 점을 세야하므로 필요하다


        //cout << " answer : "<<answer;
        //cout << "\n";
    }
    answer *= 4;
    return answer;
}

int main() {
    int r1, r2;
    cin >> r1 >> r2;
    long long res = solution(r1, r2);
    cout << res;
}