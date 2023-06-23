package solutionWithInterface.application;

public class ProgramTheory {

    public static void main(String[] args) {
        System.out.println("\nInterface\n" +
                "\tInterface is a type that defines a set of operations that a Class must implement.\n" +
                "\tInterface establishes a kind of contract that a Class must fulfill.\n" +
                "\tInterface allows to create loosely coupled and flexible software systems.\n" +
                "\tInterface is a public and abstract Class that has only abstract methods with no body.\n" +
                "\tInterface has only constantes. All variables are final and static.\n");

        System.out.println("\nInversion of controle\n" +
                "\tIs is a software development pattern that concists of removing the responsability of instantiating\n" +
                "\t\tits dependencies from the Class.");

        System.out.println("\nDependency injection\n" +
                "\tIs is one of the ways to carry out the inversion of control.\n" +
                "\tAn external component instantiates the dependency which is injected by the superclass object.\n" +
                "\tCan be implemented through many ways, like: constructors, instantiation class, container or frameword.\n");

        System.out.println("\nDifference between inheritance and interface\n" +
                "\tinheritance. Key word 'extends'.\n" +
                "\tInheritance reuse of parameters (information) and methods (behavior).\n" +
                "\tinterface = key word 'implements'.\n" +
                "\tInterface has the main objective to fulfilled a contract.\n" +
                "\tIs is possible to make an implementation that combines interface with abstract class.\n");
    }
}
