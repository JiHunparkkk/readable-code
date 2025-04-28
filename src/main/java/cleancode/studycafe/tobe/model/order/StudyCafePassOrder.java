package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import java.util.Optional;

public class StudyCafePassOrder {

    private final StudyCafeSeatPass seatPass;
    private final StudyCafeLockerPass lockerPass;

    private StudyCafePassOrder(StudyCafeSeatPass studyCafeSeatPass, StudyCafeLockerPass studyCafeLockerPass) {
        this.seatPass = studyCafeSeatPass;
        this.lockerPass = studyCafeLockerPass;
    }

    public static StudyCafePassOrder of(StudyCafeSeatPass studyCafeSeatPass, StudyCafeLockerPass lockerPass) {
        return new StudyCafePassOrder(studyCafeSeatPass, lockerPass);
    }

    public int getTotalPrice() {
        int lockerPassPrice = lockerPass != null ? lockerPass.getPrice() : 0;
        int totalPrice = seatPass.getPrice() + lockerPassPrice;

        return totalPrice - getDiscountPrice();
    }

    public StudyCafeSeatPass getSeatPass() {
        return seatPass;
    }

    public Optional<StudyCafeLockerPass> getLockerPass() {
        return Optional.ofNullable(lockerPass);
    }

    public double getDiscountRate() {
        return seatPass.getDiscountRate();
    }

    public int getDiscountPrice() {
        return (int) (seatPass.getPrice() * getDiscountRate());
    }
    
}
