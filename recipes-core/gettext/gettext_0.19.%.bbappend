DEPENDS_append_mingw32 = " pthreads-win32"
LDFLAGS_prepend_mingw32 = " -lpthread "

CFLAGS_append_mingw32 = " -DLIBXML_STATIC"
EXTRA_OECONF_append_mingw32 = " --enable-threads=windows --enable-static --disable-shared "

