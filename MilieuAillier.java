public class MilieuAillier extends Milieu implements Remplacable{
	private String nom;
	public static int cptMilAil=0;


	// Les Ailliers sont plus rapide et plus fort au niveau des dribbles que les milieux de terrain offensifs.
	
	public MilieuAillier(String nom){
		super(nom);
		vitesse+=10;
		dribble+=20;
		}


	//Un Ailier est aussi un Milieu donc +1
	public static int getCptMilAil(){
		return cptMil;
		}

	public String getNom(){
		return nom;
		}

	//Présentation des stats du joueur
	public String presentation(){
		return super.presentation();
		}

	//Stats général du joueur
	public int statsGeneral(){
		return super.statsGeneral();
		}

	}



