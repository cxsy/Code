#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    NSDate *date = [NSDate date];
    NSLog (@"today is %@", date);

    NSDate *yesterday = [NSDate dateWithTimeIntervalSinceNow: -(24 * 60 * 60)];
    NSLog (@"yesterday is %@", yesterday);
    [pool drain];
    return (0);
}