import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.text.NumberFormat;

public class Equipe{
	//Les 3 catégories d'équipes. L'équipe de selection contenant les 20 joueurs appelés pour la selection. L'équipe des 11 titulaires pour le match et l'équipe de remplacant.
	public static ArrayList<Joueur> equipeSelect;
	private ArrayList<Joueur> equipeTitulaire;
	private ArrayList<Remplacable> equipeDeRemplacement;

	//Servira pour l'analyse de fin de match pour déterminer quelle équipe l'emportera
	public static int point=0; 

	//Variables pour la note général des statistiques Gardien / Defenseurs / Milieux / Attaquants.
	public static double genGarTit;
	public static double genDefTit;
	public static double genMilTit;
	public static double genAttTit;
	public static double genTotalTit;

	//Variables servant pour la boucle pour l'exception qui sera relevé si la saisie des joueurs de l'équipe est mauvaise. Afin de pouvoir redemander à l'utilisateur une nouvelle saisie de choix.
	public static boolean passeG=false;
	public static boolean passeD=false;
	public static boolean passeM=false;
	public static boolean passeA=false;

	
	

	//Le tableau des joueurs pouvant être selectionnés selon leur postes.
	protected String[] nomGar = {"Lloris","Neuer","Buffon","Courtois","Barthez","Khan"};
	protected String[] nomDef = {"Van Dijk","Thiago","Ramos","Pique","Alba","Alder","Hummels","Laporte","Silva","Thuram","Bonucci","Kimich","Marqui","Umtiti","Alaba","Sandro"};
	protected String[] nomMil = {"Zidane","Pogba","De Bruyne","Veratti","Matuidi","Rabiot","Kroos","Modric","Silva","Kopa"};
	protected String[] nomMilAil = {"Cuadrado","Torres","Sancho","Mane","Ribery","Junior"};
	protected String[] nomAt = {"MBappe","Icardi","Cavani","Ronaldo","Neymar","Messi","Giroud","Zlatan","Thauvin","Dembele","Cavani","Hazard","Martial","Payet"};
	protected String[] nomRempl = {"Hoareau","Menes","Chantome","Armand","Lahm","Mishi","Sakai","Song","Park"};

	//L'arrayList contenant les joueurs selon leur catégories.
	public static ArrayList<String> listeGardien = new ArrayList<String>();
	public static ArrayList<String> listeDefenseur = new ArrayList<String>();
	public static ArrayList<String> listeMilieu = new ArrayList<String>();
	public static ArrayList<String> listeMilieuAillier = new ArrayList<String>();
	public static ArrayList<String> listeAttaquant = new ArrayList<String>();
	public static ArrayList<String> listeRemplacant = new ArrayList<String>();

