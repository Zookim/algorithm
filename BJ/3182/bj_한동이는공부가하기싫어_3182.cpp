#include <iostream>
using namespace std;
int countlist[1001] = {0,};
bool visited[1001];
int list[1001] = {0,};

int dfs(int index) {
	if (visited[index]) return 1;
	//cout << index;
	visited[index] = true;
	int next = list[index];
	return dfs(next) + 1;

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);


	
	int N;
	cin >> N;
	//cout << N;
	int maxs = 0;
	int maxs_index = 0;

	//visited[1001] = {false,};
	
	for (int i = 1; i <= N;i++){
		//cout << "sdf";
		int a;
		cin >> a;
		//cout << a;
		list[i] = a;
	}
	//input
	for (int i = 1; i <= N; i++) {
		//cout << "¼ø¼­ " << i << "\n";
		countlist[i] = dfs(i);
		
		//cout << countlist[i];
		fill_n(visited, 1001, false);
		if (countlist[i] > maxs) {
			maxs = countlist[i];
			maxs_index = i;
		}
	}
	//cout << "\n" << maxs << "\n";
	cout << maxs_index;
}
