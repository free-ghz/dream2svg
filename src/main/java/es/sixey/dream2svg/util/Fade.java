package es.sixey.dream2svg.util;
import java.util.StringJoiner;

public class Fade {
    public static void main(String[] x) {
        String a = "aaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa\naaaaaaaaaaaaa";
        String b = "zzzzzzzzzzzzz\nyyyyyyyyyyyyy\nfffffffffffff\njjjjjjjjjjjjj\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx\nxxxxxxxxxxxxx";
        var fader = new Fade();
        System.out.println(fader.fadeBetween(a, b));
    }

    public String fadeBetween(String a, String b) {
        var aArr = a.split("\n");
        var bArr = b.split("\n");
        var height = aArr.length;
        var fadeDistance = Math.min(aArr.length, bArr.length);
        var bOffset = height - bArr.length;
        var accumulator = new StringJoiner("\n");
        accumulator.add(aArr[0]);

        for (int i = 1, rowsOfB = 0; i < height-1; i++) {
            var aRow = aArr[i];
            if (i-bOffset <= 0) {
                accumulator.add(aRow);
                continue;
            }
            var bRow = bArr[i-bOffset];
            rowsOfB += 1;
            double fractionOfBToUse = rowsOfB/(double)fadeDistance;
            var lineWidth = Math.max(aRow.length(), bRow.length());
            String stitchedRow = "";
            for (int j = 0; j < lineWidth; j++) {
                if (j < aRow.length() && j < bRow.length()) {
                    // choice
                    if (Math.random() > fractionOfBToUse) {
                        stitchedRow += aRow.charAt(j);
                    } else {
                        stitchedRow += bRow.charAt(j);
                    }
                } else if (j < aRow.length()) {
                    stitchedRow += aRow.charAt(j);
                } else {
                    stitchedRow += bRow.charAt(j);
                }
            }
            accumulator.add(stitchedRow);
        }
        accumulator.add(bArr[bArr.length - 1]);

        return accumulator.toString();
    }
}
