#import <Cocoa/Cocoa.h>

@interface Engine : NSObject <NSCopying>
{
    int horsepower;
}
@property (readwrite) int horsepower;
- (id) init;
@end