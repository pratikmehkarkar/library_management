package com.company;

public class Student extends Member {

    public Student(LibraryFacade libraryFacade){
        setLibraryFacade(libraryFacade);
    }

    @Override
    public String step1() {

        return getName()+" uses newly learned topics to complete assignment \n";
    }

    @Override
    public String step2() {

        return getName()+" tells classmates about the completion \n";
    }

    @Override
    public String step3() {
        return getName()+" is now prepared for the upcoming test";
    }
}
