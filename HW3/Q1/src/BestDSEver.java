public class BestDSEver {

    /**
     * Thread un-safe insert method
     * @param o new object to be added
     */
    void insert(Object o){System.out.println("Object Inserted");}
    /**
     * Thread un-safe remove method
     * @param o new object to be added
     */
    void remove(Object o){System.out.println("Object removed");}

    /**
     * Thread un-safe get method
     * @param index of the wanting object
     * @return the object
     */
    Object get(int index){System.out.println("Object returned"); return new Object();}
}
