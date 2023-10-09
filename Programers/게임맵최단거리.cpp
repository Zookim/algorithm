#include<vector>
#include<iostream>
#include<queue>

using namespace std;
struct point {
    int r, c;
};

int dr[4] = { -1,1,0,0 }; //�����¿�
int dc[4] = { 0,0,-1,1 };
int solution(vector<vector<int> > maps)
{
    int answer = -1;
    //BFS
    int R = maps.size();
    int C = maps[0].size();

    vector<vector<bool>> visited(R, vector<bool>(C, false));


    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (maps[r][c] == 0) {
                visited[r][c] = true;
            }
        }
    }

    queue<point> que;
    que.push({ 0,0 });
    int count = 1;
    while (!que.empty()) {
        int n = que.size();
        for (int i = 0; i < n; i++) {
            point now = que.front();
            que.pop();

            if (now.r == R - 1 && now.c == C - 1) { //�������� ����
                return count;
            }
            //�̵��Ҽ� �ִ� �ĺ��� Ž��
            for (int k = 0; k < 4; k++) {
                int row = now.r + dr[k];
                int col = now.c + dc[k];

                // no�湮, no ��,no�����ʰ� �̸� �̵�����
                if (row < R && row >= 0 && col < C && col >= 0 && visited[row][col] == false) {
                    visited[row][col] = true;
                    que.push({ row,col });
                }
            }
        }
        count++;
    }

    return answer;
}