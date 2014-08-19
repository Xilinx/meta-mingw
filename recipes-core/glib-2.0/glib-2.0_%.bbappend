EXTRA_OECONF_mingw32 = "--enable-included-printf=yes ${CORECONF}"
FILES_${PN}_append_mingw32 = " ${libdir}/charset.alias ${libdir}/gthread-2.0.def"
