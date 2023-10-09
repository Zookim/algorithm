#include <string>
#include <vector>
#include <iostream>

using namespace std;
struct point {
    int r;
    int c;
};
vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    point start;
    point end;
    int R = wallpaper.size();
    int C = wallpaper[0].size();
    start = { R,C };
    end = { 0,0 };

    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (wallpaper[r][c] == '#') {
                start.r = start.r > r ? r : start.r;
                start.c = start.c > c ? c : start.c;
                end.r = end.r < r ? r : end.r;
                end.c = end.c < c ? c : end.c;
            }
        }


    }
    //cout << start.r << " " << start.c << " " << end.r+1 <<" "<<end.c+1;

    answer = { start.r, start.c,end.r + 1,end.c + 1 };
    return answer;
}