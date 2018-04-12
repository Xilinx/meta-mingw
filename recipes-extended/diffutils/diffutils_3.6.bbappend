
FILESEXTRAPATHS_prepend_mingw32 := "${THISDIR}/${BPN}:"

SRC_URI_remove_mingw32 = "file://0001-explicitly-disable-replacing-getopt.patch"
SRC_URI_append_mingw32 = " file://sdiff-no-kill.patch"

CACHED_CONFIGUREVARS_append_mingw32 = " ac_cv_header_getopt_h=yes "

# Add some definitions for POSIX signals..
CFLAGS_append_mingw32 = " -DSIGALRM=14 -DSIGHUP=1 -DSIGQUIT=3 -DSIGPIPE=13 -DSIGTSTP=18 -DSIGSTOP=17 "

do_configure_prepend_mingw32 () {
    # Remove building of "man"
    sed -i -e 's:^SUBDIRS = lib src tests doc man po gnulib-test:SUBDIRS = lib src tests doc po gnulib-test:g' ${S}/Makefile.am
}



