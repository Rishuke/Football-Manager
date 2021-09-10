public class Defenseur extends Joueur implements Remplacable{
	private int vitesse;
	private int tir;
	private int passe;
	private int dribble;
	private int defense;
	private int physique;
	public static int cptDef=0;


	//Les defenseurs se doivent d'avoir un physique imposant et un bon niveau de défense, la vitesse et le tir sont donc négligés pour la défense.
	
	public Defenseur(String nom){
		super(nom);
		vitesse = 40 + (int)(Math.random() * ((50 - 40) + 1));
		tir = 40 + (int)(Math.random() * ((50 - 40) + 1));
		passe = 50 + (int)(Math.random() * ((70 - 50) + 1));
		dribble = 40 + (int)(Math.random() * ((50 - 40) + 1));
		defense = 70 + (int)(Math.random() * ((90 - 70) + 1));
		physique = 70 + (int)(Math.random() * ((90 - 70) + 1));
		}

	public Defenseur clone(){
		Defenseur at = new Defenseur(nom);
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

	//Accesseurs du nombre de Defenseur créés
	public static int getCptDef(){
		return cptDef;
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
