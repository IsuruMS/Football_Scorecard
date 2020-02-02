import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

//class to define a person
class person{
    public String name;
    public int age;
    public double experience;

    //constructors
    public person(int age,String name,double experience)
    {
        this.age=age;
        this.name=name;
        this.experience=experience;
    }
    public person()
    {

    }
}

//players class derived by person class
class players extends person{
    public int number;
    public int goals;
    public int assists;
    public int position;        //player positions 1 - Forward, 2 - Mid Field, 3 - Defence, 4 - Goalie
    public float passingAccuracy;
    public float shootingAccuracy;
    public String team;
    public int xCord;
    public int yCord;
    public boolean haveBall = false;

    public players(int age,String name,double experience,int number,float passingAccuracy,float shootingAccuracy,String team,int pos)
    {
        super(age,name,experience);
        this.number=number;
        this.passingAccuracy=passingAccuracy;
        this.shootingAccuracy=shootingAccuracy;
        this.team=team;
        this.position=pos;
    }
    public players()
    {
        super();
    }

    public static float generatePass() {
      Random rd = new Random(); // creating Random object
      float rando=rd.nextFloat()*100;
      //System.out.println(rd.nextFloat()); // displaying a random float value between 0.0 and 1.0
      return rando;
   }

   public static float generateShoot() {
      Random rd = new Random(); // creating Random object
      float randoo=rd.nextFloat()*100;
      //System.out.println(rd.nextFloat()); // displaying a random float value between 0.0 and 1.0
      return randoo;
   }
}
//coaches class derived by person class
class couches extends person{
    public float ability;
    public float winAbility;

    public couches(int age,String name,float experience,float ability,float winAbility)
    {
        super(age,name,experience);
        this.ability=ability;
        this.winAbility=winAbility;
    }
}
//referees class derived by person class
class referees extends person{
    private float error;

    public referees(int age,String name,float experience,float error)
    {
        super(age,name,experience);
        this.error=error;
    }

}
//doctors class derived by person class
class doctors extends person{
    private String qualifications;

    public doctors(int age,String name,float experience,String qualifications)
    {
        super(age,name,experience);
        this.qualifications=qualifications;
    }
}
//class of the team
class team 
{
    public int teamID;
    public String teamName;
    public players[] members = new players[11];
    public int score = 0;
    public team(String n)
    {
        this.teamName=n;
    }
}

class ball{

    class position{
        private int positionX;
        private int positionY;
        public void display() 
        { 
            System.out.println("position_x = " + positionX); 
            System.out.println("position_y = " + positionY);   
        } 
    }
    
    public float circumference, weight, air_pressure;
    public String material, shape;    
}

class footballground{

    class dimensions{
        private float length;
        private float width;
        public void display() 
        { 
            System.out.println("length of footballground = " + length); 
            System.out.println("width of footballground = " + width);   
        } 
    }

    public String penalty_area, goal_lines, touch_line;
    
}

class goal_area{

    class dimention2{
        private float length;
        private float width;
        public void display() 
        { 
            System.out.println("length of goalarea = " + length); 
            System.out.println("width of goalarea = " + width);   
        } 
    }

    public String goal_post, crossbar;
}

