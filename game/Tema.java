package game;

public class Tema {

    String nome;
    Long id;
    String bgImgPath;//caminho da imagem para o tema do cenario
    String bgColor;//código hexadecimal da cor do cenario

    public Tema(String nome, Long id, String bgImgPath, String bgColor) {
        this.nome = nome;
        this.id = id;
        this.bgImgPath = bgImgPath;
        this.bgColor = bgColor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null){
            System.out.println("Digite o nome do tema");
        }else if(nome.isBlank()){
            System.out.println("O nome não pode ser vazio");
        }else{
            this.nome = nome;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id == null){
            System.out.println("E necessário um ID");
        }else if(id < 0){
            System.out.println("deve ser maior que zero");
        }else{
            this.id = id;
        }
    }

    public String getBgImgPath() {
        return bgImgPath;
    }

    public void setBgImgPath(String bgImgPath) {
        if(bgImgPath == null){
            System.out.println("Digite o path");
        }else if(bgImgPath.isBlank()){
            System.out.println("O path não pode ser vazio");
        }else{
            this.bgImgPath = bgImgPath;
        }
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        if(bgColor == null){
            System.out.println("Digite o path");
        }else if(bgColor.isBlank()){
            System.out.println("O path não pode ser vazio");
        }else{
            this.bgColor = bgColor;
        }
    }

    

    
}