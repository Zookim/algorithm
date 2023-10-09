#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;


vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    unordered_map<char, int> umap;


    for (int i = 0; i < keymap.size(); i++) {
        for (int j = 0; j < keymap[i].size(); j++) {
            char nowChar = keymap[i][j];
            if (umap.find(nowChar) == umap.end()) {
                umap[nowChar] = j + 1;
            }
            else {
                umap[nowChar] = umap[nowChar] > j + 1 ? j + 1 : umap[nowChar];
            }
        }
    }

    // for(auto m : umap){
    //     cout << m.first << " " << m.second<<" \n";
    // }
    //

    for (int i = 0; i < targets.size(); i++) {
        int num = 0;
        for (int j = 0; j < targets[i].size(); j++) {
            if (umap.find(targets[i][j]) == umap.end()) {
                num = -1;
                break;
            }
            else {
                num += umap[targets[i][j]];
            }

        }
        answer.push_back(num);
    }



    return answer;
}