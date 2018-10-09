package gregtech.api.objects;

/**
 * Color container for anything dealing with colors
 */
public class IColorModulationContainer {
    private short[] mRGBA = new short[4];

    public IColorModulationContainer() {
        setRGBA(255, 255, 255, 0);
    }

    public IColorModulationContainer(short[] aRGBA) {
        setRGBA(aRGBA);
    }

    public IColorModulationContainer(short aR, short aG, short aB, short aA) {
        setRGBA(aR, aG, aB, aA);
    }

    public IColorModulationContainer(short aR, short aG, short aB) {
        setRGBA(aR, aG, aB, 0);
    }

    public IColorModulationContainer(int aR, int aG, int aB, int aA) {
        setRGBA(aR, aG, aB, aA);
    }

    public IColorModulationContainer(int aR, int aG, int aB) {
        setRGBA(aR,  aG, aB, 0);
    }

    public IColorModulationContainer(int aARGB) {
        setARGB(aARGB);
    }

    /**
     * Gets Red, Green, Blue, Alpha as a short array
     * @return RGBA short array
     */
    public short[] getRGBA() {
        return mRGBA;
    }

    /**
     * Sets the color from an RGBA short array
     * @param aRGBA short array
     */
    public void setRGBA(short[] aRGBA) {
        mRGBA = aRGBA;
    }
    public void setRGBA(short aR, short aG, short aB, short aA) {
        this.mRGBA = new short[]{aR, aG, aB, aA};
    }
    public void setRGBA(int aR, int aG, int aB, int aA) {
        setRGBA((short)aR, (short)aG , (short)aB, (short) aA);
    }

    /**
     * Gets the Alpha, Red, Green, Blue color as an int
     * @return int ARGB, example: 0x00ff8020
     *         Alpha = 0x0
     *         Red = 0xff
     *         Green = 0x80
     *         Blue = 0x20
     */
    public int getARGB() {
        return ((mRGBA[3] & 0xff) << 24 |
                (mRGBA[0] & 0xff) << 16 |
                (mRGBA[1] & 0xff) << 8 |
                (mRGBA[2] & 0xff));
    }

    public short getRed() {
        return mRGBA[0];
    }

    public void setRed(short aRed) {
        mRGBA[0] = aRed;
    }

    public short getGreen() {
        return mRGBA[1];
    }

    public void setGreen(short aGreen) {
        mRGBA[1] = aGreen;
    }

    public short getBlue() {
        return mRGBA[2];
    }

    public void setBlue(short aBlue) {
        mRGBA[2] = aBlue;
    }

    public void setAlpha(short aAlpha) {
        mRGBA[3] = aAlpha;
    }

    public short getAlpha() {
        return mRGBA[3];
    }

    /**
     * Sets the color from an ARGB int
     * @param aARGB ARGB int, example:
     * <code>
     * <pre>
     * setARGB(0x00ff8020)
     * </pre>
     * </code>
     */
    public void setARGB(int aARGB) {
        mRGBA[0] = (short)((aARGB >> 16) & 0xff); // Red
        mRGBA[1] = (short)((aARGB >> 8) & 0xff);  // Green
        mRGBA[2] = (short)((aARGB) & 0xff); // Blue
        mRGBA[3] = (short)((aARGB >> 24) & 0xff); // Alpha
    }

}