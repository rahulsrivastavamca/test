
public class Sallary {
  private int sallary;

public int getSallary() {
	return sallary;
}

public void setSallary(int sallary) throws NegativeSallaryException{
	if (sallary < 0){
		throw new NegativeSallaryException("sallary can not be negative.");
	}
	this.sallary = sallary;
}
	
}
