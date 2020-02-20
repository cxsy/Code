#import <Foundation/Foundation.h>
@interface CategoryThing : NSObject
{
    NSInteger thing1;
    NSInteger thing2;
    NSInteger thing3;
}
@end

@interface CategoryThing (Thing1)
- (void) setThing1: (NSInteger) thing1;
- (NSInteger) thing1;
@end

@interface CategoryThing (Thing2)
- (void) setThing2: (NSInteger) thing2;
- (NSInteger) thing2;
@end

@interface CategoryThing (Thing3)
- (void) setThing3: (NSInteger) thing3;
- (NSInteger) thing3;
@end