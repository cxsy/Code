#import <Foundation/Foundation.h>
@interface Garage : NSObject
{
    NSMutableDictionary *stuff;
}
@end
@implementation Garage
- (void) setValue: (id) value forUndefinedKey: (NSString *) key
{
    if (stuff == nil)
    {
        stuff = [[NSMutableDictionary alloc] init];
    }
    [stuff setValue: value forKey: key];
}
- (id) valueForUndefinedKey: (NSString *) key
{
    id value = [stuff valueForKey: key];
    return (value);
}
@end
int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    Garage *garage = [[Garage alloc] init];
    [garage setValue: @"bunny" forKey: @"fluffy"];
    [garage setValue: @"greeble" forKey: @"bork"];
    [garage setValue: [NSNull null] forKey: @"snorgle"];
    [garage setValue: nil forKey: @"gronk"];
    NSLog (@"values are %@ %@ %@ and %@", [garage valueForKey: @"fluffy"], [garage valueForKey: @"bork"], [garage valueForKey: @"snorgle"], [garage valueForKey: @"gronk"]);
    [pool drain];
    return (0);
}