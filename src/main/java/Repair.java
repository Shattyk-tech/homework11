public class Repair implements Techinice{
    @Override
    public void changeDriver(Baza baza, DriverBase driverBase) {
        System.out.println("Нельзя сменить водителя");
    }

    @Override
    public void starDriver(Baza baza, DriverBase driverBase) {
        baza.setState("route");

    }

    @Override
    public void starRepair(Baza baza, DriverBase driverBase) {
        System.out.println("Уже в ремонте");

    }
}
