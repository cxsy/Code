#import "NSString+NumberConvenience.h"

@implementation NSConstantString (NumberConvenience)
- (NSNumber *) lengthAsNumber
{
    NSUInteger length = [self length];
    return ([NSNumber numberWithUnsignedInt: length]);
}
@end