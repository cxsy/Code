#include <bits/stdc++.h>
#include <unistd.h>

using namespace std;

int main(int argc, char const *argv[])
{
    int i = 0;
    // ofstream out("out.txt");
    cout << 'a';
    pid_t pid = fork();
    if (pid == 0)
    {
        // i = 2;
        // cout << i << "\n";
        cout << 'b';
        // exit(0);
        // cout << "This is subprocess!\n";
    }
    else
    {
        sleep(2);
        cout << 'c';
        // exit(0);
        // cout << i << "\n";
        // cout << "This is process!\n";
    }

    return 0;
}
