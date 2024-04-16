package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class DoubleMetaphone implements StringEncoder {
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", "T", "K", "S", "N", "M", "B", "Z"};
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (charAt(r8, r3) == 'V') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        r1 = r1 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (charAt(r8, r3) == 'Q') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (charAt(r8, r3) == 'N') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
        if (conditionM0(r8, r1) != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        if (charAt(r8, r3) == 'K') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        if (charAt(r8, r3) == 'F') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e2, code lost:
        if (charAt(r8, r3) == 'B') goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doubleMetaphone(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r8 = r7.cleanInput(r8)
            if (r8 != 0) goto L_0x0008
            r8 = 0
            return r8
        L_0x0008:
            boolean r0 = r7.isSlavoGermanic(r8)
            boolean r1 = r7.isSilentStart(r8)
            org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult r2 = new org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult
            int r3 = r7.getMaxCodeLen()
            r2.<init>(r3)
        L_0x0019:
            boolean r3 = r2.isComplete()
            if (r3 != 0) goto L_0x00f9
            int r3 = r8.length()
            int r3 = r3 + -1
            if (r1 > r3) goto L_0x00f9
            char r3 = r8.charAt(r1)
            r4 = 199(0xc7, float:2.79E-43)
            if (r3 == r4) goto L_0x00f0
            r4 = 209(0xd1, float:2.93E-43)
            r5 = 78
            if (r3 == r4) goto L_0x00ec
            r4 = 75
            r6 = 70
            switch(r3) {
                case 65: goto L_0x00e6;
                case 66: goto L_0x00d5;
                case 67: goto L_0x00cf;
                case 68: goto L_0x00c9;
                case 69: goto L_0x00e6;
                case 70: goto L_0x00bd;
                case 71: goto L_0x00b7;
                case 72: goto L_0x00b1;
                case 73: goto L_0x00e6;
                case 74: goto L_0x00ab;
                case 75: goto L_0x009f;
                case 76: goto L_0x0099;
                case 77: goto L_0x008d;
                case 78: goto L_0x0081;
                case 79: goto L_0x00e6;
                case 80: goto L_0x007c;
                case 81: goto L_0x006e;
                case 82: goto L_0x0069;
                case 83: goto L_0x0064;
                case 84: goto L_0x005f;
                case 85: goto L_0x00e6;
                case 86: goto L_0x004d;
                case 87: goto L_0x0048;
                case 88: goto L_0x0043;
                case 89: goto L_0x00e6;
                case 90: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x00f5
        L_0x003e:
            int r1 = r7.handleZ(r8, r2, r1, r0)
            goto L_0x0019
        L_0x0043:
            int r1 = r7.handleX(r8, r2, r1)
            goto L_0x0019
        L_0x0048:
            int r1 = r7.handleW(r8, r2, r1)
            goto L_0x0019
        L_0x004d:
            r2.append((char) r6)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 86
            if (r4 != r5) goto L_0x005d
        L_0x005a:
            int r1 = r1 + 2
            goto L_0x0019
        L_0x005d:
            r1 = r3
            goto L_0x0019
        L_0x005f:
            int r1 = r7.handleT(r8, r2, r1)
            goto L_0x0019
        L_0x0064:
            int r1 = r7.handleS(r8, r2, r1, r0)
            goto L_0x0019
        L_0x0069:
            int r1 = r7.handleR(r8, r2, r1, r0)
            goto L_0x0019
        L_0x006e:
            r2.append((char) r4)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 81
            if (r4 != r5) goto L_0x005d
            goto L_0x005a
        L_0x007c:
            int r1 = r7.handleP(r8, r2, r1)
            goto L_0x0019
        L_0x0081:
            r2.append((char) r5)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            if (r4 != r5) goto L_0x005d
            goto L_0x005a
        L_0x008d:
            r3 = 77
            r2.append((char) r3)
            boolean r3 = r7.conditionM0(r8, r1)
            if (r3 == 0) goto L_0x00f5
            goto L_0x005a
        L_0x0099:
            int r1 = r7.handleL(r8, r2, r1)
            goto L_0x0019
        L_0x009f:
            r2.append((char) r4)
            int r3 = r1 + 1
            char r5 = r7.charAt(r8, r3)
            if (r5 != r4) goto L_0x005d
            goto L_0x005a
        L_0x00ab:
            int r1 = r7.handleJ(r8, r2, r1, r0)
            goto L_0x0019
        L_0x00b1:
            int r1 = r7.handleH(r8, r2, r1)
            goto L_0x0019
        L_0x00b7:
            int r1 = r7.handleG(r8, r2, r1, r0)
            goto L_0x0019
        L_0x00bd:
            r2.append((char) r6)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            if (r4 != r6) goto L_0x005d
            goto L_0x005a
        L_0x00c9:
            int r1 = r7.handleD(r8, r2, r1)
            goto L_0x0019
        L_0x00cf:
            int r1 = r7.handleC(r8, r2, r1)
            goto L_0x0019
        L_0x00d5:
            r3 = 80
            r2.append((char) r3)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 66
            if (r4 != r5) goto L_0x005d
            goto L_0x005a
        L_0x00e6:
            int r1 = r7.handleAEIOUY(r2, r1)
            goto L_0x0019
        L_0x00ec:
            r2.append((char) r5)
            goto L_0x00f5
        L_0x00f0:
            r3 = 83
            r2.append((char) r3)
        L_0x00f5:
            int r1 = r1 + 1
            goto L_0x0019
        L_0x00f9:
            if (r9 == 0) goto L_0x0100
            java.lang.String r8 = r2.getAlternate()
            goto L_0x0104
        L_0x0100:
            java.lang.String r8 = r2.getPrimary()
        L_0x0104:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.doubleMetaphone(java.lang.String, boolean):java.lang.String");
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public String encode(String str) {
        return doubleMetaphone(str);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return StringUtils.equals(doubleMetaphone(str, z), doubleMetaphone(str2, z));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0112, code lost:
        if (contains(r1, r9, 2, "CE", "CI") == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleC(java.lang.String r18, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            boolean r4 = r0.conditionC0(r1, r3)
            r5 = 75
            r6 = 2
            if (r4 == 0) goto L_0x0018
            r2.append((char) r5)
        L_0x0014:
            int r1 = r3 + 2
            goto L_0x0117
        L_0x0018:
            r4 = 83
            r7 = 0
            r8 = 1
            if (r3 != 0) goto L_0x002f
            r9 = 6
            java.lang.String[] r10 = new java.lang.String[r8]
            java.lang.String r11 = "CAESAR"
            r10[r7] = r11
            boolean r9 = contains(r1, r3, r9, r10)
            if (r9 == 0) goto L_0x002f
            r2.append((char) r4)
            goto L_0x0014
        L_0x002f:
            java.lang.String[] r9 = new java.lang.String[r8]
            java.lang.String r10 = "CH"
            r9[r7] = r10
            boolean r9 = contains(r1, r3, r6, r9)
            if (r9 == 0) goto L_0x0041
            int r1 = r17.handleCH(r18, r19, r20)
            goto L_0x0117
        L_0x0041:
            java.lang.String[] r9 = new java.lang.String[r8]
            java.lang.String r10 = "CZ"
            r9[r7] = r10
            boolean r9 = contains(r1, r3, r6, r9)
            r10 = 88
            if (r9 == 0) goto L_0x0062
            int r9 = r3 + -2
            r11 = 4
            java.lang.String[] r12 = new java.lang.String[r8]
            java.lang.String r13 = "WICZ"
            r12[r7] = r13
            boolean r9 = contains(r1, r9, r11, r12)
            if (r9 != 0) goto L_0x0062
            r2.append((char) r4, (char) r10)
            goto L_0x0014
        L_0x0062:
            int r9 = r3 + 1
            java.lang.String[] r11 = new java.lang.String[r8]
            java.lang.String r12 = "CIA"
            r11[r7] = r12
            r13 = 3
            boolean r11 = contains(r1, r9, r13, r11)
            if (r11 == 0) goto L_0x0078
            r2.append((char) r10)
        L_0x0074:
            int r1 = r3 + 3
            goto L_0x0117
        L_0x0078:
            java.lang.String[] r11 = new java.lang.String[r8]
            java.lang.String r14 = "CC"
            r11[r7] = r14
            boolean r11 = contains(r1, r3, r6, r11)
            if (r11 == 0) goto L_0x0093
            if (r3 != r8) goto L_0x008e
            char r11 = r0.charAt(r1, r7)
            r14 = 77
            if (r11 == r14) goto L_0x0093
        L_0x008e:
            int r1 = r17.handleCC(r18, r19, r20)
            return r1
        L_0x0093:
            java.lang.String[] r11 = new java.lang.String[r13]
            java.lang.String r14 = "CK"
            r11[r7] = r14
            java.lang.String r14 = "CG"
            r11[r8] = r14
            java.lang.String r14 = "CQ"
            r11[r6] = r14
            boolean r11 = contains(r1, r3, r6, r11)
            if (r11 == 0) goto L_0x00ac
            r2.append((char) r5)
            goto L_0x0014
        L_0x00ac:
            java.lang.String[] r11 = new java.lang.String[r13]
            java.lang.String r14 = "CI"
            r11[r7] = r14
            java.lang.String r15 = "CE"
            r11[r8] = r15
            java.lang.String r16 = "CY"
            r11[r6] = r16
            boolean r11 = contains(r1, r3, r6, r11)
            if (r11 == 0) goto L_0x00dc
            java.lang.String[] r5 = new java.lang.String[r13]
            java.lang.String r9 = "CIO"
            r5[r7] = r9
            java.lang.String r7 = "CIE"
            r5[r8] = r7
            r5[r6] = r12
            boolean r1 = contains(r1, r3, r13, r5)
            if (r1 == 0) goto L_0x00d7
            r2.append((char) r4, (char) r10)
            goto L_0x0014
        L_0x00d7:
            r2.append((char) r4)
            goto L_0x0014
        L_0x00dc:
            r2.append((char) r5)
            java.lang.String[] r2 = new java.lang.String[r13]
            java.lang.String r4 = " C"
            r2[r7] = r4
            java.lang.String r4 = " Q"
            r2[r8] = r4
            java.lang.String r4 = " G"
            r2[r6] = r4
            boolean r2 = contains(r1, r9, r6, r2)
            if (r2 == 0) goto L_0x00f4
            goto L_0x0074
        L_0x00f4:
            java.lang.String[] r2 = new java.lang.String[r13]
            java.lang.String r4 = "C"
            r2[r7] = r4
            java.lang.String r4 = "K"
            r2[r8] = r4
            java.lang.String r4 = "Q"
            r2[r6] = r4
            boolean r2 = contains(r1, r9, r8, r2)
            if (r2 == 0) goto L_0x0116
            java.lang.String[] r2 = new java.lang.String[r6]
            r2[r7] = r15
            r2[r8] = r14
            boolean r1 = contains(r1, r9, r6, r2)
            if (r1 != 0) goto L_0x0116
            goto L_0x0014
        L_0x0116:
            r1 = r9
        L_0x0117:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleC(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (contains(str, i2, 1, "I", "E", "H")) {
            if (!contains(str, i2, 2, "HU")) {
                if (!(i == 1 && charAt(str, i - 1) == 'A')) {
                    if (!contains(str, i - 1, 5, "UCCEE", "UCCES")) {
                        doubleMetaphoneResult.append('X');
                        return i + 3;
                    }
                }
                doubleMetaphoneResult.append("KS");
                return i + 3;
            }
        }
        doubleMetaphoneResult.append('K');
        return i2;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0) {
            if (contains(str, i, 4, "CHAE")) {
                doubleMetaphoneResult.append('K', 'X');
                return i + 2;
            }
        }
        if (conditionCH0(str, i)) {
            doubleMetaphoneResult.append('K');
        } else if (conditionCH1(str, i)) {
            doubleMetaphoneResult.append('K');
        } else {
            if (i > 0) {
                if (contains(str, 0, 2, "MC")) {
                    doubleMetaphoneResult.append('K');
                } else {
                    doubleMetaphoneResult.append('X', 'K');
                }
            } else {
                doubleMetaphoneResult.append('X');
            }
            return i + 2;
        }
        return i + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 2, "DG")) {
            int i2 = i + 2;
            if (contains(str, i2, 1, "I", "E", "Y")) {
                doubleMetaphoneResult.append('J');
                return i + 3;
            }
            doubleMetaphoneResult.append("TK");
            return i2;
        }
        if (contains(str, i, 2, "DT", "DD")) {
            doubleMetaphoneResult.append('T');
            return i + 2;
        }
        doubleMetaphoneResult.append('T');
        return i + 1;
    }

    private int handleG(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            return handleGH(str, doubleMetaphoneResult, i);
        }
        if (charAt(str, i2) != 'N') {
            if (contains(str, i2, 2, "LI") && !z) {
                doubleMetaphoneResult.append("KL", "L");
            } else if (i != 0 || (charAt(str, i2) != 'Y' && !contains(str, i2, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
                if (contains(str, i2, 2, "ER") || charAt(str, i2) == 'Y') {
                    if (!contains(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                        int i3 = i - 1;
                        if (!contains(str, i3, 1, "E", "I")) {
                            if (!contains(str, i3, 3, "RGY", "OGY")) {
                                doubleMetaphoneResult.append('K', 'J');
                            }
                        }
                    }
                }
                if (!contains(str, i2, 1, "E", "I", "Y")) {
                    if (!contains(str, i - 1, 4, "AGGI", "OGGI")) {
                        if (charAt(str, i2) == 'G') {
                            int i4 = i + 2;
                            doubleMetaphoneResult.append('K');
                            return i4;
                        }
                        doubleMetaphoneResult.append('K');
                        return i2;
                    }
                }
                if (!contains(str, 0, 4, "VAN ", "VON ")) {
                    if (!contains(str, 0, 3, "SCH")) {
                        if (!contains(str, i2, 2, "ET")) {
                            if (contains(str, i2, 3, "IER")) {
                                doubleMetaphoneResult.append('J');
                            } else {
                                doubleMetaphoneResult.append('J', 'K');
                            }
                        }
                    }
                }
                doubleMetaphoneResult.append('K');
            } else {
                doubleMetaphoneResult.append('K', 'J');
            }
        } else if (i != 1 || !isVowel(charAt(str, 0)) || z) {
            if (contains(str, i + 2, 2, "EY") || charAt(str, i2) == 'Y' || z) {
                doubleMetaphoneResult.append("KN");
            } else {
                doubleMetaphoneResult.append("N", "KN");
            }
        } else {
            doubleMetaphoneResult.append("KN", "N");
        }
        return i + 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (contains(r12, r14 - 2, 1, "B", "H", "D") == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (contains(r12, r14 - 3, 1, "B", "H", "D") == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        if (contains(r12, r14 - 4, 1, "B", "H") != false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleGH(java.lang.String r12, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r13, int r14) {
        /*
            r11 = this;
            r0 = 75
            r1 = 2
            if (r14 <= 0) goto L_0x0017
            int r2 = r14 + -1
            char r2 = r11.charAt(r12, r2)
            boolean r2 = r11.isVowel(r2)
            if (r2 != 0) goto L_0x0017
            r13.append((char) r0)
        L_0x0014:
            int r14 = r14 + r1
            goto L_0x00ae
        L_0x0017:
            r2 = 73
            if (r14 != 0) goto L_0x002e
            int r14 = r14 + r1
            char r12 = r11.charAt(r12, r14)
            if (r12 != r2) goto L_0x0029
            r12 = 74
            r13.append((char) r12)
            goto L_0x00ae
        L_0x0029:
            r13.append((char) r0)
            goto L_0x00ae
        L_0x002e:
            java.lang.String r3 = "D"
            java.lang.String r4 = "H"
            java.lang.String r5 = "B"
            r6 = 0
            r7 = 3
            r8 = 1
            if (r14 <= r8) goto L_0x0049
            int r9 = r14 + -2
            java.lang.String[] r10 = new java.lang.String[r7]
            r10[r6] = r5
            r10[r8] = r4
            r10[r1] = r3
            boolean r9 = contains(r12, r9, r8, r10)
            if (r9 != 0) goto L_0x0014
        L_0x0049:
            if (r14 <= r1) goto L_0x005b
            int r9 = r14 + -3
            java.lang.String[] r10 = new java.lang.String[r7]
            r10[r6] = r5
            r10[r8] = r4
            r10[r1] = r3
            boolean r3 = contains(r12, r9, r8, r10)
            if (r3 != 0) goto L_0x0014
        L_0x005b:
            if (r14 <= r7) goto L_0x006c
            int r3 = r14 + -4
            java.lang.String[] r9 = new java.lang.String[r1]
            r9[r6] = r5
            r9[r8] = r4
            boolean r3 = contains(r12, r3, r8, r9)
            if (r3 == 0) goto L_0x006c
            goto L_0x0014
        L_0x006c:
            if (r14 <= r1) goto L_0x009f
            int r3 = r14 + -1
            char r3 = r11.charAt(r12, r3)
            r4 = 85
            if (r3 != r4) goto L_0x009f
            int r3 = r14 + -3
            r4 = 5
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.String r5 = "C"
            r4[r6] = r5
            java.lang.String r5 = "G"
            r4[r8] = r5
            java.lang.String r5 = "L"
            r4[r1] = r5
            java.lang.String r5 = "R"
            r4[r7] = r5
            java.lang.String r5 = "T"
            r6 = 4
            r4[r6] = r5
            boolean r3 = contains(r12, r3, r8, r4)
            if (r3 == 0) goto L_0x009f
            r12 = 70
            r13.append((char) r12)
            goto L_0x0014
        L_0x009f:
            if (r14 <= 0) goto L_0x0014
            int r3 = r14 + -1
            char r12 = r11.charAt(r12, r3)
            if (r12 == r2) goto L_0x0014
            r13.append((char) r0)
            goto L_0x0014
        L_0x00ae:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleGH(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if ((i != 0 && !isVowel(charAt(str, i - 1))) || !isVowel(charAt(str, i + 1))) {
            return i + 1;
        }
        doubleMetaphoneResult.append('H');
        return i + 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleJ(java.lang.String r11, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r12, int r13, boolean r14) {
        /*
            r10 = this;
            r0 = 1
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r2 = "JOSE"
            r3 = 0
            r1[r3] = r2
            r4 = 4
            boolean r1 = contains(r11, r13, r4, r1)
            r5 = 32
            java.lang.String r6 = "SAN "
            r7 = 72
            r8 = 74
            if (r1 != 0) goto L_0x0090
            java.lang.String[] r1 = new java.lang.String[r0]
            r1[r3] = r6
            boolean r1 = contains(r11, r3, r4, r1)
            if (r1 == 0) goto L_0x0023
            goto L_0x0090
        L_0x0023:
            r1 = 2
            r6 = 65
            if (r13 != 0) goto L_0x0036
            java.lang.String[] r9 = new java.lang.String[r0]
            r9[r3] = r2
            boolean r2 = contains(r11, r13, r4, r9)
            if (r2 != 0) goto L_0x0036
            r12.append((char) r8, (char) r6)
            goto L_0x0085
        L_0x0036:
            int r2 = r13 + -1
            char r4 = r10.charAt(r11, r2)
            boolean r4 = r10.isVowel(r4)
            if (r4 == 0) goto L_0x0058
            if (r14 != 0) goto L_0x0058
            int r14 = r13 + 1
            char r4 = r10.charAt(r11, r14)
            if (r4 == r6) goto L_0x0054
            char r14 = r10.charAt(r11, r14)
            r4 = 79
            if (r14 != r4) goto L_0x0058
        L_0x0054:
            r12.append((char) r8, (char) r7)
            goto L_0x0085
        L_0x0058:
            int r14 = r11.length()
            int r14 = r14 - r0
            if (r13 != r14) goto L_0x0063
            r12.append((char) r8, (char) r5)
            goto L_0x0085
        L_0x0063:
            int r14 = r13 + 1
            java.lang.String[] r4 = L_T_K_S_N_M_B_Z
            boolean r14 = contains(r11, r14, r0, r4)
            if (r14 != 0) goto L_0x0085
            r14 = 3
            java.lang.String[] r14 = new java.lang.String[r14]
            java.lang.String r4 = "S"
            r14[r3] = r4
            java.lang.String r3 = "K"
            r14[r0] = r3
            java.lang.String r3 = "L"
            r14[r1] = r3
            boolean r14 = contains(r11, r2, r0, r14)
            if (r14 != 0) goto L_0x0085
            r12.append((char) r8)
        L_0x0085:
            int r12 = r13 + 1
            char r11 = r10.charAt(r11, r12)
            if (r11 != r8) goto L_0x00b4
            int r12 = r13 + 2
            goto L_0x00b4
        L_0x0090:
            if (r13 != 0) goto L_0x009a
            int r14 = r13 + 4
            char r14 = r10.charAt(r11, r14)
            if (r14 == r5) goto L_0x00af
        L_0x009a:
            int r14 = r11.length()
            if (r14 == r4) goto L_0x00af
            java.lang.String[] r14 = new java.lang.String[r0]
            r14[r3] = r6
            boolean r11 = contains(r11, r3, r4, r14)
            if (r11 == 0) goto L_0x00ab
            goto L_0x00af
        L_0x00ab:
            r12.append((char) r8, (char) r7)
            goto L_0x00b2
        L_0x00af:
            r12.append((char) r7)
        L_0x00b2:
            int r12 = r13 + 1
        L_0x00b4:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleJ(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'L') {
            if (conditionL0(str, i)) {
                doubleMetaphoneResult.appendPrimary('L');
            } else {
                doubleMetaphoneResult.append('L');
            }
            return i + 2;
        }
        doubleMetaphoneResult.append('L');
        return i2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('F');
            return i + 2;
        }
        doubleMetaphoneResult.append('P');
        if (contains(str, i2, 1, "P", "B")) {
            i2 = i + 2;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleR(java.lang.String r7, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r8, int r9, boolean r10) {
        /*
            r6 = this;
            int r0 = r7.length()
            r1 = 1
            int r0 = r0 - r1
            r2 = 82
            r3 = 2
            if (r9 != r0) goto L_0x0032
            if (r10 != 0) goto L_0x0032
            int r10 = r9 + -2
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.String r4 = "IE"
            r5 = 0
            r0[r5] = r4
            boolean r10 = contains(r7, r10, r3, r0)
            if (r10 == 0) goto L_0x0032
            int r10 = r9 + -4
            java.lang.String[] r0 = new java.lang.String[r3]
            java.lang.String r4 = "ME"
            r0[r5] = r4
            java.lang.String r4 = "MA"
            r0[r1] = r4
            boolean r10 = contains(r7, r10, r3, r0)
            if (r10 != 0) goto L_0x0032
            r8.appendAlternate((char) r2)
            goto L_0x0035
        L_0x0032:
            r8.append((char) r2)
        L_0x0035:
            int r8 = r9 + 1
            char r7 = r6.charAt(r7, r8)
            if (r7 != r2) goto L_0x003f
            int r8 = r9 + 2
        L_0x003f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleR(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009b, code lost:
        if (contains(r10, r12 + 1, 1, "M", "N", "L", "W") == false) goto L_0x009d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleS(java.lang.String r10, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r11, int r12, boolean r13) {
        /*
            r9 = this;
            int r0 = r12 + -1
            r1 = 2
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.String r3 = "ISL"
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "YSL"
            r5 = 1
            r2[r5] = r3
            r3 = 3
            boolean r0 = contains(r10, r0, r3, r2)
            if (r0 == 0) goto L_0x0019
        L_0x0016:
            int r12 = r12 + r5
            goto L_0x0108
        L_0x0019:
            r0 = 88
            r2 = 83
            if (r12 != 0) goto L_0x0030
            r6 = 5
            java.lang.String[] r7 = new java.lang.String[r5]
            java.lang.String r8 = "SUGAR"
            r7[r4] = r8
            boolean r6 = contains(r10, r12, r6, r7)
            if (r6 == 0) goto L_0x0030
            r11.append((char) r0, (char) r2)
            goto L_0x0016
        L_0x0030:
            java.lang.String[] r6 = new java.lang.String[r5]
            java.lang.String r7 = "SH"
            r6[r4] = r7
            boolean r6 = contains(r10, r12, r1, r6)
            r7 = 4
            if (r6 == 0) goto L_0x0061
            int r13 = r12 + 1
            java.lang.String[] r6 = new java.lang.String[r7]
            java.lang.String r8 = "HEIM"
            r6[r4] = r8
            java.lang.String r4 = "HOEK"
            r6[r5] = r4
            java.lang.String r4 = "HOLM"
            r6[r1] = r4
            java.lang.String r4 = "HOLZ"
            r6[r3] = r4
            boolean r10 = contains(r10, r13, r7, r6)
            if (r10 == 0) goto L_0x005b
            r11.append((char) r2)
            goto L_0x005e
        L_0x005b:
            r11.append((char) r0)
        L_0x005e:
            int r12 = r12 + r1
            goto L_0x0108
        L_0x0061:
            java.lang.String[] r6 = new java.lang.String[r1]
            java.lang.String r8 = "SIO"
            r6[r4] = r8
            java.lang.String r8 = "SIA"
            r6[r5] = r8
            boolean r6 = contains(r10, r12, r3, r6)
            if (r6 != 0) goto L_0x00fe
            java.lang.String[] r6 = new java.lang.String[r5]
            java.lang.String r8 = "SIAN"
            r6[r4] = r8
            boolean r6 = contains(r10, r12, r7, r6)
            if (r6 == 0) goto L_0x007f
            goto L_0x00fe
        L_0x007f:
            java.lang.String r13 = "Z"
            if (r12 != 0) goto L_0x009d
            int r6 = r12 + 1
            java.lang.String[] r7 = new java.lang.String[r7]
            java.lang.String r8 = "M"
            r7[r4] = r8
            java.lang.String r8 = "N"
            r7[r5] = r8
            java.lang.String r8 = "L"
            r7[r1] = r8
            java.lang.String r8 = "W"
            r7[r3] = r8
            boolean r3 = contains(r10, r6, r5, r7)
            if (r3 != 0) goto L_0x00a9
        L_0x009d:
            int r3 = r12 + 1
            java.lang.String[] r6 = new java.lang.String[r5]
            r6[r4] = r13
            boolean r6 = contains(r10, r3, r5, r6)
            if (r6 == 0) goto L_0x00bb
        L_0x00a9:
            r11.append((char) r2, (char) r0)
            int r11 = r12 + 1
            java.lang.String[] r0 = new java.lang.String[r5]
            r0[r4] = r13
            boolean r10 = contains(r10, r11, r5, r0)
            if (r10 == 0) goto L_0x00b9
            goto L_0x005e
        L_0x00b9:
            r12 = r11
            goto L_0x0108
        L_0x00bb:
            java.lang.String[] r0 = new java.lang.String[r5]
            java.lang.String r6 = "SC"
            r0[r4] = r6
            boolean r0 = contains(r10, r12, r1, r0)
            if (r0 == 0) goto L_0x00cc
            int r12 = r9.handleSC(r10, r11, r12)
            goto L_0x0108
        L_0x00cc:
            int r0 = r10.length()
            int r0 = r0 - r5
            if (r12 != r0) goto L_0x00e9
            int r0 = r12 + -2
            java.lang.String[] r6 = new java.lang.String[r1]
            java.lang.String r7 = "AI"
            r6[r4] = r7
            java.lang.String r7 = "OI"
            r6[r5] = r7
            boolean r0 = contains(r10, r0, r1, r6)
            if (r0 == 0) goto L_0x00e9
            r11.appendAlternate((char) r2)
            goto L_0x00ec
        L_0x00e9:
            r11.append((char) r2)
        L_0x00ec:
            java.lang.String[] r11 = new java.lang.String[r1]
            java.lang.String r0 = "S"
            r11[r4] = r0
            r11[r5] = r13
            boolean r10 = contains(r10, r3, r5, r11)
            if (r10 == 0) goto L_0x00fc
            goto L_0x005e
        L_0x00fc:
            r12 = r3
            goto L_0x0108
        L_0x00fe:
            if (r13 == 0) goto L_0x0104
            r11.append((char) r2)
            goto L_0x0107
        L_0x0104:
            r11.append((char) r2, (char) r0)
        L_0x0107:
            int r12 = r12 + r3
        L_0x0108:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleS(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (charAt(str, i2) == 'H') {
            int i3 = i + 3;
            if (contains(str, i3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i3, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X", "SK");
                } else {
                    doubleMetaphoneResult.append("SK");
                }
            } else if (i != 0 || isVowel(charAt(str, 3)) || charAt(str, 3) == 'W') {
                doubleMetaphoneResult.append('X');
            } else {
                doubleMetaphoneResult.append('X', 'S');
            }
        } else {
            if (contains(str, i2, 1, "I", "E", "Y")) {
                doubleMetaphoneResult.append('S');
            } else {
                doubleMetaphoneResult.append("SK");
            }
        }
        return i + 3;
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 4, "TION")) {
            doubleMetaphoneResult.append('X');
        } else {
            if (contains(str, i, 3, "TIA", "TCH")) {
                doubleMetaphoneResult.append('X');
            } else {
                if (!contains(str, i, 2, "TH")) {
                    if (!contains(str, i, 3, "TTH")) {
                        doubleMetaphoneResult.append('T');
                        int i2 = i + 1;
                        return contains(str, i2, 1, "T", "D") ? i + 2 : i2;
                    }
                }
                int i3 = i + 2;
                if (!contains(str, i3, 2, "OM", "AM")) {
                    if (!contains(str, 0, 4, "VAN ", "VON ")) {
                        if (!contains(str, 0, 3, "SCH")) {
                            doubleMetaphoneResult.append('0', 'T');
                            return i3;
                        }
                    }
                }
                doubleMetaphoneResult.append('T');
                return i3;
            }
        }
        return i + 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (contains(r11, r13, 2, "WH") != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleW(java.lang.String r11, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r12, int r13) {
        /*
            r10 = this;
            r0 = 1
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r2 = "WR"
            r3 = 0
            r1[r3] = r2
            r2 = 2
            boolean r1 = contains(r11, r13, r2, r1)
            if (r1 == 0) goto L_0x0017
            r11 = 82
            r12.append((char) r11)
            int r13 = r13 + r2
            goto L_0x00a2
        L_0x0017:
            r1 = 70
            if (r13 != 0) goto L_0x0048
            int r4 = r13 + 1
            char r5 = r10.charAt(r11, r4)
            boolean r5 = r10.isVowel(r5)
            if (r5 != 0) goto L_0x0033
            java.lang.String[] r5 = new java.lang.String[r0]
            java.lang.String r6 = "WH"
            r5[r3] = r6
            boolean r5 = contains(r11, r13, r2, r5)
            if (r5 == 0) goto L_0x0048
        L_0x0033:
            char r11 = r10.charAt(r11, r4)
            boolean r11 = r10.isVowel(r11)
            r13 = 65
            if (r11 == 0) goto L_0x0043
            r12.append((char) r13, (char) r1)
            goto L_0x0046
        L_0x0043:
            r12.append((char) r13)
        L_0x0046:
            r13 = r4
            goto L_0x00a2
        L_0x0048:
            int r4 = r11.length()
            int r4 = r4 - r0
            if (r13 != r4) goto L_0x005b
            int r4 = r13 + -1
            char r4 = r10.charAt(r11, r4)
            boolean r4 = r10.isVowel(r4)
            if (r4 != 0) goto L_0x009e
        L_0x005b:
            int r4 = r13 + -1
            r5 = 5
            r6 = 4
            java.lang.String[] r7 = new java.lang.String[r6]
            java.lang.String r8 = "EWSKI"
            r7[r3] = r8
            java.lang.String r8 = "EWSKY"
            r7[r0] = r8
            java.lang.String r8 = "OWSKI"
            r7[r2] = r8
            java.lang.String r8 = "OWSKY"
            r9 = 3
            r7[r9] = r8
            boolean r4 = contains(r11, r4, r5, r7)
            if (r4 != 0) goto L_0x009e
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r5 = "SCH"
            r4[r3] = r5
            boolean r4 = contains(r11, r3, r9, r4)
            if (r4 == 0) goto L_0x0085
            goto L_0x009e
        L_0x0085:
            java.lang.String[] r1 = new java.lang.String[r2]
            java.lang.String r2 = "WICZ"
            r1[r3] = r2
            java.lang.String r2 = "WITZ"
            r1[r0] = r2
            boolean r11 = contains(r11, r13, r6, r1)
            if (r11 == 0) goto L_0x00a1
            java.lang.String r11 = "TS"
            java.lang.String r0 = "FX"
            r12.append((java.lang.String) r11, (java.lang.String) r0)
            int r13 = r13 + r6
            goto L_0x00a2
        L_0x009e:
            r12.appendAlternate((char) r1)
        L_0x00a1:
            int r13 = r13 + r0
        L_0x00a2:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleW(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        if (contains(r7, r9 - 2, 2, "AU", "OU") == false) goto L_0x0038;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleX(java.lang.String r7, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r8, int r9) {
        /*
            r6 = this;
            r0 = 1
            if (r9 != 0) goto L_0x000a
            r7 = 83
            r8.append((char) r7)
            int r9 = r9 + r0
            goto L_0x0052
        L_0x000a:
            int r1 = r7.length()
            int r1 = r1 - r0
            r2 = 0
            r3 = 2
            if (r9 != r1) goto L_0x0038
            int r1 = r9 + -3
            java.lang.String[] r4 = new java.lang.String[r3]
            java.lang.String r5 = "IAU"
            r4[r2] = r5
            java.lang.String r5 = "EAU"
            r4[r0] = r5
            r5 = 3
            boolean r1 = contains(r7, r1, r5, r4)
            if (r1 != 0) goto L_0x003d
            int r1 = r9 + -2
            java.lang.String[] r4 = new java.lang.String[r3]
            java.lang.String r5 = "AU"
            r4[r2] = r5
            java.lang.String r5 = "OU"
            r4[r0] = r5
            boolean r1 = contains(r7, r1, r3, r4)
            if (r1 != 0) goto L_0x003d
        L_0x0038:
            java.lang.String r1 = "KS"
            r8.append((java.lang.String) r1)
        L_0x003d:
            int r8 = r9 + 1
            java.lang.String[] r1 = new java.lang.String[r3]
            java.lang.String r4 = "C"
            r1[r2] = r4
            java.lang.String r2 = "X"
            r1[r0] = r2
            boolean r7 = contains(r7, r8, r0, r1)
            if (r7 == 0) goto L_0x0051
            int r9 = r9 + r3
            goto L_0x0052
        L_0x0051:
            r9 = r8
        L_0x0052:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleX(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('J');
            return i + 2;
        }
        if (contains(str, i2, 2, "ZO", "ZI", "ZA") || (z && i > 0 && charAt(str, i - 1) != 'T')) {
            doubleMetaphoneResult.append("S", "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        if (charAt(str, i2) == 'Z') {
            i2 = i + 2;
        }
        return i2;
    }

    private boolean conditionC0(String str, int i) {
        if (contains(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int i2 = i - 2;
        if (isVowel(charAt(str, i2))) {
            return false;
        }
        if (!contains(str, i - 1, 3, "ACH")) {
            return false;
        }
        char charAt = charAt(str, i + 2);
        if (charAt != 'I' && charAt != 'E') {
            return true;
        }
        if (contains(str, i2, 6, "BACHER", "MACHER")) {
            return true;
        }
        return false;
    }

    private boolean conditionCH0(String str, int i) {
        if (i != 0) {
            return false;
        }
        int i2 = i + 1;
        if (!contains(str, i2, 5, "HARAC", "HARIS")) {
            if (!contains(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) {
                return false;
            }
        }
        return !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int i) {
        if (!contains(str, 0, 4, "VAN ", "VON ")) {
            if (!contains(str, 0, 3, "SCH")) {
                if (!contains(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
                    int i2 = i + 2;
                    if (!contains(str, i2, 1, "T", "S")) {
                        if (!contains(str, i - 1, 1, "A", "O", "U", "E") && i != 0) {
                            return false;
                        }
                        if (contains(str, i2, 1, L_R_N_M_B_H_F_V_W_SPACE) || i + 1 == str.length() - 1) {
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004b, code lost:
        if (contains(r9, r9.length() - 1, 1, "A", "O") != false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean conditionL0(java.lang.String r9, int r10) {
        /*
            r8 = this;
            int r0 = r9.length()
            r1 = 3
            int r0 = r0 - r1
            java.lang.String r2 = "ALLE"
            r3 = 4
            r4 = 0
            r5 = 2
            r6 = 1
            if (r10 != r0) goto L_0x0023
            int r0 = r10 + -1
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r7 = "ILLO"
            r1[r4] = r7
            java.lang.String r7 = "ILLA"
            r1[r6] = r7
            r1[r5] = r2
            boolean r0 = contains(r9, r0, r3, r1)
            if (r0 == 0) goto L_0x0023
            return r6
        L_0x0023:
            int r0 = r9.length()
            int r0 = r0 - r5
            java.lang.String[] r1 = new java.lang.String[r5]
            java.lang.String r7 = "AS"
            r1[r4] = r7
            java.lang.String r7 = "OS"
            r1[r6] = r7
            boolean r0 = contains(r9, r0, r5, r1)
            if (r0 != 0) goto L_0x004d
            int r0 = r9.length()
            int r0 = r0 - r6
            java.lang.String[] r1 = new java.lang.String[r5]
            java.lang.String r5 = "A"
            r1[r4] = r5
            java.lang.String r5 = "O"
            r1[r6] = r5
            boolean r0 = contains(r9, r0, r6, r1)
            if (r0 == 0) goto L_0x0059
        L_0x004d:
            int r10 = r10 - r6
            java.lang.String[] r0 = new java.lang.String[r6]
            r0[r4] = r2
            boolean r9 = contains(r9, r10, r3, r0)
            if (r9 == 0) goto L_0x0059
            return r6
        L_0x0059:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.conditionL0(java.lang.String, int):boolean");
    }

    private boolean conditionM0(String str, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'M') {
            return true;
        }
        if (contains(str, i - 1, 3, "UMB")) {
            if (i2 == str.length() - 1) {
                return true;
            }
            if (contains(str, i + 2, 2, "ER")) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }

    private boolean isSilentStart(String str) {
        for (String startsWith : SILENT_START) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: protected */
    public char charAt(String str, int i) {
        if (i < 0 || i >= str.length()) {
            return 0;
        }
        return str.charAt(i);
    }

    protected static boolean contains(String str, int i, int i2, String... strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        String substring = str.substring(i, i3);
        for (String equals : strArr) {
            if (substring.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public class DoubleMetaphoneResult {
        private final StringBuilder alternate = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
        private final int maxLength;
        private final StringBuilder primary = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());

        public DoubleMetaphoneResult(int i) {
            this.maxLength = i;
        }

        public void append(char c) {
            appendPrimary(c);
            appendAlternate(c);
        }

        public void append(char c, char c2) {
            appendPrimary(c);
            appendAlternate(c2);
        }

        public void appendPrimary(char c) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c);
            }
        }

        public void appendAlternate(char c) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c);
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }
    }
}
