DESCRIPTION = "Winpthreads runtime libraries from MinGW-w64 project"

require mingw-w64.inc

SRC_URI += "file://0001-winpthreads-Add-__udivmoddi4.patch;striplevel=3"

S = "${WORKDIR}/mingw-w64-v${PV}/mingw-w64-libraries/winpthreads"
B = "${WORKDIR}/build-${TARGET_SYS}"

inherit autotools nativesdk

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "nativesdk-mingw-w64-runtime virtual/${TARGET_PREFIX}gcc"

do_configure() {
    oe_runconf
}

TOOLCHAIN_OPTIONS = " --sysroot=${STAGING_DIR_TARGET}"

do_install:append() {
    # headers are already installed by mingw-w64-headers
    rm -rf ${D}${includedir}
}
