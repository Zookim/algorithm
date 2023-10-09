#include <string>
#include <vector>
#include <list>
#include <iostream>
using namespace std;

int dfs(int depth, int sums, int n, int target, vector<int> numbers) {
    if (depth == n) {
        if (sums == target) {
            return 1;
        }
        else {
            return 0;
        }
    }

    return dfs(depth + 1, sums + numbers[depth], n, target, numbers) + dfs(depth + 1, sums - numbers[depth], n, target, numbers);

}

int solution(vector<int> numbers, int target) {
    int answer = 0;
    //��� ����� �� -> DFS, �� �������� ����
    int n = numbers.size();
    answer = dfs(0, 0, n, target, numbers);

    return answer;
}