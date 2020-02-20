#import "StaticConstTest.h"

static NSString *const msg = @"Hello There!";
NSString *const global_msg = @"Hello World!";

@implementation StaticConstTest
- (NSString *) description
{
    return (msg);
}
@end