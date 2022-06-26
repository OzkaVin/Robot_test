public class Woman extends Person{
    private String maidenName;

    public Woman(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age, partner);
        this.maidenName = lastName;
    }

    public String getMaidenName(){
        return maidenName;
    }

    @Override
    public boolean isRetired(){
        return age>60;
    }

    @Override
    public boolean equals(Object o) {
        Woman that = (Woman) o;
        return super.equals(o) &&
                maidenName.equals(that.maidenName);
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

