do_install_append_class-nativesdk_mingw32() {
    install -d ${D}${SDKPATHNATIVE}/environment-setup.d

    cat <<EOF > ${D}${SDKPATHNATIVE}/environment-setup.d/go.bat
set GOROOT=%OECORE_NATIVE_SYSROOT%\\usr\\lib\\${BPN}
EOF
}

FILES_${PN}_append_class-nativesdk_mingw32 = " ${SDKPATHNATIVE}/environment-setup.d"
