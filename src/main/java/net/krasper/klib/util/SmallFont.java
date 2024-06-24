package net.krasper.klib.util;


import net.krasper.klib.KLib;

public class SmallFont {

    private KLib core;

    public SmallFont(KLib core) {
        this.core = core;
    }

    public String change(String string) {
        String normalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerNormalAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String smallTextAlphabet = "ᴀʙᴄᴅᴇꜰɢʜɪᴊᴋʟᴍɴᴏᴘǫʀѕᴛᴜᴠᴡxʏᴢ";

        String[] split = string.split("");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            char character = string.charAt(i);

            int index = normalAlphabet.indexOf(character);

            if (index == -1) {
                index = lowerNormalAlphabet.indexOf(character);
            }

            if (index == -1) {
                stringBuilder.append(character);
                continue;
            }

            char smallChar = smallTextAlphabet.charAt(index);

            stringBuilder.append(smallChar);
        }

        return stringBuilder.toString();
    }

}