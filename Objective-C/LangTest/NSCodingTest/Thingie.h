#import <Cocoa/Cocoa.h>

@interface Thingie: NSObject <NSCoding>
{
    NSString *name;
    int magicNumber;
    float shoeSize;
    NSMutableArray *subThingies;
}
@property (copy) NSString *name;
@property int magicNumber;
@property float shoeSize;
@property (retain) NSMutableArray *subThingies;
- (id) initWithName: (NSString *) n magicNumber: (int) mn shoeSize: (float) ss;
@end