package br.com.adrianomenezes;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        int i = 5;
        System.out.println("Before: "+i);
        change(i);
        System.out.println("After: "+i);
    }

    private static void change(int i) {
        i++;
    }
}
