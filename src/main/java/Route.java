public class Route implements Techinice {


    @Override
    public void changeDriver(Baza baza, DriverBase driverBase) {
        System.out.println("Грузовик в пути, невозможно сменить водителя");
    }

    @Override
    public void starDriver(Baza baza, DriverBase driverBase) {
        System.out.println("Грузовик уже в пути");

    }

    @Override
    public void starRepair(Baza baza, DriverBase driverBase) {
        System.out.println("repair");

    }
}

