#import <Foundation/Foundation.h>

typedef NS_ENUM(NSUInteger, State) {
    Disconnected,
    Connecting,
    Connected,
};

typedef NS_OPTIONS(NSUInteger, Has) {
    None = 0,
    a    = 1 << 0,
    b    = 1 << 1,
    c    = 1 << 2,
};

int main (int argc, const char *argv[])
{
    @autoreleasepool
    {
        State state = Disconnected;
        switch (state) {
            case Disconnected:
                NSLog (@"Disconnected!");
                break;
            case Connecting:
                NSLog (@"Connecting!");
                break;
            case Connected:
                NSLog (@"Connected!");
                break;
        }
        Has has = a | b;
        if (has & a)
        {
            NSLog (@"has a!");
        }
        if (has & c)
        {
            NSLog (@"has c!");
        } else {
            NSLog (@"no c!");
        }
    }
    return (0);
}