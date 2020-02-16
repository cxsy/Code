#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    
    NSRect rect = NSMakeRect (1, 2, 30, 40);
    NSValue *value = [NSValue valueWithBytes: &rect objCType: @encode(NSRect)];
    NSRect p;
    [value getValue: &p];
    [p Height];
    NSValue *value1 = [NSValue valueWithRect: rect];
    [pool drain];
    return (0);
}
139