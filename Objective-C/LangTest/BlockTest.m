#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    // int (^square_block)(int a) = 
    // ^(int a) {return a * a;};
    // int result = square_block(5);
    // printf("Result = %d\n", result);
    [pool drain];
    return (0);
}