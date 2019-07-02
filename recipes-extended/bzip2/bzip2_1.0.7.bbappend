
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_mingw32 = " file://0001-Fix-include-path-separator.patch"
