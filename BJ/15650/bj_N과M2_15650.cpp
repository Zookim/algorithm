#define _CRT_SECURE_NO_WARNINGS //얘가 맨앞으로 와야한다.
#include <iostream>

int N, M;
int list[9];
bool selected[9];

void comb(int start, int index) 
{
	if (index == M) 
	{
		for(int i=0;i<M;i++){
			printf("%d ", list[i]);
		}
		printf("\n");
		return;
	}
	for (int i = start; i <= N; i++) 
	{
		if (selected[i] == true) 
		{
			continue;
		}

		selected[i] = true;
		list[index] = i;
		comb(i + 1, index + 1);
		selected[i] = false;
	}

}



int main()
{
	scanf("%d %d",&N,&M);
	comb(1,0);
	return 0;

}