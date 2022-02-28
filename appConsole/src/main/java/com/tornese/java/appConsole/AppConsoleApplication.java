package com.tornese.java.appConsole;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;

@SpringBootApplication
public class AppConsoleApplication {

	private static double valorTotal;
	
	

	public static void main(String[] args) {
		/*
		João é um comerciante que vende laranjas 
		ele precisa fazer uma entrega de algumas coisas
		cada laranja que ele vendo custa 0,50 centavos, cada caixa tem 50 laranjas.

		Faça um programa que peça a quantidade de caixas para o João e de o total a receber.

		Perguntar ao cliente se o pagamento será a vista, caso seja a vista e o valor for maior que R$100,00 reias dar um desconto de 10%
		Caso o pagamento seja parcelado acrescentar 15% sobre o valor total

		obs: aceitar parcelas no máximo de 12 vezes, e mostrar o valor de cada parcela ja com acrescimo

		O lucro do comerciante será de 45% em suas vendas

		Dar um relatorio final sobre a operação acima



		*/

		System.out.println("=============================");
		System.out.println("Seja muito Bem Vindo João ao seu Software");
		System.out.println("=============================");

		Console cnsl = System.console();
		int quantidadeCaixas = Integer.parseInt(cnsl.readLine(" Digite a Quantidade de Ciaxas \n"));

		

		double valorLaranja = 0.50;
		int quantidadeLaranjaPorCaixa = 50;
		int quantidadeCaixaPromocao = 10;
		int porcentagemLucro = 40;
		int porcentagemDesconto = 10;
		int porcentagemAcrescimo = 15;
		int maximoParcelas = 12;
		double valorParaDesconto = 100;
		int totalDeLaranja = quantidadeCaixas * quantidadeLaranjaPorCaixa;
		double valoTotal = totalDeLaranja * valorLaranja;
		double valorTotalAlterado = valoTotal;
		int parcelas = 0;

		String tipoPagamento = cnsl.readLine(" Você deseja Pagar a Vista ou Parcelado? \n A - À Vista\n P - Parcelado\n");
		

		boolean aVista = tipoPagamento.toUpperCase().equals ("A");
		if(aVista){
			System.out.println("Voce Selecionou o Pagamento À Vista");
			if(valoTotal > valorParaDesconto || quantidadeCaixas == quantidadeCaixaPromocao){
				valorTotalAlterado -=(valoTotal *porcentagemDesconto/100);

			}
			
		}
		else{
			 parcelas = parseInt(cnsl.readLine("Voce selecionou Pagamento Parcelado, Digite a Quantidade de Parcelas\n"));
			if(parcelas > maximoParcelas){
				System.out.println("Quantidade de Parcelas Invalida, Iremos Assumir em " + maximoParcelas + " Vezes! ");
				parcelas = maximoParcelas;
			}

			if(parcelas == 1){
				System.out.println("Você Escolheu o Pagamento à Vista");
				if(valoTotal > valorParaDesconto || quantidadeCaixas == quantidadeCaixaPromocao){
					valorTotalAlterado -= (valoTotal * porcentagemDesconto / 100);
				}
			}

			else if(parcelas > 5)
				valorTotalAlterado += (valorTotal * porcentagemAcrescimo / 100);
			else{
				switch(parcelas){
					case 2:
					porcentagemAcrescimo = 5;
					break;
					case 3:
					porcentagemAcrescimo = 8;
					break;
					case 4:
					porcentagemAcrescimo = 10;
					break;
					case 5:
					porcentagemAcrescimo = 13;
					break;

				}
				valorTotalAlterado += (valoTotal * porcentagemAcrescimo / 100);
			}

			valorTotalAlterado += (valoTotal * porcentagemAcrescimo / 100);
			


		}

		double lucroAReceber = (valorTotalAlterado * porcentagemLucro / 100);



		System.out.println("=============================");
		System.out.println("Parabéns Pela Venda João");
		System.out.println("O seu Lucro é de: R$" + lucroAReceber);
		System.out.println("Valor Total a Receber é de: R$" + valorTotalAlterado);
		System.out.println("O Cliente Escolheu o tipo de Pagamento: " + (aVista ? "À Vista" : " Parcelado em " + parcelas + " Vezes "));
		if(aVista){
			System.out.println("Para Pagamento à Vista demos o Desconto de: R$ "+(valoTotal - valorTotalAlterado) );
			
		}
		else{
			System.out.println("Para Pagamento Parcelado O Acrescimo é De: R$" + (valorTotalAlterado - valoTotal ) );
			System.out.println("O Valor das Prcelas será de: R$" + ( valorTotalAlterado / parcelas ));
		}
		System.out.println("=============================");









		//SpringApplication.run(AppConsoleApplication.class, args);
	}



	private static int parseInt(String readLine) {
		return 0;
	}

	
	}


