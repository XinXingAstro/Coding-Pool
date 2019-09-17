class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        char[] chr = s.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            switch(chr[i]) {
                case 'I' :
                    ans += 1; break;
                case 'V' :
                    ans += 5; break;
                case 'X' :
                    ans += 10; break;
                case 'L' :
                    ans += 50; break;
                case 'C' :
                    ans += 100; break;
                case 'D' :
                    ans += 500; break;
                case 'M' :
                    ans += 1000; break;
            }
        }
        if (s.indexOf("IV") != -1) ans -= 2;
        if (s.indexOf("IX") != -1) ans -= 2;
        if (s.indexOf("XL") != -1) ans -= 20;
        if (s.indexOf("XC") != -1) ans -= 20;
        if (s.indexOf("CD") != -1) ans -= 200;
        if (s.indexOf("CM") != -1) ans -= 200;
        return ans;
    }
}