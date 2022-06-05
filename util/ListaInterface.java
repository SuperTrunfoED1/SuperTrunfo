package util;

public interface ListaInterface<T> {
    
    void addFirst(T coisa);

    void add(T coisa);//funciona como um addLast, mas retirei o "Last" para reduzir o nome

    T set(T antigo, T novo);//altera o elemento

    T set(int index, T novo);//sobrecarga
    
    T remove(T coisa);//remove o elemento
    
    T remove(int index);//sobrecarga

    T search(T coisa);//busca o elemento

    T search(int index);//sobrecarga


    T shift();//remove o primeiro nó

    T pop(); //remove o ultimo nó
    
    T peekFirst();
    
    T peekLast();

    int size();

    void show();

    void indexar();
}
