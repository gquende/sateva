package finance.controllers;

import finance.classes.*;
import finance.model.DespesaModel;
import finance.model.DividaModel;
import finance.model.ReceitaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainViewFinanceController {

    @FXML
    private Label labelReceitas;

    @FXML
    private Circle perfilFoto;

    @FXML
    private Label labelDespesas;

    @FXML
    private Label labelDividas;

    @FXML
    private StackedAreaChart<PieChart, String> graficoDespesasReceitas;

    @FXML
    private Label labelMetaPoupanca;
    @FXML
    private ImageView imgLogin;
    @FXML
    private Label labelPatrimonio;
    @FXML
    private Label userLabel;

    @FXML
    private Button addItem;

    @FXML
    private Label labelPercentagemReceitas;

    @FXML
    private Label labelPercentagemDividas;

    @FXML
    private Label labelPercentagemDespesas;

    @FXML
    Pane paneDividas;

    @FXML
    Pane paneReceitas;
    @FXML
    Pane paneDespesas;
    //  public static Pessoa login;
    @FXML
    Pane graphicPane;

    @FXML
    private ImageView imgView;


    @FXML
    private LineChart<?, ?> graficoLinear;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;


    Hashtable<String, Double> categorias;
    private ArrayList<Receita> receitas;
    private ArrayList<Despesa> despesas;
    private ArrayList<Divida> dividas;
    private  ArrayList<Divida> dividasNPagas;

    //Variaveis que recebem o calculo das despesas totais do mes
    private double totalDespesaMesActual=0;
    private double totalDespesaMesAnterior=0;
    private double totalDividasMesActual=0;
    private double totalDividasMesAnterior=0;
    double totalReceitaMesActual=0;
    double totalReceitaMesAnterior=0;

    //Tabelas hash para separar as despesas por categorias
    Hashtable<String, String> despesaSemanal= new Hashtable<String, String>();
   Hashtable<String, String> receitaSemanal= new Hashtable<String, String>();






    public void initialize(){


        //Image newImg= new Image(getClass().getResourceAsStream("/finance/img/022-book.png"));//Carregar uma imagem!
        Image img= new Image("/finance/img/022-book.png");
      //  imgView.getStyleClass().add("imageview");
    //    imgView.setImage(img);
  //      imgView.getStyleClass().add("imageview");
//imgView.setStyle("-fx-background-radius: 40");

perfilFoto.setStroke(Color.WHITE);
perfilFoto.setFill(new ImagePattern(img));

        carregarDados();
        userLabel.setText(LoginController.getPessoa().getNome()+" "+LoginController.getPessoa().getSobrenome());//Mostra os dados do Utilizador


        paneDespesas.setOnMouseClicked(event -> {

            System.out.println("Clicou em Despesas");
            DespesasDoMesController controller= new DespesasDoMesController();
            controller.showView();
        });

        paneDividas.setOnMouseClicked(event -> {

            System.out.println("Clicou em Divida");
            DividasDoMesController controller= new DividasDoMesController();
            controller.showView();

        });

        paneReceitas.setOnMouseClicked(event -> {

            ReceitasDoMesController controller= new ReceitasDoMesController();
            controller.showView();
            System.out.println("Clicou em Receitas!");

        });


    }

    public void carregarDados(){

        carregarReceitas();
        carregarDespesas();
       carregarDividas();
        setarValoresDasDespesas();
        carregarGraficos();
    }

    private void carregarReceitas(){
        ReceitaModel receitaModel=new ReceitaModel();
        receitas= receitaModel.listarReceitas(LoginController.getPessoa().getUsername());
        Date date= new Date();
        Format dataFormat= new SimpleDateFormat("MM");//Formata a data para so receber o mes

        ReceitasDoMesController.receitas=new ArrayList<>();
        for(Receita receita: receitas){
            if(receita.getData().substring(5,7).equals(dataFormat.format(date.getTime())))//Compara os dados se e do mes actual
            {
                totalReceitaMesActual+=receita.getValor();
                ReceitasDoMesController.receitas.add(receita);
            }
            if((Integer.valueOf(dataFormat.format(date.getTime()))-1)<10)//Compara os dados se e o mes anterior
            {
                String mesAnterior="0"+(Integer.valueOf(dataFormat.format(date.getTime()))-1);//Se o mes e menor que o 10 acrescenta um zero a frente para compessar o formato
                if (receita.getData().substring(5,7).equals(mesAnterior))
                    totalReceitaMesAnterior+=receita.getValor();
            }
        }
        labelReceitas.setText(totalReceitaMesActual+" Kzs");//Carrega o total na view
        System.out.println(totalReceitaMesAnterior);

        float percentagem= Math.round((float) (((100*totalReceitaMesActual)/totalReceitaMesAnterior)-100.0));
        if(percentagem>0)//Verifica a percentangem para determinar a cor que ser mostrado
        {
            labelPercentagemReceitas.setStyle("-fx-text-fill: #2dcf09");
            labelPercentagemReceitas.setText("+"+percentagem+"%");
        }
        else{
            labelPercentagemReceitas.setStyle("-fx-text-fill: #ff241c");
            labelPercentagemReceitas.setText(percentagem+"%");

        }
    }

    private void carregarDespesas(){

        categorias= new Hashtable<String, Double>();
        DespesaModel despesaModel=new DespesaModel();
        despesas= despesaModel.listarDespesas(LoginController.getPessoa().getUsername());
        System.out.println(despesas);
        Date date= new Date();
        Format dataFormat= new SimpleDateFormat("MM");//Formata a data para so receber o mes


        DespesasDoMesController.despesas=new ArrayList<Despesa>();

        for(Despesa despesa: despesas){
            if(despesa.getData().substring(5,7).equals(dataFormat.format(date.getTime())))//Compara os dados se e do mes actual
            {
                totalDespesaMesActual+=despesa.getValor();
                DespesasDoMesController.despesas.add(despesa);
                if(categorias.containsKey(despesa.getTipo()))
                {
                    double total=categorias.get(despesa.getTipo());//Busca a quantidade guardada da chave neste caso da categorai
                    System.out.println(categorias.get(despesa.getTipo()));//888888888888888888
                    total+=despesa.getValor();//Adiciona o valor guardado da categoria
                    categorias.replace(despesa.getTipo(),total);//Substitui o valor da categoria
                    System.out.println("Novo valor: "+categorias.get(despesa.getTipo()));

                }
                else
                {
                    categorias.put(despesa.getTipo(),despesa.getValor());
                }
            }
            if((Integer.valueOf(dataFormat.format(date.getTime()))-1)<10)//Compara os dados se e o mes anterior
            {
                String mesAnterior="0"+(Integer.valueOf(dataFormat.format(date.getTime()))-1);//Se o mes e menor que o 10 acrescenta um zero a frente para compessar o formato
                if (despesa.getData().substring(5,7).equals(mesAnterior))
                    totalDespesaMesAnterior+=despesa.getValor();
            }
        }

    }

    private void setarValoresDasDespesas(){

        labelDespesas.setText(totalDespesaMesActual+" Kzs");//Carrega o total na view
        labelDividas.setText(totalDividasMesActual+"Kzs");

        float percentagemDespesa= Math.round((float) (((100*totalDespesaMesActual)/totalDespesaMesAnterior)-100.0));
        float percentagemDividas= Math.round((float) (((100*totalDividasMesActual)/totalDividasMesAnterior)-100.0));

        if(percentagemDespesa>0)//Verifica a percentangem para determinar a cor que ser mostrado
        {
          if (totalDespesaMesAnterior==0){
              labelPercentagemDespesas.setStyle("-fx-text-fill: #ffffff");
              labelPercentagemDespesas.setText("-");
          }else {
              labelPercentagemDespesas.setStyle("-fx-text-fill: #2dcf09");
              labelPercentagemDespesas.setText("+"+percentagemDespesa+"%");
          }
        }
        else{
            if(totalDespesaMesAnterior==0)
            {
                labelPercentagemDespesas.setStyle("-fx-text-fill: #ff241c");
                labelPercentagemDespesas.setText("-");
            }
            else
            {
                labelPercentagemDespesas.setStyle("-fx-text-fill: #ff241c");
                labelPercentagemDespesas.setText("-"+percentagemDespesa+"%");
            }

        }

        if(percentagemDividas>0)//Verifica a percentangem para determinar a cor que ser mostrado
        {
           if (totalDividasMesAnterior==0){
               labelPercentagemDividas.setStyle("-fx-text-fill: #ffffff");
               labelPercentagemDividas.setText("-");
           }
           else
           {
               labelPercentagemDividas.setStyle("-fx-text-fill: #2dcf09");
               labelPercentagemDividas.setText("+"+percentagemDividas+"%");
           }
        }
        else{
            if(totalDividasMesAnterior==0)
            {
                labelPercentagemDividas.setStyle("-fx-text-fill: #ff241c");
                labelPercentagemDividas.setText("-");
            }
            else
            {
                labelPercentagemDividas.setStyle("-fx-text-fill: #ff241c");
                labelPercentagemDividas.setText("-"+percentagemDividas+"%");
            }

        }





    }

    private void carregarDividas(){


        DividaModel dividaModel=new DividaModel();
        dividas=dividaModel.listarDividas(LoginController.getPessoa().getUsername());
        dividasNPagas=new ArrayList<>();
        Date date= new Date();
        Format dataFormat= new SimpleDateFormat("MM");//Formata a data para so receber o mes
        DespesasDoMesController.dividasPagas=new ArrayList<Divida>();
        double total;


        for(Divida divida: dividas){

            if(divida.getDataDivida().substring(5,7).equals(dataFormat.format(date.getTime())))//Compara os dados se e do mes actual
            {

                if(divida.getEstado().equals("Pago")&&divida.getEstado()!=null)//Verifica se e uma divida paga
                {
                    totalDespesaMesActual+=divida.getValor();
                    DespesasDoMesController.dividasPagas.add(divida);
                    if (!categorias.containsKey("Divida"))//Verifica Se ja tem uma chave com o nome de Divida
                        categorias.put("Divida",divida.getValor());
                    else
                    {
                        total=categorias.get("Divida");//Busca a quantidade guardada da chave neste caso da categorai
                        total+=divida.getValor();//Adiciona o valor guardado da categoria
                        categorias.replace("Divida", total);//Substitui o valor da categoria
                    }
                }

                else{
                    dividasNPagas.add(divida);
                }

            }

        }

        totalDividasMesActual=dividaModel.totalDividasDoMesActual();
        totalDividasMesAnterior=dividaModel.totalDividasDoMesAnterior();
        DividasDoMesController.dividas=dividasNPagas;

    }




    private void carregarGraficos(){

            ObservableList<PieChart.Data> dados= FXCollections.observableArrayList();
            Enumeration<String> chaves=categorias.keys();

            while(chaves.hasMoreElements())//Itera as chaves
            {
                String chave=chaves.nextElement();
                dados.add(new PieChart.Data(chave,categorias.get(chave)));
                System.out.println(categorias.get(chave));
            }


            graphicPane.getChildren().clear();
            PieChart graficoCircular= new PieChart(dados);
            graphicPane.getChildren().add(graficoCircular);
            graficoCircular.setPrefSize(350,300);
            graficoCircular.setTitle("Grafico das Despesas");
            graficoCircular.getStylesheets().add("/finance/views/style.css");


//Grafico Linear

        Locale locale= new Locale("pt","pt-pt");
        DateFormat format= DateFormat.getDateInstance(DateFormat.FULL,locale);
Date date= new Date();


        Calendar calendar= Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(format.format(calendar.getTime()));
        String teste=format.format(calendar.getTime());
        System.out.println(teste);
        int posicao=teste.indexOf(",");
        System.out.println(posicao);
        System.out.println(teste.substring(0,posicao));
        calendar.add(Calendar.DAY_OF_MONTH, 2);//Acrescenta dias numa determinada Data
         teste=format.format(calendar.getTime());
        System.out.println(teste);
         posicao=teste.indexOf(",");
        System.out.println(posicao);
        System.out.println(teste.substring(0,posicao));
       // System.out.println(format.format(calendar.get(Calendar.DAY_OF_WEEK)));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        DiasDaSemana diasDaSemana= new DiasDaSemana();
       // calendar.setTime(calendar.add(Calendar.DAY_OF_MONTH,3));
       // date.setTime();
        System.out.println(diasDaSemana.diaDaSemana(calendar.get(Calendar.DAY_OF_WEEK)));
        //





//calendar.se










        XYChart.Series series= new XYChart.Series();
        XYChart.Series series2= new XYChart.Series();
        series.setName("Receitas");
        series2.setName("Dividas");

        series.getData().add(new XYChart.Data("0",10));
        series.getData().add(new XYChart.Data("1",23));
        series.getData().add(new XYChart.Data("2",2));
        series.getData().add(new XYChart.Data("3",23));
        series.getData().add(new XYChart.Data("4",25));
        series.getData().add(new XYChart.Data("5",34));
        series.getData().add(new XYChart.Data("6",29));
        series.getData().add(new XYChart.Data("7",28));
        series.getData().add(new XYChart.Data("8",228));



        series2.getData().add(new XYChart.Data("0",10));
        series2.getData().add(new XYChart.Data("1",28));
        series2.getData().add(new XYChart.Data("2",12));
        series2.getData().add(new XYChart.Data("3",40));
        series2.getData().add(new XYChart.Data("4",29));
        series2.getData().add(new XYChart.Data("5",37));
        series2.getData().add(new XYChart.Data("6",5));
        series2.getData().add(new XYChart.Data("7",20));
        series2.getData().add(new XYChart.Data("8",100));

        graficoLinear.getData().addAll(series,series2);

        }

        public void add(){

            AdicionarItemController controller= new AdicionarItemController();
            controller.showView();
            if(AdicionarItemController.adicionou==true) //Caso tenha Verifica se foi realmente adicionando algum item
            {
                carregarDados();
                AdicionarItemController.adicionou=false;
            }

        }


    }
