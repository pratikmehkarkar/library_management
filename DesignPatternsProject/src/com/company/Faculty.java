package com.company;

public class Faculty extends Member {

    public Faculty(LibraryFacade libraryFacade){
        setLibraryFacade(libraryFacade);
    }
    @Override
    public String step1() {

        return getName()+" can now start teaching students the newly learned topics";
    }

    @Override
    public String step2() {
        return getName()+" starts preparing a new test paper for students";
    }

    @Override
    public String step3() {

        return getName()+" asks students too to read this book";
    }
}
