DESCRIPTION = "Runtime libraries from MinGW-w64 project"

require mingw-w64.inc

S = "${WORKDIR}/mingw-w64-v${PV}/mingw-w64-crt"
B = "${WORKDIR}/build-${TARGET_SYS}"

inherit autotools nativesdk

BUILDSDK_CPPFLAGS_append = " -isystem${STAGING_INCDIR}"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "nativesdk-mingw-w64-headers virtual/${TARGET_PREFIX}gcc-initial "

PROVIDES += "virtual/nativesdk-libc"
PROVIDES += "virtual/nativesdk-${SDK_PREFIX}libc-initial"
PROVIDES += "virtual/nativesdk-${SDK_PREFIX}libc-for-gcc"

# Work around pulling in eglibc for now...
PROVIDES += "virtual/nativesdk-libintl"

STAGINGCC = "gcc-cross-initial-${TARGET_ARCH}"
STAGINGCC_class-nativesdk = "gcc-crosssdk-initial-${SDK_SYS}"
TOOLCHAIN_OPTIONS = " --sysroot=${STAGING_DIR_TARGET}"
PATH_prepend = "${STAGING_BINDIR_TOOLCHAIN}.${STAGINGCC}:"

do_configure() {
    oe_runconf
}

FILES_${PN} += "${exec_prefix}/libsrc"

