import java.io.File;
import java.io.IOException;

public class Cipher{
    public static void main(String args[]){
        if(args.length != 5){
            System.exit(1);
        }

        String cipherType = args[0];
        String inputFile = args[1];
        String outputFile = args[2];
        String keyFile = args[3];
        String modeOfOperation = args[4];
        
        if(!cipherType.equals("B") && !cipherType.equals("S")){
            System.out.println("Invalid Function Type");
            System.exit(1);
        }

        File input = new File(inputFile);
        if(!input.exists()){
            System.out.println("Input File Does Not Exist");
            System.exit(1);
        }

        File Key = new File(keyFile);
        if(!Key.exists()){
            System.out.println("Key File Does Not Exist");
            System.exit(1);
        }

        if(!modeOfOperation.equals("E") && !modeOfOperation.equals("D")){
            System.out.println("Invalid Mode Type");
            System.exit(1);
        }

        try {
            char[] inputText = Utility.readFile(inputFile);
            char[] keyText = Utility.readFile(keyFile);
            

            if (cipherType.equals("B") && keyText.length == 16){

                if (modeOfOperation.equals("E")){

                    char[] outputText = Block.encryptBlock(inputText, keyText);
                    Utility.writeFile(outputFile, outputText);

                } else if (modeOfOperation.equals("D")){

                    char[] outputText = Block.decryptBlock(inputText, keyText);
                    Utility.writeFile(outputFile, outputText);

                }
            } else if (cipherType.equals("S")){

                char[] outputText = Stream.streamCipher(inputText, keyText);
                Utility.writeFile(outputFile, outputText);

            }

            
        } catch (IOException e) {
            System.exit(1);
        }

    }
}