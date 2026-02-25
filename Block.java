import java.util.List;
import java.util.ArrayList;

public class Block {
    public static char[] encryptBlock(char[] input, char[] key){
        List<char[]> blocks = Utility.paddBlocks(input);
        List<char[]> xoredBlocks = new ArrayList<>();
        List<char[]> encryptedText = new ArrayList<>();

        for(char[] block : blocks){
            char[] xoredBlock = Utility.xorBlocks(block, key);
            xoredBlocks.add(xoredBlock);
        }

        for(char[] xor : xoredBlocks){
            char[] swappedBlock = Utility.swapBlocks(xor, key);
            encryptedText.add(swappedBlock);
        }

        return Utility.makeList(encryptedText);
    }

    public static char[] decryptBlock(char[] input, char[] key){
        List<char[]> blocks = Utility.paddBlocks(input);
        List<char[]> swappedBlocks = new ArrayList<>();
        List<char[]> decryptedText = new ArrayList<>();

        for(char[] block : blocks){
            char[] swappedBlock = Utility.swapBlocks(block, key);
            swappedBlocks.add(swappedBlock);
        }

        for(char[] swap : swappedBlocks){
            char[] reXored = Utility.xorBlocks(swap, key);
            decryptedText.add(reXored);
        }

        char[] temp = Utility.makeList(decryptedText);
        int listLength = temp.length;
        while(listLength > 0 && temp[listLength - 1] == (char)0x81){
            listLength--;
        }

        char[] finished = new char[listLength];

        for(int i = 0; i < listLength; i++){
            finished[i] = temp[i];
        }
        return finished;
    }
}
