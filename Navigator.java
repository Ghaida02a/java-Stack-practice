import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Navigator {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        List<String> forwardJourney = new ArrayList<>();
        forwardJourney.add("LEFT");
        forwardJourney.add("STRAIGHT");
        forwardJourney.add("TAKE EXIT 2 ON ROUND ABOUT");
        forwardJourney.add("RIGHT");

        System.out.println("Forward journey: " + forwardJourney);
        List<String> returnJourney = navigator.traceBack(forwardJourney);
        System.out.println("Return journey: " + returnJourney);
    }

    public List<String> traceBack(List<String> forwardJourney) {
        Stack<String> pathStack = new Stack<>();
        for (String step : forwardJourney) {
            pathStack.push(step);
        }

        List<String> returnJourney = new ArrayList<>();
        while (!pathStack.isEmpty()) {
            String currentStep = pathStack.pop();
            String oppositeStep = getOppositeStep(currentStep);
            returnJourney.add(oppositeStep);
        }
        return returnJourney;
    }

    private String getOppositeStep(String step) {
        step = step.toUpperCase();
        switch (step){
            case "RIGHT":
                return "LEFT";
            case "LEFT":
                return "RIGHT";
            case "STRAIGHT":
                return "STRAIGHT";
            default:
                if(step.startsWith("TAKE EXIT")){
                    String exitNumber = step.replaceAll("[^0-9]", "");
                    return "ENTER ROUND ABOUT AT EXIT " + exitNumber;
                }
        }
        return "UNKNOWN";
    }
}