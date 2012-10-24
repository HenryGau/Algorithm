#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <cstring>
#include <vector>
#include <set>
#include <map>
#include <queue>
#include <stack>

using namespace std;

#define FOR(i,a,b) for(int i=a;i<=b;i++)
#define FORN(i,a,b) for(int i=a;i<b;i++)
#define SET(a,v) memset(a,v,sizeof(a))
#define DOWN(i,a,b) for(int i=a;i>=b;i--)

int d[1<<17];

int dx[]={-1,0,1,0};
int dy[]={0,1,0,-1};

bool inside(int x,int y) {
	return 0<=x && x<=3 && 0<=y && y<=3;
}

int bit(int s,int i) {
	return (s >> i)&1;
}

int main() {
	int start=0;
	FOR(i,0,3) {
		string s;
		cin >> s;
		FOR(j,0,3) start=start*2+s[j]-48;
	}
	int finish=0;
	FOR(i,0,3) {
		string s;
		cin >> s;
		FOR(j,0,3) finish=finish*2+s[j]-48;
	}
	
	int id[4][4],cnt=0;
	DOWN(i,3,0) DOWN(j,3,0) id[i][j]=cnt++;
	
	queue<int> q;
	q.push(start);
	
	SET(d,-1);
	d[start]=0;

	while(!q.empty()) {
		int u=q.front();q.pop();
		FOR(i,0,3) FOR(j,0,3) if (bit(u,id[i][j])==1) FOR(k,0,3) {
			int x=i+dx[k],y=j+dy[k];
			if(inside(x,y) && bit(u,id[x][y])==0) {
				int v=u-(1<<id[i][j])+(1<<id[x][y]);
				if(d[v]==-1) {
					q.push(v);
					d[v]=d[u]+1;
					if(v==finish) {
						cout << d[v];
						return 0;
					}
				}
			}
		}
	}
}
