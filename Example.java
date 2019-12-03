
public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Movie1 m1=new Movie1("Chinese",10);
		Movie1 m2=new Movie1("Math",20);
		Movie1 m3=new Movie1("English",30);
		
		Renta1 r1=new Renta1(m1,5);
		Renta1 r2=new Renta1(m2,6);
		Renta1 r3=new Renta1(m3,7);
		
		Customer11 c1=new Customer11("Xu");
		Customer11 c2=new Customer11("Ning");
		
		c1.addRental(r1); 	c1.addRental(r2); 	c1.addRental(r3);
		
		c2.addRental(r1); c2.addRental(r2);
		
		System.out.println(c1.statement());
		System.out.println(c2.statement());
	}

}
