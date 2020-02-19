#import <Foundation/Foundation.h>
#import "NSString+NumberConvenience.h"

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    NSMutableDictionary *dict = [NSMutableDictionary dictionary];
    [dict setObject: [@"hello" lengthAsNumber] forKey: @"hello"];
    [dict setObject: [@"iLikeFish" lengthAsNumber] forKey: @"iLikeFish"];
    [dict setObject: [@"Once upon a time" lengthAsNumber] forKey: @"Once upon a time"];
    NSLog (@"%@", dict);
    [pool drain];
    return (0);
}