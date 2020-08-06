package finance.classes;

public class Orcamento {

    private int id;
    private String user;
    private String tipo;
    private double valor;
    private String data;
    private String descricao;

    public Orcamento(int id, String user, String tipo, double valor, String data, String descricao) {
        this.id = id;
        this.user = user;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public Orcamento(String user, String tipo, double valor, String data, String descricao) {
        this.user = user;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }
}
