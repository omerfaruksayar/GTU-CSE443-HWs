public class Driver {
    public static void main(String[] args) {

        MailAdress m1 = new MailAdress("abc@gtu.edu.tr", "abc");
        MailAdress m2 = new MailAdress("bcd@gtu.edu.tr", "bcd");
        MailAdress m3 = new MailAdress("cde@gtu.edu.tr", "cde");

        CompositeBook c1 = new CompositeBook("students@gtu.edu.tr", "students");
        c1.add(m3);
        c1.add(m2);
        c1.add(m1);

        MailAdress m4 = new MailAdress("def@gtu.edu.tr", "def");
        MailAdress m5 = new MailAdress("efg@gtu.edu.tr", "efg");
        MailAdress m6 = new MailAdress("fgh@gtu.edu.tr", "fgh");

        CompositeBook c2 = new CompositeBook("cengStudents@gtu.edu.tr", "cengStudents");
        c2.add(m6);
        c2.add(m5);
        c2.add(m4);

        MailAdress m7 = new MailAdress("ghj@gtu.edu.tr", "ghj");
        MailAdress m8 = new MailAdress("hjk@gtu.edu.tr", "hjk");
        MailAdress m9 = new MailAdress("jkl@gtu.edu.tr", "jkl");

        CompositeBook c3 = new CompositeBook("mechStudents@gtu.edu.tr", "mechStudents");
        c3.add(m9);
        c3.add(m8);
        c3.add(m7);

        c1.add(c3);
        c1.add(c2);
        c1.printAdress();
    }
}
