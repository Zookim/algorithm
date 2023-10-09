#include <string>
#include <vector>
#include <cmath>
#include <climits>
#include <iostream>
using namespace std;

vector<int> solution(int m, int n, int startX, int startY, vector<vector<int>> balls) {
    vector<int> answer;
    // ��
    int balls_len = balls.size();
    for (int ball_num = 0; ball_num < balls_len; ball_num++) {
        // x�߽���, y�߽����� ���Ѵ�.
        int nowX = balls.at(ball_num)[0];
        int nowY = balls.at(ball_num)[1];
        // float mid_x= (startX + nowX)/2;
        // float mid_y= (startY + nowY)/2;

        // �� ����� �߽����� ���鰣�� �Ÿ��� ���Ѵ�
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
        if (nowX != startX || startY > nowY) { // �ι�° ������ ������� �ʾ� ��� Ʋ�ȴ�, �����ϴ��� �ݴ��ʺ��� ġ�� ��������� ���� ����� �־���.

            //y=n
            int s_Y = startY + 2 * (n - startY);
            tmp4 = pow(startX - nowX, 2) + pow(s_Y - nowY, 2);
            minValue = minValue < tmp4 ? minValue : tmp4;
        }
        //����Ī�� ����� �ʿ䰡 ��������
        // ���� ��ǥ�� ���ΰ����� ���� �Ÿ���ª�� ����Ī�� ���Ī�� �Ÿ��� ��������
        // �׻� ���Ī�� �Ÿ��� ª��.
        //start(a,b), ball(c,d) �϶�, a,b,c,d >0�̹Ƿ�
        // start'(-a,-b) start''(-a,b)��� �׻�  start''���� �Ÿ��� �� ª�� �� �ۿ� ����.


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