#include <string>
#include <vector>
#include <cmath>
#include <climits>
#include <iostream>
using namespace std;

vector<int> solution(int m, int n, int startX, int startY, vector<vector<int>> balls) {
    vector<int> answer;
    // 각
    int balls_len = balls.size();
    for (int ball_num = 0; ball_num < balls_len; ball_num++) {
        // x중심점, y중심점을 구한다.
        int nowX = balls.at(ball_num)[0];
        int nowY = balls.at(ball_num)[1];
        // float mid_x= (startX + nowX)/2;
        // float mid_y= (startY + nowY)/2;

        // 각 축상의 중심점과 공들간의 거리를 구한다
        int minValue = INT_MAX;

        int tmp1 = 0, tmp2 = 0, tmp3 = 0, tmp4 = 0;

        if (nowY != startY || startX < nowX) {

            //x = 0
            int s_X = -startX;
            tmp1 = pow(s_X - nowX, 2) + pow(startY - nowY, 2);
            minValue = minValue < tmp1 ? minValue : tmp1;

        }

        if (nowY != startY || startX > nowX) {
            //x=m
            int s_X = startX + 2 * (m - startX);
            tmp2 = pow(s_X - nowX, 2) + pow(startY - nowY, 2);
            minValue = minValue < tmp2 ? minValue : tmp2;
        }

        if (nowX != startX || startY < nowY) {

            //y=0
            int s_Y = -startY;
            tmp3 = pow(startX - nowX, 2) + pow(s_Y - nowY, 2);
            minValue = minValue < tmp3 ? minValue : tmp3;

        }
        if (nowX != startX || startY > nowY) { // 두번째 조건을 고려하지 않아 계속 틀렸다, 수평하더라도 반대쪽벽을 치면 원쿠션으로 공응 맞출수 있었다.

            //y=n
            int s_Y = startY + 2 * (n - startY);
            tmp4 = pow(startX - nowX, 2) + pow(s_Y - nowY, 2);
            minValue = minValue < tmp4 ? minValue : tmp4;
        }
        //점대칭을 고려할 필요가 없는이유
        // 같은 좌표의 공두개에서 가장 거리가짧은 점대칭과 축대칭의 거리를 비교했을때
        // 항상 축대칭이 거리가 짧다.
        //start(a,b), ball(c,d) 일때, a,b,c,d >0이므로
        // start'(-a,-b) start''(-a,b)라면 항상  start''와의 거리가 더 짧을 수 밖에 없다.


        //(0,0)
//         int s_x = -startX;
//         int s_y = -startY;
//         int tmp5 = pow(s_x-nowX,2) + pow(s_y-nowY,2);
//         minValue = minValue < tmp5 ? minValue:tmp5;
//         //(0,n)
//         s_x = - startX;
//         s_y = startY+ 2*(n-startY);
//         int tmp6 = pow(s_x-nowX,2) + pow(s_y-nowY,2);
//         minValue = minValue < tmp6 ? minValue:tmp6;
//         //(m,0)
//         s_x = startX+2*(m-startX);
//         s_y = -startY;
//         int tmp7 = pow(s_x-nowX,2) + pow(s_y-nowY,2);
//         minValue = minValue < tmp7 ? minValue:tmp7;
//         //(m,n)
//         s_x = startX+2*(m-startX);
//         s_y = startY+ 2*(n-startY);
//         int tmp8 = pow(s_x-nowX,2) + pow(s_y-nowY,2);
//         minValue = minValue < tmp8 ? minValue:tmp8;

//         cout << "1 :"<<tmp1 << " 2:" <<tmp2 <<" 3:"<<tmp3 <<" 4:"<<tmp4;
//         cout << " 5 :"<<tmp5 << " 6:" <<tmp6 <<" 7:"<<tmp7 <<" 8:"<<tmp8<<"\n";
        answer.push_back(minValue);
    }



    return answer;
}