package util;

public class Lista<T> implements ListaInterface<T> {
    class Node {
        Node next;
        Node before;
        T content;

        public Node(T cont) {
            content = cont;
            next = null;
            before = null;
        }
    }

    // ------------------------------
    // atributos
    private Node first;
    private Node last;
    public Integer size;

    // ------------------------------
    // construtor
    public Lista() {
        first = null;
        last = null;
        size = 0;
    }

    // ------------------------------
    // metodos
    @Override
    public void addFirst(T cont) {
        Node novo = new Node(cont);

        if (first == null) {
            first = novo;
            last = novo;
        } else {
            first.before = novo;
            novo.next = first;
            first = novo;
        }
        size++;
    }

    @Override
    public void add(T cont) {// a.k.a. addLast
        Node novo = new Node(cont);

        if (last == null) {
            first = novo;
            last = novo;
        } else {
            last.next = novo;
            novo.before = last;
            last = novo;
        }
        size++;
    }

    @Override
    public T set(T antigo, T novo) {
        Node nov = new Node(novo);

        if (first != null) {
            Node tmp = first;

            while (tmp != null) {
                if (tmp.content.equals(antigo)) {
                    tmp.content = nov.content;// atribui o novo nó ao antigo
                    return antigo;// finaliza o laço e retorna o elemento antigo
                } else {
                    tmp = tmp.next;
                }
            }
            return null;
        } else {
            System.out.println("Lista vazia!");
            return null;
        }

    }

    @Override
    public T remove(T cont) {
        T retorno = null;

        if (first == null) {
            System.out.println("Lista vazia!");
        } else if ((first == last) && (first.content.equals(cont))) {
            retorno = first.content;

            first = null;
            last = null;

            size--;
        } else if (first.content.equals(cont)) {
            retorno = shift();
        } else if (last.content.equals(cont)) {
            retorno = pop();
        } else {
            Node tmp = first;

            while (tmp != null) {
                if (tmp.content.equals(cont)) {
                    retorno = tmp.content;

                    tmp.before.next = tmp.next;
                    tmp.next.before = tmp.before;
                    tmp.next = null;
                    tmp.before = null;

                    size--;
                    break;
                } else {
                    tmp = tmp.next;
                }
            }
        }

        return retorno;
    }

    @Override
    public T peekFirst() {
        if (first != null) {
            return first.content;
        } else {
            System.out.println("Lista vazia!!");
            return null;
        }

    }

    @Override
    public T peekLast() {
        if (last != null) {
            return last.content;
        } else {
            System.out.println("Lista vazia!!");
            return null;
        }
    }

    @Override
    public void show() {// método utilizado para depuração
        Node tmp = first;
        int i = 1;

        if (tmp != null) {
            System.out.println("---------------------------------------");
            while (tmp != null) {
                System.out.println(i + "º elemento: " + tmp.content);
                tmp = tmp.next;
                i += 1;
            }
            System.out.println("TAMNHO: " + size);
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Lista vazia!!");
        }
    }

    @Override
    public T pop() {
        T removido = null;

        if (last == null) {
            System.out.println("Lista vazia!!");
        } else {
            removido = last.content;
            if (first == last) {
                first = null;
                last = null;

                size--;
            } else {
                last.before.next = null;
                last = last.before;

                size--;
            }
        }

        return removido;
    }

    @Override
    public T shift() {
        T removido = null;

        if (first == null) {
            System.out.println("Lista vazia!!");
        } else {
            removido = first.content;
            if (first == last) {
                first = null;
                last = null;

                size--;
            } else {
                first.next.before = null;
                first = first.next;

                size--;
            }
        }

        return removido;
    }

    public T search(T criterio) {
        Node p = first; // ponteiro temporario

        if (first != null) {
            while (p != null) {
                if (p.content.equals(criterio)) {
                    System.out.println();
                    return p.content;
                }
                p = p.next;
            }
        }

        return null;
    }

}
