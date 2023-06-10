#define _CRT_SECURE_NO_WARNINGS //얘가 맨앞으로 와야한다.
#include<iostream>

using namespace std;

bool select[9];
int N,M;
int permlist[9];
int selected[9];

void perm(int index) {
	if (index == M) {
		for (int i = 0; i < M; i++) {
			//cout << permlist[i] << " ";
			printf("%d ", permlist[i]);

		}
		//cout << "\n";
		printf("\n");
		return;
	}


	for (int i = 1; i <= N; i++) {
		//if (selected[i] == 1) continue;
		if (select[i] == true) continue;
		select[i] = true;
		permlist[index] = i;
		perm(index + 1);
		select[i] = false;
	}
	



}
int main() {

	/*for (int i = 0; i < 9; i++) {
		cout << permlist[i] << " ";
	}*/
	//cout << "\n";
	//cin >> N >> M;
	scanf("%d %d", &N, &M);

	perm(0);
	return 0;


}