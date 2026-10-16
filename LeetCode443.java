
// 443 . String ComPression


class Solution {
    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;

        while(readIndex < chars.length){
            char curentChar = chars[readIndex];

            int count = 0;
            // count duplicate

            while(readIndex < chars.length && curentChar == chars[readIndex]){
                readIndex++;
                count++;
            }
            //ab mere pass current character and uska count dono available hai 
            chars[writeIndex] = curentChar;
            writeIndex++;

            // now insert the count
            if(count > 1){
                String countStr = String.valueOf(count);
                for(char digit : countStr.toCharArray()){
                    chars[writeIndex] = digit;
                    writeIndex++;
                }
            }
        }
        return writeIndex;
    }
}