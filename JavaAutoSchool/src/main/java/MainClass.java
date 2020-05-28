public class MainClass {

    public static void main(String[] args) {

        BMW bmw = new BMW() ;
        Audi audi = new Audi();
        Volkswagen volkswagen = new Volkswagen();

        Program.fillInWithRandomData(bmw);
        Program.fillInWithRandomData(audi);
        Program.fillInWithRandomData(volkswagen);

        Car.printValueAndNameOfFieldsOfChildClass(bmw);
        Car.printValueAndNameOfFieldsOfChildClass(audi);
        Car.printValueAndNameOfFieldsOfChildClass(volkswagen);
    }

}
