package sateva.classes;

import java.util.ArrayList;

public class Tarefa {

  private String title;
  private String priority;
  private int percentagem;
  private String date;
  private String time;
  private String status;
  private ArrayList<Tarefa> subtarefas;
  private String description;

  public Tarefa(String title, String priority, int percentagem, String date, String time, String status, String description) {
    this.title = title;
    this.priority = priority;
    this.percentagem = percentagem;
    this.date = date;
    this.time = time;
    this.status = status;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Tarefa(String title) {
    this.title = title;
  }

  public Tarefa(String title, String priority, String date, String time) {
    this.title = title;
    this.priority = priority;
    this.date = date;
    this.time = time;
  }

  public Tarefa(String title, String date, String time) {
    this.title = title;
    this.date = date;
    this.time = time;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public int getPercentagem() {
    return percentagem;
  }

  public void setPercentagem(int percentagem) {
    this.percentagem = percentagem;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ArrayList<Tarefa> getSubtarefas() {
    return subtarefas;
  }

  public void setSubtarefas(ArrayList<Tarefa> subtarefas) {
    this.subtarefas = subtarefas;
  }

}
