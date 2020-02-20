#import "CategoryThing.h"

@implementation CategoryThing (Thing1)
- (void) setThing1: (NSInteger) t1 
{
    thing1 = t1;
}

- (NSInteger) thing1
{
    return (thing1);
}
@end