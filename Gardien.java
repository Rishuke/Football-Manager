public class Gardien extends Joueur implements Remplacable{
	private int plongeon;
	private int jeuALaMain;
	private int tir;
	private int reflexes;
	private int vitesse;
	private int positionnement;
	public static int cptGar=0;

	//Il n'y aura pas de comparatif entre le gardien et les joueurs sur le terrain comme les statistiques sont différentes, nous cherchons uniquement le gardien avec les meilleurs statistiques pour pouvoir comparer avec le gardien adverse.


	public Gardien(String nom){
		super(nom);
		plongeon = 80 + (int)(Math.random() * ((90 - 80) + 1));
		jeuALaMain = 80 + (int)(Math.random() * ((90 - 80) + 1));
		tir = 70 + (int)(Math.random() * ((80 - 70) + 1));
		reflexes = 85 + (int)(Math.random() * ((95 - 85) + 1));
		vitesse = 50 + (int)(Math.random() * ((60 - 50) + 1));
		positionnement = 80 + (int)(Math.random() * ((90 - 80) + 1));
		}

	public Gardien clone(){
		Gardien at = new Gardien(nom);
		at.plongeon=plongeon;
		at.jeuALaMain=jeuALaMain;
		at.tir=tir;
		at.reflexes=reflexes;
		at.vitesse=vitesse;
		at.positionnement=positionnement;
		return at;
		}

	//Accesseur du nom du gardien
	public String getNom(){
		return nom;
		}

	//Accesseur du nombre de Gardien créés
	public static int getCptGar(){
		return cptGar;
		}

	//Statistiques détaillés du Gardien
	public String presentation(){
		return nom+" | STATS -> PLO : "+plongeon+", JAM : "+jeuALaMain+", TIR : "+tir+", REF : "+reflexes+", VIT : "+ vitesse+", POS : "+ positionnement;
		}

	//Statistique général du Gardien
	public int statsGeneral(){
		return plongeon+jeuALaMain+tir+reflexes+vitesse+positionnement;
		}

	//Methodes pour l'interface Remplacable
	public void echauffement(){
		System.out.println("Le joueur part s'echauffer");
		}

	public void pret(){
		System.out.println("Le joueur est pret");
		}

	}
