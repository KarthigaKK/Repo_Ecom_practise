import java.util.Collection;
import java.util.List;

public class ApplicationHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rooms oxford=new Rooms("oxford","suite",3,125.00);
		Rooms Stanford=new Rooms("Stanford","private",1,400.00);
		Rooms IIM=new Rooms("IIM","guest",3,125.00);
		Rooms Karthiga=new Rooms("Karthiga","Shivam",1,125.00);
		
		Collection<Rooms> room=List.of(oxford,Stanford,IIM,Karthiga);
		
		double rate=getPotentialRevenue(room);
		System.out.println(rate);
	}
	
	public static double getPotentialRevenue(Collection<Rooms> room)
	{
		return room.stream()
				.mapToDouble(r->r.getRate())
				.sum();
	}

}
