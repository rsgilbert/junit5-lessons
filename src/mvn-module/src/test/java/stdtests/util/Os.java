package stdtests.util;

/**
 * Utility enumeration to select one operating system
 */
public enum Os {
    WINDOWS, MAC, LINUX, OTHER;

    public static Os determine() {
        Os out = OTHER;
        String myOs = System.getProperty("os.name");
        if(myOs.contains("win"))
            out = WINDOWS;
        else if(myOs.contains("mac"))
            out = MAC;
        else if(myOs.contains("nux"))
            out = LINUX;
        return out;
    }
}
