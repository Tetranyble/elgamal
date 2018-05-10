package elgamal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
*@PrimeGenerator a class that generates prime numbers
*
*/

/**
 *
 * @author Imperial-lab (now Tetranyble Technology)- Ekenekiso S. Ugbanawaji
 */
public class PrimeGenerator{
    
    protected static final int  numberOfBits = 1028;
    protected static final int base = 2;
    protected int customNumberOfBits;
    int min;
    int max;

    /**
     *
     * @param numberOfBits bit length of the generator
     */
    public PrimeGenerator(int numberOfBits){
       
        this.customNumberOfBits = numberOfBits;
        limitOfPrime();
    }

    PrimeGenerator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void limitOfPrime() throws ArithmeticException{
        
        if(customNumberOfBits <= 0){
            throw new ArithmeticException("Your input must be greater than zero");
        }
        if(numberOfBits <= customNumberOfBits){
            min = (int) Math.pow(base, (numberOfBits-1));
            max = (int) Math.pow(base, numberOfBits);
        }else{
            //throw new ArithmeticException("The input you've supplied is greater than maximum permissible value");
            min = (int) Math.pow(base, (customNumberOfBits-1));
            max = (int) Math.pow(base, customNumberOfBits);
        }
     }
    protected boolean isPrimeNumber = false;
    protected final List<Double> primeNumbers = new ArrayList<>();
    protected final List<String> foundPrimeNumbers = new ArrayList<>();
  
     public void primeNum(int iteration){
         System.out.println("Generating prime numners now between" + min + " and " + max);
         /*
         *According to Fermat’s Little Theorem if p is a prime 
         *number and a is a positive integer less than p, then 
         * ap = a ( mod p )
         *or alternatively:
         *a(p-1) = 1 ( mod p )
         */
         //let the first supposed prime number be this.min class variable
         Random rn = new Random();
         int passedTest = 75;
         int difference = max - min;
         int a = (rn.nextInt(difference + 1) + min)-1;
         for(double c = min ; c <= max; c++ ){
            for(int i = 0; i<=iteration; i++){
                if((a * c) == a % c){
                  foundPrimeNumbers.add("true");
                }
            }
            if(passedTest >= foundPrimeNumbers.size()){
                 isPrimeNumber = true;
                primeNumbers.add(c);
            }
         }
//         for(double i = min ; i <= max; i++ ){
//             //check if the number is prime number
//             for(int k = 2; k < i; k++){
//                 if((i % k) != 0){
//                     isPrimeNumber = true;
//                     primeNumbers.add(i);
//                 }
//             }
//         }
     }
     private static  int defaultIteration = 100;
     public void primeNum(){
         primeNum(defaultIteration);
     }
     private Random randomGenerator = new Random();
     public double getPrimeNumber(){
         if(primeNumbers.isEmpty()){
             primeNum();
             int index = randomGenerator.nextInt(primeNumbers.size());
             return primeNumbers.get(index);
         }else{
             int index = randomGenerator.nextInt(primeNumbers.size());
             
             System.out.println("*******************************************************");
             return primeNumbers.get(index);
         }
        
     }
}