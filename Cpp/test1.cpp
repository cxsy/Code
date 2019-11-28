#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const *argv[])
{
    ifstream in("in.txt");
    ofstream out("out.txt");
    string s;
    in >> s;
    int p = 0;
    int i = s.find(',');
    while (i != string::npos)
    {
        out << s.substr(p, i - p) << "\n";
        p = i + 1;
        i = s.find(',', i + 1);
    }
    out << s.substr(p) << "\n";
    return 0;
}
