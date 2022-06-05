import java.util.ArrayList;

public class CompositeBook implements MailAdressBook{

    String mail;
    String name;
    ArrayList<MailAdressBook> children;

    /**
     * Constructor of the CompositeBook Class
     * @param mail String, mail address of the group(s)
     * @param name String, name of the group(s)
     */
    public CompositeBook(String mail, String name) {
        this.mail = mail;
        this.name = name;
        this.children = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printAdress() {
        System.out.println("***********************************************************");
        System.out.println("Group mail: "+ mail + " Group name: " + name);
        for (MailAdressBook m: children) {
            m.printAdress();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    public void add(MailAdressBook m){
        int index = 0;
        boolean added = false;
        for (MailAdressBook ma: children) {
            if (ma.compareTo(m) >= 0){
                index = children.indexOf(ma);
                children.add(index, m);
                added = true;
                break;
            }
        }
        if (!added)
            children.add(m);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(MailAdressBook o) {
        return this.name.compareTo(o.getName());
    }
}
