#import <Cocoa/Cocoa.h>

@interface Tire : NSObject <NSCopying>
{
    float pressure;
    float treadDepth;
}
@property float pressure;
@property float treadDepth;
- (id) initWithPressure: (int) p treadDepth: (int) td;
@end
// 224