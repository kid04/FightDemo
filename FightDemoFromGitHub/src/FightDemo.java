import java.util.*;

public class FightDemo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // Создание команд героев
        Team teamFirst = new Team("Мстители");
        teamFirst.addFighter(new Fighter("Iron Man", 3, false));
        teamFirst.addFighter(new Fighter("Hulk", 2, false));
        teamFirst.addFighter(new Fighter("Dr.Strange", 3, true));
        Team teamSecond = new Team("Плохиши");
        teamSecond.addFighter(new Fighter("Tanos", 1, false));
        teamSecond.addFighter(new Fighter("Mysterio", 3, false));
        teamSecond.addFighter(new Fighter("Surtur", 2, true));

        // Определяется право первого хода.
        Team thisTeam = (teamBegin()) ? teamFirst : teamSecond;
        Team otherTeam = changeTeam(thisTeam, teamFirst, teamSecond);
        // В принципе, этого достаточно, чтобы начать бой.

        while (!thisTeam.allDead()) {
            Fighter hittingFighter = thisTeam.checkLastFighter();
            Fighter sufferingFighter = otherTeam.checkLastFighter();
            if (hittingFighter == null) {
                System.out.printf("Выберите нападающего из команды %s:%n%s",
                        thisTeam.getTeamName(), thisTeam);
                hittingFighter = thisTeam.chooseFighter(in.nextInt());
                System.out.printf("%s готов к атаке!%n", hittingFighter);
            }
            else {
                System.out.printf("В команде %s в живых остался только один -%n%s.%n",
                        thisTeam.getTeamName(), hittingFighter);
                if (sufferingFighter == null)
                    System.out.println("И он готов к атаке!");
            }
            if (sufferingFighter == null) {
                System.out.printf("Кого атаковать в команде %s?%n%s",
                        otherTeam.getTeamName(), otherTeam);
                sufferingFighter = otherTeam.chooseFighter(in.nextInt());
            }
            else
                System.out.printf("Он будет атаковать последнего из оставшихся%nв живых в команде %s - %s.%n",
                        otherTeam.getTeamName(), sufferingFighter);
            System.out.printf("%s атакует %s.%n", hittingFighter, sufferingFighter);
            hittingFighter.makeDamage(sufferingFighter);
            System.out.printf((sufferingFighter.isAlive()) ? "%s отразил атаку.%n%n" : "%s пал смертью храбрых.%n%n",
                    sufferingFighter);
            // Передача права следующего хода.
            thisTeam = changeTeam(thisTeam, teamFirst, teamSecond);
            otherTeam = changeTeam(thisTeam, teamFirst, teamSecond);
        }

        System.out.printf("Победила команда %s!%n", otherTeam.getTeamName());
    }

    private static Team changeTeam(Team thisTeam, Team teamFirst, Team teamSecond) {
        return (thisTeam == teamFirst) ? teamSecond : teamFirst;
    }

    public static boolean teamBegin() {
        return (Math.random() > Math.random());
    }
}