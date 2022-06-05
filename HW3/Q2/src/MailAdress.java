public class MailAdress implements MailAdressBook{

    String mail;
    String name;

    /**
     * Constructor of the MailAddress class, it is represented as leaf of the tree.
     * @param mail String, mail address
     * @param name String, owner name
     */
    public MailAdress(String mail, String name) {
        this.mail = mail;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printAdress() {
        System.out.println(mail + " " + name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(MailAdressBook o) {
        return this.name.compareTo(o.getName());
    }
}