	//Variable pour la saisie
	private Scanner sc;

	
	//CREATION EQUIPE AVEC LA LISTE DES 20
	public Equipe(){
		equipeSelect = new ArrayList<Joueur>();
		equipeTitulaire = new ArrayList<Joueur>();
		Joueur aleatoire;

		sc= new Scanner(System.in);

		//INITIALISATION DES JOUEURS DANS LES ARRAYLISTS
		for(int i=0; i < 6 ; i++){
			listeGardien.add(nomGar[i]);
			}
		
		for(int i=0; i < 16 ; i++){
			listeDefenseur.add(nomDef[i]);
			}
		
		for(int i=0; i < 10 ; i++){
			listeMilieu.add(nomMil[i]);
			}

		for(int i=0; i < 6 ; i++){
			listeMilieuAillier.add(nomMilAil[i]);
			}
		
		for(int i=0; i < 14 ; i++){
			listeAttaquant.add(nomAt[i]);
			}

		for(int s = 0; s<9 ; s++){
			listeRemplacant.add(nomRempl[s]);
			}

		//SELECTION DES 20 JOUEURS MIS ALEATOIREMENT DANS L'EQUIPESELECT 
	
		for(int i = 0 ; i < 3 ; i++){
			int placeAlea = (int)(Math.random() * listeGardien.size());
			aleatoire = new Gardien(listeGardien.get(placeAlea));
			equipeSelect.add(aleatoire);
			listeGardien.remove(placeAlea);
			Gardien.cptGar++;
			
		}
	
		for(int j = 3 ; j < 8 ; j++){
			int placeAlea = (int)(Math.random() * listeDefenseur.size());
			aleatoire = new Defenseur(listeDefenseur.get(placeAlea));
			equipeSelect.add(aleatoire);
			listeDefenseur.remove(placeAlea);
			Defenseur.cptDef++;
		}
		
		for(int k = 8 ; k < 10 ; k++){
			int placeAlea = (int)(Math.random() * listeMilieu.size());
			aleatoire = new Milieu(listeMilieu.get(placeAlea));
			equipeSelect.add(aleatoire);
			listeMilieu.remove(placeAlea);
			Milieu.cptMil++;
			
		}

		for(int k = 10 ; k < 13 ; k++){
			int placeAlea = (int)(Math.random() * listeMilieuAillier.size());
			aleatoire = new MilieuAillier(listeMilieuAillier.get(placeAlea));
			equipeSelect.add(aleatoire);
			listeMilieuAillier.remove(placeAlea);
			Milieu.cptMil++;
			
		}
		
		for(int l = 13 ; l < 20 ; l++){
			int placeAlea = (int)(Math.random() * listeAttaquant.size());
			aleatoire = new Attaquant(listeAttaquant.get(placeAlea));
			equipeSelect.add(aleatoire);
			listeAttaquant.remove(placeAlea);
			Attaquant.cptAtt++;

		}

		//EQUIPE DE REMPLACEMENT CONSTITUER DE JOUEURS REMPLACANT (UTILISANT L'INTERFACE REMPLACABLE)

		/*
		for(int a = 0; a < 3 ; a++){
			Remplacable r = new Attaquant(listeRemplacant.get(a));
			equipeDeRemplacement.add(r);
			}

		for(int b = 3; b < 6 ; b++){
			Remplacable r = new Milieu(listeRemplacant.get(b));
			equipeDeRemplacement.add(r);
			}

		for(int c = 6; c < 9 ; c++){
			Remplacable r = new Defenseur(listeRemplacant.get(c));
			equipeDeRemplacement.add(r);
			}
			*/
			
	}


	//CHOIX GARDIEN
	public void ajoutGardien() throws MauvaisFormatException{
		System.out.println("\n Quel est le gardien que vous souhaitez choisir ? \n");
		for(int i = 0; i < 3 ; i++){
			 System.out.println(i+1+"/ "+equipeSelect.get(i).presentation()+"\n");
			}
		int str;
		str=sc.nextInt();
		//Exception si la saisie est mauvaise.
		if(str>3 || str==0){
				throw new MauvaisFormatException();
				
			}else{
				if(str==1){
					passeG=true;
					equipeTitulaire.add(equipeSelect.get(0));
					}
				if(str==2){
					passeG=true;
					equipeTitulaire.add(equipeSelect.get(1));
					}
				if(str==3){
					passeG=true;
					equipeTitulaire.add(equipeSelect.get(2));
					}
			}
		}
		


	//CHOIX DEFENSEURS
	public void ajoutDefenseurs() throws MauvaisFormatException{
		System.out.println("\n Quels sont les quatres defenseurs que vous souhaitez choisir ? \n");
		for(int i = 3; i < 8 ; i++){
			 System.out.println(i-2+"/ "+equipeSelect.get(i).presentation()+"\n");
			}
		int str;
		str=sc.nextInt();
		//Exception si la saisie est mauvaise.
		if(str!=1234 && str!=1235 && str!=1245 && str!=1345 && str!=2345){
				throw new MauvaisFormatException();
				
			}else{
				//CHOIX
				if(str==1234){
					passeD=true;
					equipeTitulaire.add(equipeSelect.get(3));
					equipeTitulaire.add(equipeSelect.get(4));
					equipeTitulaire.add(equipeSelect.get(5));
					equipeTitulaire.add(equipeSelect.get(6));
					}
				if(str==1235){
					passeD=true;
					equipeTitulaire.add(equipeSelect.get(3));
					equipeTitulaire.add(equipeSelect.get(4));
					equipeTitulaire.add(equipeSelect.get(5));
					equipeTitulaire.add(equipeSelect.get(7));
					}
				if(str==1245){
					passeD=true;
					equipeTitulaire.add(equipeSelect.get(3));
					equipeTitulaire.add(equipeSelect.get(4));
					equipeTitulaire.add(equipeSelect.get(6));
					equipeTitulaire.add(equipeSelect.get(7));
				}
				if(str==1345){
					passeD=true;
					equipeTitulaire.add(equipeSelect.get(3));
					equipeTitulaire.add(equipeSelect.get(5));
					equipeTitulaire.add(equipeSelect.get(6));
					equipeTitulaire.add(equipeSelect.get(7));
					}
				if(str==2345){
					passeD=true;
					equipeTitulaire.add(equipeSelect.get(4));
					equipeTitulaire.add(equipeSelect.get(5));
					equipeTitulaire.add(equipeSelect.get(6));
					equipeTitulaire.add(equipeSelect.get(7));
				}
		
			}
		}

