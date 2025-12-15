import java.util.Stack;

public class Historico {
private Stack<Musica> historico = new Stack<>();


public void registrar(Musica m) {
historico.push(m);
}


public void voltar() {
if (historico.isEmpty()) {
System.out.println("Histórico vazio");
} else {
Musica m = historico.pop();
System.out.println("Voltando para: " + m);
}
}
}
