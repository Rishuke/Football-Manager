public class Attaquant extends Joueur implements Remplacable{
	private int vitesse;
	private int tir;
	private int passe;
	private int dribble;
	private int defense;
	private int physique;
	public static int cptAtt=0;

	//Les attaquants sont très bon en tir et en vitesse pour pouvoir créer des occasions et de bons appels de balles, ils sont la pointe de l'équipe, en conséquence le physique et le niveau de défense est négligé.

	public Attaquant(String nom){
		super(nom);
		vitesse = 70 + (int)(Math.random() * ((90 - 70) + 1));
		tir = 70 + (int)(Math.random() * ((90 - 70) + 1));
		passe = 50 + (int)(Math.random() * ((60 - 50)+ 1));
		dribble = 60 + (int)(Math.random() * ((70 - 60) + 1));
		defense = 40 + (int)(Math.random() * ((50 - 40) + 1));
		physique = 50 + (int)(Math.random() * ((60 - 50) + 1));
		}


	public Attaquant clone(){
		Attaquant at = new Attaquant(nom);
		at.vitesse=vitesse;
		at.tir=tir;
		at.passe=passe;
		at.dribble=dribble;
		at.defense=defense;
		at.physique=physique;
		return at;
		}


	//Accesseurs du nombre d'Attaquant créés
	public static int getCptAtt(){
		return cptAtt;
		}
		

	public String getNom(){
		return nom;
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
