package com.company;

public class Main {

    public static void main(String[] args) {
        String simulationFileLocation;

        int length = args.length - 1;

        simulationFileLocation = args[length];

        DiscreteSimulation discreteSimulation = new DiscreteSimulation();

        discreteSimulation.processSimulationSetup(simulationFileLocation);

        discreteSimulation.printSimulationState();
        for (int i = 0; i < 20; i++)
        {
            discreteSimulation.processNextEvent();
        }
    }
}