//driver class to execute the program
    class GamePlay
    {
        //coin toss to determine who gets to play the ball first
        public static float toss() {
        Random rd = new Random(); // creating Random object
        float rando=rd.nextFloat()*100;
        return rando;
        }

        //shooting accuracy, passing accuracy and goal keeper's saving ability is determined by the random numbers
        //if a players shooting accuracy is higher than the generated random number he will hit the target [hit to the goal]
        //but at the same time if goalie's saving ability is hifher than the generated random number then goal will be saved
        //otherwise goal will be scored

        //same procedure for passing the ball between two team mates
        //if passing accuracy is > than the generated number then pass will be successfull
        //else there is a probability to go out of the touch line or an opponent get the ball

        public static float RandomNumberGenerator() {
        Random rd = new Random(); // creating Random object
        float rand=rd.nextFloat()*100;
        return rand;
        }

        public static String teamA, teamB;
        private static int tossResult = 1;
        public static String startBall;

        //fill the team members, their passing and shooting accuracies, experience, age etc.
        public static void fill(team t, team u)
        {
            t.members[0] = new players(33,"RONALDO",100.0,7,97,98,teamA,1);
            t.members[1] = new players(20,"MBAPPE",86.0,11,97,97,teamA,1);
            t.members[2] = new players(24,"HAZARD",91.0,6,97,94,teamA,1);
            t.members[3] = new players(32,"MODRIC",95.0,10,96,89,teamA,2);
            t.members[4] = new players(29,"KROOS",96.0,8,99,98,teamA,2);
            t.members[5] = new players(30,"BENZEMA",90.0,9,97,90,teamA,2);
            t.members[6] = new players(26,"CARVAJAL",90.0,2,91,81,teamA,3);
            t.members[7] = new players(31,"RAMOS",98.0,4,94,89,teamA,3);
            t.members[8] = new players(25,"VARANE",93.0,5,92,74,teamA,3);
            t.members[9] = new players(30,"MARCELO",97.0,3,95,86,teamA,3);
            t.members[10] = new players(25,"COUTORIS",82.0,1,82,74,teamA,4);

            u.members[0] = new players(33,"MESSI",95.0,10,98,91,teamB,2);
            u.members[1] = new players(20,"GRIEZMAN",80.0,11,90,90,teamB,1);
            u.members[2] = new players(24,"SUAREZ",80.0,9,87,84,teamB,1);
            u.members[3] = new players(32,"DEJONG",75.0,7,79,57,teamB,2);
            u.members[4] = new players(29,"ARTHUR",79.0,8,74,68,teamB,2);
            u.members[5] = new players(30,"BUSQUETS",90.0,6,77,75,teamB,2);
            u.members[6] = new players(26,"ALBA",87.0,5,82,80,teamB,3);
            u.members[7] = new players(31,"PIQUE",90.0,4,76,80,teamB,3);
            u.members[8] = new players(25,"UMTITI",86.0,3,76,74,teamB,3);
            u.members[9] = new players(30,"FIRPO",77.0,2,81,86,teamB,3);
            u.members[10] = new players(25,"TERSTEGEN",82.0,1,83,66,teamB,4);
        }
        
        //get the current player in possesion of the ball
        public static players getPlayerWithBall(team TeamA, team TeamB)
        {
            players temp = new players();
            for (int k=0; k<11; k++)
            {
                if(TeamA.members[k].haveBall == true)
                {
                    temp = TeamA.members[k];
                }
                if(TeamB.members[k].haveBall == true)
                {
                    temp = TeamB.members[k];
                }
            }
            return temp;
        }

        //integer random number generator to determine which player will receive the pass
        //from the player that has the ball in his possesion
        private static int getRandomNumberInRange(int min, int max) {

            if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
            }

            Random r = new Random();
            return r.nextInt((max - min) + 1) + min;
        }

        //scoreboard printing
        public static void output(String team1, String team2, int score1, int score2, String player, String team_with_ball, String ss, String half, int time){//Scoreboard
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("                      UEFA CHAMPIONS' LEAGUE FINAL - BAKU 2019/20                          ");
            System.out.println("                                   "+team1+" vs "+team2);
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println(" Half    : " + half);
            System.out.println("");
            System.out.println("                " + team1 + "    \t\t     |          "+team2);
            System.out.println("                                             |");
            System.out.println("                "+score1+"                            |          "+score2);
            System.out.println("                                             |");
            System.out.println(ss);
            
            if(ss == "GOAL")
                { System.out.println("GOAL! : " + team_with_ball + " " + player); }
            else if((player != " ")&&(team_with_ball != " "))
            { System.out.println("Possession : " + team_with_ball + " " + player); }
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("                                     Time    : " + time);
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.print(10);
            System.out.print("\b\b");
            System.out.print("     ");
        }

        //main function which drives the program
        public static void main(String args[])
        {
            //two teams
            team TeamA = new team(teamA);
            team TeamB = new team(teamB);

            teamA = "Real Madrid";
            teamB = "FC Barcelona";

            //coin toss
            float num = toss();
            if (num>=50)
            {
                tossResult=2;
                startBall = teamA;
            }
            else
            {
                startBall = teamB;
            }
            //team IDs
            TeamA.teamID = 1 ;
            TeamB.teamID = 2 ;
            fill(TeamA, TeamB);

            //determine who gets the ball first in coin toss
            if(tossResult == 1)
            {
                //teamA has the ball
                TeamA.members[0].haveBall = true;
            }
            else
            {
                //team B has the ball
                TeamB.members[0].haveBall = true;
            }
            //get the player with the ball in possesion
            players playerWithBall = getPlayerWithBall(TeamA, TeamB);
            String half = "First Half";
            int time = 0;
            //program iterates for two halves
            //of 45 minutes 
            //each minute is represented by 2 seconds
            for(int j=0; j<2; j++)
            {
                for(int i=0; i<45; i++)
                {
                    time++;
                    int n;
                    if(playerWithBall.number<10)
                    {
                        n = getRandomNumberInRange(playerWithBall.number, 10);
                        n--;
                    }
                    else 
                    {
                        n = getRandomNumberInRange(0, playerWithBall.number-1);
                    }
                    float pass = RandomNumberGenerator();
                    float passOrShoot = RandomNumberGenerator();
                    if(passOrShoot >=70)
                    {
                        if(pass <= playerWithBall.passingAccuracy*0.75)
                        {
                            if(playerWithBall.team == teamA)
                            {
                                TeamA.members[n].haveBall=true;
                                playerWithBall = TeamA.members[n];
                            }
                            else
                            {
                                TeamB.members[n].haveBall=true;
                                playerWithBall = TeamB.members[n];
                            }
                            output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "PASS SUCCESS",half,time);
                        }
                        else if(pass <= playerWithBall.passingAccuracy*(0.9))
                        {
                            if(playerWithBall.team == teamA)
                            {
                                n = getRandomNumberInRange(0, 10);
                                playerWithBall = TeamB.members[n];
                            }
                            else
                            {
                                n = getRandomNumberInRange(0, 10);
                                playerWithBall = TeamA.members[n];
                            }
                            output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "PASS UNSUCCESSFUL",half,time);
                        }
                        else
                        {
                            if(playerWithBall.team == teamA)
                            {
                                n = getRandomNumberInRange(0, 9);
                                playerWithBall = TeamB.members[n];
                            }
                            else
                            {
                                n = getRandomNumberInRange(0, 9);
                                playerWithBall = TeamA.members[n];
                            }
                            output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "THROW IN TO THE OTHER TEAM",half,time);
                        }
                    }
                    else
                    {
                        float shoot = RandomNumberGenerator();
                        if(shoot <= playerWithBall.shootingAccuracy/2)
                        {
                            float success = RandomNumberGenerator();
                            if(success<=50)
                            {
                                playerWithBall.goals++;
                                String team = playerWithBall.team;
                                if(team == teamA)
                                {
                                    TeamA.score++;
                                    output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "GOAL",half,time);

                                }
                                else if (team == teamB)
                                {
                                    TeamB.score++;
                                    output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "GOAL",half,time);

                                }

                            }
                            else
                            {
                                if(playerWithBall.team == teamA)
                            {
                                n = getRandomNumberInRange(0, 10);
                                playerWithBall = TeamB.members[n];
                            }
                            else
                            {
                                n = getRandomNumberInRange(0, 10);
                                playerWithBall = TeamA.members[n];
                            }
                                output(teamA, teamB, TeamA.score, TeamB.score, " ", " ", "GOAL KEEPER SAVED THE SHOT",half,time);
                            }
                        }
                    }
                    try
                    {
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
                System.out.println("");
                System.out.println("");
                if(half == "First Half")
                {
                System.out.println("--------------------------HALF TIME--------------------------");
                }
                else
                {
                System.out.println("--------------------------FULL TIME--------------------------");
                }
                System.out.println("");
                System.out.println("");
                half = "Second Half";
                try
                    {
                        TimeUnit.SECONDS.sleep(3);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
            }
            //if the score is same after full time 90 minutes then match goes to extra time
            if(TeamA.score == TeamB.score)
            {
                System.out.println("--------------------------EXTRA TIME--------------------------");
                //now team possesion are eversed as it is extra time
                if(tossResult == 1)
                {
                    //teamA has the ball
                    TeamB.members[0].haveBall = true;
                }
                else
                {
                    TeamA.members[0].haveBall = true;
                }
                
                playerWithBall = getPlayerWithBall(TeamA, TeamB);
                half = "First Half";
                for(int j=0; j<2; j++)
                {
                for(int i=0; i<15; i++)
                {
                    time++;
                    int n;
                    if(playerWithBall.number<10)
                    {
                        n = getRandomNumberInRange(playerWithBall.number, 10);
                        n--;
                    }
                    else 
                    {
                        n = getRandomNumberInRange(0, playerWithBall.number-1);
                    }
                    float pass = RandomNumberGenerator();
                    float passOrShoot = RandomNumberGenerator();
                    if(passOrShoot >=70)
                    {
                        if(pass <= playerWithBall.passingAccuracy*0.75)
                        {
                            if(playerWithBall.team == teamA)
                            {
                                TeamA.members[n].haveBall=true;
                                playerWithBall = TeamA.members[n];
                            }
                            else
                            {
                                TeamB.members[n].haveBall=true;
                                playerWithBall = TeamB.members[n];
                            }
                            output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "PASS SUCCESS",half,time);
                        }
                        else if(pass <= playerWithBall.passingAccuracy*(0.9))
                        {
                            if(playerWithBall.team == teamA)
                            {
                                n = getRandomNumberInRange(0, 10);
                                playerWithBall = TeamB.members[n];
                            }
                            else
                            {
                                n = getRandomNumberInRange(0, 10);
                                playerWithBall = TeamA.members[n];
                            }
                            output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "PASS UNSUCCESSFUL",half,time);
                        }
                        else
                        {
                            if(playerWithBall.team == teamA)
                            {
                                n = getRandomNumberInRange(0, 9);
                                playerWithBall = TeamB.members[n];
                            }
                            else
                            {
                                n = getRandomNumberInRange(0, 9);
                                playerWithBall = TeamA.members[n];
                            }
                            output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "THROW IN TO THE OTHER TEAM",half,time);
                        }
                    }
                    else
                    {
                        float shoot = RandomNumberGenerator();
                        if(shoot <= playerWithBall.shootingAccuracy/2)
                        {
                            float success = RandomNumberGenerator();
                            if(success<=50)
                            {
                                playerWithBall.goals++;
                                String team = playerWithBall.team;
                                if(team == teamA)
                                {
                                    TeamA.score++;
                                    output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "GOAL",half,time);

                                }
                                else if (team == teamB)
                                {
                                    TeamB.score++;
                                    output(teamA, teamB, TeamA.score, TeamB.score, playerWithBall.name, playerWithBall.team, "GOAL",half,time);

                                }

                            }
                            else
                            {
                                if(playerWithBall.team == teamA)
                            {
                                n = getRandomNumberInRange(0, 10);
                                playerWithBall = TeamB.members[n];
                            }
                            else
                            {
                                n = getRandomNumberInRange(0, 10);
                                playerWithBall = TeamA.members[n];
                            }
                                output(teamA, teamB, TeamA.score, TeamB.score, " ", " ", "GOAL KEEPER SAVED THE SHOT",half,time);
                            }
                        }
                    }
                    try
                    {
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
                System.out.println("");
                System.out.println("");
                if(half == "First Half")
                {
                System.out.println("--------------------------HALF TIME - EXTRA TIME--------------------------");
                }
                else
                {
                System.out.println("--------------------------FULL TIME - EXTRA TIME--------------------------");
                }
                System.out.println("");
                System.out.println("");
                half = "Second Half";
                try
                    {
                        TimeUnit.SECONDS.sleep(3);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    //if still the score is similar match goes to penalty shootouts
                    if(TeamA.score == TeamB.score)
                    {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("--------------------------Penalty Shootout--------------------------");
                        System.out.println("");
                        System.out.println("");
                        String shooter1;
                        String shooter2;
                        float n1;
                        float n2;
                        //5 players shoots penalties to determine who is the winner
                        for(int m=0; m<5; m++)
                        {
                            shooter1 = TeamA.members[m].name;
                            shooter2 = TeamB.members[m].name;

                            n1 = RandomNumberGenerator();
                            n2 = RandomNumberGenerator();
                            
                            if(n1<=TeamA.members[m].shootingAccuracy/2)
                            {
                                if(n2 <= 50)
                                {
                                    System.out.print("PENALTY : SUCCESS | " + shooter1 + " |        ");
                                }
                                else
                                {
                                    System.out.print("PENALTY : SAVED   |" + shooter1  + " |        ");
                                }
                            }
                            else
                            {
                                System.out.print("PENALTY : OFF TARGET   |" + shooter1  + " |        ");
                            }

                            if(n1<=TeamB.members[m].shootingAccuracy/2)
                            {
                                if(n2 <= 50)
                                {
                                    System.out.print("PENALTY : SUCCESS | " + shooter2 + " |        ");
                                }
                                else
                                {
                                    System.out.print("PENALTY : SAVED   |" + shooter2  + " |        ");
                                }
                            }
                            else
                            {
                                System.out.print("PENALTY : OFF TARGET   |" + shooter2  + " |        ");
                            }

                        }
                        if(TeamA.score != TeamB.score)
                        {
                            System.out.println("!!!!!!!!!! CONGRATULATIONS !!!!!!!!!!");
                            System.out.println("UEFA CHAMPIONS' LEAGUE WINNERS 2019/20");
                            if(TeamA.score > TeamB.score)
                                System.out.println("------" + teamA + "------");
                            else
                                System.out.println("------" + teamB + "------");
                        }
                        else
                        {
                            System.out.println("!!!!!!!!!! DRAW !!!!!!!!!!");
                            System.out.println("UEFA CHAMPIONS' LEAGUE WINNERS 2019/20");
                                System.out.println("------" + teamA + "------");
                                System.out.println("------" + teamB + "------");

                        }
                }
                else if(TeamA.score != TeamB.score)
                {
                    System.out.println("!!!!!!!!!! CONGRATULATIONS !!!!!!!!!!");
                    System.out.println("UEFA CHAMPIONS' LEAGUE WINNERS 2019/20");
                    if(TeamA.score > TeamB.score)
                        System.out.println("------" + teamA + "------");
                    else
                        System.out.println("------" + teamB + "------");
                }
            }
        }
        else
            {
                System.out.println("!!!!!!!!!! CONGRATULATIONS !!!!!!!!!!");
                System.out.println("UEFA CHAMPIONS' LEAGUE WINNERS 2019/20");
                if(TeamA.score > TeamB.score)
                    System.out.println("       ------" + teamA + "------");
                else
                    System.out.println("       ------" + teamB + "------");
            }
            System.out.println("");
            System.out.println("");
        }
    }