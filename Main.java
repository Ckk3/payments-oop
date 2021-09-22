import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import classes.*;

class Main {
  static float valorTotal;
  public static void main(String[] args){
    
    //Instanciando classe de pagamento
    Scanner scanner = new Scanner(System.in);
    //listas com cada tipo de objeto
    List<Especie> especieList = new ArrayList<Especie>(); 
    List<Cartao> cartaoList = new ArrayList<Cartao>(); 
    List<CreditoeDebito> cartaoDebitoList = new ArrayList<CreditoeDebito>(); 
    while(true){
      
      System.out.print("Insira o valor da compra: (Digite 'parar' para receber o relatorio)\n-");
      String resp = scanner.next();
      if(resp.equals("parar"))
        break;
      float valor = Float.parseFloat(resp);
      valorTotal += valor;

      System.out.println("Escolha uma opcao:\n1- Dinheiro em especie\n2- Credito\n3- Debito");
      String opcao = scanner.next();
      
      switch(opcao){
        case "1":
          pagDinheiro(valor, scanner, especieList);
          break;
        case "2":
          pagCartao(valor, scanner, cartaoList, cartaoDebitoList);
          break;
        case "3":
          pagCreditoDebito(valor, cartaoDebitoList);
          break;
        default:
          System.out.println("Escolha uma opcao valida");
      }
    }
    printFinal(cartaoDebitoList, cartaoList, especieList);
  }


  public static void pagDinheiro(float valor, Scanner scanner, List<Especie> especieList){
    Especie pag = new Especie();
    pag.setValor(valor);
    System.out.print("Insira o valor pago pelo usuário-");
    float valorUsr = scanner.nextFloat();
    pag.setValorUsr(valorUsr);
    especieList.add(pag);
  }

  public static void pagCartao(float valor, Scanner scanner, List<Cartao> cartaoList, List<CreditoeDebito> cartaoDebitoList){
    Cartao pag = new Cartao();
    pag.setValor(valor);
    System.out.print("Insira o numero de prestacoes -");
    int numPrest = scanner.nextInt();
    
    if(numPrest==1){
      pagCreditoDebito(valor, cartaoDebitoList);
    }
    else{
      pag.setPrest(numPrest);
      cartaoList.add(pag);
    }
  }

  public static void pagCreditoDebito(float valor, List<CreditoeDebito> cartaoDebitoList){
    CreditoeDebito pag = new CreditoeDebito();
    pag.setValor(valor);
    cartaoDebitoList.add(pag);
  }


  public static void printFinal(List<CreditoeDebito> cartaoDebitoList, List<Cartao> cartaoList, List<Especie> especieList){
    System.out.print("\n\n\n");

    System.out.println("Quantidade de operações: " + (cartaoDebitoList.size() + cartaoList.size() + especieList.size()));

    System.out.println("Operações por cada tipo");
    System.out.println("Dinheiro em Espécie: " + especieList.size());
    System.out.println("Cartão de Credito: " + cartaoList.size());
    System.out.println("Débito ou 1x no Crédito: " + cartaoDebitoList.size());

    System.out.print("\nO valor total gasto foi de: R$" + valorTotal);


  }
}