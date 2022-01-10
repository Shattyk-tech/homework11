public class State implements Techinice{


    @Override
    public void changeDriver(Baza baza, DriverBase driverBase) {
        baza.setDriver(driverBase.getName());

    }

    @Override
    public void starDriver(Baza baza, DriverBase driverBase) {
        baza.setState("route");

    }

    @Override
    public void starRepair(Baza baza, DriverBase driverBase) {
        baza.setName("repair");

    }
}
