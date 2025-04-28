package cleancode.studycafe.tobe.model.pass;

import java.util.List;

public class StudyCafeSeatPasses {

    private final List<StudyCafeSeatPass> studyCafePasses;

    private StudyCafeSeatPasses(List<StudyCafeSeatPass> studyCafePasses) {
        this.studyCafePasses = studyCafePasses;
    }

    public static StudyCafeSeatPasses of(List<StudyCafeSeatPass> passes) {
        return new StudyCafeSeatPasses(passes);
    }

    public List<StudyCafeSeatPass> findPassBy(StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
                .filter(studyCafePass -> studyCafePass.isSamePassType(studyCafePassType))
                .toList();
    }

}
