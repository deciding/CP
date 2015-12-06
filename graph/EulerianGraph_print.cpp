#include <iostream>
#include <list>
#include <vector>


using namespace std;

typedef pair<int, int> ii;
typedef vector<ii> vii;

list<int> cyc;
vector <vii> AdjList(6);
void EulerTour(list<int>::iterator i, int u){
	int x;
	if (!cyc.empty())
		x = *i;
	for (int j = 0; j < (int)AdjList[u].size(); j++){
		ii &v = AdjList[u][j];
		if (v.second){
			v.second = 0;
			//ii uu;
			int uuk;
			for (int k = 0; k < (int)AdjList[v.first].size(); k++){
				uuk = k;
				ii &uu = AdjList[v.first][k];
				if (uu.first == u && uu.second){
					uu.second = 0;
					break;
				}
			}
			list<int>::iterator pos = cyc.insert(i, u);
			int y = *pos;
			EulerTour(pos, v.first);
		}
	}
}
int main(){
	AdjList[0] = { make_pair(1, 1), make_pair(2, 1) };
	AdjList[1] = { make_pair(0, 1), make_pair(2, 1), make_pair(3, 1), make_pair(4, 1) };
	AdjList[2] = { make_pair(0, 1), make_pair(1, 1), make_pair(3, 1), make_pair(4, 1) };
	AdjList[3] = { make_pair(1, 1), make_pair(2, 1), make_pair(4, 1), make_pair(5, 1) };
	AdjList[4] = { make_pair(1, 1), make_pair(2, 1), make_pair(3, 1), make_pair(5, 1) };
	AdjList[5] = { make_pair(3, 1), make_pair(4, 1) };

	cyc.clear();
	EulerTour(cyc.begin(), 0);
	for (list<int>::iterator it = cyc.begin(); it != cyc.end(); it++)
		printf("%d\n", *it);
	getchar();
	return 0;
}