package arraysandbox;
import java.util.Arrays;
import java.util.Random;

public class ArraySandbox {
    public static void main(String[] args) {
        /* Variable Declarations*/
        int[] dfa = new int[10];
        int cntOfEntries = 10;
        int sub = 0;  // used as subscript for the array
        long key; // the element we'ren looking for
        Random random = new Random(100);


        /*   -----------   */
        /*   INSERT DATA   */
        /*   -----------   */
        for (sub = 0; sub < cntOfEntries; sub++) {
            dfa[sub] = random.nextInt(100);
            }//end for

        /*     --------------    */
        /*     SHOW THE ARRAY    */
        /*     --------------    */
        System.out.print("Using for loop: " );
        for (sub = 0; sub < dfa.length; sub++){
             System.out.print(dfa[sub]  + ", ");
        }
        System.out.println("");

        System.out.print("Using for each loop: " );
        for (int entry:dfa) {
            System.out.print(entry +", ");
        }
        System.out.println("");
        System.out.print("Using Arrays.toString:  ");
        System.out.println(Arrays.toString(dfa));

        /*     ----------------------------    */
        /*     FIND AN ElEMENT IN THE ARRAY    */
        /*     ----------------------------    */
        key = 66;
        for (sub = 0; sub < cntOfEntries; sub++) {
            if(dfa[sub] == key ) {
               break;
            } // end if
        }//end for

        /*are we past the last element or did we find thekey? */
        if(sub == cntOfEntries) {
            System.out.println("Sorry " + key + " is not on the list");
        } else {
            System.out.println(key + " is the " + (sub+1) + " item");
        }// end if

        /*     ------------------------------    */
        /*     DELETE AN ElEMENT IN THE ARRAY    */
        /*     ------------------------------    */
        key = 66;
        for (sub = 0; sub < cntOfEntries; sub++) {
            if(dfa[sub] == key ) {
                break;
            } // end if
        }//end for

        /*are we past the last element or did we find the key? */
        if(sub == cntOfEntries) {
            System.out.println("Sorry " + key + " is not on the list");
        } else {
            for(int sub2 = sub; sub2< cntOfEntries -1; sub2++){
                dfa[sub2] = dfa[sub2+1];
            } // end for
            cntOfEntries--;
            System.out.println(key + " deleted " + Arrays.toString(dfa));
        }// end if


        /*     --------------    */
        /*     COPY THE ARRAY    */
        /*     --------------    */

        /* WRONG!!! only creates an array the same length as the one you wanted to copy */
        int afd[] = new int[dfa.length];
        System.out.println(Arrays.toString(afd));

        /* WRONG!!!  WRONG!!!  WRONG!!!
          afd is now a reference to dfa!!!   afd has bupkis
          if you do this at work, shut down, gather your things
          and move to Siberia.
         */
        afd = dfa;

        //good old loop
        int[] newArray = new int[10];

        for(sub = 0; sub < dfa.length; sub++ ){
           newArray[sub] = dfa[sub];
        }// end for

        System.out.println(Arrays.toString(dfa));
        System.out.println(Arrays.toString(newArray));

        /* Arrays.copyOf */
        int[] newArray2 = new int[10];
        newArray2 = Arrays.copyOf(dfa, dfa.length);
        System.out.println("newArray2 " + Arrays.toString(newArray2));

        /* Arrays.copyOf */
        int[] newArray3 = Arrays.copyOf(dfa, dfa.length - 5);
        System.out.println("newArray3 " + Arrays.toString(newArray3));
        System.out.println(dfa.length + "," + newArray3.length);

        /* just clone it */
        int[] newArray4 = dfa.clone();
        System.out.println("newArray4 " + Arrays.toString(newArray4));

        /* use System.arraycopy();
        * public static void arraycopy(Object src, int srcPos, Object dest,
        * int destPos, int length)
        */
        int[] newArray5 = new int[dfa.length];
        System.arraycopy(dfa,0, newArray5, 0, 7);
        System.out.println("newArray5 " + Arrays.toString(newArray5));


/* Overview of above copy methods:

Simply assigning reference is wrong
Array can be copied by iterating over array, and one by one assigning elements.
We can avoid iteration over elements using clone() or System.arraycopy()
clone() creates a new array of same size,
but System.arraycopy() can be used to copy from a source range to a destination range.
System.arraycopy() is faster than clone() as it uses Java Native Interface (Source : StackOverflow)
 */



    }// end main
}//end class






