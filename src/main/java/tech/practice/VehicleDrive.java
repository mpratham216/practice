package tech.practice;

public class VehicleDrive extends AbstractImpl implements InterfaceImpl {

	public VehicleDrive(String model, int year) {
		super(model, year);
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Car is Driving");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Car is started");
	}
		
}
