#import <Foundation/Foundation.h>
#import "StaticConstTest.h"
// ERROR: multiple definatino of 'global_msg'
// #import "AnotherFile.h"


int main (int argc, const char *argv[])
{
    @autoreleasepool
    {
        StaticConstTest *sct = [[StaticConstTest alloc] init];
        // 不可见
        // NSLog (@"%@", msg);
        NSLog (@"%@", sct);
        // 可见
        NSLog (@"%@", global_msg);
    }
    return (0);
}