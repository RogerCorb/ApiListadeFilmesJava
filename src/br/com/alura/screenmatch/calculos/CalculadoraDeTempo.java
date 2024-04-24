package br.com.alura.screenmatch.calculos;
import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;
// **** aqui chamavamos as duas classes Filme e Serie
// **** imagina se amanhã tivéssemos Desenhos e novelas ?
// **** teriamos que criar mais metodos inclui passando estas
// **** estas novas classes ... para evitar isso usaremos o
// **** conceito POLIMORFISMO e chamaremos a SUPERCLASSE TITULO
// **** pois ela é a classe mae de série e filmes e tratará separadamente
// **** quando eu chamar o método INCLUI cada classe.
//    public void inclui(Filme f) {
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void inclui(Serie s) {   // Sobrecarga de método mesmo nome porém parametros diferentes
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }

    public void inclui(Titulo titulo){
        System.out.println("Adicionando duração em minutos de " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }

    public int getTempoTotal() {
        return this.tempoTotal;
    }
}
