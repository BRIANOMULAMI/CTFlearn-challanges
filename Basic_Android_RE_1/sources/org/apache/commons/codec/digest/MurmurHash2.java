package org.apache.commons.codec.digest;

import org.apache.commons.codec.binary.StringUtils;

public final class MurmurHash2 {
    private static final int M32 = 1540483477;
    private static final long M64 = -4132994306676758123L;
    private static final int R32 = 24;
    private static final int R64 = 47;

    private MurmurHash2() {
    }

    public static int hash32(byte[] bArr, int i, int i2) {
        int i3 = i2 ^ i;
        int i4 = i >> 2;
        for (int i5 = 0; i5 < i4; i5++) {
            int littleEndianInt = getLittleEndianInt(bArr, i5 << 2) * M32;
            i3 = (i3 * M32) ^ ((littleEndianInt ^ (littleEndianInt >>> 24)) * M32);
        }
        int i6 = i4 << 2;
        int i7 = i - i6;
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 == 3) {
                    i3 ^= (bArr[i6 + 2] & 255) << 16;
                }
                int i8 = ((i3 >>> 13) ^ i3) * M32;
                return i8 ^ (i8 >>> 15);
            }
            i3 ^= (bArr[i6 + 1] & 255) << 8;
        }
        i3 = ((bArr[i6] & 255) ^ i3) * M32;
        int i82 = ((i3 >>> 13) ^ i3) * M32;
        return i82 ^ (i82 >>> 15);
    }

    public static int hash32(byte[] bArr, int i) {
        return hash32(bArr, i, -1756908916);
    }

    public static int hash32(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash32(bytesUtf8, bytesUtf8.length);
    }

    public static int hash32(String str, int i, int i2) {
        return hash32(str.substring(i, i2 + i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005b, code lost:
        r0 = r0 ^ ((((long) r10[r12 + 2]) & 255) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
        r0 = r0 ^ ((((long) r10[r12 + 1]) & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006f, code lost:
        r0 = ((((long) r10[r12]) & 255) ^ r0) * M64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
        r10 = ((r0 >>> 47) ^ r0) * M64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007e, code lost:
        return r10 ^ (r10 >>> 47);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        r0 = r0 ^ ((((long) r10[r12 + 5]) & 255) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0047, code lost:
        r0 = r0 ^ ((((long) r10[r12 + 4]) & 255) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0051, code lost:
        r0 = r0 ^ ((((long) r10[r12 + 3]) & 255) << 24);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long hash64(byte[] r10, int r11, int r12) {
        /*
            long r0 = (long) r12
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r0 = r0 & r2
            long r2 = (long) r11
            r4 = -4132994306676758123(0xc6a4a7935bd1e995, double:-2.0946245025644615E32)
            long r2 = r2 * r4
            long r0 = r0 ^ r2
            int r12 = r11 >> 3
            r2 = 0
        L_0x0013:
            r3 = 47
            if (r2 >= r12) goto L_0x002a
            int r6 = r2 << 3
            long r6 = getLittleEndianLong(r10, r6)
            long r6 = r6 * r4
            long r8 = r6 >>> r3
            long r6 = r6 ^ r8
            long r6 = r6 * r4
            long r0 = r0 ^ r6
            long r0 = r0 * r4
            int r2 = r2 + 1
            goto L_0x0013
        L_0x002a:
            int r12 = r12 << 3
            int r11 = r11 - r12
            r6 = 255(0xff, double:1.26E-321)
            switch(r11) {
                case 1: goto L_0x006f;
                case 2: goto L_0x0065;
                case 3: goto L_0x005b;
                case 4: goto L_0x0051;
                case 5: goto L_0x0047;
                case 6: goto L_0x003d;
                case 7: goto L_0x0033;
                default: goto L_0x0032;
            }
        L_0x0032:
            goto L_0x0076
        L_0x0033:
            int r11 = r12 + 6
            byte r11 = r10[r11]
            long r8 = (long) r11
            long r8 = r8 & r6
            r11 = 48
            long r8 = r8 << r11
            long r0 = r0 ^ r8
        L_0x003d:
            int r11 = r12 + 5
            byte r11 = r10[r11]
            long r8 = (long) r11
            long r8 = r8 & r6
            r11 = 40
            long r8 = r8 << r11
            long r0 = r0 ^ r8
        L_0x0047:
            int r11 = r12 + 4
            byte r11 = r10[r11]
            long r8 = (long) r11
            long r8 = r8 & r6
            r11 = 32
            long r8 = r8 << r11
            long r0 = r0 ^ r8
        L_0x0051:
            int r11 = r12 + 3
            byte r11 = r10[r11]
            long r8 = (long) r11
            long r8 = r8 & r6
            r11 = 24
            long r8 = r8 << r11
            long r0 = r0 ^ r8
        L_0x005b:
            int r11 = r12 + 2
            byte r11 = r10[r11]
            long r8 = (long) r11
            long r8 = r8 & r6
            r11 = 16
            long r8 = r8 << r11
            long r0 = r0 ^ r8
        L_0x0065:
            int r11 = r12 + 1
            byte r11 = r10[r11]
            long r8 = (long) r11
            long r8 = r8 & r6
            r11 = 8
            long r8 = r8 << r11
            long r0 = r0 ^ r8
        L_0x006f:
            byte r10 = r10[r12]
            long r10 = (long) r10
            long r10 = r10 & r6
            long r10 = r10 ^ r0
            long r0 = r10 * r4
        L_0x0076:
            long r10 = r0 >>> r3
            long r10 = r10 ^ r0
            long r10 = r10 * r4
            long r0 = r10 >>> r3
            long r10 = r10 ^ r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest.MurmurHash2.hash64(byte[], int, int):long");
    }

    public static long hash64(byte[] bArr, int i) {
        return hash64(bArr, i, -512093083);
    }

    public static long hash64(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash64(bytesUtf8, bytesUtf8.length);
    }

    public static long hash64(String str, int i, int i2) {
        return hash64(str.substring(i, i2 + i));
    }

    private static int getLittleEndianInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static long getLittleEndianLong(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
