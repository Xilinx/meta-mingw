EXTRA_OECONF_mingw32 = "--enable-included-printf=yes ${CORECONF}"
FILES_${PN}_append_mingw32 = " ${libdir}/charset.alias ${libdir}/gthread-2.0.def"

# glib always provides bash-completion output, package the output but prevent
# the dependency chain on bash (via bash-completion) for mingw32 targets only.
RDEPENDS_${PN}-bash-completion_remove_mingw32 = "bash-completion"
