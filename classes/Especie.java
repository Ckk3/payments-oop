package classes;

public class Especie extends Pagamento{ 
    private float valorUsr;

    public void setValorUsr(float newValor){
        this.valorUsr = newValor;
    }

    protected float getValorUsr(){
        return this.valorUsr;
    }

    public float getTroco(){
        return (this.getValorUsr() - this.getValor());
    }
}
