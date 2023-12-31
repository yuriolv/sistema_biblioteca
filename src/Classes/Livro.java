package Classes;

public class Livro {
    private String titulo;
    private String autor;
    private String assunto;
    private Integer qtdEstoque;
    private String image;
    private String coleção;

    public Livro(String titulo, String autor, String assunto, int qtdEstoque ,String coleção , String image){
        this.titulo = titulo;
        this.autor = autor;
        this.assunto = assunto;
        this.qtdEstoque = qtdEstoque;
        this.image = image;
        this.coleção = coleção;
    }

   

    public String toString(){
        return titulo+"\t"+autor+"\t"+assunto+"\t"+qtdEstoque+"\t"+coleção+"\t"+image;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getImage(){
        return image;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getAssunto() {
        return assunto;
    }
    
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }
    
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
    public String getColeção() {
        return coleção;
    }

    public void setColeção(String coleção) {
        this.coleção = coleção;
    }
}
