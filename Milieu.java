public class Milieu extends Joueur implements Remplacable{
	protected int vitesse;
	private int tir;
	private int passe;
	protected int dribble;
	private int defense;
	private int physique;
	public static int cptMil=0;

	// Les milieux de terrain sont les plus complets et les plus équilibrés, étant donc bon dans toutes les statistiques en général.
	
	public Milieu(String nom){
		super(nom);
		vitesse = 70 + (int)(Math.random() * ((80 - 70) + 1));
		tir = 60 + (int)(Math.random() * ((70 - 60) + 1));
		passe = 70 + (int)(Math.random() * ((90 - 70) + 1));
		dribble = 50 + (int)(Math.random() * ((60 - 50) + 1));
		defense = 50 + (int)(Math.random() * ((60 - 50) + 1));
		physique = 60 + (int)(Math.random() * ((70 - 60) + 1));
		}

	public Milieu clone(){
		Milieu at = new Milieu(nom);
		at.vitesse=vitesse;
		at.tir=tir;
		at.passe=passe;
		at.dribble=dribble;
		at.defense=defense;
		at.physique=physique;
		return at;
		}

	public String getNom(){
		return nom;
		}

	//Accesseurs du nombre de Milieu créés
	public static int getCptMil(){
		return cptMil;
		}

	//Présentation des stats du joueur
	public String presentation(){
		return nom+" | STATS -> VIT : "+vitesse+", TIR : "+tir+", PAS : "+passe+", DRI : "+dribble+", DEF : "+ defense+", PHY : "+ physique;
		}

	//Stats général du joueur
	public int statsGeneral(){
		return vitesse+tir+passe+dribble+defense+physique;
		}

		
	//Methodes pour l'interface Remplacable
	public void echauffement(){
		System.out.println("Le joueur part s'echauffer");
		}

	public void pret(){
		System.out.println("Le joueur est pret");
		}

	}
