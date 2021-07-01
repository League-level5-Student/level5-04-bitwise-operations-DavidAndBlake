package _05_Pseudo_RNG;

import java.awt.*;

public class PseudoRNG
{
    /*
     * It is impossible for a computer to come up with a series of numbers
     * that are truly random. They can, however, use mathematical algorithms
     * to generate numbers that can seem random. These are called pseudo random
     * numbers.
     *
     */

    //1. Create a member variable of type long called "seed"
    private long seed;

    //2. Make a constructor that initializes the member variable
    PseudoRNG(int s)
    {
        seed = s;
    }
    //3. Complete the steps inside the xorShift method

    //4. Complete the steps in the main method

    //5. Write your own pseudo random generation method. You can use the xor
    //    shift as a guide. Use the main method to test it.


    // This is called the xor shift. It is a very simple algorithm to generate
    // Pseudo random numbers.
    long xorShift()
    {
        //1. Create a local long called seed and set it equal to the member variable
        //   We will only use the local variable for the rest of the method
        long seed = this.seed;
        //2. Shift seed to the left 13 bits and save the result
        long left13BitShiftSeed = seed<<13;
        //3. xor seed by the result of step 1 and save that result
        long xorSeed = seed ^ seed; //xor #1
        //4. Set seed equal to the result of step 2
        seed = left13BitShiftSeed;
        //5. Shift seed to the right 7 bits and save the result
        long right7BitShiftSeed = seed >> 7;
        //6. xor seed by the result of step 4 and save that result
        long xor4Seed = seed ^ left13BitShiftSeed;
        //7. Set seed equal to the result of step 5
        seed = right7BitShiftSeed;
        //8. Shift seed to the left 17 bits and save the result
        long left17BitShiftSeed = seed << 17;
        //9. xor seed by the result of step 7 and save that result
        long xor7Seed = seed ^ seed;
        //10. Set seed equal to the result of step 8
        seed = left17BitShiftSeed;
        //11. change the line below to return seed
        return seed;

        //For fun, see if you can rewrite the method using only 4 lines of cod
    }
    long xorShiftRewritten()
    {
        long seed = this.seed << 23;
        return seed;
    }


    public static void main(String[] args)
    {

        //1. Create a PseudoRNG object with any seed.
        PseudoRNG pseudoRNG = new PseudoRNG(5);
        //2. Print the result of xorShift() 3 times and note the random numbers.
        System.out.println(pseudoRNG.xorShift());
        System.out.println(pseudoRNG.xorShift());
        System.out.println(pseudoRNG.xorShift());
        //3. Create a second PSeudoRNG object with a different seed and print the result of xorShift 3 times.
        PseudoRNG pseudoRNG1 = new PseudoRNG(90);
        System.out.println(pseudoRNG1.xorShift());
        System.out.println(pseudoRNG1.xorShift());
        System.out.println(pseudoRNG1.xorShift());
        //4. Run the tests a second time and notice that 3 random numbers are the same because the seed generates the same sequence of random numbers.
        //DONE
        //If you would like to set the seed with a number that is hard to predict, you can use System.currentTimeMillis().
        PseudoRNG pseudoRNG2 = new PseudoRNG((int)(System.currentTimeMillis()));
        System.out.println("time = " + pseudoRNG2.xorShift());
        PseudoRNG pseudoRNG3 = new PseudoRNG((int)(System.currentTimeMillis()));
        System.out.println("time = " + pseudoRNG3.xorShift());
        try
        {
            Thread.sleep(57);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        PseudoRNG pseudoRNG4 = new PseudoRNG((int)(System.currentTimeMillis()));
        System.out.println("time = " + pseudoRNG4.xorShift());
        try
        {
            Thread.sleep(57);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        PseudoRNG pseudoRNG5 = new PseudoRNG((int)(System.currentTimeMillis()));
        System.out.println("time = " + pseudoRNG5.xorShift());

    }
}