	//CHOIX MILIEUX
	public void ajoutMilieux() throws MauvaisFormatException{
		System.out.println("\n Quels sont les quatres milieux que vous souhaitez choisir ? \n");
		for(int i = 8; i < 13 ; i++){
			 System.out.println(i-7+"/ "+equipeSelect.get(i).presentation()+"\n");
			}
		int str;
		str=sc.nextInt();
		//Exception si la saisie est mauvaise.
		if(str!=1234 && str != 1235 && str!=1245 && str!=1345 && str !=2345){
				throw new MauvaisFormatException();
				
			}else{
				//CHOIX
				if(str==1234){
					passeM=true;
					equipeTitulaire.add(equipeSelect.get(8));
					equipeTitulaire.add(equipeSelect.get(9));
					equipeTitulaire.add(equipeSelect.get(10));
					equipeTitulaire.add(equipeSelect.get(11));
					}
				if(str==1235){
					passeM=true;
					equipeTitulaire.add(equipeSelect.get(8));
					equipeTitulaire.add(equipeSelect.get(9));
					equipeTitulaire.add(equipeSelect.get(10));
					equipeTitulaire.add(equipeSelect.get(12));
					}
				if(str==1245){
					passeM=true;
					equipeTitulaire.add(equipeSelect.get(8));
					equipeTitulaire.add(equipeSelect.get(9));
					equipeTitulaire.add(equipeSelect.get(11));
					equipeTitulaire.add(equipeSelect.get(12));
					}
				if(str==1345){
					passeM=true;
					equipeTitulaire.add(equipeSelect.get(8));
					equipeTitulaire.add(equipeSelect.get(10));
					equipeTitulaire.add(equipeSelect.get(11));
					equipeTitulaire.add(equipeSelect.get(12));
					}
				if(str==2345){
					passeM=true;
					equipeTitulaire.add(equipeSelect.get(9));
					equipeTitulaire.add(equipeSelect.get(10));
					equipeTitulaire.add(equipeSelect.get(11));
					equipeTitulaire.add(equipeSelect.get(12));
					}
			}
		}
		

