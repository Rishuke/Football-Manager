public class TestEquipe{
	public static void main(String[]args){

		//Création de notre équipe
		Equipe n = new Equipe();

		//Création de l'équipe adverse
		EquipeAdverse m = new EquipeAdverse(n.listeGardien, n.listeDefenseur, n.listeMilieu, n.listeAttaquant);

		//Copie d'un attaquant
		System.out.println("\n");
		System.out.println("|!|Partie fictive|!|  TEST CLONAGE DANS LE CAS OU UN JOUEUR SE BLESSE. LA MACHINE TEST DE CLONAGE EST PRETE !");
		System.out.println("\n");
		Attaquant a = new Attaquant("Costa");
		System.out.println(a.presentation());
		Attaquant a2 = a.clone();
		System.out.println(a2.presentation());
		System.out.println("SUCCES");

		//Présentation des 20 joueurs selectionnés
		n.presentationSelectionDes20();

		//Présentation des 11 joueurs titulaires de l'équipe adverse
		m.presentationEquipeAdverse();
		System.out.println("\n");

		//Présentation en 2D de l'équipe adverse
		m.presentationEquipeAdverse2D();


		//Exception relevé tant que la variable passeG est fausse, on redemande à l'utilisateur de ressaisir son choix par faute sur le format.
		while(n.passeG == false){
			try{
				n.ajoutGardien();
			}catch(MauvaisFormatException e){
				System.out.println(e.getMessage());
				}
		}

		//Pareillement
		while(n.passeD == false){
			try{
				n.ajoutDefenseurs();
			}catch(MauvaisFormatException e){
				System.out.println(e.getMessage());
				}
		}

		//Pareillement
		while(n.passeM == false){
			try{
				n.ajoutMilieux();
			}catch(MauvaisFormatException e){
				System.out.println(e.getMessage());
				}
		}

		//Pareillement
		while(n.passeA == false){
			try{
				n.ajoutAttaquants();
			}catch(MauvaisFormatException e){
				System.out.println(e.getMessage());
				}
		}
	
		
		System.out.println("\n");
		
		//Les 11 titulaires
		n.presentationOnzeTitulaire();
		System.out.println("\n");
		
		//Les 11 titulaires en 2D
		n.presentationEquipeTitulaire2D();
		System.out.println("\n");

		
		//Résumé et pronostics d'avant-match.
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("STATISTIQUE DE L'EQUIPE ADVERSE :");
		System.out.println("---------------------------------");
		System.out.printf("Gardien adverse : %.1f/20 \n",m.genGarAdv());
		System.out.printf("Defense adverse : %.1f/20 \n",m.genDefAdv());
		System.out.printf("Milieu adverse : %.1f/20 \n",m.genMilAdv());
		System.out.printf("Attaque adverse : %.1f/20 \n",m.genAttAdv());
		System.out.printf("General equipe adverse : %.1f/20 \n",m.totalGenEquipeAdv());


		System.out.println("\n");
		System.out.println("\n");
		System.out.println("STATISTIQUE DE L'EQUIPE TITULAIRE :");
		System.out.println("---------------------------------");
		System.out.printf("Gardien titulaire : %.1f/20 \n",n.genGarTit());
		System.out.printf("Defense titulaire : %.1f/20 \n",n.genDefTit());
		System.out.printf("Milieu titulaire : %.1f/20 \n",n.genMilTit());
		System.out.printf("Attaque titulaire : %.1f/20 \n",n.genAttTit());
		System.out.printf("General equipe titulaire : %.1f/20 \n",n.totalGenEquipeTit());


		System.out.println("\n");
		System.out.println("\n");

		//Equipe gagnante ou pas.
		n.gagnant();
		
			}
		
	}

	
			
