#include <string>
#include <vector>
#include <iostream>
#include <list>
#include <queue>

using namespace std;
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };

struct Point {
    int r;
    int c;
};
void print(vector<vector<int>> visited) {

    for (auto a : visited) {
        for (auto b : a) {
            cout << b << " ";
        }
        cout << "\n";
    }
    cout << "\n";
    return;
}
int solution(vector<string> board) {
    int answer = 0;
    int R = board.size();
    int C = board.at(0).size();
    vector<vector<int>> visited(R, vector<int>(C, 0));

    // for(auto a: board){
    //     for(auto b : a){
    //         cout << b << " ";
    //     }
    //     cout << "\n";
    // }
    // cout << "\n";
    //
    Point start;

    // R �� �������� ã�� �����Ѵ�.
    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (board.at(r)[c] == 'R') { start.r = r; start.c = c; visited[r][c] = 3; }
            if (board.at(r)[c] == 'D') { visited[r][c] = 1; }
        }
    }
    //cout << "start \n";
    //print(visited);
    queue<Point> que;
    que.push(start);

    // BSP ���Ž�� ����� ���� visited

    while (!que.empty()) {
        int N = que.size();
        answer++;
        for (int i = 0; i < N; i++) {

            Point now;
            now = que.front();
            // cout << now.r << " "<<now.c<<"\n";
            que.pop();

            if (board[now.r][now.c] == 'G') {
                return answer - 1;
            }
            //������ ������ Ž���Ѵ�.
            for (int k = 0; k < 4; k++) {
                // ���κ��̳� ��ֹ��� ���������� �̵�
                int row = now.r, col = now.c;
                while (1) {
                    row += dr[k];
                    col += dc[k];

                    if (row < 0 || row >= R || col < 0 || col >= C || board[row][col] == 'D') {
                        row -= dr[k];
                        col -= dc[k];
                        break;
                    }
                }

                // �湮���� �������̶�� ť�� ���� ��ġ�� �ִ´�.
                if (visited[row][col] == 0) {

                    /*Point nextPoint;
                    nextPoint.r = row;
                    nextPoint.c = col;
                    que.push(nextPoint);*/
                    //Ȥ��
                    /*
                    Point nextPoint = {row,col};
                    que.push(nextPoint);
                    */
                    que.push({row,col});
                    visited[row][col] = 2;

                    //  print(visited);
                }
            }

        }
    }
    answer = -1;
    return answer;
}