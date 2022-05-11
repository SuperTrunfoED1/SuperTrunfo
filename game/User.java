package game;

public class User{

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
    public boolean autenticar(User usu){
        if(usu == null){
            System.out.println("Usuário inválido!");
            return false;
        }else{
            if(nickname.equals(usu.nickname) && senha.equals(usu.senha)){
                return true;
            }else{
                return false;
            }
        }
    }
}