package com.applicationregisteration.fx.byezbercime;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticationManager {

    public boolean isEmailAuthentication() {
        boolean result = false;

        return result;
    }

    public boolean isIllegalCharacter(String infoValue) {
        boolean result = false;

        StringBuilder textInfo = new StringBuilder();
        String legalCharacters = "zxcvbnmilkjhgfdsaqwertyuop0_987654321ZXCVBNMLKJHGFDSAQWERTYUIOP";
        String[] legalCharactersSplits = legalCharacters.split("");
        List<String> illegals = Arrays.stream(legalCharactersSplits).collect(Collectors.toList());

        String[] textSplits = infoValue.split("");

        for (int s = 0; s < textSplits.length; s++) {
            String value =  textSplits[s];
            if (isCharacter(illegals,value)) {
                textInfo.append(value);
            } else {
                break;
            }
        }

        String infoStr =  textInfo.toString();

        if (infoStr.equals(infoValue)) {
            result = true;
        }
        return result;
    }

    private boolean isCharacter(List<String> s,String value) {
        boolean result = false;

        if (!s.isEmpty() && !value.isEmpty()) {
            for (String v : s) {
                if (v.equals(value)) {
                    result = true;
                }
            }
        }

        return result;
    }

    public boolean isOverloadCooldownData(long nowDate, long beforeDate) {
        boolean result = false;
        if (nowDate > beforeDate) {
            result = true;
        }
        return result;
    }

}
