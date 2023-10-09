#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>
using namespace std;
// 새것 >> 진행중인 과제 , 끝낸 순서 대로 반환

struct plan {
    string name;
    int start;
    int playtime;
};

bool cmp(plan a, plan b) {
    return a.start < b.start; // ture일 정렬
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    vector<plan> list;
    stack<int> staylist; // 대기중인 작업의 인덱스를 저장

    for (int i = 0; i < plans.size(); i++) {
        plan tmp;
        tmp.name = plans.at(i)[0];
        int time = (plans.at(i)[1][0] - '0') * 600 + (plans.at(i)[1][1] - '0') * 60 +
            (plans.at(i)[1][3] - '0') * 10 + (plans.at(i)[1][4] - '0');
        tmp.start = time;
        tmp.playtime = stoi(plans.at(i)[2]);
        list.push_back(tmp);
    }
    plan end;
    end.name = "end";
    end.start = 144000; //그날이 끝나도 과제는 계속가능 -> 문제원인
    end.playtime = 0;

    list.push_back(end);
    sort(list.begin(), list.end(), cmp);

    // for(int i=0;i< list.size();i++){
    //     cout << list.at(i).name<<"\n";
    // }

    for (int i = 0; i < list.size() - 1; i++) {
        //cout << list.at(i).name<<" ";

        plan nowPlan = list.at(i);
        plan nextPlan = list.at(i + 1);

        int work = nextPlan.start - nowPlan.start;
        if (work < nowPlan.playtime) {// 중단됨
            list.at(i).playtime -= work;
            staylist.push(i);

        }
        else if (work > nowPlan.playtime) { // 여유
            list.at(i).playtime = 0;
            answer.push_back(list.at(i).name); // 현재 작업은 끝남

            int rest = work - nowPlan.playtime;
            while (!staylist.empty() && rest > 0) { // 여유시간이 남았다면
                int n = staylist.top();
                //  cout << "n : " << n <<" " <<list.at(n).name << " ";

                if (list.at(n).playtime > rest) { // 끝내지 못함
                    list.at(n).playtime -= rest;
                    rest = 0;
                }
                else {// 여유시간이 더 크거나 같다면
                    rest -= list.at(n).playtime;
                    list.at(n).playtime = 0;
                    staylist.pop();
                    answer.push_back(list.at(n).name);
                }
            }

        }
        else { // 시간에 작업이 끝난경우
            list.at(i).playtime = 0;
            answer.push_back(list.at(i).name);
        }
        //  cout << "\n";
    }

    return answer;
}