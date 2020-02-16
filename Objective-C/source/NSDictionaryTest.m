#import <Foundation/Foundation.h>

int main (int argc, const char *argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    
    NSDictionary *map = [NSDictionary dictionaryWithObjectsAndKeys: @"a", @"b", nil];
    NSLog ([map objectForKey: @"b"]);
    // NSLog ([map[@"b"]]);

    NSMutableDictionary *map1 = [NSMutableDictionary dictionary];
    [map1 setObject: @"a" forKey: @"b"]; 
    NSLog ([map1 objectForKey: @"b"]);

    [pool drain];
    return (0);
}