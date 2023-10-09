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
    //모든 경우의 수 -> DFS, 각 누적값을 결정
    int n = numbers.size();
    answer = dfs(0, 0, n, target, numbers);

    return answer;
}