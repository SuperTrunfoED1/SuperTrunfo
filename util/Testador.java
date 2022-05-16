package util;



import game.User;

public class Testador {
	public static void main(String[] args) {

		/*
		 * ListaInterface<String> lista = new Lista<String>();
		 * 
		 * lista.add("primeiro");
		 * lista.add("segundo");
		 * lista.add("terceiro");
		 * lista.add("kkk");
		 * 
		 * String quarto = lista.search("primeiro");;
		 */


		ListaInterface<User> lista = new Lista<User>();

		User novo = new User();
		User novo2 = new User();
		User novo3 = new User();

		novo2.setNickname("Joao");
		novo3.setNickname("Juliana");

		lista.add(novo2);
		lista.add(novo3);

		novo.setNickname("Felipe");

	

		



	}
}
