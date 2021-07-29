
do_configure:append:mingw32 () {
		# don't try to build the other dtc components when installing libs
		sed -i 's/install-lib: all/install-lib: libfdt/g' ${S}/Makefile
}

do_compile:mingw32 () {
		oe_runmake libfdt
}

do_install:mingw32 () {
		oe_runmake install-lib install-includes
}

RDEPENDS:${PN}-misc:remove:mingw32 = "bash"

