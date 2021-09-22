package classes;

public class Cartao extends Pagamento{
    private int prestacoes;

    public void setPrest(int newPrest){
        this.prestacoes = newPrest;
    }

    public int getPrest(){
        return this.prestacoes;
    }

    public float getValorPrest(){
        return (this.getValor()/this.getPrest());
    }

}
