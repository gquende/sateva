package finance.classes;

public class Receita {


    private int id;
    private String user;
    private String tipo;
    private String descricao;
    private String fonte;
    private double valor;
    private String data;

    public Receita(String user, String tipo, String descricao, String fonte, double valor, String data) {
        this.user = user;
        this.tipo = tipo;
        this.descricao = descricao;
        this.fonte = fonte;
        this.valor = valor;
        this.data = data;
    }

    public Receita(int id, String user, String tipo, String descricao, String fonte, double valor, String data) {
        this.id = id;
        this.user = user;
        this.tipo = tipo;
        this.descricao = descricao;
        this.fonte = fonte;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFonte() {
        return fonte;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString(){



        return this.user+"\n"+this.tipo+"\n"+this.descricao+"\n"+this.fonte+"\n"+this.valor+"\n"+this.data;
    }


}



