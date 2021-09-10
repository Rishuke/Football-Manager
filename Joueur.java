public abstract class Joueur{
	protected String nom;

	public Joueur(String nom){
		this.nom=nom;
		}


	public abstract String presentation();

	public abstract String getNom();

	public abstract int statsGeneral();

	}
