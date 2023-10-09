#include <string>
#include <vector>
#include <iostream>

using namespace std;
struct point {
    int r;
    int c;
};
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };
char d[4] = { 'N','S','W','E' };
point find(vector<string> park, int rowlen, int collen) {
    point now;
    for (int i = 0; i < rowlen; i++) {
        for (int j = 0; j < collen; j++) {
            if (park.at(i)[j] == 'S') {
                now.r = i;
                now.c = j;
                return now;
            }
        }
    }
}
vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int rowlen = park.size();
    int collen = park.at(0).size();

    point now;
    now.r = 0;
    now.c = 0;
    now = find(park, rowlen, collen);


    for (int i = 0; i < routes.size(); i++) {
        char direction = routes.at(i)[0];
        int dis = routes.at(i)[2] - '0';

        bool pass = false;

        int row = now.r;
        int col = now.c;
        for (int k = 0; k < 4; k++) {
            if (direction == d[k]) {
                for (int j = 1; j <= dis; j++) {
                    col += dc[k];
                    row += dr[k];
                    if ((col >= collen) || (row >= rowlen) || (col < 0) || (row < 0)
                        || park.at(row)[col] == 'X')
                    {// 해당 명령어는 무시한다.
                        pass = true;
                    }
                }
            }
        }
        if (!pass) {
            now.r = row;
            now.c = col;
        }
    }

    answer.push_back(now.r);
    answer.push_back(now.c);

    return answer;
}