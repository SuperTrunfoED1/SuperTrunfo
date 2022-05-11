package util;

public interface ListaInterface<T> {
    
    void addFirst(T coisa);

    void add(T coisa);//funciona como um addLast, mas retirei o "Last" para reduzir o nome

    T set(T antigo, T novo);//altera o elemento
    
    T remove(T coisa);

    T shift();//remove o primeiro nó

    T pop(); //remove o ultimo nó
    
    T peekFirst();
    
    T peekLast();

    void show();
}
