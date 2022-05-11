package util;

public class Testador {
    public static void main(String[] args) {
        ListaInterface<Integer> lista = new Lista<Integer>();

        lista.add(3);//ok
        lista.add(4);
        lista.addFirst(2);//ok
        lista.addFirst(1);
        lista.add(5);
        lista.show();

        System.out.println("Elemento removido: " + lista.remove(1)); //ok
        lista.show();
        System.out.println("Elemento removido: " + lista.remove(3)); 
        lista.show();
        System.out.println("Elemento alterado: " + lista.set(5,1)); //ok
        lista.show();
        System.out.println("Elemento alterado: " + lista.set(2,6)); 
        lista.show();
    }
}
