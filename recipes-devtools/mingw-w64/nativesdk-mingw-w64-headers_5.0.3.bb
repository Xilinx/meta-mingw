DESCRIPTION = "Header files from the MingGW-w64 project"
LICENSE = "ZPL-2.1"
LIC_FILES_CHKSUM = "file://../COPYING;md5=bb936f0e04d8f1e19ad545100cee9654"

COMPATIBLE_HOST = ".*-mingw.*"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/mingw-w64/mingw-w64/mingw-w64-release/mingw-w64-v${PV}.tar.bz2 \
           file://epsilon.patch \
           file://0001-intrin-impl.h-do-not-define-_xgetbv-for-GCC-8.patch;striplevel=2"

SRC_URI[md5sum] = "5524c20312560cc8683b7d8ee292cb8c"
SRC_URI[sha256sum] = "2a601db99ef579b9be69c775218ad956a24a09d7dabc9ff6c5bd60da9ccc9cb4"

S = "${WORKDIR}/mingw-w64-v${PV}/mingw-w64-headers"
B = "${WORKDIR}/build-${TARGET_SYS}"

inherit autotools nativesdk

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = ""

PACKAGECONFIG ??= "secure-api"

PACKAGECONFIG[secure-api] = "--enable-secure-api,--disable-secure-api"

do_configure() {
	oe_runconf
}

do_compile() {
	:
}

do_install_append() {
    # install correct pthread headers
    install -m 0644 -t ${D}${includedir} ${S}/../mingw-w64-libraries/winpthreads/include/*.h
}

FILES_${PN} += "${exec_prefix}/${TARGET_SYS}"
