#import <Foundation/Foundation.h>

typedef enum {
    kCircle,
    kRectanle,
    kEgg
} ShapeType;

typedef enum {
    kRedColor,
    kGreenColor,
    kBlueColor
} ShapeColor;

typedef struct {
    int x, y, width, height;
} ShapeRect;

typedef struct {
    ShapeType type;
    ShapeColor fillColor;
    ShapeRect bounds;
} Shape;

NSString *colorName (ShapeColor colorName) 
{
    switch (colorName) {
        case kRedColor:
            return @"red";
            break;
        case kGreenColor:
            return @"green";
            break;
        case kBlueColor:
            return @"blue";
            break;
    }
    return @"no clue";
}
void drawCircle (ShapeRect bounds, ShapeColor fillColor) 
{
    NSLog (@"drawing a circle at (%d %d %d %d) in %@", bounds.x, bounds.y, bounds.width, bounds.height, colorName(fillColor));
}
void drawRectangle (ShapeRect bounds, ShapeColor fillColor) 
{
    NSLog (@"drawing a rectangle at (%d %d %d %d) in %@", bounds.x, bounds.y, bounds.width, bounds.height, colorName(fillColor));
}
void drawEgg (ShapeRect bounds, ShapeColor fillColor) 
{
    NSLog (@"drawing an egg at (%d %d %d %d) in %@", bounds.x, bounds.y, bounds.width, bounds.height, colorName(fillColor));
}

void drawShapes (Shape shapes[], int count) 
{
    for (int i = 0; i < count; i++) {
        switch (shapes[i].type) {
            case kCircle:
                drawCircle (shapes[i].bounds, shapes[i].fillColor);
                break;
            case kRectanle:
                drawRectangle (shapes[i].bounds, shapes[i].fillColor);
                break;
            case kEgg:
                drawEgg (shapes[i].bounds, shapes[i].fillColor);
                break;
        }
    }
}


int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    Shape shapes[3];

    ShapeRect rect0 = {0, 0, 10, 30};
    shapes[0].type = kCircle;
    shapes[0].fillColor = kRedColor;
    shapes[0].bounds = rect0;
    ShapeRect rect1 = {30, 40, 50, 60};
    shapes[1].type = kRectanle;
    shapes[1].fillColor = kGreenColor;
    shapes[1].bounds = rect1;
    ShapeRect rect2 = {15, 18, 37, 29};
    shapes[2].type = kEgg;
    shapes[2].fillColor = kBlueColor;
    shapes[2].bounds = rect2;
    drawShapes (shapes, 3);
    [pool drain];
    return (0);
}