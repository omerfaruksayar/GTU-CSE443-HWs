public class Driver {


    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        BestDSEver bds = new BestDSEver();
        GetCommand gc = new GetCommand(bds);
        InsertCommand ic = new InsertCommand(bds);
        RemoveCommand rc = new RemoveCommand(bds);
        Invoker invoker = new Invoker();
        class MyThread extends Thread{
            @Override
            public void run() {
                invoker.getCommand().execute(o);
            }
        }

        class MyGetThread extends Thread{
            @Override
            public void run() {
                invoker.getCommand().execute(0);
            }
        }
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        MyThread mt4 = new MyThread();
        MyGetThread mgt1 = new MyGetThread();
        MyGetThread mgt2 = new MyGetThread();

        invoker.setCommand(ic);
        mt1.start();
        mt2.start();
        Thread.sleep(100);
        invoker.setCommand(gc);
        mgt1.start();
        mgt2.start();
        Thread.sleep(100);
        invoker.setCommand(rc);
        mt3.start();
        mt4.start();
    }

}
