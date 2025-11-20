public class DeadlockResolvido {
    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            adquirirNaOrdem("T1");
        });

        Thread t2 = new Thread(() -> {
            adquirirNaOrdem("T2");
        });

        t1.start();
        t2.start();
    }

    static void adquirirNaOrdem(String nome) {
        System.out.println(nome + " tentando adquirir LOCK_A");
        synchronized (LOCK_A) {
            System.out.println(nome + " adquiriu LOCK_A");
            dormir(50);

            System.out.println(nome + " tentando adquirir LOCK_B");
            synchronized (LOCK_B) {
                System.out.println(nome + " executou com sucesso!");
            }
        }
    }

    static void dormir(long ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
