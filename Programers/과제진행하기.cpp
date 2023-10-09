#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>
using namespace std;
// ���� >> �������� ���� , ���� ���� ��� ��ȯ

struct plan {
    string name;
    int start;
    int playtime;
};

bool cmp(plan a, plan b) {
    return a.start < b.start; // ture�� ����
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    vector<plan> list;
    stack<int> staylist; // ������� �۾��� �ε����� ����

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
    end.start = 144000; //�׳��� ������ ������ ��Ӱ��� -> ��������
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
        if (work < nowPlan.playtime) {// �ߴܵ�
            list.at(i).playtime -= work;
            staylist.push(i);

        }
        else if (work > nowPlan.playtime) { // ����
            list.at(i).playtime = 0;
            answer.push_back(list.at(i).name); // ���� �۾��� ����

            int rest = work - nowPlan.playtime;
            while (!staylist.empty() && rest > 0) { // �����ð��� ���Ҵٸ�
                int n = staylist.top();
                //  cout << "n : " << n <<" " <<list.at(n).name << " ";

                if (list.at(n).playtime > rest) { // ������ ����
                    list.at(n).playtime -= rest;
                    rest = 0;
                }
                else {// �����ð��� �� ũ�ų� ���ٸ�
                    rest -= list.at(n).playtime;
                    list.at(n).playtime = 0;
                    staylist.pop();
                    answer.push_back(list.at(n).name);
                }
            }

        }
        else { // �ð��� �۾��� �������
            list.at(i).playtime = 0;
            answer.push_back(list.at(i).name);
        }
        //  cout << "\n";
    }

    return answer;
}