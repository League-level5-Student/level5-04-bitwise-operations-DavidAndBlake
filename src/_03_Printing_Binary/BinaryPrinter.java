package _03_Printing_Binary;

public class BinaryPrinter {
	/*
	 * Complete the methods below so they print the passed in parameter in binary.
	 * Do not use the Integer.toBinaryString method!
	 * Use the main method to test your methods.
	 */

	
	public void printByteBinary(byte b) {
		// We first want to print the bit in the one's place
		
//		System.out.print((b&0b10000000)>>7);
//		// Shift b seven bits to the right
//		System.out.print((b&0b01000000)>>6);
//		System.out.print((b&0b00100000)>>5);
//		System.out.print((b&0b00010000)>>4);
//		System.out.print((b&0b00001000)>>3);
//		System.out.print((b&0b00000100)>>2);
//		System.out.print((b&0b00000010)>>1);
//		System.out.print((b&0b00000001)>>0);
		int bitToShift = 0b10000000;
		for(int i = 0; i<=7; i++) {
			byte bitPlace = (byte)(7-i);
//			System.out.println("bitToShift = " + bitToShift);
			System.out.print((b&bitToShift)>>bitPlace);
			bitToShift = (bitToShift>>1);
		}
		// Use the & operator to "mask" the bit in the one's place
		// This can be done by "anding" (&) it with the value of 1
		
		// Print the result using System.out.print (NOT System.out.println)
		//Use this method to print the remaining 7 bits of b
		
	}
	
	public void printShortBinary(short s) {
		// Create 2 byte variables
		byte firstByte;
		byte secondByte;
		// Use bit shifting and masking (&) to save the first
		// 8 bits of s in one byte, and the second 8 bits of
		// s in the other byte
	
		firstByte = (byte) (s&0xff);
		secondByte = (byte) (s>>8);
		
		// Call printByteBinary twice using the two bytes
		System.out.print("\nfirstByte = ");
		printByteBinary (firstByte);
		System.out.print("\nsecondByte = ");
		printByteBinary(secondByte);
		// Make sure they are in the correct order
	}
	
	public void printIntBinary(int i) {
		// Create 2 short variables
		
		// Use bit shifting and masking (&) to save the first
		// 16 bits of i in one short, and the second 16 bits of
		// i in the other short
		
		// Call printShortBinary twice using the two short variables
		// Make sure they are in the correct order
	}
	
	public void printLongBinary(long l) {
		// Use the same method as before to complete this method
	}
	
	public static void main(String[] args) {
		// Test your methods here
		BinaryPrinter printer = new BinaryPrinter();
		printer.printByteBinary((byte) 68);
		printer.printShortBinary((short) 2057);
	}
}
