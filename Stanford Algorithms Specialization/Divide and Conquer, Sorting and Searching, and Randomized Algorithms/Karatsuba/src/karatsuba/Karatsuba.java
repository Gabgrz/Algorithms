/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karatsuba;

/**
 *
 * @author gab12
 */
public class Karatsuba {
/*
    
Input: two n-digit positive integers x and y.
Output: the product x · y.
Assumption: n is a power of 2.
--------------------------------------------------
if n = 1 then // base case
    compute x · y in one step and return the result
else // recursive case
    a, b := first and second halves of x
    c, d := first and second halves of y
    compute p := a + b and q := c + d using
    grade-school addition
    recursively compute ac := a · c, bd := b · d, and
    pq := p · q
    compute adbc := pq - ac - bd using grade-school
    addition
    compute 10^n * ac + 10^(n/2) * adbc + bd using
    grade-school addition and return the result
        
        */

    /**
     * @param args the command line arguments
     */
    
    static long RecIntMult(long i1, long i2){
        return 0;
    }   
    
    
    static long karatsubaMulti(String x, String y){
        
        System.out.println("-----------\nX:"+x+" Y:"+y);
        
        if(x.length() % 2 != 0 || y.length() % 2 != 0){System.out.println("HOLA");
            return Long.parseLong(x)*Long.parseLong(y);
        }
            
        
        if(x.toString().length() > y.toString().length()){
            System.out.println(">");
            y = "0"+y;
            System.out.println("New Y: "+y);
        }
        else if(x.toString().length() < y.toString().length()) {
            System.out.println("<");
            x = "0" + x;
        }
        
        if(x.toString().length() < 2){
            System.out.println("Length: "+x.toString().length());
            Long xi = Long.parseLong(x);
            Long yi = Long.parseLong(y);
            System.out.println("n == 1 RETURN: "+xi*yi);
            return xi*yi;
        }
            
        else{
            
            /*
            int adbc = p*q-a*c-b*d;
            int result = (int)(Math.pow(10,x.toString().length()) * (a*c) + Math.pow(10, x.toString().length()/2) * adbc + b*d);
            System.out.println(result);
            */
            Long a = new Long(x.toString().substring(0, x.toString().length() / 2));
            Long b = new Long(x.toString().substring(x.toString().length() / 2));;
            Long c = new Long(y.toString().substring(0, y.toString().length() / 2));;
            Long d = new Long(y.toString().substring(y.toString().length() / 2));;
            System.out.println("a:"+a + " b:"+b +" c:"+c+" d:"+d);
            Long p = a + b; 
            Long q = c + d;
            System.out.println("p:" + p + " q:" + q);
            
            long ac = karatsubaMulti(a.toString(),c.toString());
            System.out.println("AC: "+ac);
            long bd = karatsubaMulti(b.toString(),d.toString());
            System.out.println("BD: "+bd);
            long pq = karatsubaMulti(p.toString(),q.toString());
            System.out.println("BQ: "+pq);
            long adbc = pq-ac-bd;
            System.out.println("ADBC: "+adbc);
            
            long result = (long)(Math.pow(10,x.toString().length()) * ac + Math.pow(10, x.toString().length()/2) * adbc + bd);
            System.out.println("ELSE RESULT: "+result);
            
            // ...
            return result;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String x = "3141592653589793238462643383279502884197169399375105820974944592";
        String y = "2718281828459045235360287471352662497757247093699959574966967627";
        System.out.println("FINAL RESULT: "+karatsubaMulti(x,y));
    }   
}