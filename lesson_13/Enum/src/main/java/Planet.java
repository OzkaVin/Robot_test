public enum Planet {
    MERCURY(1, 0, 23.5, null),
    VENUS(2, 234.5, 87.4, MERCURY),
    MARS(3, 456.2, 56.3, VENUS),
    EARTH(4, 564.8, 145.6, MARS),
    JUPITER(5, 478.3, 213.3, EARTH),
    SATURN(6, 323.7, 284.4, JUPITER),
    URANUS(7, 657.6, 203.9, SATURN),
    NEPTUNE(8, 478.5, 315.4, URANUS),
    PLANET_NINE(9, 654.4, 67.3, NEPTUNE);

    private final int number;
    private final double distanceFromPrevious;
    private double distanceFromSun;
    private final double radius;
    private Planet previousPlanet;
    private Planet nextPlanet;

    Planet(int number, double distancePrevious, double radius, Planet previousPlanet) {
        this.number = number;
        this.distanceFromPrevious = distancePrevious;
        this.radius = radius;
        this.previousPlanet = previousPlanet;

        if(previousPlanet != null) {
            previousPlanet.nextPlanet = this;
            this.distanceFromSun = previousPlanet.distanceFromSun + distanceFromPrevious;
        }
        else{
            // MERCURY case
            this.distanceFromSun = 657.8;
        }
    }

    public void getInfo(){
        System.out.println(this.number + ": Planet name - " + this.name() + " has radius " + this.radius + " km. And " + this.distanceFromSun + " km far from Sun.");
        System.out.println("Next planet - " + this.nextPlanet + ", previous planet - " + this.previousPlanet);
    }
}