	//CHOIX ATTAQUANTS
	public void ajoutAttaquants() throws MauvaisFormatException{
		System.out.println("\n Quels sont les deux attaquants que vous souhaitez choisir ? \n");
		for(int i = 13; i < 20 ; i++){
			 System.out.println(i-12+"/ "+equipeSelect.get(i).presentation()+"\n");
			}
		int str;
		str=sc.nextInt();
		//Exception si la saisie est mauvaise.
		if(str!=12 && str!=13 && str!=14 && str!=15 && str!=16 && str!=23 && str!=24 && str!=25 && str!=26 && str!=34 && str!=35 && str!=36 && str!=45 && str!=46 && str!=56){
				throw new MauvaisFormatException();
				
			}else{
				//CHOIX
				if(str==12){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(13));
					equipeTitulaire.add(equipeSelect.get(14));
					}
				if(str==13){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(13));
					equipeTitulaire.add(equipeSelect.get(15));
					}
				if(str==14){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(13));
					equipeTitulaire.add(equipeSelect.get(16));
					}
				if(str==15){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(13));
					equipeTitulaire.add(equipeSelect.get(17));
					}
				if(str==16){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(13));
					equipeTitulaire.add(equipeSelect.get(18));
					}
				if(str==23){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(14));
					equipeTitulaire.add(equipeSelect.get(15));
					}
				if(str==24){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(14));
					equipeTitulaire.add(equipeSelect.get(16));
					}
				if(str==25){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(14));
					equipeTitulaire.add(equipeSelect.get(17));
					}
				if(str==26){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(14));
					equipeTitulaire.add(equipeSelect.get(18));
					}
				if(str==34){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(15));
					equipeTitulaire.add(equipeSelect.get(16));
					}
				if(str==35){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(15));
					equipeTitulaire.add(equipeSelect.get(17));
					}
				if(str==36){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(15));
					equipeTitulaire.add(equipeSelect.get(18));
					}
				if(str==45){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(16));
					equipeTitulaire.add(equipeSelect.get(17));
					}
				if(str==46){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(16));
					equipeTitulaire.add(equipeSelect.get(18));
					}
				if(str==56){
					passeA=true;
					equipeTitulaire.add(equipeSelect.get(17));
					equipeTitulaire.add(equipeSelect.get(18));
					}
			}
	}


		

	//PRESENTATION DES 20 JOUEURS SELECTIONNES
	public void presentationSelectionDes20(){
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("VOICI LA LISTE DES 20 JOUEURS SELECTIONNES POUR LE PROCHAIN MATCH");
		for(int i = 0 ; i < 20 ; i++){
			if(i==0){
				System.out.println("\n");
				System.out.println("LES "+Gardien.getCptGar()+" GARDIENS :");
				System.out.println("----------------");
				System.out.println("\n");
				}
			if(i==3){
				System.out.println("\n");
				System.out.println("LES "+Defenseur.getCptDef()+" DEFENSEURS :");
				System.out.println("------------------");
				System.out.println("\n");
				}
			if(i==8){
				System.out.println("\n");
				System.out.println("LES "+Milieu.getCptMil()+" MILIEUX :");
				System.out.println("---------------");
				System.out.println("\n");
				}
			if(i==13){
				System.out.println("\n");
				System.out.println("LES "+Attaquant.getCptAtt()+" ATTAQUANTS :");
				System.out.println("------------------");
				System.out.println("\n");
				}
			System.out.println(equipeSelect.get(i).presentation());
			
		}
	}


	//PRESENTATION DES 11 TITULAIRES
	public void presentationOnzeTitulaire(){
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("VOICI LA LISTE DES 11 JOUEURS TITULAIRES POUR LE PROCHAIN MATCH");
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
				System.out.println("---------");
				System.out.println("\n");
				}
			if(i==9){
				System.out.println("\n");
				System.out.println("ATTAQUANTS :");
				System.out.println("------------");
				System.out.println("\n");
				}
			System.out.println(equipeTitulaire.get(i).presentation());
			
		}
		
	}


	//PRESENTION EN 2D (à plat) SUR LE TERRAIN DES TITULAIRES
	public void presentationEquipeTitulaire2D(){
		System.out.println("\n");
		System.out.println("          "+equipeTitulaire.get(equipeTitulaire.size()-1).nom+"       "+equipeTitulaire.get(equipeTitulaire.size()-2).nom+"         \n");
		System.out.println(equipeTitulaire.get(equipeTitulaire.size()-3).nom+"     "+equipeTitulaire.get(equipeTitulaire.size()-4).nom+"     "+equipeTitulaire.get(equipeTitulaire.size()-5).nom+"     "+equipeTitulaire.get(equipeTitulaire.size()-6).nom+"\n");
		System.out.println(equipeTitulaire.get(equipeTitulaire.size()-7).nom+"     "+equipeTitulaire.get(equipeTitulaire.size()-8).nom+"     "+equipeTitulaire.get(equipeTitulaire.size()-9).nom+"     "+equipeTitulaire.get(equipeTitulaire.size()-10).nom+"\n");
		System.out.println("               (C)"+equipeTitulaire.get(equipeTitulaire.size()-11).nom+"                \n");
		}

	//ACCESEUR DE LA LISTE
	public ArrayList<Joueur> getListeDesOnze(){
		return equipeTitulaire;
		}

	//NOTE GENERAL DE L'EQUIPE
	public double totalGenEquipeTit(){
		genTotalTit = (double)(genGarTit + genDefTit + genMilTit + genAttTit)/7800*20;
		return genTotalTit;
		}

	//NOTE GENERAL DU GARDIEN
	public double genGarTit(){
		genGarTit=(double)equipeTitulaire.get(0).statsGeneral()/600*20;
		return genGarTit;
		}

	//NOTE GENERAL DES DEFENSEURS
	public double genDefTit(){
		for(int i=1; i < 5 ; i++){
			genDefTit += equipeTitulaire.get(i).statsGeneral();
			}
		return (double)genDefTit/2400*20;
		}

	//NOTE GENERAL DES MILIEUX
	public double genMilTit(){
		for(int i=5; i < 9 ; i++){
			genMilTit += equipeTitulaire.get(i).statsGeneral();
			}
		return (double)genMilTit/2400*20;
		}
		
	//NOTE GENERAL DES ATTAQUANTS
	public double genAttTit(){
		for(int i=9; i < 11 ; i++){
			genAttTit += equipeTitulaire.get(i).statsGeneral();
			}
		return (double)genAttTit/2400*20;
		}
		

	//ANALYSE D'AVANT MATCH SELON LES STATISTIQUES GENERES AVANT
	public void gagnant(){
		System.out.println("RESUME DE L'ANALYSE : \n");
		if(genAttTit > EquipeAdverse.genDefAdv){
			point++;
			System.out.println(" - Attaque gagnante sur la defense adverse. \n");
			}else{
				EquipeAdverse.point++;
				System.out.println(" - Defense adverse gagnante sur votre attaque. \n");
				
				}

		if(genDefTit > EquipeAdverse.genAttAdv){
			point++;
			System.out.println(" - Defense gagnante sur l'attaque adverse. \n");
			}else{
				EquipeAdverse.point++;
				System.out.println(" - Attaque adverse gagnante sur votre defense. \n");
				}

		if(genMilTit > EquipeAdverse.genMilAdv){
			point++;
			System.out.println(" - Milieux gagnant. \n");
			}else{
				EquipeAdverse.point++;
				System.out.println(" - Milieux gagnant. \n");
				}

		if(genGarTit > EquipeAdverse.genGarAdv){
			point++;
			System.out.println(" - Statistique de votre gardien meilleur et plus completes. \n");
			}else{
				EquipeAdverse.point++;
				System.out.println(" - Statistiques du gardien adverse meilleur et plus completes. \n");
				}

		if(point > EquipeAdverse.point){
			if (genTotalTit > EquipeAdverse.genTotalAdv){
				System.out.println(" - Statistiques general de l'equipe meilleures que celles adverse. \n \n Votre composition d'equipe est sure de gagner, votre composition domine celle de l'equipe adverse sur le terrain. Meme les statistiques general de l'equipe adverse ne lui permettrait pas de gagner. \n");
				}else{
					System.out.println(" - Statistiques general de l'equipe moins bonne que celle de l'equipe adverse. \n \n Votre composition d'equipe est sure de gagner, votre composition domine celle de l'equipe adverse sur le terrain. ATTENTION, neanmoins les statistiques de l'equipe adverse sont meilleurs, un petit changement est requis pour assurer la victoire. \n");
				}
			}else{
				if(genTotalTit > EquipeAdverse.genTotalAdv){
					System.out.println(" - Statistiques general de l'equipe meilleures que celles adverse. \n \n Malheureusement votre composition d'equipe ne vous assurera pas la victoire, une recomposition est necessaire. NEANMOINS rien n'est perdu car vos statistiques d'equipe sont meilleurs que celle de l'equipe adverse, une recomposition de l'equipe est requise pour assurer la victoire. \n");
					}else{
						System.out.println(" - Statistiques general de l'equipe moins bonne que celle de l'equipe adverse. \n \n Vous allez perdre a coup sur. L'equipe adverse domine sur la plupart des lignes du terrain et sur les statistiques de l'equipe. Une recomposition total de l'equipe est necessaire. \n");
					}
				}
			}



		
}
