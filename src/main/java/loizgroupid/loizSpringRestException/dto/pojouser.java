package loizgroupid.loizSpringRestException.dto;

public class pojouser {
	
	private String nom ;
	private String prenom ;		
	
	
	public pojouser(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public pojouser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
