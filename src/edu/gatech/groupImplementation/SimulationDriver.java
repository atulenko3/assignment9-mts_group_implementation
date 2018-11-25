package edu.gatech.groupImplementation;

import java.io.File;
import java.util.Scanner;

public class SimulationDriver {
	private static DiscreteSimulationController mts;
	
	public SimulationDriver() {
		mts = new DiscreteSimulationController();
	}
	
	public void moveNextBus() { mts.triggerNextEvent(); }

    public void revertEvent() { mts.revertState(); }
	
    public static void main(String[] args) {
    	SimulationDriver transitSimulation = new SimulationDriver();
    	
        final String DELIMITER = ",";
        String scenarioFile = args[0];
        //String probabilityBounds = args[1];  //Disabled for now, need to implement passengers exchanges to test this

        try { //Read the first file in args[0] - add route, stop, bus, etc
            Scanner takeCommand = new Scanner(new File(scenarioFile));
            String[] tokens;

            do {
                String userCommandLine = takeCommand.nextLine();
                tokens = userCommandLine.split(DELIMITER);

                switch (tokens[0]) {
                    case "add_stop":
                    	mts.makeStop(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]),  Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]));                        
                        break;
                    case "add_route":
                    	mts.makeRoute(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
                        break;
                    case "extend_route":
                    	mts.addStopToRoute(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                        break;
                    case "add_bus":
                    	mts.makeBus(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]), 
                    			Integer.parseInt(tokens[5]));
                        break;
                    case "add_event":
                    	mts.addEvent(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]));
                        break;
                    default:
                        System.out.println("Command not recognized");
                        break;
                }
            } while (takeCommand.hasNextLine());

            takeCommand.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
        
/*        try { //Reads the second file in args[1] which includes the probabilities for the passenger exchanges
            Scanner takeProbabilities = new Scanner(new File(probabilityBounds));
            String[] tokens;

            do {
                String userCommandLine = takeProbabilities.nextLine();
                tokens = userCommandLine.split(DELIMITER);

                mts.addProbabilities(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]));
               	
                } while (takeProbabilities.hasNextLine());

           takeProbabilities.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }*/

        test20Runs(transitSimulation);
        //test1Revert(transitSimulation);
        //test2Revert(transitSimulation);
        //test3Revert(transitSimulation);
    }

    /*
    Test Cases - could move these to separate files if we want
     */
    private static void test20Runs(SimulationDriver transitSimulation) {
        for(int i=0;i<20;i++) {
            transitSimulation.moveNextBus();  //This command runs the simulation for a total of 20 events
        }
    }

    private static void test1Revert(SimulationDriver transitSimulation) {
        for(int i=0;i<10;i++) {
            transitSimulation.moveNextBus();  //This command runs the simulation for a total of 20 events
        }

        transitSimulation.revertEvent();
        System.out.println("RevertEvent");

        for(int i=0;i<10;i++) {
            transitSimulation.moveNextBus();  //This command runs the simulation for a total of 20 events
        }
    }

    private static void test2Revert(SimulationDriver transitSimulation) {
        for(int i=0;i<10;i++) {
            transitSimulation.moveNextBus();  //This command runs the simulation for a total of 20 events
        }

        transitSimulation.revertEvent();
        System.out.println("RevertEvent");
        transitSimulation.revertEvent();
        System.out.println("RevertEvent");

        for(int i=0;i<10;i++) {
            transitSimulation.moveNextBus();  //This command runs the simulation for a total of 20 events
        }
    }

    private static void test3Revert(SimulationDriver transitSimulation) {
        for(int i=0;i<10;i++) {
            transitSimulation.moveNextBus();  //This command runs the simulation for a total of 20 events
        }

        transitSimulation.revertEvent();
        System.out.println("RevertEvent");
        transitSimulation.revertEvent();
        System.out.println("RevertEvent");
        transitSimulation.revertEvent();
        System.out.println("RevertEvent");


        for(int i=0;i<10;i++) {
            transitSimulation.moveNextBus();  //This command runs the simulation for a total of 20 events
        }
    }
}
