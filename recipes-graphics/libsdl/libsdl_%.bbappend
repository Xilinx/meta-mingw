# Disable default x11 support
PACKAGECONFIG_class-nativesdk_mingw32 = ""

# Configs that only apply to Windows/MinGW
PACKAGECONFIG[stdio-redirect] = "--enable-stdio-redirect,--disable-stdio-redirect"
PACKAGECONFIG[directx] = "--enable-directx,--disable-directx"

