package elgamal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
*@PrimeGenerator a class thatgenerates prime numbers
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
    double min;
    double max;

    /**
     *
     * @param numberOfBits bit length of the generator
     */
    public PrimeGenerator(int numberOfBits){
       
        this.customNumberOfBits = numberOfBits;
        limitOfPrime();
    }
    
    private void limitOfPrime() throws ArithmeticException{
        
        if(customNumberOfBits <= 0){
            throw new ArithmeticException("Your input must be greater than zero");
        }
        if(numberOfBits <= customNumberOfBits){
            min = Math.pow(base, (numberOfBits-1));
            max = Math.pow(base, numberOfBits);
        }else{
            //throw new ArithmeticException("The input you've supplied is greater than maximum permissible value");
            min = Math.pow(base, (customNumberOfBits-1));
            max = Math.pow(base, customNumberOfBits);
        }
     }
    protected boolean isPrimeNumber = false;
    protected final List<Double> primeNumbers = new ArrayList<>();
  
     public void primeNum(){
         System.out.println("Generating prime numners now between" + min + " and " + max);
         for(double i = min ; i <= max; i++ ){
             //check if the number is prime number
             for(int k = 2; k < i; k++){
                 if((i % k) != 0){
                     isPrimeNumber = true;
                     primeNumbers.add(i);
                 }
             }
         }
     }
     private Random randomGenerator = new Random();
     public double getPrimeNumber(){
         if(primeNumbers.isEmpty()){
             primeNum();
             int index = randomGenerator.nextInt(primeNumbers.size());
        return primeNumbers.get(index);
         }else{
             int index = randomGenerator.nextInt(primeNumbers.size());
             return primeNumbers.get(index);
         }
        
     }
}