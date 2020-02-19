#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    // void (^square_block)() = 
    // ^{printf("Hello Blocks!\n")}; not working
    // int result = square_block(5);
    // printf("Result = %d\n", result);
    [pool drain];
    return (0);
}