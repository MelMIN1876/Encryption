public class Stream {
    
    public static char[] streamCipher(char[] input, char[] key){
        char[] output = new char[input.length];

        for(int i = 0; i < input.length; i++){
            output[i] = (char) (input[i] ^ key[i % key.length]);
        }

        return output;
    }
}
