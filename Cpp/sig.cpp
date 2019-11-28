#include <bits/stdc++.h>
#include <signal.h>
#include <unistd.h>
using namespace std;

void int_handler(int signum)
{
    cout << "\n BYE BYE! \n";
    exit(-1);
}
int main(int argc, char const *argv[])
{
    signal(SIGINT, int_handler);
    cout << "int_handler set for SIGINT\n";
    while (1)
    {
        cout << "go to sleep.\n";
        sleep(2);
    }
    return 0;
}
