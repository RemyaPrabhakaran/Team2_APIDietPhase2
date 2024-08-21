package payload;

public class Patient_Vitals {

	public float Weight;
    public float Height;
    public float Temperature;
    public int SP;
    public int DP;
    
    public Patient_Vitals(float weight, float height, float temp, int sp, int dp)
    {
    	this.Weight=weight;
    	this.Height=height;
    	this.Temperature=temp;
    	this.SP=sp;
    	this.DP=dp;
    	
    }

}

