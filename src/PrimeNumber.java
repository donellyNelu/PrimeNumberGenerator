import Generators.MillerRabinGenerator;
import Generators.SieveGenerator;
import Generators.TrialDivisionGenerator;

import java.util.*;

public class PrimeNumber {

    // this method reads and returns the lower limit selected by the user.
    private static int generateLowerLimit(){
        int lowerLimit;
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the lower limit");
        lowerLimit = s.nextInt();

        return lowerLimit;

    }

    // this method reads and returns the upper limit selected by the user.
    private static int generateUpperLimit(){
        int upperLimit;
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the upper limit");
        upperLimit = s.nextInt();

        return upperLimit;
    }


    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Please select a prime number generation Strategy");
        System.out.println("Enter 1 for generator one");
        System.out.println("Enter 2 for generator two");
        System.out.println("Enter 3 for generator three");

        //gets the prime number generator option selected by the user from 1 - 3
        // any option greater than 3 is invalid
        int generatorOption =  s.nextInt();
            if (generatorOption == 1){
                int lowerLimit = PrimeNumber.generateLowerLimit();
                int upperLimit = PrimeNumber.generateUpperLimit();

                TrialDivisionGenerator trialDivisionGenerator = new TrialDivisionGenerator();
                System.out.println("The prime numbers are" + trialDivisionGenerator.generatePrime(lowerLimit,upperLimit));

            }else if(generatorOption == 2){
                int lowerLimit = PrimeNumber.generateLowerLimit();
                int upperLimit = PrimeNumber.generateUpperLimit();

                SieveGenerator sieveGenerator = new SieveGenerator();
                System.out.println("The prime numbers are" + sieveGenerator.generatePrime(lowerLimit,upperLimit));

            }else if(generatorOption == 3){
               int lowerLimit = PrimeNumber.generateLowerLimit();
               int upperLimit = PrimeNumber.generateUpperLimit();

               MillerRabinGenerator millerRabinGenerator = new MillerRabinGenerator();
                System.out.println("The prime numbers are" + millerRabinGenerator.generatePrime(lowerLimit,upperLimit));
            }else{
                System.out.println("The number selected isn't a valid prime number generator option");
            }

    }
}

