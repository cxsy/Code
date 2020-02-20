#import <Foundation/Foundation.h>

#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    @autoreleasepool
    {
        NSNumber *number = [NSNumber numberWithFloat: 12345.12];
        NSLog (@"%d", [number intValue]);

        // literal expression
        NSNumber *someInt = @1;
        NSNumber *someFloat = @2.5f;
        NSNumber *expressionNumber = @(2 * 2.5);
        NSLog (@"%@", someInt);
        NSLog (@"%@", someFloat);
        NSLog (@"%@", expressionNumber);
    }
    return (0);
}