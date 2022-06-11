public class Woman extends Person{
    private String maidenName;

    public Woman(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age, partner);
        this.maidenName = lastName;
    }

    @Override
    public boolean isRetired(){
        return age>60;
    }

    @Override
    public void registerPartnership(Person partner){
        super.registerPartnership(partner);
        this.setLastName(partner.getLastName());
    }

    @Override
    public void deregisterPartnership(boolean bToPreviousSurname){
        super.deregisterPartnership(bToPreviousSurname);
        if (bToPreviousSurname)
            this.setLastName(maidenName);
    }

    @Override
    public void getInfo(){
        super.getInfo();
        System.out.println("Maiden name: " + maidenName);
    }
}
