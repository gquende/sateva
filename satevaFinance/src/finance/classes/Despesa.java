package finance.classes;

public class Despesa {

    private String user;
    private int id;
    private String tipo;
    private String descricao;
    private String data;
    private double valor;


    public Despesa() {
    }

    public Despesa(String user, int id, String tipo, String descricao, String data, double valor) {
        this.user = user;
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }
    public Despesa(String user, String tipo, String descricao, String data, double valor) {
        this.user = user;
       // this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
