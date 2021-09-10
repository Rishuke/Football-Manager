import java.util.ArrayList;

public class EquipeAdverse{

	//ArrayList selon les postes pour l'équipe adverse
	private ArrayList<Joueur> equipeAdverse;
	private ArrayList<String> gard;
	private ArrayList<String> def;
	private ArrayList<String> mid;
	private ArrayList<String> att;

	//Variables pour obtenir les statistiques de l'équipe adverse
	public static double genGarAdv;
	public static double genDefAdv;
	public static double genMilAdv;
	public static double genAttAdv;
	public static double genTotalAdv;

	//Servira pour l'analyse de fin de match pour déterminer quelle équipe l'emportera
	public static int point=0;

	//Creation de l'équipe adverse (= reste de ce qui n'a pas été choisi lors de l'initialisation de notre équipe de 20 joueurs)
	public EquipeAdverse(ArrayList<String> g, ArrayList<String> d, ArrayList<String> m, ArrayList<String> a){
		equipeAdverse = new ArrayList<Joueur>();
		gard = g;
		def = d;
		mid = m;
		att = a;

		for(int i = 0 ; i < 1 ; i++){
			equipeAdverse.add(new Gardien(gard.get(i)));
			}

		for(int i = 0 ; i < 4 ; i++){
			equipeAdverse.add(new Defenseur(def.get(i)));
			}

		for(int i = 0 ; i < 4 ; i++){
			equipeAdverse.add(new Milieu(mid.get(i)));
			}

		for(int i = 0 ; i < 2 ; i++){
			equipeAdverse.add(new Attaquant(att.get(i)));
			}

		}

	//PRESENTATION DE L'EQUIPE ADVERSE
	public void presentationEquipeAdverse(){
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("VOICI LA LISTE DES 11 JOUEURS SELECTIONNES DE L'EQUIPE ADVERSE POUR LE PROCHAIN MATCH");
		for(int i = 0 ; i < 11 ; i++){
			if(i==0){
				System.out.println("\n");
				System.out.println("GARDIENS :");
				System.out.println("----------");
				System.out.println("\n");
				}
			if(i==1){
				System.out.println("\n");
				System.out.println("DEFENSEURS :");
				System.out.println("------------");
				System.out.println("\n");
				}
			if(i==5){
				System.out.println("\n");
				System.out.println("MILIEUX :");
				System.out.println("----------");
				System.out.println("\n");
				}
			if(i==9){
				System.out.println("\n");
				System.out.println("ATTAQUANTS :");
				System.out.println("------------");
				System.out.println("\n");
				}
			System.out.println(equipeAdverse.get(i).presentation());
			
			}
		}

	//PRESENTATION DE L'EQUIPE ADVERSE (à plat) SUR LE TERRAIN
	public void presentationEquipeAdverse2D(){
		System.out.println("\n");
		System.out.println("          "+equipeAdverse.get(equipeAdverse.size()-1).nom+"       "+equipeAdverse.get(equipeAdverse.size()-2).nom+"         \n");
		System.out.println(equipeAdverse.get(equipeAdverse.size()-3).nom+"     "+equipeAdverse.get(equipeAdverse.size()-4).nom+"     "+equipeAdverse.get(equipeAdverse.size()-5).nom+"     "+equipeAdverse.get(equipeAdverse.size()-6).nom+"\n");
		System.out.println(equipeAdverse.get(equipeAdverse.size()-7).nom+"     "+equipeAdverse.get(equipeAdverse.size()-8).nom+"     "+equipeAdverse.get(equipeAdverse.size()-9).nom+"     "+equipeAdverse.get(equipeAdverse.size()-10).nom+"\n");
		System.out.println("               (C)"+equipeAdverse.get(equipeAdverse.size()-11).nom+"                \n");
		}


	
	//STATISTIQUES ADVERSE

	public double totalGenEquipeAdv(){
		genTotalAdv = (double)(genGarAdv + genDefAdv + genMilAdv + genAttAdv)/7800*20;
		
		return genTotalAdv;
		}

	public double genGarAdv(){
		genGarAdv=(double)equipeAdverse.get(0).statsGeneral()/600*20;
		return genGarAdv;
		}

	public double genDefAdv(){
		for(int i=1; i < 5 ; i++){
			genDefAdv += equipeAdverse.get(i).statsGeneral();
			}
		return (double)genDefAdv/2400*20;
		}

	public double genMilAdv(){
		for(int i=5; i < 9 ; i++){
			genMilAdv += equipeAdverse.get(i).statsGeneral();
			}
		return (double)genMilAdv/2400*20;
		}

	public double genAttAdv(){
		for(int i=9; i < 11 ; i++){
			genAttAdv += equipeAdverse.get(i).statsGeneral();
			}
		return (double)genAttAdv/2400*20;
		}

	
		
	

	}


























	
