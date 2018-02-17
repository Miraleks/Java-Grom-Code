package lesson09.utils;

public class Checker {
    //public - видно всем и отовсюду
    //private - существует только в классе
    //default (package-private) - по умолчанию при создании метода или объекта без указания области видимости, существует в рамках пакета
    //protected - класс, пакет и наследники класса


    int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName) {
//        if(companyName == "Google" || companyName == "Amazon")
//            return false;
//        return true;
        if (companyNamesValidatedCount > 10)
            return false;

        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
