package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

public class StudyCafeSeatPass implements StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafeSeatPass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafeSeatPass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafeSeatPass(passType, duration, price, discountRate);
    }

    public boolean isSameDurationType(StudyCafeLockerPass lockerPass) {
        return lockerPass.isSameDuration(this.duration)
                && lockerPass.isSamePassType(this.passType);
    }

    public boolean isSamePassType(StudyCafePassType type) {
        return this.passType == type;
    }

    @Override
    public StudyCafePassType getPassType() {
        return this.passType;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

}
