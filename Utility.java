import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Utility {
    public static char[] readFile(String filePath) throws IOException {
        StringBuilder str = new StringBuilder();

        try(FileReader readIn = new FileReader(filePath)){
            int temp;
            while((temp = readIn.read()) != -1){
                str.append((char) temp);
            }
        }
        return str.toString().toCharArray();
    }

    public static void writeFile(String filePath, char[] text) throws IOException {
        try(FileWriter writeOut = new FileWriter(filePath)){
            for(char c : text){
                writeOut.write(c);
            }
        }
    }

    public static List<char[]> paddBlocks(char[] text){
        List<char[]> blocks = new ArrayList<>();
        int blockSize = 16;
        char pad = (char) 0x81;
        int i = 0;

        while (i < text.length){
            int length = Math.min(blockSize, text.length - i);
            char[] block = new char[blockSize];

            for (int j = 0; j < length; j++){
                block[j] = text[i + j];
            }

            for (int j = length; j < blockSize; j++){
                block[j] = pad;
            }

            blocks.add(block);
            i += blockSize;
        }
        if (text.length == 0){
            blocks = new ArrayList<>();
        }
        
        return blocks;
    }

    public static char[] xorBlocks(char[] block, char[] key){
        char[] xoredBlock = new char[block.length];

        for(int i = 0; i < block.length; i++){
            xoredBlock[i] = (char) (block[i] ^ key[i]);
        }
        
        return xoredBlock;
    }

    public static char[] swapBlocks(char[] block, char[] key){
        char[] swappedBlocks = new char[block.length];

        for(int i = 0; i < block.length; i++){
            swappedBlocks[i] = block[i];
        }

        int start = 0;
        int end = block.length - 1;
        int keySwap = 0;
        while(start < end){
            int modValue = key[keySwap] % 2;
            if(modValue == 1){
                char temp = swappedBlocks[start];
                swappedBlocks[start] = swappedBlocks[end];
                swappedBlocks[end] = temp;
                end--;
            }
            start++;
            keySwap = (keySwap + 1) % key.length;
        }
        return swappedBlocks;

    }

    public static char[] makeList(List<char[]> blocks){
        if(blocks.isEmpty()){
            return new char[0];
        }
        int totalSize = blocks.size() * 16;
        char[] finishedList = new char[totalSize];
        int i = 0;
        for(char[] block : blocks){
            for(char c : block){
                finishedList[i] = c;
                i++;
            }
        }
        return finishedList;
    }
    
}
