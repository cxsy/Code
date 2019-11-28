#include <bits/stdc++.h>
using namespace std;
int helper(vector<int> &v, int low, int high, int m)
{
    if (high - low <= 1)
    {
        return 0;
    }
    int res = 0;
    int mid = (low + high) / 2;
    int lval = helper(v, low, mid, m);
    int hval = helper(v, mid, high, m);
    vector<int> tmp;
    int i = low, j = mid;
    while (i < mid || j < high)
    {
        if (i == mid || (j < high && v[j] < v[i]))
        {
            res = (res + mid - i) % m;
            tmp.push_back(v[j++]);
        }
        else
        {
            tmp.push_back(v[i++]);
        }
    }
    for (int t = low; t < high; t++)
    {
        v[t] = tmp[t - low];
    }

    return (res + lval + hval) % m;
}

void hh(int arr[])
{
    cout << "In: " << (arr[0] = -1) << "\n";
}
int main(int argc, char const *argv[])
{
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 0};
    cout << "Before: " << arr[0] << "\n";
    hh(arr);
    cout << "After: " << arr[0] << "\n";
    // cout << helper(v, 0, (int)v.size(), 1000000007) << "\n";
    return 0;
}
