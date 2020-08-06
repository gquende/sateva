package finance.classes;

public class Divida {

    private String user;
    private int id;
    private String tipo;
    private String descricao;
    private String dataDivida;
    private String dataLiquidacao;
    private double valor;
    private String estado;
    private String dividendo;

    public Divida(String user, int id, String tipo, String descricao, String dataDivida, double valor, String estado, String dividendo) {
        this.user = user;
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataDivida = dataDivida;
        this.valor = valor;
        this.estado = estado;
        this.dividendo = dividendo;
    }
    public Divida(String user,int id, String tipo, String descricao, String dataDivida, double valor, String estado, String dividendo,String dataLiquidacao)
    {
        this.user = user;
        this.tipo = tipo;
        this.id = id;
        this.descricao = descricao;
        this.dataDivida = dataDivida;
        this.valor = valor;
        this.estado = estado;
        this.dividendo = dividendo;
        this.dataLiquidacao=dataLiquidacao;
    }

    //Pode ser acrescentado a data do pagamento da divida caso o estado seja a pagar!
    public Divida(String user, String tipo, String descricao, String dataDivida, double valor, String estado, String dividendo,String dataLiquidacao)
    {
        this.user = user;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataDivida = dataDivida;
        this.valor = valor;
        this.estado = estado;
        this.dividendo = dividendo;
        this.dataLiquidacao=dataLiquidacao;
    }




    public Divida(String user, String tipo, String descricao, String dataDivida, double valor, String estado, String dividendo)
    {
        this.user = user;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataDivida = dataDivida;
        this.valor = valor;
        this.estado = estado;
        this.dividendo = dividendo;

    }

    public String getUser() {
        return user;
    }

    public int getId() {
        return id;
    }


    public String getTipo() {
        return tipo;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataDivida() {
        return dataDivida;
    }

    public void setDataDivida(String dataDivida) {
        this.dataDivida = dataDivida;
    }

    public String getDataLiquidacao() {
        return dataLiquidacao;
    }

    public void setDataLiquidacao(String dataLiquidacao) {
        this.dataLiquidacao = dataLiquidacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDividendo() {
        return dividendo;
    }

    public void setDividendo(String dividendo) {
        this.dividendo = dividendo;
    }



}
