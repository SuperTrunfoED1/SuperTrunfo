package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import util.Lista;
import util.ListaInterface;

public class User implements Serializable{

    private String nickname;
    private String senha;
    private Integer score;
    
    //------------------------------------
    //construtores
    public User(String nick, String senha){
        setNickname(nick);
        setSenha(senha);
        setScore(0);
    }

    public User(){
        nickname = "";
        senha = "";
        score = 0;
    }

    //------------------------------------
    //getters-setters
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        if(score < 0){
            System.out.println("Pontuação precisa ser zero ou maior!");
        }else{
            this.score = score;
        }
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        if(senha == null){
            System.out.println("Digita algo!");
        }else if(senha.isBlank()){
            System.out.println("A senha não pode ser apenas um espaço vazio!");
        }else{
            this.senha = senha;
        }
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        if(nickname == null){
            System.out.println("Digita algo!");
        }else if(nickname.isBlank()){
            System.out.println("O nick não pode ser apenas um espaço vazio!");
        }else{
            this.nickname = nickname;
        }
    }
    //------------------------------------
    //metodos
    public boolean autenticar(User usu) throws IOException{
        if(usu == null){
            System.out.println("Usuário inválido!");
            return false;
        }else{

            ListaInterface<User> ListaUsuarios = new Lista<User>();
            ListaUsuarios = ler("Usuarios.txt");
            User usuarios = new User();
            usuarios = ListaUsuarios.search(usu);

            if (usuarios != null) {
                if(usuarios.getNickname().equals(usu.getNickname()) && usuarios.getSenha().equals(usu.getSenha())){
                    return true;
                }else{
                    return false;
                }
            }

            return false;
            
        }
    }

    public ListaInterface<User> ler(String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        ListaInterface<User> ListaUsuarios = new Lista<User>();
        String linha = "";

        while (linha != null) {
            linha = bufferedReader.readLine();
            User usuarios = new User();
            if (linha != null) {
                
                String[] armazena = linha.split(",");
                usuarios.setNickname(armazena[0]);
                usuarios.setSenha(armazena[1]);
                usuarios.setScore(Integer.valueOf(armazena[2]));

                ListaUsuarios.add(usuarios);

            }
        }
        bufferedReader.close();

        return ListaUsuarios;
    }

    @Override
    public String toString() {
        return nickname + "," + senha + "," +  score;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (nickname == null) {
            if (other.nickname != null)
                return false;
        } else if (!nickname.equals(other.nickname))
            return false;
        return true;
    }

    
}