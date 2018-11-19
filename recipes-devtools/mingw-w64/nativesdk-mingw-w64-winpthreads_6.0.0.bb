DESCRIPTION = "Winpthreads runtime libraries from MinGW-w64 project"

require mingw-w64.inc

S = "${WORKDIR}/mingw-w64-v${PV}/mingw-w64-libraries/winpthreads"
B = "${WORKDIR}/build-${TARGET_SYS}"

inherit autotools nativesdk

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "nativesdk-mingw-w64-runtime virtual/${TARGET_PREFIX}gcc-initial"

do_configure() {
    oe_runconf
}

STAGINGCC = "gcc-cross-initial-${TARGET_ARCH}"
STAGINGCC_class-nativesdk = "gcc-crosssdk-initial-${SDK_SYS}"
TOOLCHAIN_OPTIONS = " --sysroot=${STAGING_DIR_TARGET}"
PATH_prepend = "${STAGING_BINDIR_TOOLCHAIN}.${STAGINGCC}:"

do_install_append() {
    # headers are already installed by mingw-w64-headers
    rm -rf ${D}${includedir}
}
