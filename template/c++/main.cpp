#include <bits/stdc++.h>
#include <boost/functional/hash.hpp>
#define DEBUG(x) cout<<#x<<": "<<x<<endl;
#define DEBUGM(xs) cout<<#xs<<": ";REP(_i,(int)xs.size())cout<<xs[_i]<<", ";cout<<endl;
#define REP(i, n) for(int i = 0; i < n; ++i)
#define REPR(i, n) for(int i = n; i >= 0; --i)
#define FOR(i, m, n) for(int i = m; i < n; ++i)
#define ALL(xs) begin(xs),end(xs)
#define _1 first
#define _2 second
#define P(k, v) make_pair(k, v)
#define PII pair<int, int>
using namespace std;
template<class T> using V = vector<T>;
template<class K> using uset = unordered_set<K, boost::hash<K>>;
template<class K, class V> using umap = unordered_map<K, V, boost::hash<K>>;
int dx[] = { 0, 1, 0, -1 }, dy[] = { 1, 0, -1, 0 }; // ↑ → ↓ ←

int main() {
    cin.tie(0); ios::sync_with_stdio(false);

    int x;
    scanf("%d", &x);
    printf("%d\n", x);
    return 0;
}

//sort(ALL(xs), greater<int>());
//lower_bound(ALL(xs), x);
//*max_element(ALL(xs));
//accumulate(ALL(xs), 0);
//priority_queue<int, vector<int>, greater<int>>
//pq.top(); pq.pop();
//q.front(); q.pop();
//sort(ALL(xs)); do{}while(next_permutation(ALL(xs)));
