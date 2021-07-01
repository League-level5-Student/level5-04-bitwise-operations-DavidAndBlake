package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

public class Base64Decoder
{
    /*
     * Base 64 is a way of encoding binary data using text.
     * Each number 0-63 is mapped to a character.
     * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
     * Since the numbers 0 through 63 can be represented using 6 bits,
     * every four (4) characters will represent twenty four (24) bits of data.
     * 4 * 6 = 24
     *
     * For this exercise, we won't worry about what happens if the total bits being converted
     * do not divide evenly by 24.
     *
     * If one char is 8 bits, is this an efficient way of storing binary data?
     * (hint: no)
     *
     * It is, however, useful for things such as storing media data inside an HTML file (for web development),
     * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
     *
     * View this link for a full description of Base64 encoding
     * https://en.wikipedia.org/wiki/Base64
     */


    final static char[] base64Chars = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    //1. Complete this method so that it returns the the element in
    //   the base64Chars array that corresponds to the passed in char.
    public static byte convertBase64Char(char c)
    {
        for (int i = 0; i < base64Chars.length; i++)
        {
            if (c == base64Chars[i])
            {
                return (byte) i;
            }
        }
        return 0;
    }

    //2. Complete this method so that it will take in a string that is 4
    //   characters long and return an array of 3 bytes (24 bits). The byte
    //   array should be the binary value of the encoded characters.
    public static byte[] convert4CharsTo24Bits(String s)
    {
        //need to shift the bits in such a way where I can pair the digits together by adding in order to create 3 lines of 6 digits from the 8 bit sections.
        byte sByte0 = (byte) convertBase64Char(s.charAt(0));
        byte sByte1 = (byte) convertBase64Char(s.charAt(1));
        byte sByte2 = (byte) convertBase64Char(s.charAt(2));
        byte sByte3 = (byte) convertBase64Char(s.charAt(3));
//        System.out.println(sByte0);
        /*We are creating the pieces of the base64 bytes instead of the traditional 8 bit bytes, and stringing
         *them together. There are three lines of six bit bytes, and we are creating three byte arrays out of
         * assembled sBytes as shown below. Our final example will look like this except with the numerical
         * placeholders replaced with the actual values.
         * 00000011
         * 11112222
         * 22333333
         */
        byte sByte00 = (byte) (sByte0 << 2); // we shift to the left by two to get rid of the leading zeroes
        byte sByte10 = (byte) (sByte1 >> 4); // we shift to the right by four to get rid of the trailing numbers and create an 8 digit row
        byte sByte11 = (byte) (sByte1 << 4); //we are splitting the third line into equal portions of the secand and third byte, which leaves it with four units of each
        byte sByte20 = (byte) (sByte2 >> 2);
        byte sByte21 = (byte) (sByte2 << 6);
        byte[] bArray = new byte[3];
        bArray[0] = (byte) (sByte00 + sByte10);
        bArray[1] = (byte) (sByte11 + sByte20);
        bArray[2] = (byte) (sByte21 + sByte3);
//        System.out.println("bArray = " + bArray);
        return bArray;
        //
    }

    //3. Complete this method so that it takes in a string of any length
    //   and returns the full byte array of the decoded base64 characters.
    public static byte[] base64StringToByteArray(String file)
    {
		/*CONSTRAINTS:
		THE PROGRAM MUST TAKE IN ANY LENGTH OF STRING
		THE PROGRAM MUST TAKE THE FOUR BITS EACH CHARACTER IS MADE OF AND CONVERT IT INTO 6 DIGIT CODE
		THE 6 DIGIT CODE MUST FIT INTO AN EVEN NUMBER OF LINES
		STEPS TO COMPLETE THE PROGRAM:
		    Split the string into chunks of four characters
		    Convert the chunks of four characters into chunks of three bytes using our method above
		    Save those bytes into an array


		IDEAS TO COMPLETE THIS PROGRAM:
		Create a for loop to count the numbers of the program and write the segments to a string array
		Check to see if the code prints correctly

			Create a mathematical function that mixes the bitshifts to fit into the six digit
			bytes automatically
			IF STATEMENTS?
			    If IF statements are used
*/
        byte[] newByteArray = new byte[(file.length()/4)*3];
        String[] fourLetterStrings;
        int index = 0;
        for (int i = 0; i < file.length(); i+=4)
        {
//            fourLetterStrings = file[i];
            String fourChars = file.substring(i, i + 4);
            byte[] anotherByteArray = convert4CharsTo24Bits(fourChars);
            for (int j = 0; j < anotherByteArray.length; j++)
            {
//                System.out.println("AnotherByteArray = " + anotherByteArray[j]);
//                System.out.println("i = " + i);
                newByteArray[index] = anotherByteArray[j];
                index++;
            }
        }

        return newByteArray;
    }
}
