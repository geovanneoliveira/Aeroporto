package oo.aeroporto.view;

public class View {

	public static void main(String[] args) {
		
		Fachada f = new Fachada();
		
		f.clickCadastrarCompanhia(1, "thomas");
		f.clickCadastrarCompanhia(1, "Stark");
	}

}
