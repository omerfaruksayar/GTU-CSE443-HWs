public interface MailAdressBook extends Comparable<MailAdressBook> {
    /**
     * Prints the mail address and name of the owner
     */
    void printAdress();

    /**
     * @return String, name of the mail address owner
     */
    String getName();
}
