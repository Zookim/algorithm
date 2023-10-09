#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<string> board) {
    int answer = 1;
    //1. 갯수 조건 확인
    int x_num = 0, o_num = 0;
    int win_x = 0, win_o = 0;
    for (int r = 0; r < 3; r++) {
        int o = 0;
        int x = 0;
        for (int c = 0; c < 3; c++) {
            if (board[r][c] == 'X') {
                x++;
                x_num++;
            }
            else if (board[r][c] == 'O') {
                o_num++;
                o++;
            }
        }
        if (o == 3) { win_o++; }
        if (x == 3) { win_x++; }

    }

    if (x_num > o_num || x_num <= o_num - 2) { return 0; }

    //대각 승리 확인1
    int o = 0;
    int x = 0;
    for (int r = 0; r < 3; r++) {
        int c = r;
        if (board[r][c] == 'X') {
            x++;
        }
        else if (board[r][c] == 'O') {
            o++;
        }

    }
    if (o == 3) { win_o++; }
    if (x == 3) { win_x++; }
    //2
    o = 0;
    x = 0;
    for (int r = 2; r >= 0; r--) {//2,1,0
        int c = 2 - r; //0,1,2
        if (board[r][c] == 'X') {
            x++;
        }
        else if (board[r][c] == 'O') {
            o++;
        }

    }
    if (o == 3) { win_o++; }
    if (x == 3) { win_x++; }

    //세로 승리조건 추가 //이부분을 고려하지 않아 오래걸림

    for (int c = 0; c < 3; c++) {
        o = 0;
        x = 0;
        for (int r = 0; r < 3; r++) {
            if (board[r][c] == 'X') {
                x++;
            }
            else if (board[r][c] == 'O') {
                o++;
            }
        }
        if (o == 3) { win_o++; }
        if (x == 3) { win_x++; }
    }


    cout << win_o << " " << win_x << "\n";

    if (win_o >= 1 && win_x >= 1) {

        return 0;
    }
    if ((win_x >= 1) && (x_num != o_num)) {
        return 0;
    }
    if ((win_o >= 1) && (x_num != (o_num - 1))) {
        return 0;
    }

    return answer;
}